/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TransactionManagement extends javax.swing.JPanel implements TransactionServiceAware {

    private TransactionService transactionService;

    public TransactionManagement() {
        this.transactionService = new TransactionServiceImpl();
        initComponents();
        mngmntDD.setBackground(new java.awt.Color(0, 119, 204));
        mngmntDD.setForeground(new java.awt.Color(255, 255, 255));
        mngmntTbl.getTableHeader().setBackground(new java.awt.Color(0, 119, 204));
        mngmntTbl.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        mngmntTbl.getTableHeader().setFont(new java.awt.Font("Poppins Medium", 0, 14));
        mngmntTbl.getTableHeader().setOpaque(false);
        loadTransactions();
    }

    public TransactionManagement(TransactionService transactionService) {
        this.transactionService = transactionService;
        initComponents();
        mngmntDD.setBackground(new java.awt.Color(0, 119, 204));
        mngmntDD.setForeground(new java.awt.Color(255, 255, 255));
        mngmntTbl.getTableHeader().setBackground(new java.awt.Color(0, 119, 204));
        mngmntTbl.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        mngmntTbl.getTableHeader().setFont(new java.awt.Font("Poppins Medium", 0, 14));
        mngmntTbl.getTableHeader().setOpaque(false);
        loadTransactions();
        setupCustomScrollbar();
    }

    @Override
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    private void loadTransactions() {
        DefaultTableModel model = (DefaultTableModel) mngmntTbl.getModel();
        model.setRowCount(0);
        List<Transaction> transactions = getAllTransactions();
        for (Transaction t : transactions) {
            Object[] row = {
                t.getTransactionID(),
                t.getTransactionDate(),
                t.getPatient() != null ? t.getPatient().getLastName() + ", " + t.getPatient().getFirstName() : "N/A",
                t.getTransactionType() != null ? t.getTransactionType().getTypeName() : "N/A",
                t.getTotalCost(),
                t.getStatus()
            };
            model.addRow(row);
        }
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

    public javax.swing.JTable getMngmntTbl() {
        return mngmntTbl;
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) mngmntTbl.getModel();
        model.setRowCount(0);
    }

    public void loadTransactionsByPatient(List<Transaction> transactions) {
        DefaultTableModel model = (DefaultTableModel) mngmntTbl.getModel();
        model.setRowCount(0);
        for (Transaction t : transactions) {
            Object[] row = {
                t.getTransactionID(),
                t.getTransactionDate(),
                t.getPatient() != null ? t.getPatient().getLastName() + ", " + t.getPatient().getFirstName() : "N/A",
                t.getTransactionType() != null ? t.getTransactionType().getTypeName() : "N/A",
                t.getTotalCost(),
                t.getStatus()
            };
            model.addRow(row);
        }
    }

    // Method to load a single transaction (for Find by ID)
    public void loadSingleTransaction(Transaction transaction) {
        DefaultTableModel model = (DefaultTableModel) mngmntTbl.getModel();
        model.setRowCount(0);
        if (transaction != null) {
            Object[] row = {
                transaction.getTransactionID(),
                transaction.getTransactionDate(),
                transaction.getPatient() != null ? transaction.getPatient().getLastName() + ", " + transaction.getPatient().getFirstName() : "N/A",
                transaction.getTransactionType() != null ? transaction.getTransactionType().getTypeName() : "N/A",
                transaction.getTotalCost(),
                transaction.getStatus()
            };
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mngmntDD = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        mngmntTbl = new javax.swing.JTable();
        tnsMngmntPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 119, 204));
        jLabel1.setText("Transaction Management Page");

        mngmntDD.setBackground(new java.awt.Color(0, 119, 204));
        mngmntDD.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        mngmntDD.setForeground(new java.awt.Color(255, 255, 255));
        mngmntDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Create New Transaction", "View All Transactions", "Find Transaction by ID", "Find Transactions by Patient", "Find Transactions by Date", "Update Transaction", "Delete Transaction" }));
        mngmntDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngmntDDActionPerformed(evt);
            }
        });

        mngmntTbl.setBackground(new java.awt.Color(255, 255, 255));
        mngmntTbl.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        mngmntTbl.setForeground(new java.awt.Color(0, 119, 204));
        mngmntTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Patient", "Transaction Type", "Cost", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mngmntTbl.setGridColor(new java.awt.Color(255, 255, 255));
        mngmntTbl.setRowHeight(25);
        mngmntTbl.setSelectionBackground(new java.awt.Color(0, 119, 204));
        mngmntTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(mngmntTbl);

        tnsMngmntPanel.setBackground(new java.awt.Color(0, 119, 204));
        tnsMngmntPanel.setMaximumSize(new java.awt.Dimension(100, 180));
        tnsMngmntPanel.setMinimumSize(new java.awt.Dimension(100, 180));
        tnsMngmntPanel.setPreferredSize(new java.awt.Dimension(100, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doctorss.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 180));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 180));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 180));

        javax.swing.GroupLayout tnsMngmntPanelLayout = new javax.swing.GroupLayout(tnsMngmntPanel);
        tnsMngmntPanel.setLayout(tnsMngmntPanelLayout);
        tnsMngmntPanelLayout.setHorizontalGroup(
            tnsMngmntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tnsMngmntPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tnsMngmntPanelLayout.setVerticalGroup(
            tnsMngmntPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tnsMngmntPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(274, 274, 274))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mngmntDD, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(tnsMngmntPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(mngmntDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tnsMngmntPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mngmntDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngmntDDActionPerformed
        // TODO add your handling code here:
        String selectedOption = (String) mngmntDD.getSelectedItem();
        tnsMngmntPanel.removeAll();
        clearTable();

        switch (selectedOption) {

            case "Create New Transaction":
                AddTransactionManagement addTransPanel = new AddTransactionManagement();
                addTransPanel.setTransactionService(transactionService);
                addTransPanel.setSize(tnsMngmntPanel.getSize());
                tnsMngmntPanel.add(addTransPanel);
                break;
            case "View All Transactions":
                loadTransactions();
                break;
            case "Find Transaction by ID":
                FindTransactionManagementID findTransPanel = new FindTransactionManagementID(transactionService);
                findTransPanel.setSize(tnsMngmntPanel.getSize());
                tnsMngmntPanel.add(findTransPanel);
                break;
            case "Find Transactions by Patient":
                FindTransactionManagementPatient findPatientPanel = new FindTransactionManagementPatient(transactionService, this);
                findPatientPanel.setSize(tnsMngmntPanel.getSize());
                tnsMngmntPanel.add(findPatientPanel);
                break;
            case "Find Transactions by Date":
                FindTransactionManagementDate findDatePanel = new FindTransactionManagementDate(transactionService, this);
                findDatePanel.setSize(tnsMngmntPanel.getSize());
                tnsMngmntPanel.add(findDatePanel);
                break;
            case "Update Transaction":
                UpdateTransactionManagement updatePanel = new UpdateTransactionManagement(transactionService, this);
                updatePanel.setBounds(0, 0, tnsMngmntPanel.getWidth(), tnsMngmntPanel.getHeight());
                tnsMngmntPanel.add(updatePanel);
                break;
            case "Delete Transaction":
                DeleteTransactionManagement deletePanel = new DeleteTransactionManagement(transactionService, this);
                deletePanel.setBounds(0, 0, tnsMngmntPanel.getWidth(), tnsMngmntPanel.getHeight());
                tnsMngmntPanel.add(deletePanel);
                tnsMngmntPanel.revalidate();
                tnsMngmntPanel.repaint();
                break;
            default:

                clearTable();
                // Optionally show a default image or message
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doctorss.png")));
                tnsMngmntPanel.add(jLabel2);
                break;
        }
        tnsMngmntPanel.revalidate();
        tnsMngmntPanel.repaint();
    }//GEN-LAST:event_mngmntDDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mngmntDD;
    private javax.swing.JTable mngmntTbl;
    private javax.swing.JPanel tnsMngmntPanel;
    // End of variables declaration//GEN-END:variables
}

interface TransactionServiceAware {

    void setTransactionService(TransactionService transactionService);

    List<Transaction> getAllTransactions();
}
