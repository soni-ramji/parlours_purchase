/**
 * 
 */
package com.jmm.capital.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmm.capital.model.ProductPurchase;
import com.jmm.capital.service.ProductPurchaseService;

/**
 * @author ramjisoni
 *
 */
@RestController
public class ProductPurchaseController {

	/**
	 * 
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductPurchaseService productService;

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/product/purchase/getpurchaseinfo")
	public ResponseEntity<ProductPurchase> getPurchaseInfoById(@RequestParam("id")String id) {
		logger.info("Starting ProductPurchaseController.getPurchaseInfoById");
		ProductPurchase product = productService.getPurchaseInfoById(id);
		ResponseEntity<ProductPurchase> result = new ResponseEntity<ProductPurchase>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getPurchaseInfoById");
		return result;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(name  = "/product/purchase/getallpurchase")
	public ResponseEntity<List<ProductPurchase>> getAllPurchase() {
		logger.info("Starting ProductPurchaseController.getAllPurchase");
		List<ProductPurchase> product = productService.getAllPurchaseInfo();
		ResponseEntity<List<ProductPurchase>> result = new ResponseEntity<List<ProductPurchase>>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getAllPurchase");
		return result;
	} 
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/product/purchase/getpurchaseinfobyproductid")
	public ResponseEntity<List<ProductPurchase>> getPurchaseInfoByProductId(@RequestParam("productId")Long productId) {
		logger.info("Starting ProductPurchaseController.getPurchaseInfoByProductId");
		List<ProductPurchase> product = productService.getPurchaseInfoByProductId(productId);
		ResponseEntity<List<ProductPurchase>> result = new ResponseEntity<List<ProductPurchase>>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getPurchaseInfoByProductId");
		return result;
	}
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/product/purchase/getpurchaseinfobyagencyid")
	public ResponseEntity<List<ProductPurchase>> getPurchaseInfoByAgencyId(@RequestParam("agencyid")Long agencyid) {
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		List<ProductPurchase> product = productService.getPurchaseInfoByAgencyId(agencyid);
		ResponseEntity<List<ProductPurchase>> result = new ResponseEntity<List<ProductPurchase>>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		return result;
	}
	
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "/product/purchase/getpurchaseinfobydate")
	public ResponseEntity<List<ProductPurchase>> getPurchaseInfoByDate() {
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		List<ProductPurchase> product = productService.getPurchaseInfoByDate(new Date());
		ResponseEntity<List<ProductPurchase>> result = new ResponseEntity<List<ProductPurchase>>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		return result;
	}
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	@PostMapping(value = "/product/purchase/savepurchase")
	public ResponseEntity<List<ProductPurchase>> savePurchase(final ProductPurchase productPurchase) {
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		List<ProductPurchase> product = productService.getPurchaseInfoByDate(new Date());
		ResponseEntity<List<ProductPurchase>> result = new ResponseEntity<List<ProductPurchase>>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getpurchaseinfobyagencyid");
		return result;
	}
	

}
