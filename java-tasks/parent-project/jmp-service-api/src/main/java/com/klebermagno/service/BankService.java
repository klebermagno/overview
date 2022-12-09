package com.klebermagno.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;

public interface BankService {
  default double getAverageUsersAge() {
    OptionalDouble optionalAvarage = getAllUsers()
      .stream()
      .mapToInt(user -> LocalDate.now().getYear() - user.getBirthday().getYear())
      .average();
    optionalAvarage.orElseThrow();
    return optionalAvarage.getAsDouble();
  }

  default boolean isPayableUser(User user) {
    int age = (user.getBirthday().getYear() - LocalDate.now().getYear());
    return age >= 18;
  }

  void subscribe(BankCard b);

  Optional<Subscription> getSubscriptionByBankCardNumber(String number);

  List<User> getAllUsers();

  List<Subscription> getAllSubscriptionsByCondition(
    Predicate<Subscription> predicate
  );
}
