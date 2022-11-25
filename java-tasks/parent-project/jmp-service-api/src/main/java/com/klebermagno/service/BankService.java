package com.klebermagno.service;

import com.klebermagno.dto.BankCard;
import com.klebermagno.dto.Subscription;
import com.klebermagno.dto.User;
import java.util.List;
import java.util.Optional;

public interface BankService {
  
  public void subscribe(BankCard b);

  public Optional<Subscription> getSubscriptionByBankCardNumber(String s);
  
  public List<User> getAllUsers();
}
