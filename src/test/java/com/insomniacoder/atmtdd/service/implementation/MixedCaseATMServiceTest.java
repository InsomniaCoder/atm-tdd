package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;
import com.insomniacoder.atmtdd.service.ATMService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MixedCaseATMServiceTest {

    private ATMService defaultATMService;
    private ATMMoney atmMoney;


    //success case for 20
    @Test
    public void withdraw1370BahtShouldDeductMultipleBankNotes() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(0);
        atmMoney.setFiveHundredBankNote(3);
        atmMoney.setHundredBankNote(2);
        atmMoney.setFiftyBankNote(3);
        atmMoney.setTwentyBankNote(6);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1970 , atmMoney.getTotalAmount());

        defaultATMService.withdraw(1370);

        Assert.assertEquals(600, atmMoney.getTotalAmount());
        Assert.assertEquals(0, atmMoney.getThousandBankNote());
        Assert.assertEquals(1, atmMoney.getFiveHundredBankNote());
        Assert.assertEquals(0, atmMoney.getHundredBankNote());
        Assert.assertEquals(0, atmMoney.getFiftyBankNote());
        Assert.assertEquals(5, atmMoney.getTwentyBankNote());
    }

}