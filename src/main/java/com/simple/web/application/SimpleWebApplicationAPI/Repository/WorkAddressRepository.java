package com.simple.web.application.SimpleWebApplicationAPI.Repository;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkAddressRepository extends JpaRepository<WorkAddress, Integer> {
}
