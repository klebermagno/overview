package com.klebermagno.serviceimpl;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import com.klebermagno.service.BankService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

  private Map<String, BankCard> bankCards = new HashMap<String, BankCard>();
  private List<Subscription> subscriptions = new ArrayList<Subscription>();
  private List<User> users = new ArrayList<User>();

  @Override
  public void subscribe(BankCard bankCard) {
    users.add(bankCard.getUser());
    Subscription subscription = new Subscription(
      bankCard.getNumber(),
      LocalDate.now()
    );
    subscriptions.add(subscription);
    bankCards.put(bankCard.getNumber(), bankCard);
  }

  @Override
  public Optional<Subscription> getSubscriptionByBankCardNumber(String number) {
    return subscriptions
      .stream()
      .filter(subscribe -> subscribe.getBankCard().equals(number))
      .findAny();
     // .orElseThrow(() -> new NumberDontMatchException());
  }

  @Override
  public List<User> getAllUsers() {
    return this.users;
  }

  @Override
  public double getAverageUsersAge() {
    return (int) this.getAllUsers()
      .stream()
      .mapToInt(user -> {
        return (int) LocalDate.now().getYear() - user.getBirthday().getYear();
      })
      .average()
      .getAsDouble();
  }

  @Override
  public boolean isPayableUser(User user) {
    int age = (int) (user.getBirthday().getYear() - LocalDate.now().getYear());
    return (age >= 18);
  }

  @Override
  public List<Subscription> getAllSubscriptionsByCondition(
    Predicate<Subscription> predicate
  ) {
    return this.subscriptions.stream()
      .filter(predicate)
      .collect(Collectors.toUnmodifiableList());
  }
}
