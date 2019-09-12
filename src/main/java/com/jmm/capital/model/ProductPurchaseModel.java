/**
 * 
 */
package com.jmm.capital.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * @author ramjisoni
 *
 */
public class ProductPurchaseModel {

	@Id
	private String id;

	private ProductModel product;

	private AgencyModel agency;

	private Long quantity;

	private Double quantityPrice;

	private String billNumber;

	private Date billDate;

	private Double profitMargin;

	private Double finalPrice;

	private String barCodeId;

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public final ProductModel getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public final void setProduct(ProductModel product) {
		this.product = product;
	}

	/**
	 * @return the agency
	 */
	public final AgencyModel getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public final void setAgency(AgencyModel agency) {
		this.agency = agency;
	}

	/**
	 * @return the quantity
	 */
	public final Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public final void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantityPrice
	 */
	public final Double getQuantityPrice() {
		return quantityPrice;
	}

	/**
	 * @param quantityPrice the quantityPrice to set
	 */
	public final void setQuantityPrice(Double quantityPrice) {
		this.quantityPrice = quantityPrice;
	}

	/**
	 * @return the billNumber
	 */
	public final String getBillNumber() {
		return billNumber;
	}

	/**
	 * @param billNumber the billNumber to set
	 */
	public final void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	/**
	 * @return the billDate
	 */
	public final Date getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate the billDate to set
	 */
	public final void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the profitMargin
	 */
	public final Double getProfitMargin() {
		return profitMargin;
	}

	/**
	 * @param profitMargin the profitMargin to set
	 */
	public final void setProfitMargin(Double profitMargin) {
		this.profitMargin = profitMargin;
	}

	/**
	 * @return the finalPrice
	 */
	public final Double getFinalPrice() {
		return finalPrice;
	}

	/**
	 * @param finalPrice the finalPrice to set
	 */
	public final void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	/**
	 * @return the barCodeId
	 */
	public final String getBarCodeId() {
		return barCodeId;
	}

	/**
	 * @param barCodeId the barCodeId to set
	 */
	public final void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}

}
