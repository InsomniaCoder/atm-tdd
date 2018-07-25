package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;
import com.insomniacoder.atmtdd.service.ATMService;

public class DefaultATMService implements ATMService {

    private ATMMoney atmMoney;

    public DefaultATMService(ATMMoney atmMoney) {
        this.atmMoney = atmMoney;
    }

    @Override
    public void withdraw(int amount) throws MoneyNotEnoughException {

        if (amount > atmMoney.getTotalAmount()) throw new MoneyNotEnoughException();


        if (amount >= 1000) {
            while (amount >= 1000) {
                if(atmMoney.getThousandBankNote() == 0){
                    break;
                }
                atmMoney.setThousandBankNote(atmMoney.getThousandBankNote() - 1);
                amount -= 1000;
            }
        }
        if (amount >= 500) {
            while (amount >= 500) {
                if(atmMoney.getFiveHundredBankNote() == 0){
                    break;
                }
                atmMoney.setFiveHundredBankNote(atmMoney.getFiveHundredBankNote() - 1);
                amount -= 500;
            }
        }
        if (amount >= 100) {
            while (amount >= 100) {
                if(atmMoney.getHundredBankNote() == 0){
                    break;
                }
                atmMoney.setHundredBankNote(atmMoney.getHundredBankNote() - 1);
                amount -= 100;
            }
        }
        if (amount >= 50) {

            while (amount >= 50) {
                if(atmMoney.getFiftyBankNote() == 0){
                    break;
                }
                atmMoney.setFiftyBankNote(atmMoney.getFiftyBankNote() - 1);
                amount -= 50;
            }
        }
        if (amount >= 20) {

            while (amount >= 20) {
                if(atmMoney.getTwentyBankNote() == 0){
                    break;
                }
                atmMoney.setTwentyBankNote(atmMoney.getTwentyBankNote() - 1);
                amount -= 20;
            }
        }


    }
}
