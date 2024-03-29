package com.klebermagno.application;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.time.LocalDate;
import java.util.Optional;
import java.util.ServiceLoader;
import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.BankCardType;
import com.klebermagno.dto.User;
import com.klebermagno.api.Bank;
import com.klebermagno.service.BankService;
/**
 * This class is a implementation of java 8,9,10 features with lombok and guice as a
 * dependency injection tool.

 */
public class App {

  public static void main(String[] args) {

    BankService service = ServiceLoader
            .load(BankService.class)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
   
    Bank bank = ServiceLoader
            .load(Bank.class)
            .findFirst()
            .orElseThrow(IllegalAccessError::new);

    User user1 = new User("José", "Silva", LocalDate.of(2020, 1, 8));
    User user2 = User
      .builder()
      .name("Thrum")
      .surname("Donald")
      .birthday(LocalDate.of(2019, 1, 8)).build();

    BankCard bc1 = bank.createBankCard(user1, BankCardType.CREDIT);
    BankCard bc2 = bank.createBankCard(user1, BankCardType.DEBIT);
    BankCard bc3 = bank.createBankCard(user2, BankCardType.CREDIT);

    service.subscribe(bc1);
    service.subscribe(bc2);
    service.subscribe(bc3);
    
    Optional<User> optional = service.getAllUsers()
            .stream()
            .filter(user-> user.getName().equals("José"))
            .findAny();
    optional.orElseThrow();
    System.out.println(optional.get());
  
  }

}