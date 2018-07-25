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

        verifySufficientMoney(amount);

        int deductThousandBank = 0;
        int deductFiveHundredBank = 0;
        int deductHundredBank = 0;
        int deductFiftyBank = 0;
        int deductTwentyBank = 0;

        if (amount >= 1000) {
            while (amount >= 1000) {
                if (atmMoney.getThousandBankNote() - deductThousandBank == 0) {
                    break;
                }
                deductThousandBank += 1;
                amount -= 1000;
            }
        }
        if (amount >= 500) {
            while (amount >= 500) {
                if (atmMoney.getFiveHundredBankNote() - deductFiveHundredBank == 0) {
                    break;
                }
                deductFiveHundredBank += 1;
                amount -= 500;
            }
        }
        if (amount >= 100) {
            while (amount >= 100) {
                if (atmMoney.getHundredBankNote() - deductHundredBank == 0) {
                    break;
                }
                deductHundredBank+=1;
                amount -= 100;
            }
        }
        if (amount >= 50) {

            while (amount >= 50) {
                if (atmMoney.getFiftyBankNote() - deductFiftyBank == 0) {
                    break;
                }
                deductFiftyBank+=1;
                amount -= 50;
            }
        }
        if (amount >= 20) {

            while (amount >= 20) {
                if (atmMoney.getTwentyBankNote() - deductTwentyBank == 0) {
                    break;
                }
                deductTwentyBank+=1;
                amount -= 20;
            }
        }
        if(amount == 10) throw new MoneyNotEnoughException();
        if(isNotDeducted(deductThousandBank,deductFiveHundredBank,deductHundredBank,deductFiftyBank,deductTwentyBank)){
            //bank notes is not dispensable
            throw new MoneyNotEnoughException();
        }
        deductBankNotes(deductThousandBank,deductFiveHundredBank,deductHundredBank,deductFiftyBank,deductTwentyBank);
    }

    private boolean isNotDeducted(int deductThousandBank, int deductFiveHundredBank, int deductHundredBank, int deductFiftyBank, int deductTwentyBank) {
        return (deductThousandBank + deductFiveHundredBank + deductHundredBank + deductFiftyBank + deductTwentyBank) == 0;
    }

    private void deductBankNotes(int deductThousandBank, int deductFiveHundredBank, int deductHundredBank, int deductFiftyBank, int deductTwentyBank) {

        atmMoney.setThousandBankNote(atmMoney.getThousandBankNote() - deductThousandBank);
        atmMoney.setFiveHundredBankNote(atmMoney.getFiveHundredBankNote() - deductFiveHundredBank);
        atmMoney.setHundredBankNote(atmMoney.getHundredBankNote() - deductHundredBank);
        atmMoney.setFiftyBankNote(atmMoney.getFiftyBankNote() - deductFiftyBank);
        atmMoney.setTwentyBankNote(atmMoney.getTwentyBankNote() - deductTwentyBank);
    }

    private void verifySufficientMoney(int amount) throws MoneyNotEnoughException {
        if (amount > atmMoney.getTotalAmount()) throw new MoneyNotEnoughException();
    }
}
