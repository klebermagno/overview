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
    private List<User> users = new ArrayList<User>();

    @Override
    public void subscribe(BankCard bankCard) {
        users.add(bankCard.getUser());
        Subscription subscription = 
            new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.add(subscription);
        bankCards.put(bankCard.getNumber(), bankCard);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
        return subscriptions
        .stream()
        .filter(subscribe -> subscribe.getBankCard().equals(number))
        .findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}