package com.practice2.springbootmysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
@Entity
@XmlRootElement 
public class Contact {
	
//	public Integer id;
//	public String firstName;
//	public String lastName;
//	public String phone;
//	public String email;
//	public Address address;
	
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="id")
	@JsonProperty("id")
	public Integer id;
	@Column(name="Name")
	public String name;
	@Column(name="Age")
	public Integer age;
	@Column(name="City")
	public String city;
	@Column(name="State")
	public String state;

}
