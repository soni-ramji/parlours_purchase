/**
 * 
 */
package com.jmm.capital.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jmm.capital.model.ProductPurchase;

/**
 * @author ramjisoni
 *
 */
public interface ProductPurchaseRepo extends MongoRepository<ProductPurchase, String>{

	ProductPurchase findBy_id(ObjectId _id);
}
