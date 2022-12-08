package com.klebermagno.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;

public interface BankService {
  default double getAverageUsersAge() {
    return (int) getAllUsers()
      .stream()
      .mapToInt(user -> {
        return (int) LocalDate.now().getYear() - user.getBirthday().getYear();
      })
      .average()
      .getAsDouble();
  }

  default boolean isPayableUser(User user) {
    int age = (int) (user.getBirthday().getYear() - LocalDate.now().getYear());
    return age >= 18;
  }

  void subscribe(BankCard b);

  Optional<Subscription> getSubscriptionByBankCardNumber(String number);

  List<User> getAllUsers();

  List<Subscription> getAllSubscriptionsByCondition(
    Predicate<Subscription> predicate
  );
}
