package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
import com.insomniacoder.atmtdd.exception.MoneyNotEnoughException;
import com.insomniacoder.atmtdd.service.ATMService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionCaseATMServiceTest {

    private ATMService defaultATMService;
    private ATMMoney atmMoney;


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