package com.example.s19d2.service;

import java.util.List;

import com.example.s19d2.entity.Account;

public interface AccountService {

     
     List<Account> findAll();

     Account save (Account account);

     Account update(long id, Account account);

     Account delete(long id);

    
}
