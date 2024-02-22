

package com.example.s19d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.s19d2.entity.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * MemberRepository
 */
public interface MemberRepository extends JpaRepository<Member,Long>{

    @Query("SELECT m FROM Member m WHERE m.email=:email")
    Optional<Member> findByEmail(String email);

    
}