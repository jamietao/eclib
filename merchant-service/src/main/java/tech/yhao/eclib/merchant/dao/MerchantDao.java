/**
 * 
 */
package tech.yhao.eclib.merchant.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.yhao.eclib.merchant.entity.Merchant;

/**
 * The Merchant data access interface. 
 * 
 * @author TaoJn
 *
 */
public interface MerchantDao extends JpaRepository<Merchant, Integer> {

	/**
	 * Find the merchant by name. 
	 * 
	 * @param name the merchant name. 
	 * @return {@link Merchant}
	 */
	Optional<Merchant> findByName(String name);
	
	/**
	 * Find the merchant by id.
	 * 
	 * @param id merchant id.
	 * @return {@link  Merchant}
	 */
	Optional<Merchant> findById(Integer id);
}
