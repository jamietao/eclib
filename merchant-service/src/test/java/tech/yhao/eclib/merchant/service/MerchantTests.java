/**
 * 
 */
package tech.yhao.eclib.merchant.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import tech.yhao.eclib.merchant.service.MerchantService;
import tech.yhao.eclib.merchant.vo.CreateMerchantRequest;
import tech.yhao.eclib.merchant.vo.Response;

/**
 * @author TaoJn
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantTests {

	@Autowired
	private MerchantService merchantService;

	@Test
	@Transactional
	public void testMerchantCreation() {
		CreateMerchantRequest request = new CreateMerchantRequest();
		request.setName("merchant - 0");
		request.setLogoUrl("http://merchant.com/logo");
		request.setLicenseUrl("http://merchant.com/license");
		request.setPhone("021-111111111");
		request.setAddress("上海");

		Response response = merchantService.createMerchant(request);
	}

}
