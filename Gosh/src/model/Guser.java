package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GUSERS database table.
 * 
 */
@Entity
@Table(name="GUSERS")
@NamedQuery(name="Guser.findAll", query="SELECT g FROM Guser g")
public class Guser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private double balance;

	private String name;

	private String password;

	private String username;

	public Guser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}