package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.service.ATMService;

public class DefaultATMService implements ATMService {

    private ATMMoney atmMoney;

    public DefaultATMService(ATMMoney atmMoney) {
        this.atmMoney = atmMoney;
    }

    @Override
    public void withdraw(int amount) {

        if(amount >= 1000){
            while (amount >= 1000) {
                atmMoney.setThousandBankNote(atmMoney.getThousandBankNote() - 1);
                amount -= 1000;
            }
        }else if(amount >= 500){
            while (amount >= 500) {
                atmMoney.setFiveHundredBankNote(atmMoney.getFiveHundredBankNote() - 1);
                amount -= 500;
            }
        }



    }
}
