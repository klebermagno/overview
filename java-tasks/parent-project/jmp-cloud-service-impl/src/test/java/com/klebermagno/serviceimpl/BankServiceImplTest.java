package com.klebermagno.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.klebermagno.dto.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceImplTest {
    private final User user1 = User.builder()
                    .name("Name-1")
                    .surname("Surname-1")
                    .birthday(LocalDate.of(1981,7,31))
                    .build();
    private final BankCard bc1 = BankCard.builder()
            .number("1234")
            .user(user1)
            .build();
    private final User user2 = User.builder()
            .name("Name-2")
                            .surname("Surname-2")
                            .birthday(LocalDate.now())
            .build();

    private final BankCard bc2 = BankCard.builder()
            .number("5678")
            .user(user2)
            .build();
    private final BankServiceImpl service = new BankServiceImpl();

    @Test
    public void shouldSubscribeAndGetSubscriptionByBankCardNumber(){


        service.subscribe(bc1);
        Subscription subscription =
                service.getSubscriptionByBankCardNumber("1234");
        assertEquals(bc1.getNumber(), subscription.getBankCard());

    }

    @Test
    public void shouldGetAllUsers() {
        service.subscribe(bc1);
        service.subscribe(bc2);
        assertEquals(2,service.getAllUsers().size());
        assertEquals(user1, service.getAllUsers().stream()
                .filter(user->user.equals(user1))
                .findAny()
                .get());
    }

    @Test
    public void shouldGetIsPayableUserFalse() {
        service.subscribe(bc2);
        assertFalse(service.isPayableUser(user2));
    }

    @Test
    public void shouldGetIsPayableUserTrue() {
        service.subscribe(bc2);
        assertTrue(service.isPayableUser(user1));
    }

    @Test
    public void shouldGetAllSubscriptionsByCondition() {
        service.subscribe(bc1);
        service.subscribe(bc2);
        List<Subscription> subscriptionList =
                service.getAllSubscriptionsByCondition(
                        subscription -> subscription.getBankCard().equals("1234"));
        assertEquals(1,subscriptionList.size());
        assertEquals("1234",subscriptionList.get(0).getBankCard());
    }
}
