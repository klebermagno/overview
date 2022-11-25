package com.klebermagno.serviceimpl;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import com.klebermagno.service.BankService;

import java.time.LocalDate;
import java.util.*;


public class BankServiceImpl implements BankService{

    private Map<String,BankCard> bankCards = new HashMap<String,BankCard>();
    private List<Subscription> subscriptions = new ArrayList<Subscription>();

    @Override
    public void subscribe(BankCard bankCard) {
        Subscription subscription = 
            new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.add(subscription);
        bankCards.put(bankCard.getNumber(), bankCard);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}