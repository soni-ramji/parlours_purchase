/**
 * 
 */
package com.jmm.capital.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jmm.capital.model.ProductPurchase;

/**
 * @author ramjisoni
 *
 */
public interface ProductPurchaseRepo extends MongoRepository<ProductPurchase, String>{

	@Query("{billDate : {$gt : ?0}}")
	List<ProductPurchase> getPurchaseInfoByDateandProductId(Date purchasrDate);
}
