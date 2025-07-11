/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package test;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 */
public class UpdateTransactionManagement extends javax.swing.JPanel implements TransactionServiceAware {

    private TransactionService transactionService;
    private TransactionManagement transactionManagement;
    private int currentTransactionID;

    public UpdateTransactionManagement() {
        this.transactionService = new TransactionServiceImpl();
        initComponents();
        jPanel1.setVisible(false);
    }

    public UpdateTransactionManagement(TransactionService transactionService, TransactionManagement transactionManagement) {
        this.transactionService = transactionService;
        this.transactionManagement = transactionManagement;
        initComponents();
        jPanel1.setVisible(false);
    }

    @Override
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchID = new test.CustomButton();
        jLabel2 = new javax.swing.JLabel();
        updateID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new test.CustomButton();
        updateLabel = new javax.swing.JLabel();
        updateTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        updateLabel1 = new javax.swing.JLabel();
        updateTextField1 = new javax.swing.JTextField();
        updateLabel2 = new javax.swing.JLabel();
        updateTextField2 = new javax.swing.JTextField();
        updateLabel3 = new javax.swing.JLabel();
        updateTextField3 = new javax.swing.JTextField();
        updateLabel4 = new javax.swing.JLabel();
        updateTextField4 = new javax.swing.JTextField();
        updateTextField5 = new javax.swing.JTextField();
        updateLabel5 = new javax.swing.JLabel();
        updateLabel6 = new javax.swing.JLabel();
        updateTextField6 = new javax.swing.JTextField();
        updateLabel7 = new javax.swing.JLabel();
        editInfo = new test.CustomButton();

        searchID.setBackground(new java.awt.Color(0, 51, 0));
        searchID.setForeground(new java.awt.Color(255, 255, 255));
        searchID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchBtn.png"))); // NOI18N
        searchID.setText("Search ID");
        searchID.setBorderColor(new java.awt.Color(0, 51, 0));
        searchID.setColor(new java.awt.Color(0, 51, 0));
        searchID.setColorClick(new java.awt.Color(4, 29, 2));
        searchID.setColorOver(new java.awt.Color(0, 102, 0));
        searchID.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        searchID.setRadius(12);
        searchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Transaction Type ID to Update:");

        updateID.setBackground(new java.awt.Color(0, 119, 204));
        updateID.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateID.setForeground(new java.awt.Color(255, 255, 255));
        updateID.setBorder(null);

        setBackground(new java.awt.Color(0, 119, 204));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update  Transaction Management");

        searchBtn.setBackground(new java.awt.Color(0, 51, 0));
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchBtn.png"))); // NOI18N
        searchBtn.setText("Search ID");
        searchBtn.setBorderColor(new java.awt.Color(0, 51, 0));
        searchBtn.setColor(new java.awt.Color(0, 51, 0));
        searchBtn.setColorClick(new java.awt.Color(4, 29, 2));
        searchBtn.setColorOver(new java.awt.Color(0, 102, 0));
        searchBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        searchBtn.setRadius(12);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        updateLabel.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel.setText("Enter Transaction ID to Update:");

        updateTextField.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField.setBorder(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(468, 165));
        jPanel1.setMinimumSize(new java.awt.Dimension(468, 165));
        jPanel1.setOpaque(false);

        updateLabel1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel1.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel1.setText("ID:");

        updateTextField1.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField1.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField1.setBorder(null);

        updateLabel2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel2.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel2.setText("Date:");

        updateTextField2.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField2.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField2.setBorder(null);

        updateLabel3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel3.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel3.setText("Type:");

        updateTextField3.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField3.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField3.setBorder(null);

        updateLabel4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel4.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel4.setText("Patient:");

        updateTextField4.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField4.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField4.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField4.setBorder(null);

        updateTextField5.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField5.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField5.setBorder(null);

        updateLabel5.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel5.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel5.setText("Remarks:");

        updateLabel6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel6.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel6.setText("Status:");

        updateTextField6.setBackground(new java.awt.Color(0, 119, 204));
        updateTextField6.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateTextField6.setForeground(new java.awt.Color(255, 255, 255));
        updateTextField6.setBorder(null);

        updateLabel7.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        updateLabel7.setForeground(new java.awt.Color(255, 255, 255));
        updateLabel7.setText("Transaction Details:");

