package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GPAYMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Gpayment.findAll", query="SELECT g FROM Gpayment g")
public class Gpayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="B_ADDRESS")
	private String bAddress;

	@Column(name="B_CITY")
	private String bCity;

	@Column(name="B_STATE")
	private String bState;

	@Column(name="B_ZIPCODE")
	private String bZipcode;

	@Column(name="C_CODE")
	private Double cCode;

	@Column(name="C_DATE")
	private String cDate;

	@Column(name="C_NUM")
	private Double cNum;

	@Column(name="P_USERNAME")
	private String pUsername;

	@Column(name="S_ADDRESS")
	private String sAddress;

	@Column(name="S_CITY")
	private String sCity;

	@Column(name="S_STATE")
	private String sState;

	@Column(name="S_ZIPCODE")
	private String sZipcode;

	public Gpayment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBAddress() {
		return this.bAddress;
	}

	public void setBAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getBCity() {
		return this.bCity;
	}

	public void setBCity(String bCity) {
		this.bCity = bCity;
	}

	public String getBState() {
		return this.bState;
	}

	public void setBState(String bState) {
		this.bState = bState;
	}

	public String getBZipcode() {
		return this.bZipcode;
	}

	public void setBZipcode(String bZipcode) {
		this.bZipcode = bZipcode;
	}

	public Double getCCode() {
		return this.cCode;
	}

	public void setCCode(Double cCode) {
		this.cCode = cCode;
	}

	public String getCDate() {
		return this.cDate;
	}

	public void setCDate(String cDate) {
		this.cDate = cDate;
	}

	public Double getCNum() {
		return this.cNum;
	}

	public void setCNum(Double cNum) {
		this.cNum = cNum;
	}

	public String getPUsername() {
		return this.pUsername;
	}

	public void setPUsername(String pUsername) {
		this.pUsername = pUsername;
	}

	public String getSAddress() {
		return this.sAddress;
	}

	public void setSAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getSCity() {
		return this.sCity;
	}

	public void setSCity(String sCity) {
		this.sCity = sCity;
	}

	public String getSState() {
		return this.sState;
	}

	public void setSState(String sState) {
		this.sState = sState;
	}

	public String getSZipcode() {
		return this.sZipcode;
	}

	public void setSZipcode(String sZipcode) {
		this.sZipcode = sZipcode;
	}

}