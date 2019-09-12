/**
 * 
 */
package com.jmm.capital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmm.capital.model.ProductPurchaseModel;
import com.jmm.capital.service.ProductPurchaseService;

/**
 * @author ramjisoni
 *
 */
@RestController("/product/purchase")
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
	@RequestMapping(name = "/getpurchaseinfo", method = RequestMethod.GET)
	public ResponseEntity<ProductPurchaseModel> getPurchaseInfoById(Long id) {
		logger.info("Starting ProductPurchaseController.getPurchaseInfoById");
		ProductPurchaseModel product = productService.getPurchaseInfoById(id);
		ResponseEntity<ProductPurchaseModel> result = new ResponseEntity<ProductPurchaseModel>(product, HttpStatus.OK);
		logger.info("Starting ProductPurchaseController.getPurchaseInfoById");
		return result;
	}

}
