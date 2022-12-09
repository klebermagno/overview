package com.klebermagno.application;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import java.lang.annotation.Retention;
import javax.inject.Inject;
import javax.inject.Qualifier;
import java.time.LocalDate;
import java.util.Optional;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.BankCardType;
import com.klebermagno.dto.User;
import com.klebermagno.api.Bank;
import com.klebermagno.serviceimpl.BankServiceImpl;
import com.klebermagno.service.BankService;
import com.klebermagno.api.impl.BankImpl;
/**
 * This class is a implementation of java 8,9,10 features with lombok and guice as a
 * dependency injection tool.

 */
public class App {

  private final Bank bank;
  private final BankService service;

  @Inject
  App(@ProviderModule.TheBank Bank bank, @ProviderModule.TheBankService BankService service){
    this.bank = bank;
    this.service = service;
  }

  public static void main(String[] args) {
    // Creates an injector that has all the necessary dependencies needed to
    // build a functional server.
    Injector injector = Guice.createInjector(new ProviderModule());
    // Bootstrap the application by creating an instance of the server then
    // start the server to handle incoming requests.
    injector.getInstance(App.class)
        .start();

  }

/**
 */
  public void start(){

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
class ProviderModule extends AbstractModule {
  @Qualifier
  @Retention(RUNTIME)
  @interface TheBank {}

  @Qualifier
  @Retention(RUNTIME)
  @interface TheBankService {}

  @Provides
  @TheBank
  static Bank provideBankImpl() {
    return new BankImpl();
  }

  @Provides
  @TheBankService
  static BankService proviceBankServiceImpl() {
    return new BankServiceImpl();
  }
}