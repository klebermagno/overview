package com.klebermagno.api.impl;

import com.klebermagno.api.Bank;
import com.klebermagno.dto.*;

import java.util.Random;


public class BankImpl implements Bank {

  private static Random random = new Random(System.currentTimeMillis());

  public BankCard createBankCard(User user, BankCardType bankCardType) {
    BankCard bankCard = null;
    switch (bankCardType) {
      case CREDIT:
        bankCard  = CreditBankCard.builder().number(generate()).user(user).build();
        break;
      case DEBIT:
        bankCard = DebitBankCard.builder().number(generate()).user(user).build();
        break;
      default:
        break;
    }
    return bankCard;
  }

  private static String generate() {
    String bin = "1234";
    int length = 12;
    int randomNumberLength = length - (bin.length() + 1);
    StringBuilder builder = new StringBuilder(bin);
    for (int i = 0; i < randomNumberLength; i++) {
      int digit = random.nextInt(10);
      builder.append(digit);
    }
    // Do the Luhn algorithm to generate the check digit.
    var checkDigit = getCheckDigit(builder.toString());
    builder.append(checkDigit);
    return builder.toString();
  }

  private static int getCheckDigit(String number) {
    int sum = 0;
    for (int i = 0; i < number.length(); i++) {
      // Get the digit at the current position.
      int digit = Integer.parseInt(number.substring(i, (i + 1)));
      if ((i % 2) == 0) {
        digit = digit * 2;
        if (digit > 9) {
          digit = (digit / 10) + (digit % 10);
        }
      }
      sum += digit;
    }
    // The check digit is the number required to make the sum a multiple of
    // 10.
    int mod = sum % 10;
    return ((mod == 0) ? 0 : 10 - mod);
  }
}
