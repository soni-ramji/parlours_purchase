/**
 * 
 */
package com.jmm.capital.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmm.capital.exception.ParlourServiceException;
import com.jmm.capital.model.ProductPurchaseModel;
import com.jmm.capital.repo.ProductPurchaseRepo;

/**
 * @author ramjisoni
 *
 */
@Service
public class ProductPurchaseService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 */
	@Autowired
	private ProductPurchaseRepo repo;

	/**
	 * 
	 * @return
	 */
	public ProductPurchaseModel getPurchaseInfoById(Long id) {
		ProductPurchaseModel productPurchaseModel = null;
		logger.info("Started ProductPurchaseService.getPurchaseInfoById with id " + id);
		try {
			Optional<ProductPurchaseModel> product = repo.findById(id);
			if (product.isPresent()) {
				productPurchaseModel = product.get();
			} else {
				throw new ParlourServiceException("No Purchase Record found on this id");
			}
		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getPurchaseInfoById " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getPurchaseInfoById with id " + id);
		return productPurchaseModel;
	}

	/**
	 * 
	 * @return
	 */
	public List<ProductPurchaseModel> getAllPurchaseInfo() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public boolean updatePurchaseInfo() {
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean deletePurchaseInfo() {
		return true;
	}
}
