package com.usecase.storeservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="store_on-premisis")
public class StoreModel {
	
	@Id
	private int storeId;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private String holidayOn;
	private String openCloseTimings;
	private Date createdOn;
	private String createdBy;
	private Date updateOn;
	private String updatedBy;
	private boolean isActive;
	public StoreModel() {
		
	}
	public StoreModel(int storeId, String addressline1, String addressline2, String city, String state, String country,
			int pincode, String holidayOn, String openCloseTimings, Date createdOn, String createdBy, Date updateOn,
			String updatedBy, boolean isActive) {
		super();
		this.storeId = storeId;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.holidayOn = holidayOn;
		this.openCloseTimings = openCloseTimings;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updateOn = updateOn;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getHolidayOn() {
		return holidayOn;
	}
	public void setHolidayOn(String holidayOn) {
		this.holidayOn = holidayOn;
	}
	public String getOpenCloseTimings() {
		return openCloseTimings;
	}
	public void setOpenCloseTimings(String openCloseTimings) {
		this.openCloseTimings = openCloseTimings;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "StoreModel [storeId=" + storeId + ", addressline1=" + addressline1 + ", addressline2=" + addressline2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ ", holidayOn=" + holidayOn + ", openCloseTimings=" + openCloseTimings + ", createdOn=" + createdOn
				+ ", createdBy=" + createdBy + ", updateOn=" + updateOn + ", updatedBy=" + updatedBy + ", isActive="
				+ isActive + "]";
	}
	

}
