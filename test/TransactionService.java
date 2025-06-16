package test;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    public int saveTransaction(Transaction transaction);
    public Transaction getTransaction(int transactionID);
    public int deleteTransaction(int transactionID);
    public int updateTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions();
    public List<Transaction> getTransactionsByDate(Date date);
    public List<Transaction> getTransactionsByPatient(int patientID);
}