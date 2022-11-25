package com.klebermagno.api.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import com.klebermagno.dto.*;
import org.junit.jupiter.api.Test;


public class BankImplTest {
    
    @Test
    public void shouldCreateACreditBankCard()
    {
        BankImpl bankCardImpl = new BankImpl();
        User user = new User("José", "Silva", LocalDate.of(2020, 1, 8));
        BankCard bankCard = bankCardImpl.createBankCard(user, BankCardType.CREDIT);
        assertTrue( bankCard instanceof CreditBankCard );

    }    

    @Test
    public void shouldCreateADebitBankCard()
    {
        BankImpl bankCardImpl = new BankImpl();
        User user = new User("José", "Silva", LocalDate.of(2020, 1, 8));
        BankCard bankCard = bankCardImpl.createBankCard(user, BankCardType.DEBIT);
        assertTrue( bankCard instanceof DebitBankCard );

    }

}