package com.parkinglot.model.account;

import com.parkinglot.constant.AccountStatus;
import com.parkinglot.model.Person;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;
}
