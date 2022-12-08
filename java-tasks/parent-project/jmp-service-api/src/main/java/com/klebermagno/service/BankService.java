package com.klebermagno.service;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface BankService {
  
  default static double getAverageUsersAge(){
    return (int)this.getAllUsers().stream().mapToInt(user -> {
      return (int)LocalDate.now().getYear() - user.getBirthday().getYear();
    }).average().getAsDouble();
  }

  default static boolean isPayableUser(User){
    int age = (int)(user.getBirthday().getYear - LocalDate.now().getYear());
    return age >= 18;
  }
  
  public void subscribe(BankCard b);

  public Optional<Subscription> getSubscriptionByBankCardNumber(String number);
  
  public List<User> getAllUsers();

  List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription>);
}
