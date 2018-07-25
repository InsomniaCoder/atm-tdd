package com.insomniacoder.atmtdd.service.implementation;

import com.insomniacoder.atmtdd.domain.ATMMoney;
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
    public void withdraw1000bahtFromMachineWith1000TotalShouldBe0(){
        atmMoney = new ATMMoney();
        atmMoney.setThousandBankNote(1);
        defaultATMService = new DefaultATMService(atmMoney);

        Assert.assertEquals(1000, atmMoney.getTotalAmount());

        defaultATMService.withdraw(1000);

        Assert.assertEquals(0, atmMoney.getTotalAmount());
        Assert.assertEquals(0, atmMoney.getThousandBankNote());
    }


}