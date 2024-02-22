package com.example.s19d2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema="s19d2", name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ManyToMany
    @JoinTable(name = "member_role", schema = "s19d2", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> members;

    public void addRole(Member member){
       if(members == null ){
         members = new ArrayList<>();
       }
       members.add(member);
    }
    
}
