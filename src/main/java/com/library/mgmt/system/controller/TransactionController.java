package com.library.mgmt.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.mgmt.system.dto.TransactionDTO;
import com.library.mgmt.system.entity.Transaction;
import com.library.mgmt.system.exception.TransactionNotFoundException;
import com.library.mgmt.system.service.TransactionService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private Converter converter;

    //create a transaction
    @PostMapping("/createTransaction")
    ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) throws TransactionNotFoundException {
        final Transaction transaction = converter.convertToTransactionEntity(transactionDTO);
        return new ResponseEntity<TransactionDTO>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    // retrieve all transactions
    @GetMapping("/getAllTransactions")
    List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    //get a transaction by its ID
    @GetMapping("/getTransactionById/{tid}")
    TransactionDTO getTransactionById(@PathVariable("tid") int id) throws TransactionNotFoundException {
        return transactionService.getTransactionById(id);
    }

    //to update a transaction
    @PutMapping("/updateTransaction/{id}")
    TransactionDTO updateTransaction(@Valid @PathVariable int id, @RequestBody TransactionDTO transactionDTO) throws TransactionNotFoundException {
        final Transaction transaction = converter.convertToTransactionEntity(transactionDTO);
        return transactionService.updateTransaction(id, transaction);
    }

    //to delete a transaction by its ID
    @DeleteMapping("/deleteTransaction/{id}")
    String deleteTransaction(@PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }
}
