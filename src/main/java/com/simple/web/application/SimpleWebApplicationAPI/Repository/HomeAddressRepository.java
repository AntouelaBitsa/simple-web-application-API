package com.simple.web.application.SimpleWebApplicationAPI.Repository;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.HomeAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeAddressRepository extends JpaRepository<HomeAddress, Integer> {
}
