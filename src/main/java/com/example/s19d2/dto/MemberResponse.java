package com.example.s19d2.dto;

import java.util.List;

import com.example.s19d2.entity.Role;

public record MemberResponse (long id, String email, List<Role> roles ){
    
}