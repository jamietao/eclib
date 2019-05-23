/**
 * 
 */
package tech.yhao.eclib.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response dropPassTemplate(PassTemplate passTemplate) {
		// TODO Auto-generated method stub
		return null;
	}

}
