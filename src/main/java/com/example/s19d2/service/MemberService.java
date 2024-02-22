package com.example.s19d2.service;

import java.util.List;

import com.example.s19d2.entity.Member;

public interface MemberService {

     
     List<Member> findAll();

     Member save (Member member);

     Member update(long id, Member member);

     Member delete(long id);

    
}
