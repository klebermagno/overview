package com.klebermagno.api;

import com.klebermagno.dto.User;
import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.BankCardType;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}