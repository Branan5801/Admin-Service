package com.tns.adminservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Admin_Service {
	@Autowired
	private Admin_Service_Repository repo;
	
	public List<Admin> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Admin A)
	{
		repo.save(A);
	}
	
	public Admin get(Integer A_userid)
	{
		return repo.findById(A_userid).get();
	}
	public void delete(Integer A_userid)
	{
		repo.deleteById(A_userid);
	}

}
