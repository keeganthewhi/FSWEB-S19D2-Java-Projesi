package com.example.s19d2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Member;
import com.example.s19d2.exception.MemberException;
import com.example.s19d2.repository.MemberRepository;
import com.example.s19d2.validation.MemberValidation;


@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Override
    public List<Member> findAll() {
       return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
       MemberValidation.isMemberCredentialsValid(member);
       return memberRepository.save(member);
    }

    @Override
    public Member update(long id, Member member) {
       MemberValidation.isMemberCredentialsValid(member);
       MemberValidation.isIdValid(id);
       memberRepository.findById(id).orElseThrow(()->new MemberException("There is no member with given id", HttpStatus.NOT_FOUND));       
       member.setId(id);
       return memberRepository.save(member) ;
    }

    @Override
    public Member delete(long id) {
        MemberValidation.isIdValid(id); 
        Member member = memberRepository.findById(id).orElseThrow(()->new MemberException("There is no member with given id", HttpStatus.NOT_FOUND)); 
        memberRepository.delete(member);  
        return member;
    }
    
}
