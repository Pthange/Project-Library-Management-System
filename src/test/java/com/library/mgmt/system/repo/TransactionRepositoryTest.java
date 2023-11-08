
package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.TransactionRepository;
import com.library.mgmt.system.entity.Transaction;

@SpringBootTest
public class TransactionRepositoryTest 
{
    @Autowired
    private TransactionRepository transactionRepository;
    // ... (Other test methods here)

    @Test
    public void testCreateTransaction() {
        // Create and save a transaction
        Transaction transaction = new Transaction();

        transaction.setReturnDate("12-05-2023");
        transaction.setBorrowDate("02-04-2023");
       
        Transaction savedTransaction = transactionRepository.save(transaction);
        assertNotNull(savedTransaction.getId());
    }

    @Test
    public void testGetAllTransactions() {
        // Clear the database to ensure a clean state
        transactionRepository.deleteAll();
        
        // Create and save multiple transaction entities
        Transaction transaction1 = new Transaction(1,"12-08-2020", "04-09-2023", "22-08-2023", 00,null, null, null);
        Transaction transaction2 = new Transaction(2,"27-12-2023", "18-01-2024", "28-01-2024", 150, null, null, null);
       
        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        
        // Retrieve all transactions from the database
        List<Transaction> allTransactions = transactionRepository.findAll();

        // Assert that the list is not empty and contains the expected number of transactions
        assertNotNull(allTransactions);
        assertEquals(2, allTransactions.size());
    }

    @Test
    public void testGetTransactionById() {
        // Create and save a transaction
        Transaction transaction = new Transaction();
        transaction.setDueDate("12-02-2024");
        transaction.setId(1);   

        transaction = transactionRepository.save(transaction);

        // Retrieve the transaction by ID
        Transaction retrievedTransaction = transactionRepository.findById(transaction.getId()).orElse(null);

        // Assert that the retrieved transaction is not null and has the correct ID
        assertNotNull(retrievedTransaction);
        assertEquals(transaction.getId(), retrievedTransaction.getId());
        assertEquals("12-02-2024", retrievedTransaction.getDueDate());
        
    }

    @Test
    public void testUpdateTransactionById() {
        // Create and save a transaction
        Transaction transaction = new Transaction();
        transaction.setDueDate("27-04-2024");
              
        transaction = transactionRepository.save(transaction);

        // Update the transaction's details
        int transactionId = transaction.getId();
        Transaction updatedTransaction = transactionRepository.findById(transactionId).orElse(null);
        assertNotNull(updatedTransaction);

        // Modify the transaction's attributes
        updatedTransaction.setDueDate("27-04-2024");
        

        // Save the updated transaction
        updatedTransaction = transactionRepository.save(updatedTransaction);

        // Retrieve the updated transaction from the database
        Transaction retrievedTransaction = transactionRepository.findById(transactionId).orElse(null);
        assertNotNull(retrievedTransaction);

        // Assert that the attributes have been updated
        assertEquals("27-04-2024", retrievedTransaction.getDueDate());
       
    }

    @Test
    public void testDeleteTransactionById() {
        // Create and save a transaction
        Transaction transaction = new Transaction();
        transaction.setBorrowDate("18-12-2021");
        
        transaction = transactionRepository.save(transaction);

        // Get the ID of the transaction to be deleted
        int transactionId = transaction.getId();

        // Delete the transaction by ID
        transactionRepository.deleteById(transactionId);

        // Try to retrieve the deleted transaction by ID, and it should be null
        Transaction deletedTransaction = transactionRepository.findById(transactionId).orElse(null);
        assertNull(deletedTransaction);
    } 
}
