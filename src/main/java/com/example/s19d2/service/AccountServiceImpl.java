package com.example.s19d2.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.s19d2.entity.Account;
import com.example.s19d2.exception.AccountException;
import com.example.s19d2.repository.AccountRepository;
import com.example.s19d2.validation.AccountValidation;


import lombok.AllArgsConstructor;

/**
 * AccountServiceImpl
 */
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository accountRepository;
  
    
    @Override
    public List<Account> findAll() {
       return accountRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Account save(Account account) {
        AccountValidation.isAccountCredentialsValid(account);

       return accountRepository.save(account);
    }

    @Override
    public Account update(long id, Account account) {
     AccountValidation.isIdValid(id);
     AccountValidation.isAccountCredentialsValid(account);
     accountRepository.findById(id).orElseThrow(()->new AccountException("There is no account with given id", HttpStatus.NOT_FOUND));
     account.setId(id);
     return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
        AccountValidation.isIdValid(id);
       Account existingAccount = accountRepository.findById(id).orElseThrow(()->new AccountException("There is no account with given id", HttpStatus.NOT_FOUND));

       accountRepository.delete(existingAccount);
       return existingAccount;
       
    }

    
}