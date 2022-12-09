package com.klebermagno.application;

import java.time.LocalDate;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.BankCardType;
import com.klebermagno.dto.User;
import com.klebermagno.serviceimpl.BankServiceImpl;
import com.klebermagno.api.impl.BankImpl;
/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    User user = new User("José", "Silva", LocalDate.of(2020, 1, 8));
    User user2 = User
      .builder()
      .name("Thrum")
      .surname("Donald")
      .birthday(LocalDate.of(2019, 1, 8)).build();
    BankImpl bank = new BankImpl();

    BankCard bc1 = bank.createBankCard(user, BankCardType.CREDIT);
    BankCard bc2 = bank.createBankCard(user, BankCardType.DEBIT);
    BankCard bc3 = bank.createBankCard(user2, BankCardType.CREDIT);

    BankServiceImpl service = new BankServiceImpl();
    service.subscribe(bc1);
    service.subscribe(bc2);
    service.subscribe(bc3);
    
    User  u = service.getAllUsers().stream().filter(user-> user.getName().equals("José")).findAny().get();
    System.out.println(u);
    //user sort
  }
}
