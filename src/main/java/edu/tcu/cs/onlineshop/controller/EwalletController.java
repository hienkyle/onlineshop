package edu.tcu.cs.onlineshop.controller;

import edu.tcu.cs.onlineshop.domain.Ewallet;
import edu.tcu.cs.onlineshop.domain.Result;
import edu.tcu.cs.onlineshop.domain.StatusCode;
import edu.tcu.cs.onlineshop.service.EwalletService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ewallet")
public class EwalletController {
    private EwalletService ewalletService;

    public EwalletController(EwalletService ewalletService) {
        this.ewalletService = ewalletService;
    }

    //find wallet by id
    @GetMapping("/{ewalletId}")
    public Result findById(@PathVariable String ewalletId){
        return new Result(true,
                StatusCode.SUCCESS,
                "Find One Success.",
                ewalletService.findById(ewalletId));
    }

    //create a new wallet
    @PostMapping
    public Result save(@RequestBody Ewallet newEwallet){
        ewalletService.save(newEwallet);
        return new Result(true,
                StatusCode.SUCCESS,
                "Save Success.");
    }

    //update an existing wallet
    @PutMapping("/{ewalletId}")
    public Result update(@PathVariable String ewalletId, @RequestBody Ewallet updatedEwallet){
        ewalletService.update(ewalletId, updatedEwallet);
        return new Result(true,
                StatusCode.SUCCESS,
                "Update Success.");
    }

    //user view their balance
    @GetMapping("/balance/{ewalletId}")
    public Result getBalance(@PathVariable String ewalletId){
        return new Result(true,
                StatusCode.SUCCESS,
                "Get Balance Success.",
                ewalletService.getBalance(ewalletId));
    }

    //user buy credits
    @PutMapping("/buy/{ewalletId}")
    public Result buyCredit(@PathVariable String ewalletId, @RequestBody double credit){
        ewalletService.buyCredit(ewalletId, credit);
        return new Result(true,
                StatusCode.SUCCESS,
                "Buy Success.");
    }

    //user withdraw credit
    @PutMapping("/withdraw/{ewalletId}")
    public Result withdraw(@PathVariable String ewalletId, @RequestBody double credit){
        boolean state = ewalletService.withdraw(ewalletId, credit);
        String message;
        if (state) message = "Withdraw Success.";
        else message = "Withdraw Failed. No action has been done.";

        return new Result(true,
                StatusCode.SUCCESS,
                message);
    }

    //user freeze wallet
    @PutMapping("/freeze/{ewalletId}")
    public Result freeze(@PathVariable String ewalletId){
        ewalletService.freeze(ewalletId);
        return new Result(true,
                StatusCode.SUCCESS,
                "Freeze Success.");
    }

    //user unfreeze wallet
    @PutMapping("/unfreeze/{ewalletId}")
    public Result unfreeze(@PathVariable String ewalletId){
        ewalletService.unfreeze(ewalletId);
        return new Result(true,
                StatusCode.SUCCESS,
                "Unfreeze Success.");
    }

    //user do transaction
    @PutMapping("/transaction/{ewalletId1}/{amount}/{ewalletId2}")
    public Result transaction(@PathVariable(name = "ewalletId1") String ewalletId1,
                              @PathVariable(name = "amount") double amount,
                              @PathVariable(name = "ewalletId2") String ewalletId2){
        boolean state = ewalletService.transaction(ewalletId1, amount, ewalletId2);
        String message;
        if(state) message = "Transaction Success.";
        else message = "Transaction failed. No action has been done.";

        return new Result(true,
                StatusCode.SUCCESS,
                message);
    }
}