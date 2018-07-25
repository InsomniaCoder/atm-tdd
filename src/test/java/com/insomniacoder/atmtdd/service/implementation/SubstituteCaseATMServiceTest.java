package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;
import com.insomniacoder.atmtdd.service.ATMService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubstituteCaseATMServiceTest {

    private ATMService defaultATMService;
    private ATMMoney atmMoney;

    //substitute case for 1000
    @Test
    public void withdraw1000bahtFromMachineWith0ThousandAnd2FiveHundredShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setFiveHundredBankNote(2);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(1000);

        Assert.assertEquals(0, atmMoney.getTotalAmount());
        Assert.assertEquals(0, atmMoney.getFiveHundredBankNote());
    }
}