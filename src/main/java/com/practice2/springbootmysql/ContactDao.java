package com.practice2.springbootmysql;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ContactDao extends CrudRepository<Contact, Integer> {

}
