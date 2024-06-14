package com.cognizant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entities.Login;

@Repository
public interface LoginInterface extends JpaRepository<Login, Integer> {


}
