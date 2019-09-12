/**
 * 
 */
package com.jmm.capital.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jmm.capital.model.ProductPurchaseModel;

/**
 * @author ramjisoni
 *
 */
public interface ProductPurchaseRepo extends MongoRepository<ProductPurchaseModel, Long>{

}
