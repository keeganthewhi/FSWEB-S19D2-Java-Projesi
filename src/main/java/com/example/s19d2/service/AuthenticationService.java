package com.example.s19d2.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Authority;
import com.example.s19d2.entity.Member;
import com.example.s19d2.entity.Role;
import com.example.s19d2.repository.MemberRepository;
import com.example.s19d2.repository.RoleRepository;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthenticationService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

  

    public Member register(String email, String password){
        Optional<Member> byEmail = memberRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            throw new RuntimeException("User with given email already exist! Email: " + email);
        }
        String encodedPassword = passwordEncoder.encode(password);
        List<Role> rolesAuth = new ArrayList<>();

        Optional<Role> roleAdmin = roleRepository.findByAuthority(Authority.ADMIN);
        if (!roleAdmin.isPresent()) {
            Role roleAdminEntity = new Role();
            roleAdminEntity.setAuthority(Authority.ADMIN);
            rolesAuth.add(roleRepository.save(roleAdminEntity));
        } else {
            rolesAuth.add(roleAdmin.get());
        }




        Member member = new Member();

        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoles(rolesAuth);

        return memberRepository.save(member);
    }
}
