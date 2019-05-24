/**
 * 
 */
package tech.yhao.eclib.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.yhao.eclib.merchant.service.MerchantService;
import tech.yhao.eclib.merchant.vo.CreateMerchantRequest;
import tech.yhao.eclib.merchant.vo.PassTemplate;
import tech.yhao.eclib.merchant.vo.Response;

/**
 * @author TaoJn
 *
 */
@Controller
@RequestMapping("/merchants")
public class MerchantsController {

	@Autowired
	private MerchantService merchantService;

	@ResponseBody
	@PostMapping
	public Response create(@RequestBody CreateMerchantRequest createRequest) {
		Response response = merchantService.createMerchant(createRequest);
		return response;
	}

	@ResponseBody
	@GetMapping("/{id}")
	public Response get(@PathVariable Integer id) {
		Response response = merchantService.buildMerchant(id);
		return response;
	}

	@ResponseBody
	@PostMapping("/drop")
	public Response drop(@RequestBody PassTemplate passTemplate) {
		return merchantService.dropPassTemplate(passTemplate);
	}
}
