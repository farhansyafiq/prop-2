package com.prop.prop2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prop.prop2.model.RoleModel;
import com.prop.prop2.repository.RoleDb;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDb roleDb;
	
	@Override
	public List<RoleModel> listRole() {
		// TODO Auto-generated method stub
		return roleDb.findAll();
	}

}
