package com.klebermagno.application;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import java.lang.annotation.Retention;
import javax.inject.Inject;
import javax.inject.Qualifier;

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
    // Creates an injector that has all the necessary dependencies needed to
    // build a functional server.
    Injector injector = Guice.createInjector(
        new RequestLoggingModule(),
        new RequestHandlerModule(),
        new AuthenticationModule(),
        new DatabaseModule());
    // Bootstrap the application by creating an instance of the server then
    // start the server to handle incoming requests.
    injector.getInstance(App.class)
        .start();

  }

  public void start(){


    User user1 = new User("José", "Silva", LocalDate.of(2020, 1, 8));
    User user2 = User
      .builder()
      .name("Thrum")
      .surname("Donald")
      .birthday(LocalDate.of(2019, 1, 8)).build();
    BankImpl bank = new BankImpl();

    BankCard bc1 = bank.createBankCard(user1, BankCardType.CREDIT);
    BankCard bc2 = bank.createBankCard(user1, BankCardType.DEBIT);
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
