package com.example.s19d2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.s19d2.entity.Authority;
import com.example.s19d2.entity.Role;

/**
 * RoleRepository
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("SELECT r FROM role r WHERE r.authority = :authority")
    Optional<Role> findByAuthority(Authority authority);
}