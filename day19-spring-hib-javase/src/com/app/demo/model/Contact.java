package com.app.demo.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dac_contacts")
public class Contact {
	private Integer id;
	private String email;
	private String name;
	private String password;
	private double subAmount;
	private Date subDate;
	private String gender;
	private String country;
	private List<String> hobbies;

	public Contact() {
		System.out.println("in contact constr");
	}

	public Contact(String email, String name, String password,
			double subAmount, Date subDate, String gender, String country,
			List<String> hobbies) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.subAmount = subAmount;
		this.subDate = subDate;
		this.gender = gender;
		this.country = country;
		this.hobbies = hobbies;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sub_amt", columnDefinition = "decimal(6,1)")
	public double getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(double subAmount) {
		this.subAmount = subAmount;
	}

	@Column(name = "sub_date")
	@Temporal(TemporalType.DATE)
	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	@Column(length = 10)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(length = 10)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ElementCollection
	@JoinTable(name = "dac_cont_hobbies",
	joinColumns = @JoinColumn(name = "cont_id"))
	@Column(name="hobby",length=20)
	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Contact [email=" + email + ", name=" + name + ", subAmount="
				+ subAmount + ", subDate=" + subDate + ", gender=" + gender
				+ ", country=" + country + ", hobbies=" + hobbies + "]";
	}

}
