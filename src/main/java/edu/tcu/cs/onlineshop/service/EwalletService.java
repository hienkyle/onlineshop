package edu.tcu.cs.onlineshop.service;

import edu.tcu.cs.onlineshop.dao.EwalletDao;
import edu.tcu.cs.onlineshop.domain.Ewallet;
import edu.tcu.cs.onlineshop.utils.IdWorker;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
public class EwalletService {
    private EwalletDao ewalletDao;
    private IdWorker idWorker;

    //Automatic injection of EwalletDao and IdWorker into this class
    public EwalletService(EwalletDao ewalletDao, IdWorker idWorker) {
        this.ewalletDao = ewalletDao;
        this.idWorker = idWorker;
    }

    public Ewallet findById(String ewalletId){
        return ewalletDao.findById(ewalletId).get();
    }

    public void save(Ewallet newEwallet) {
        newEwallet.setId(idWorker.nextId() + "");
        newEwallet.setBalance(0.0);
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        newEwallet.setTimeCreate(date + " " + time);
        newEwallet.setTimeModify(date + " " + time);
        newEwallet.setStatus("Normal");
        ewalletDao.save(newEwallet);
    }


    public void update(String ewalletId, Ewallet updatedEwallet) {
        updatedEwallet.setId(ewalletId);
        Ewallet curr = ewalletDao.findById(ewalletId).get();
        if(updatedEwallet.getBalance() == -1.0)
            updatedEwallet.setBalance(curr.getBalance());
        updatedEwallet.setTimeCreate(curr.getTimeCreate());
        updatedEwallet.setTimeModify(LocalDate.now()+ " " + LocalTime.now());
        if(updatedEwallet.getStatus() == null)
            updatedEwallet.setStatus(curr.getStatus());
        ewalletDao.save(updatedEwallet);
    }

    public Double getBalance(String ewalletId) {
        return ewalletDao.findById(ewalletId).get().getBalance();
    }

    public void buyCredit(String ewalletId, double credit){
        Ewallet curr = ewalletDao.findById(ewalletId).get();
        if(curr.getStatus().equals("Freeze")) return;

        Ewallet updatedEwallet = new Ewallet();
        updatedEwallet.setId(ewalletId);
        double newBalance = curr.getBalance() + credit;
        updatedEwallet.setBalance(newBalance);
        update(ewalletId, updatedEwallet);
    }

    public boolean withdraw(String ewalletId, double credit) {
        Ewallet curr = ewalletDao.findById(ewalletId).get();
        if(curr.getStatus().equals("Freeze")) return false;
        if(curr.getBalance() < credit) return false;

        Ewallet updatedEwallet = new Ewallet();
        updatedEwallet.setId(ewalletId);
        double newBalance = curr.getBalance() - credit;
        updatedEwallet.setBalance(newBalance);
        update(ewalletId, updatedEwallet);
        return true;
    }

    public void freeze(String ewalletId) {
        ewalletDao.findById(ewalletId).get().setStatus("Freeze");
    }

    public boolean transaction(String ewalletId1, double amount, String ewalletId2) {
        Ewallet e1 = ewalletDao.findById(ewalletId1).get();
        Ewallet e2 = ewalletDao.findById(ewalletId2).get();

        if(e1.getStatus().equals("Freeze") || e2.getStatus().equals("Freeze")) return false;
        if(e1.getBalance() < amount) return false;

        //withdraw from wallet 1
        Ewallet updatedEwallet1 = new Ewallet();
        withdraw(ewalletId1, amount);

        //credit to wallet 2
        Ewallet updatedEwallet2 = new Ewallet();
        buyCredit(ewalletId2, amount);

        return true;
    }

    public void unfreeze(String ewalletId) {
        ewalletDao.findById(ewalletId).get().setStatus("Normal");
    }
}