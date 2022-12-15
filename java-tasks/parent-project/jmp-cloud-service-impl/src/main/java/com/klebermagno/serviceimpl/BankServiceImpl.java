package com.klebermagno.serviceimpl;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import com.klebermagno.service.BankService;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

  private final Map<String, BankCard> bankCards = new HashMap<>();
  private final List<Subscription> subscriptions = new ArrayList<>();
  private final List<User> users = new ArrayList<>();

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
  public Subscription getSubscriptionByBankCardNumber(String number) {
    return subscriptions
      .stream()
      .filter(subscribe -> subscribe.getBankCard().equals(number))
      .findAny()
            .orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public List<User> getAllUsers() {
    return this.users;
  }

  @Override
  public double getAverageUsersAge() {
    OptionalDouble optionalAvarage = this.getAllUsers()
      .stream()
      .mapToInt(user -> LocalDate.now().getYear() - user.getBirthday().getYear())
      .average();
    optionalAvarage.orElseThrow();
    return optionalAvarage.getAsDouble();
  }

  @Override
  public boolean isPayableUser(User user) {
    int age = (int) (LocalDate.now().getYear() - user.getBirthday().getYear());
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
