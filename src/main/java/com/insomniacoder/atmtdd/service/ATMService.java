package com.insomniacoder.atmtdd.service;

import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;

public interface ATMService {

     void withdraw(int amount) throws MoneyNotEnoughException;
}
