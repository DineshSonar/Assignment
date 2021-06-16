package com.uxpsystems.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.model.User;

@Repository("userDaoSupport")
public interface UserDaoSupport extends JpaRepository<User, Long>{

}



