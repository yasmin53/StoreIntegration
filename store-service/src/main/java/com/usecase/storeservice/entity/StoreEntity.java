package com.usecase.storeservice.entity;

import java.util.Date;


public class StoreEntity {



	private int id;
	private int storeId;
	private String name;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private long contact;
	private String holidayOn;
	private String openCloseTimings;
	private Date createdOn;
	private String createdBy;
	private Date updateOn;
	private String updatedBy;
	private boolean isActive;
	public StoreEntity() {
		
	}
	
	public StoreEntity(int id, int storeId, String name, String addressline1, String addressline2, String city,
			String state, String country, int pincode, long contact, String holidayOn, String openCloseTimings,
			Date createdOn, String createdBy, Date updateOn, String updatedBy, boolean isActive) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.contact = contact;
		this.holidayOn = holidayOn;
		this.openCloseTimings = openCloseTimings;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updateOn = updateOn;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
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
		return "StoreModel [id=" + id + ", storeId=" + storeId + ", name=" + name + ", addressline1=" + addressline1
				+ ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + ", contact=" + contact + ", holidayOn=" + holidayOn + ", openCloseTimings="
				+ openCloseTimings + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updateOn=" + updateOn
				+ ", updatedBy=" + updatedBy + ", isActive=" + isActive + "]";
	}
	
	

}
