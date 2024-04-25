package edu.tcu.cs.onlineshop.service;

import edu.tcu.cs.onlineshop.dao.EwalletDao;
import edu.tcu.cs.onlineshop.domain.Ewallet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EwalletServiceTest {

    @Mock
    EwalletDao ewalletDao;
    @InjectMocks
    EwalletService ewalletService;

    List<Ewallet> list;

    @BeforeEach
    void setUp() {
        Ewallet e1 = new Ewallet();
        e1.setId("1");
        e1.setBalance(100.00);
        e1.setTimeCreate("01/01/2023");
        e1.setTimeModify("01/01/2023");
        e1.setStatus("Normal");

        Ewallet e2 = new Ewallet();
        e2.setId("2");
        e2.setBalance(100.00);
        e2.setTimeCreate("01/01/2023");
        e2.setTimeModify("01/01/2023");
        e2.setStatus("Normal");

        list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void buyCredit() {
    }

    @Test
    void withdraw() {
    }

    @Test
    void freeze() {
    }

    @Test
    void transaction() {
    }

    @Test
    void unfreeze() {
    }
}