package test;

import java.util.Date;

public class Transaction {
    private int transactionID;
    private Patient patient;
    private TransactionType transactionType;
    private Date transactionDate;
    private String remarks;
    private double totalCost;
    private String status;
    
    // Getters and Setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // Display transaction details
    public void displayDetails() {
        System.out.println("Transaction Details");
        System.out.println("ID: " + transactionID);
        System.out.println("Date: " + transactionDate);
        if (patient != null) {
            System.out.println("Patient: " + patient.getLastName() + ", " + patient.getFirstName());
        }
        if (transactionType != null) {
            System.out.println("Type: " + transactionType.getTypeName());
        }
        System.out.println("Cost: " + totalCost);
        System.out.println("Remarks: " + remarks);
        System.out.println("Status: " + status);
    }
}