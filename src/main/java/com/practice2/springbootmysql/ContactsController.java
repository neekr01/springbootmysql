package com.practice2.springbootmysql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contacts")
@RestController
@CrossOrigin
public class ContactsController {
	
	@Autowired
	ContactDao dao;
	
	@RequestMapping(path="/info", method=RequestMethod.GET)
	public String info() {
		return "Springboot connected to Mysql";
	}
	
	
	@RequestMapping(path="/",method=RequestMethod.GET, produces= "application/json")
	public Iterable<Contact> getAllContacts() {
		Iterable<Contact>contacts=dao.findAll();
		ArrayList<Contact>list=new ArrayList<Contact>();
		Iterator<Contact>itr=contacts.iterator();
		while(itr.hasNext()) {
			Contact fContact=itr.next();
			if(fContact.getAge()>=23 && fContact.getAge()<=25) {
				((ArrayList<Contact>) list).add(fContact);
				
			}
		}
		return list;
	}
	
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET, produces="application/json")
	public Optional<Contact> getContactById(@PathVariable Integer id) {
		return dao.findById(id);
	}
	
	
	@RequestMapping(path="/", method=RequestMethod.POST, produces="application/json")
	public Contact addNewContact(@RequestBody Contact contact) {
		return dao.save(contact);
	}
	
	@RequestMapping(path="/", method=RequestMethod.PUT, produces="application/json")
	public Contact updateContact(@RequestBody Contact user) {
		Contact contact=dao.findById(user.getId()).get();
		if(user.getCity()!=null) {contact.setCity(user.getCity());}
		if(user.getState()!=null) {contact.setState(user.getState());}
		if(user.getAge()!=null) {contact.setAge(user.getAge());}
		dao.save(contact);
		return contact;
	}

}
