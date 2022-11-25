package com.klebermagno.dto;

import lombok.experimental.SuperBuilder;
import lombok.Data;
@Data
@SuperBuilder
public class BankCard {
    
    private String number;

    private User user;

}
