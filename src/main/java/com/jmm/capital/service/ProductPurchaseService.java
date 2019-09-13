/**
 * 
 */
package com.jmm.capital.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.jmm.capital.exception.ParlourServiceException;
import com.jmm.capital.model.AgencyModel;
import com.jmm.capital.model.ProductModel;
import com.jmm.capital.model.ProductPurchase;
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
	public ProductPurchase getPurchaseInfoById(String id) {
		ProductPurchase productPurchaseModel = null;
		logger.info("Started ProductPurchaseService.getPurchaseInfoById with id " + id);
		try {
			ObjectId ids = new ObjectId(id);
			// ProductPurchase product = repo.findBy_id(ids);
			Optional<ProductPurchase> product = repo.findById(id);
			// System.out.println("sddssd" + product.get().getBarCodeId());

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
	public ProductPurchase getPurchaseInfoByDate(Date date) {
		ProductPurchase productPurchaseModel = null;
		logger.info("Started ProductPurchaseService.getPurchaseInfoByDate with id " + date);
		try {
			/*
			 * ObjectId ids = new ObjectId(id); // ProductPurchase product =
			 * repo.findBy_id(ids); Optional<ProductPurchase> product = repo.findById(id);
			 * // System.out.println("sddssd" + product.get().getBarCodeId());
			 * 
			 * if (product.isPresent()) { productPurchaseModel = product.get(); } else {
			 * throw new ParlourServiceException("No Purchase Record found on this id"); }
			 */

		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getPurchaseInfoByDate " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getPurchaseInfoByDate with id " + date);
		return productPurchaseModel;
	}

	/**
	 * 
	 * @return
	 */
	public List<ProductPurchase> getPurchaseInfoByProductId(Long productId) {
		List<ProductPurchase> product = null;
		logger.info("Started ProductPurchaseService.getPurchaseInfoByProductId with id " + productId);
		try {
			ProductPurchase productPurchase = new ProductPurchase();
			ProductModel productModel = new ProductModel();
			productModel.setProductId(productId);
			Example<ProductPurchase> criteria = Example.of(productPurchase, ExampleMatcher.matchingAll());

			product = repo.findAll(criteria);

		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getPurchaseInfoByProductId " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getPurchaseInfoByProductId with id " + productId);
		return product;
	}

	/**
	 * 
	 * @return
	 */
	public List<ProductPurchase> getPurchaseInfoByAgencyId(Long agencyId) {

		List<ProductPurchase> product = null;
		logger.info("Started ProductPurchaseService.getPurchaseInfoByAgencyId with anagecyId " + agencyId);
		try {
			ProductPurchase productPurchase = new ProductPurchase();
			AgencyModel agency = new AgencyModel();
			productPurchase.setAgency(agency);
			Example<ProductPurchase> criteria = Example.of(productPurchase, ExampleMatcher.matchingAll());

			product = repo.findAll(criteria);

		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getPurchaseInfoByAgencyId " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getPurchaseInfoByAgencyId with id " + agencyId);
		return product;

	}

	/**
	 * 
	 * @return
	 */
	public List<ProductPurchase> getAllPurchaseInfo() {
		List<ProductPurchase> allPurchase = new ArrayList<ProductPurchase>();
		logger.info("Started ProductPurchaseService.getAllPurchaseInfo");
		try {
			allPurchase = repo.findAll();
			logger.info("Total Product Found " + allPurchase.size());
		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getAllPurchaseInfo " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getAllPurchaseInfo");
		return allPurchase;

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
	public boolean deletePurchaseInfo(final String id) {
		boolean deleted = false;
		logger.info("Started ProductPurchaseService.deletePurchaseInfo by Id " + id);
		try {
			repo.deleteById(id);
			deleted = true;
		} catch (Exception ex) {
			throw new ParlourServiceException("Exception found to delete Purchase Information");
		}
		logger.info("Completed ProductPurchaseService.deletePurchaseInfo by Id " + id);
		return deleted;
	}
}
