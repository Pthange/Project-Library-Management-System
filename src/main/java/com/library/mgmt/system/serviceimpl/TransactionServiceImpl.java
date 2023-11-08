package com.library.mgmt.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.TransactionRepository;
import com.library.mgmt.system.dto.TransactionDTO;
import com.library.mgmt.system.entity.Transaction;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.TransactionService;
import com.library.mgmt.system.util.Converter;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private Converter converter;

    // Method to create a Transaction
    @Override
    public TransactionDTO createTransaction(Transaction transaction) {
        // Set any necessary attributes specific to the Transaction entity
        Transaction savedTransaction = transactionRepository.save(transaction);
        return converter.convertToTransactionDTO(savedTransaction);
    }

    // Method to retrieve all Transactions
    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();

        List<TransactionDTO> dtoList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            dtoList.add(converter.convertToTransactionDTO(transaction));
        }

        return dtoList;
    }

    // Method to get a Transaction by ID
    @Override
    public TransactionDTO getTransactionById(int id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Transaction", "Id", id));
        return converter.convertToTransactionDTO(transaction);
    }

    // Method to update a Transaction by ID
    @Override
    public TransactionDTO updateTransaction(int id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Transaction", "Id", id));

        // Update other attributes specific to the Transaction entity
        // For example: existingTransaction.setSomeAttribute(transaction.getSomeAttribute());

        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return converter.convertToTransactionDTO(updatedTransaction);
    }

    // Method to delete a Transaction by ID
    @Override
    public String deleteTransaction(int id) {
        Transaction removingTransaction = transactionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Transaction", "Id", id));

        transactionRepository.deleteById(id);
        return "Transaction deleted successfully!";
    }
}
