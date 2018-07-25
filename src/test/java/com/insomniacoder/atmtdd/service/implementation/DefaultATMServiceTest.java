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


    @Test
    public void withdraw1000bahtFromMachineWith1000TotalShouldBe0() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(1);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(1000);

        Assert.assertEquals(0, atmMoney.getTotalAmount());
        Assert.assertEquals(0, atmMoney.getThousandBankNote());
    }

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

    @Test(expected = MoneyNotEnoughException.class)
    public void overWithdrawShouldThrowMoneyNotEnoughException() throws MoneyNotEnoughException {
        atmMoney = new ATMMoney();
        defaultATMService = new DefaultATMService(atmMoney);
        defaultATMService.withdraw(500);
    }


}