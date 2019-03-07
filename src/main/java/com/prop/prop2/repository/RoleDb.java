package com.prop.prop2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prop.prop2.model.RoleModel;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long>{

} 
