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
    //substitute case for 500
    @Test
    public void withdraw500bahtFromMachineWith0FiveHundredAnd6HundredShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setHundredBankNote(6);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(600, atmMoney.getTotalAmount());

        defaultATMService.withdraw(500);

        Assert.assertEquals(100, atmMoney.getTotalAmount());
        Assert.assertEquals(1, atmMoney.getHundredBankNote());
    }
    //substitute case for 100
    @Test
    public void withdraw150bahtFromMachineWith0HundredAnd4FiftyShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setFiftyBankNote(4);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(200, atmMoney.getTotalAmount());

        defaultATMService.withdraw(150);

        Assert.assertEquals(50, atmMoney.getTotalAmount());
        Assert.assertEquals(1, atmMoney.getFiftyBankNote());
    }
    //substitute case for 50
    @Test
    public void withdraw100bahtFromMachineWith0fiftyAnd6TwentyShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setTwentyBankNote(6);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(120, atmMoney.getTotalAmount());

        defaultATMService.withdraw(100);

        Assert.assertEquals(20, atmMoney.getTotalAmount());
        Assert.assertEquals(1, atmMoney.getTwentyBankNote());
    }
}