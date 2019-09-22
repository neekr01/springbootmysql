package com.practice2.springbootmysql;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	public Integer id;
	public Integer newAge;
	public String newCity;
	public String newState;

}
