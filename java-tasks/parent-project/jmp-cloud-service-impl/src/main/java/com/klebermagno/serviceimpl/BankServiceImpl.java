package com.klebermagno.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Subscription;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.User;
import com.klebermagno.service.BankService;


public class BankServiceImpl implements BankService{

    private Map<String><BankCard> bankCards = new HashMap();
    private List<Subscription> subscriptions = new ArrayList<>();

    public void subscribe(BankCard bankCard) {
        Subscription subscription = 
            new Subscription(bankCard.getSubscriptionByBankCardNumber, bankCard.getStartDate);
        subscription.add(subscription);
        bankCards.put(b.getSubscriptionByBankCardNumber(), bankCard);
    }

    public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
        return null;
    }

    public List<User> getAllUsers() {
        return null;
    }
}