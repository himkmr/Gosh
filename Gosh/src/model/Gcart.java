package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GCART database table.
 * 
 */
@Entity
@Table(name = "Gcart", schema="TESTDB")
@NamedQuery(name="Gcart.findAll", query="SELECT g FROM Gcart g")
public class Gcart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int bought;

	private String cusername;

	private double price;

	private int productid;

	private String productname;

	private int quantity;

	public Gcart() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBought() {
		return this.bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

	public String getCusername() {
		return this.cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}