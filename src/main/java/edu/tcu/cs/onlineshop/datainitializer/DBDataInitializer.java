package edu.tcu.cs.onlineshop.datainitializer;

import edu.tcu.cs.onlineshop.dao.EwalletDao;
import edu.tcu.cs.onlineshop.domain.Ewallet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private EwalletDao ewalletDao;

    public DBDataInitializer(EwalletDao ewalletDao) {
        this.ewalletDao = ewalletDao;
    }

    @Override
    public void run(String... args) throws Exception {
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

        Ewallet e3 = new Ewallet();
        e3.setId("3");
        e3.setBalance(100.00);
        e3.setTimeCreate("01/01/2023");
        e3.setTimeModify("01/01/2023");
        e3.setStatus("Normal");

        Ewallet e4 = new Ewallet();
        e4.setId("4");
        e4.setBalance(100.00);
        e4.setTimeCreate("01/01/2023");
        e4.setTimeModify("01/01/2023");
        e4.setStatus("Normal");

        Ewallet e5 = new Ewallet();
        e5.setId("5");
        e5.setBalance(100.00);
        e5.setTimeCreate("01/01/2023");
        e5.setTimeModify("01/01/2023");
        e5.setStatus("Normal");

        ewalletDao.save(e1);
        ewalletDao.save(e2);
        ewalletDao.save(e3);
        ewalletDao.save(e4);
        ewalletDao.save(e5);
    }
}