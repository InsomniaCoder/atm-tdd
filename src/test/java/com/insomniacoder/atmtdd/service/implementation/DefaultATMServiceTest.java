package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;
import com.insomniacoder.atmtdd.service.ATMService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultATMServiceTest {

    private ATMService defaultATMService;
    private ATMMoney atmMoney;


    //success case for 1000
    @Test
    public void withdraw1000bahtFromMachineWith2000TotalShouldBe1000() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(2);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(2000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(1000);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());
        Assert.assertEquals(1, atmMoney.getThousandBankNote());
    }

    @Test
    public void withdraw3000bahtFromMachineWith7000TotalShouldBe4000() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(7);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(7000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(3000);

        Assert.assertEquals(4000, atmMoney.getTotalAmount());
        Assert.assertEquals(4, atmMoney.getThousandBankNote());
    }

    //success case for 500
    @Test
    public void withdraw500bahtFromMachineWithTwo500TotalShouldBe500() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setFiveHundredBankNote(2);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(500);

        Assert.assertEquals(500, atmMoney.getTotalAmount());
        Assert.assertEquals(1, atmMoney.getFiveHundredBankNote());
    }

    //success case for 100
    @Test
    public void withdraw300bahtFromMachineWith7HundredBankTotalShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setHundredBankNote(7);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(700, atmMoney.getTotalAmount());

        defaultATMService.withdraw(300);

        Assert.assertEquals(400, atmMoney.getTotalAmount());
        Assert.assertEquals(4, atmMoney.getHundredBankNote());
    }

    //success case for 50
    @Test
    public void withdraw150bahtFromMachineWith6fiftyBankTotalShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setFiftyBankNote(6);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(300, atmMoney.getTotalAmount());

        defaultATMService.withdraw(150);

        Assert.assertEquals(150, atmMoney.getTotalAmount());
        Assert.assertEquals(3, atmMoney.getFiftyBankNote());
    }

    //success case for 20
    @Test
    public void withdraw60bahtFromMachineWith5TwentyBankTotalShouldSuccess() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setTwentyBankNote(5);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(100, atmMoney.getTotalAmount());

        defaultATMService.withdraw(60);

        Assert.assertEquals(40, atmMoney.getTotalAmount());
        Assert.assertEquals(2, atmMoney.getTwentyBankNote());
    }

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


    @Test(expected = MoneyNotEnoughException.class)
    public void overWithdrawShouldThrowMoneyNotEnoughException() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        defaultATMService = new DefaultATMService(atmMoney);
        defaultATMService.withdraw(500);
    }

    /*@Test(expected = MoneyNotEnoughException.class)
    public void withdraw500bahtFromMachineWithOne1000TotalShouldThrowMoneyNotEnoughException() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(1);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(500);
    }*/
}