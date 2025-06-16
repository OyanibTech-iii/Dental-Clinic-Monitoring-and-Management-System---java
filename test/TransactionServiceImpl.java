package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    
    private PatientService patientService = new PatientServiceImpl();
    private TransactionTypeService typeService = new TransactionTypeServiceImpl();
    
    @Override
    public int saveTransaction(Transaction transaction) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "INSERT INTO Transaction (PatientID, TypeID, TransactionDate, Remarks, TotalCost, Status) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, transaction.getPatient().getPatientID());
            prepStat.setInt(2, transaction.getTransactionType().getTypeID());
            prepStat.setTimestamp(3, new java.sql.Timestamp(transaction.getTransactionDate().getTime()));
            prepStat.setString(4, transaction.getRemarks());
            prepStat.setDouble(5, transaction.getTotalCost());
            prepStat.setString(6, transaction.getStatus());
            
            result = prepStat.executeUpdate();
            
            // Get the generated ID and set it to the transaction object
            if (result > 0) {
                String getIdQuery = "SELECT LAST_INSERT_ID()";
                PreparedStatement idStat = conn.prepareStatement(getIdQuery);
                ResultSet idResult = idStat.executeQuery();
                if (idResult.next()) {
                    transaction.setTransactionID(idResult.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public Transaction getTransaction(int transactionID) {
        Transaction transaction = null;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Transaction WHERE TransactionID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, transactionID);
            
            ResultSet result = prepStat.executeQuery();
            
            if (result.next()) {
                transaction = new Transaction();
                transaction.setTransactionID(result.getInt("TransactionID"));
                
                // Get associated patient and transaction type
                Patient patient = patientService.getPatient(result.getInt("PatientID"));
                TransactionType type = typeService.getTransactionType(result.getInt("TypeID"));
                
                transaction.setPatient(patient);
                transaction.setTransactionType(type);
                transaction.setTransactionDate(result.getTimestamp("TransactionDate"));
                transaction.setRemarks(result.getString("Remarks"));
                transaction.setTotalCost(result.getDouble("TotalCost"));
                transaction.setStatus(result.getString("Status"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return transaction;
    }

    @Override
    public int deleteTransaction(int transactionID) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "DELETE FROM Transaction WHERE TransactionID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, transactionID);
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int updateTransaction(Transaction transaction) {
        int result = 0;
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "UPDATE Transaction SET PatientID = ?, TypeID = ?, TransactionDate = ?, Remarks = ?, TotalCost = ?, Status = ? WHERE TransactionID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, transaction.getPatient().getPatientID());
            prepStat.setInt(2, transaction.getTransactionType().getTypeID());
            prepStat.setTimestamp(3, new java.sql.Timestamp(transaction.getTransactionDate().getTime()));
            prepStat.setString(4, transaction.getRemarks());
            prepStat.setDouble(5, transaction.getTotalCost());
            prepStat.setString(6, transaction.getStatus());
            prepStat.setInt(7, transaction.getTransactionID());
            
            result = prepStat.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Transaction";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            ResultSet result = prepStat.executeQuery();
            
            while (result.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(result.getInt("TransactionID"));
                
                // Get associated patient and transaction type
                Patient patient = patientService.getPatient(result.getInt("PatientID"));
                TransactionType type = typeService.getTransactionType(result.getInt("TypeID"));
                
                transaction.setPatient(patient);
                transaction.setTransactionType(type);
                transaction.setTransactionDate(result.getTimestamp("TransactionDate"));
                transaction.setRemarks(result.getString("Remarks"));
                transaction.setTotalCost(result.getDouble("TotalCost"));
                transaction.setStatus(result.getString("Status"));
                
                transactions.add(transaction);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsByDate(Date date) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Transaction WHERE DATE(TransactionDate) = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setDate(1, new java.sql.Date(date.getTime()));
            
            ResultSet result = prepStat.executeQuery();
            
            while (result.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(result.getInt("TransactionID"));
                
                // Get associated patient and transaction type
                Patient patient = patientService.getPatient(result.getInt("PatientID"));
                TransactionType type = typeService.getTransactionType(result.getInt("TypeID"));
                
                transaction.setPatient(patient);
                transaction.setTransactionType(type);
                transaction.setTransactionDate(result.getTimestamp("TransactionDate"));
                transaction.setRemarks(result.getString("Remarks"));
                transaction.setTotalCost(result.getDouble("TotalCost"));
                transaction.setStatus(result.getString("Status"));
                
                transactions.add(transaction);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsByPatient(int patientID) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Connection conn = DbConnection.connectToDb();
            String query = "SELECT * FROM Transaction WHERE PatientID = ?";
            
            PreparedStatement prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, patientID);
            
            ResultSet result = prepStat.executeQuery();
            
            while (result.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(result.getInt("TransactionID"));
                
                // Get associated patient and transaction type
                Patient patient = patientService.getPatient(result.getInt("PatientID"));
                TransactionType type = typeService.getTransactionType(result.getInt("TypeID"));
                
                transaction.setPatient(patient);
                transaction.setTransactionType(type);
                transaction.setTransactionDate(result.getTimestamp("TransactionDate"));
                transaction.setRemarks(result.getString("Remarks"));
                transaction.setTotalCost(result.getDouble("TotalCost"));
                transaction.setStatus(result.getString("Status"));
                
                transactions.add(transaction);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return transactions;
    }
}