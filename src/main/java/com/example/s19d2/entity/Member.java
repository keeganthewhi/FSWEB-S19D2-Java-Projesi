package com.example.s19d2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Entity
@Table(name="member",schema="s19d2")
public class Member {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(name = "member_role", schema = "s19d2", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public void addRole(Role role){
       if(roles == null ){
         roles = new ArrayList<>();
       }
       roles.add(role);
    }

    
}
