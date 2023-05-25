package org.kukkas.employeeportal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "add_id")
	private int addId;
	
	@Column(name = "add_line")
	private String addLine;
	
	@Column(name = "distt")
	private String distt;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private int pincode;

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getAddLine() {
		return addLine;
	}

	public void setAddLine(String addLine) {
		this.addLine = addLine;
	}

	public String getDistt() {
		return distt;
	}

	public void setDistt(String distt) {
		this.distt = distt;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", addLine=" + addLine + ", distt=" + distt + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
}
