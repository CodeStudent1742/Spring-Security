package com.springboot2.security;

import com.springboot2.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findAllByUsername(String username);
}
