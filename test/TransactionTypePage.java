package test;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class TransactionTypePage extends javax.swing.JPanel implements TransactionTypeServiceAware {

    private TransactionTypeService transactionTypeService;

    public TransactionTypePage() {
        // Initialize the service
        this.transactionTypeService = new TransactionTypeServiceImpl();

        initComponents();
        transDD.setBackground(new java.awt.Color(0, 119, 204));
        transDD.setForeground(new java.awt.Color(255, 255, 255));
        transDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Add Transaction Type", "View All Transaction Type", "Update Transaction Type", "Find Transaction by ID", "Delete Transaction Type"}));
        transTbl.getTableHeader().setBackground(new java.awt.Color(0, 119, 204));
        transTbl.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        transTbl.getTableHeader().setFont(new java.awt.Font("Poppins Medium", 0, 14));
        transTbl.getTableHeader().setOpaque(false);

        setupCustomScrollbar();
    }

    @Override
    public void setTransactionTypeService(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    private void setupCustomScrollbar() {
        // Create custom scrollbars
        scrollpane verticalScrollBar = new scrollpane();
        scrollpane horizontalScrollBar = new scrollpane();

        // Set the custom scrollbars to the JScrollPane
        jScrollPane1.setVerticalScrollBar(verticalScrollBar);
        jScrollPane1.setHorizontalScrollBar(horizontalScrollBar);

        // Optional: Configure scrollbar policies
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Optional: Set scrollbar colors to match your theme
        verticalScrollBar.setForeground(new java.awt.Color(0, 119, 204));
        horizontalScrollBar.setForeground(new java.awt.Color(0, 119, 204));
    }

    // Refactored method using the service
    public void viewAllTransactionType() {
        try {
            // Use the service instead of direct database access
            List<TransactionType> transactionTypes = transactionTypeService.getAllTransactionTypes();

            // Get the table model
            DefaultTableModel model = (DefaultTableModel) transTbl.getModel();

            // Clear existing rows
            model.setRowCount(0);

            // Add data from service to table
            for (TransactionType type : transactionTypes) {
                Object[] row = {
                    type.getTypeID(),
                    type.getTypeName(),
                    type.getDefaultCost()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            System.err.println("Error retrieving transaction type data: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error retrieving transaction type data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Additional method to find transaction type by ID using service
    public void findTransactionTypeById(int typeID) {
        try {
            TransactionType type = transactionTypeService.getTransactionType(typeID);

            if (type != null) {
                // Display in table or show details
                DefaultTableModel model = (DefaultTableModel) transTbl.getModel();
                model.setRowCount(0);
                Object[] row = {
                    type.getTypeID(),
                    type.getTypeName(),
                    type.getDefaultCost()
                };
                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Transaction Type with ID " + typeID + " not found.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("Error finding transaction type: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error finding transaction type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete transaction type using service
    public void deleteTransactionType(int typeID) {
        try {
            int result = transactionTypeService.deleteTransactionType(typeID);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Transaction Type deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Refresh the table
                viewAllTransactionType();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete transaction type. ID may not exist.", "Delete Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("Error deleting transaction type: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error deleting transaction type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to save transaction type using service
    public void saveTransactionType(TransactionType type) {
        try {
            int result = transactionTypeService.saveTransactionType(type);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Transaction Type saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Refresh the table
                viewAllTransactionType();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save transaction type.", "Save Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("Error saving transaction type: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error saving transaction type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to update transaction type using service
    public void updateTransactionType(TransactionType type) {
        try {
            int result = transactionTypeService.updateTransactionType(type);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Transaction Type updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Refresh the table
                viewAllTransactionType();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update transaction type. ID may not exist.", "Update Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("Error updating transaction type: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error updating transaction type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getter method to allow other panels to access the service
    public TransactionTypeService getTransactionTypeService() {
        return transactionTypeService;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        transDD = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        transTbl = new javax.swing.JTable();
        transTypePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 119, 204));
        jLabel1.setText("Transaction Type Page");

        transDD.setBackground(new java.awt.Color(0, 119, 204));
        transDD.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        transDD.setForeground(new java.awt.Color(255, 255, 255));
        transDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Add New Transaction Type", " View All Transaction Types", " Find Transaction Type by ID", " Update Transaction Type", " Delete Transaction Type" }));
        transDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transDDActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        transTbl.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        transTbl.setForeground(new java.awt.Color(0, 119, 204));
        transTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Names", "Default Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transTbl.setGridColor(new java.awt.Color(255, 255, 255));
        transTbl.setRowHeight(25);
        transTbl.setSelectionBackground(new java.awt.Color(0, 119, 204));
        transTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(transTbl);

        transTypePanel.setBackground(new java.awt.Color(0, 119, 204));
        transTypePanel.setMaximumSize(new java.awt.Dimension(100, 180));
        transTypePanel.setMinimumSize(new java.awt.Dimension(100, 180));
        transTypePanel.setPreferredSize(new java.awt.Dimension(100, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/promo.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 180));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 180));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 180));

        javax.swing.GroupLayout transTypePanelLayout = new javax.swing.GroupLayout(transTypePanel);
        transTypePanel.setLayout(transTypePanelLayout);
        transTypePanelLayout.setHorizontalGroup(
            transTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        transTypePanelLayout.setVerticalGroup(
            transTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(transDD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(307, 307, 307))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(transTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(transDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transDDActionPerformed
        // TODO add your handling code here:
        MouseClick.playClickSound();
        String selectedOption = (String) transDD.getSelectedItem();
        transTypePanel.removeAll();

        if (selectedOption != null) {
            switch (selectedOption) {
                case "Add Transaction Type" -> {
                    AddNewTransaction addTransPanel = new AddNewTransaction();
                    addTransPanel.setTransactionTypeService(transactionTypeService); 
                    addTransPanel.setSize(transTypePanel.getSize());
                    transTypePanel.add(addTransPanel);
                }
                case "View All Transaction Type" -> {
                    viewAllTransactionType();
                    transTypePanel.removeAll();
                }
                case "Update Transaction Type" -> {
                    UpdateTransactionType updatePanel = new UpdateTransactionType();
                    updatePanel.setTransactionTypeService(transactionTypeService);
                    updatePanel.setSize(transTypePanel.getSize());
                    transTypePanel.add(updatePanel);
                }
                case "Find Transaction by ID" -> {
                    FindTransactionByID findPanel = new FindTransactionByID();
                    findPanel.setTransactionTypeService(transactionTypeService);
                    findPanel.setSize(transTypePanel.getSize());
                    transTypePanel.add(findPanel);
                }
                case "Delete Transaction Type" -> {
                    DeleteTransactionType deletePanel = new DeleteTransactionType();
                    deletePanel.setTransactionTypeService(transactionTypeService);
                    deletePanel.setSize(transTypePanel.getSize());
                    transTypePanel.add(deletePanel);
                }
            }
        }
        transTypePanel.revalidate();
        transTypePanel.repaint();
    }//GEN-LAST:event_transDDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JComboBox<String> transDD;
    private javax.swing.JTable transTbl;
    private javax.swing.JPanel transTypePanel;
    // End of variables declaration//GEN-END:variables
}

interface TransactionTypeServiceAware {

    void setTransactionTypeService(TransactionTypeService transactionTypeService);
}
