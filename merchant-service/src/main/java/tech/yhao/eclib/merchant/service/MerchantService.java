/**
 * 
 */
package tech.yhao.eclib.merchant.service;

import tech.yhao.eclib.merchant.vo.CreateMerchantRequest;
import tech.yhao.eclib.merchant.vo.PassTemplate;
import tech.yhao.eclib.merchant.vo.Response;

/**
 * @author TaoJn
 *
 */
public interface MerchantService {

	Response createMerchant(CreateMerchantRequest request);

	Response buildMerchant(Integer id);

	Response dropPassTemplate(PassTemplate passTemplate);
}
