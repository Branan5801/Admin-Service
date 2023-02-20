package com.tns.adminservice;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin_Service_Controller {
	@Autowired(required=true)
	private Admin_Service service;
	
	@GetMapping("/Adminservice")
	public java.util.List<Admin> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/Adminservice/{A_userid}")
	public ResponseEntity<Admin> get(@PathVariable Integer A_userid)
	{
		try
		{
			Admin A=service.get(A_userid);
			return new ResponseEntity<Admin>(A,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Adminservice")
	public void add(@RequestBody Admin A)
	{
		service.save(A);
	}
	
	@PutMapping("/Adminservice/{A_userid}")
	public ResponseEntity<?> update(@RequestBody Admin A, @PathVariable Integer A_userid)
	{
		Admin existA=service.get(A_userid);
		service.save(existA);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/Adminservice/{A_userid}")
	public void delete(@PathVariable Integer A_userid)
	{
		service.delete(A_userid);
	}

}
