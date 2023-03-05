package com.distance.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "distance_data", schema = "public")
public class DistanceInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fromPincode;
	private String toPincode;
	private String distance;
	
	public DistanceInfo(String fromPincode, String toPincode, String distance) {
		this.fromPincode = fromPincode;
		this.toPincode = toPincode;
		this.distance = distance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromPincode() {
		return fromPincode;
	}
	public void setFromPincode(String fromPincode) {
		this.fromPincode = fromPincode;
	}
	public String getToPincode() {
		return toPincode;
	}
	public void setToPincode(String toPincode) {
		this.toPincode = toPincode;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
}
