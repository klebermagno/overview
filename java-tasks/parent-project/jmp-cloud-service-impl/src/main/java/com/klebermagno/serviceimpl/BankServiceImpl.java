package com.klebermagno.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import com.klebermagno.exception.NumberDontMatchException;
import com.klebermagno.service.BankService;


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
        .findAny().orElseThrow(new NumberDontMatchException("Number not found: %s",number));
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

   @Override
   default static double getAverageUsersAge(){
    return (int)this.getAllUsers().stream().mapToInt(user -> {
      return (int)LocalDate.now().getYear() - user.getBirthday().getYear();
    }).average().getAsDouble();
  }

  @Override
  default static boolean isPayableUser(User){
    int age = (int)(user.getBirthday().getYear - LocalDate.now().getYear());
    return age >= 18;
  }

  @Override
  List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate){
    return this.subscriptions.stream().filter(predicate).collect(Collectors.toUnmodifiableList());
  }
}