package com.simple.web.application.SimpleWebApplicationAPI.Repository;

import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
