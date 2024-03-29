package com.klebermagno.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class Subscription {

    private String bankCard;

    private LocalDate startDate;

    public Subscription(String bankCard, LocalDate startDate) {
        this.bankCard = bankCard;
        this.startDate = startDate;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
