package com.library.mgmt.system.service;

import java.util.List;

import com.library.mgmt.system.dto.TransactionDTO;
import com.library.mgmt.system.entity.Transaction;

// Service interface for managing Transaction entity
public interface TransactionService {
    // Create a new Transaction
    TransactionDTO createTransaction(Transaction transaction);

    // Retrieve all Transactions
    List<TransactionDTO> getAllTransactions();

    // Retrieve a Transaction by ID
    TransactionDTO getTransactionById(int id);

    // Update a Transaction by ID
    TransactionDTO updateTransaction(int id, Transaction transaction);

    // Delete a Transaction by ID
    String deleteTransaction(int id);
}