        editInfo.setBackground(new java.awt.Color(0, 51, 0));
        editInfo.setForeground(new java.awt.Color(255, 255, 255));
        editInfo.setText("SaveChanges");
        editInfo.setBorderColor(new java.awt.Color(0, 51, 0));
        editInfo.setColor(new java.awt.Color(0, 51, 0));
        editInfo.setColorClick(new java.awt.Color(4, 29, 2));
        editInfo.setColorOver(new java.awt.Color(0, 102, 0));
        editInfo.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        editInfo.setRadius(12);
        editInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateTextField3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(updateLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateTextField6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(updateLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(updateLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateLabel7)
                            .addComponent(editInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(updateLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel1)
                            .addComponent(updateTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel2)
                            .addComponent(updateTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel3)
                            .addComponent(updateTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel4)
                            .addComponent(updateTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel5)
                            .addComponent(updateTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateLabel6)
                            .addComponent(updateTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateLabel)
                    .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIDActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_searchIDActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here
        String idText = updateTextField.getText().trim();

        if (!idText.isEmpty()) {
            try {
                int transactionID = Integer.parseInt(idText);
                Transaction transaction = transactionService.getTransaction(transactionID);
                if (transaction != null) {
                    // Check if patient exists and show appropriate message
                    if (transaction.getPatient() != null) {
                        JOptionPane.showMessageDialog(this,
                                "ID Owned by Patient : " + transaction.getPatient().getLastName() + ", " + transaction.getPatient().getFirstName(),
                                "Patient Found Successfully",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "No patient found for this transaction.",
                                "No Patient",
                                JOptionPane.WARNING_MESSAGE);
                    }

                    // Populate fields with transaction details
                    currentTransactionID = transaction.getTransactionID();
                    updateTextField1.setText(String.valueOf(transaction.getTransactionID()));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    updateTextField2.setText(sdf.format(transaction.getTransactionDate()));
                    updateTextField3.setText(transaction.getTransactionType() != null
                            ? String.valueOf(transaction.getTransactionType().getTypeID()) : "");
                    updateTextField4.setText(transaction.getPatient() != null
                            ? String.valueOf(transaction.getPatient().getPatientID()) : "");
                    updateTextField5.setText(String.valueOf(transaction.getTotalCost()));
                    updateTextField6.setText(transaction.getStatus() != null ? transaction.getStatus() : "");
                    jPanel1.setVisible(true);
                    transactionManagement.loadSingleTransaction(transaction);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No transaction found for Transaction ID: " + idText,
                            "Not Found",
                            JOptionPane.WARNING_MESSAGE);
                    jPanel1.setVisible(false);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid Transaction ID format. Please enter a valid number.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                jPanel1.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please enter a Transaction ID.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            jPanel1.setVisible(false);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInfoActionPerformed
        // TODO add your handling code here
        String idText = updateTextField1.getText().trim();
        String dateText = updateTextField2.getText().trim();
        String typeIdText = updateTextField3.getText().trim();
        String patientIdText = updateTextField4.getText().trim();
        String costText = updateTextField5.getText().trim();
        String statusText = updateTextField6.getText().trim();

        if (idText.isEmpty() || dateText.isEmpty() || typeIdText.isEmpty() || patientIdText.isEmpty()
                || costText.isEmpty() || statusText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int transactionID;
        try {
            transactionID = Integer.parseInt(idText);
            if (transactionID != currentTransactionID) {
                JOptionPane.showMessageDialog(this,
                        "Transaction ID cannot be modified.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Transaction ID format.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date transactionDate;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            transactionDate = sdf.parse(dateText);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid date format. Please use yyyy-MM-dd.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int typeID;
        try {
            typeID = Integer.parseInt(typeIdText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Transaction Type ID format.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int patientID;
        try {
            patientID = Integer.parseInt(patientIdText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Patient ID format.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        double totalCost;
        try {
            totalCost = Double.parseDouble(costText);
            if (totalCost < 0) {
                JOptionPane.showMessageDialog(this,
                        "Total cost cannot be negative.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Total Cost format.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Create Transaction object
        Transaction updatedTransaction = new Transaction();
        updatedTransaction.setTransactionID(transactionID);
        updatedTransaction.setTransactionDate(transactionDate);
        updatedTransaction.setTotalCost(totalCost);
        updatedTransaction.setStatus(statusText);

        // Set TransactionType
        TransactionType transactionType = new TransactionType();
        transactionType.setTypeID(typeID);
        updatedTransaction.setTransactionType(transactionType);

        // Set Patient
        Patient patient = new Patient();
        patient.setPatientID(patientID);
        updatedTransaction.setPatient(patient);

        // Confirm update
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update Transaction ID: " + transactionID + "?",
                "Confirm Update",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            int result = transactionService.updateTransaction(updatedTransaction);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "Transaction ID: " + transactionID + " updated successfully.",
                        "Update Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                jPanel1.setVisible(false);
                updateTextField.setText("");
                transactionManagement.loadSingleTransaction(updatedTransaction);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to update transaction ID: " + transactionID + ". Ensure Type ID and Patient ID exist.",
                        "Update Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private test.CustomButton editInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private test.CustomButton searchBtn;
    private test.CustomButton searchID;
    private javax.swing.JTextField updateID;
    private javax.swing.JLabel updateLabel;
    private javax.swing.JLabel updateLabel1;
    private javax.swing.JLabel updateLabel2;
    private javax.swing.JLabel updateLabel3;
    private javax.swing.JLabel updateLabel4;
    private javax.swing.JLabel updateLabel5;
    private javax.swing.JLabel updateLabel6;
    private javax.swing.JLabel updateLabel7;
    private javax.swing.JTextField updateTextField;
    private javax.swing.JTextField updateTextField1;
    private javax.swing.JTextField updateTextField2;
    private javax.swing.JTextField updateTextField3;
    private javax.swing.JTextField updateTextField4;
    private javax.swing.JTextField updateTextField5;
    private javax.swing.JTextField updateTextField6;
    // End of variables declaration//GEN-END:variables
}
