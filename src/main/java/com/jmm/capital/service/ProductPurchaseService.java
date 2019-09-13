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
import com.jmm.capital.util.DateTimeUtility;

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
			//ObjectId ids = new ObjectId(id);
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
	public List<ProductPurchase> getPurchaseInfoByDate(Date billingDate) {
		List<ProductPurchase> product = new ArrayList<>();
		String billingString = "2019-09-10T21:27:08-04:00";
		billingDate = DateTimeUtility.stringToDate(billingString);
		logger.info("Started ProductPurchaseService.getPurchaseInfoByDate with id " + billingDate);
		try {
			product = repo.getPurchaseInfoByDateandProductId(billingDate);
		} catch (Exception ex) {
			throw new ParlourServiceException(
					"Exception Found in ProductPurchaseService.getPurchaseInfoByDate " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.getPurchaseInfoByDate with id " + billingDate);
		return product;
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
	 * @param productPurchase
	 * @return
	 */
	public boolean updatePurchaseInfo(final ProductPurchase productPurchase) {

		logger.info("Starting ProductPurchaseService.updatePurchaseInfo");
		boolean result = false;
		try {
			// TODO Validation needed
			repo.save(productPurchase);
			result = true;
		} catch (Exception ex) {
			logger.error("Exception found to update Purchase Info " + ex.getMessage());
			throw new ParlourServiceException("Exception found to update Purchase Info " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.updatePurchaseInfo");
		return result;

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

	/**
	 * 
	 * @param billingDate
	 * @param productId
	 * @return
	 */
	public List<ProductPurchase> getPurchaseInfoByDateAndProductId(final Date billingDate, final Long productId) {
		logger.info("Starting ProductPurchaseService.getPurchaseInfoByDateAndProductId with purchase Date "
				+ billingDate + " and ProductId" + productId);
		List<ProductPurchase> productInfos = new ArrayList<>();
		try {
			productInfos = repo.getPurchaseInfoByDateandProductId(billingDate);
		} catch (Exception ex) {
			logger.error(
					"Exception found in ProductPurchaseService.getPurchaseInfoByDateAndProductId " + ex.getMessage());
			throw new ParlourServiceException(
					"Exception found in ProductPurchaseService.getPurchaseInfoByDateAndProductId " + ex.getMessage());
		}
		logger.info("Completed PurchaseProductService.getPurchaseInfoByDateAndProductId with billDate " + billingDate);
		return productInfos;
	}

	/**
	 * 
	 * @param productPurchase
	 * @return
	 */
	public boolean savePurchaseInfo(final ProductPurchase productPurchase) {
		logger.info("Starting ProductPurchaseService.savePurchaseInfo");
		boolean result = false;
		try {
			// TODO Validation needed
			repo.save(productPurchase);
			result = true;
		} catch (Exception ex) {
			logger.error("Exception found to save Purchase Info " + ex.getMessage());
			throw new ParlourServiceException("Exception found to save Purchase Info " + ex.getMessage());
		}
		logger.info("Completed ProductPurchaseService.savePurchaseInfo");
		return result;
	}
}
