/**
 * 
 */
package tech.yhao.eclib.merchant.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tech.yhao.eclib.merchant.constant.Constants;
import tech.yhao.eclib.merchant.constant.ErrorCode;
import tech.yhao.eclib.merchant.dao.MerchantDao;
import tech.yhao.eclib.merchant.entity.Merchant;
import tech.yhao.eclib.merchant.service.MerchantService;
import tech.yhao.eclib.merchant.vo.CreateMerchantRequest;
import tech.yhao.eclib.merchant.vo.CreateMerchantResponse;
import tech.yhao.eclib.merchant.vo.PassTemplate;
import tech.yhao.eclib.merchant.vo.Response;

/**
 * @author TaoJn
 *
 */
@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDao merchantDao;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Transactional
	@Override
	public Response createMerchant(CreateMerchantRequest request) {

		ErrorCode validationResult = request.validate(merchantDao);
		Response response = null;

		if (validationResult != ErrorCode.SUCCESS) {
			response = new Response(validationResult);
		} else {
			Merchant merchant = request.toMerchant();
			Merchant created = merchantDao.save(merchant);
			CreateMerchantResponse createResponse = new CreateMerchantResponse();
			createResponse.setId(created.getId());
			response = new Response(createResponse);
		}

		return response;
	}

	@Override
	public Response buildMerchant(Integer id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}

		Optional<Merchant> result = merchantDao.findById(id);
		if (result.isPresent()) {
			return new Response(result.get());
		} else {
			return new Response(ErrorCode.MERCHANT_NOT_EXIST);
		}
	}

	@Override
	public Response dropPassTemplate(PassTemplate passTemplate) {
		ErrorCode validationResult = passTemplate.validate(merchantDao);
		if (validationResult != ErrorCode.SUCCESS) {
			return new Response(validationResult);
		}

		String jsonContent = JSON.toJSONString(passTemplate);
		// Client will create the topic if topic is not available. 
		kafkaTemplate.send(Constants.TEMPLATE_TOPIC, Constants.TEMPLATE_TOPIC, jsonContent);

		return new Response(ErrorCode.SUCCESS);
	}
}
