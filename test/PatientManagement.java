package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class PatientManagement extends javax.swing.JPanel {

    public PatientManagement() {
        initComponents();
        choicesDropdown.setBackground(new java.awt.Color(0, 119, 204));
        choicesDropdown.setForeground(new java.awt.Color(255, 255, 255));
        choicesDropdown.setOpaque(false);
        choicesDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Add Patient", "View All Patient", "Update Patient", "Find Patient by ID", "Find Patient by Name", "Delete Patient"}));
        patientMngmtTable.getTableHeader().setFont(new java.awt.Font("Poppins Medium", 0, 14));
        patientMngmtTable.getTableHeader().setOpaque(false);
        patientMngmtTable.getTableHeader().setBackground(new java.awt.Color(0, 119, 204));
        patientMngmtTable.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        setupCustomScrollbar();
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

    private void loadAllPatients() {
        try {
            Connection conn = DbConnection.connectToDb();
            if (conn != null) {
                // Query to get id, concatenated name (FirstName, LastName), and contact
                String query = "SELECT PatientID, FirstName, LastName, ContactNumber  FROM patient";
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();

                // Get the table model
                DefaultTableModel model = (DefaultTableModel) patientMngmtTable.getModel();

                // Clear existing rows
                model.setRowCount(0);

                // Add data from database to table
                while (rs.next()) {
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");

                    // Handle null values and create formatted name
                    String Names = "";
                    if (firstName != null && lastName != null) {
                        Names = firstName + ", " + lastName;
                    } else if (firstName != null) {
                        Names = firstName;
                    } else if (lastName != null) {
                        Names = lastName;
                    }

                    Object[] row = {
                        rs.getInt("PatientID"),
                        Names,
                        rs.getString("ContactNumber")
                    };
                    model.addRow(row);
                }

                // Close resources
                rs.close();
                pst.close();
                conn.close();

            } else {
                JOptionPane.showMessageDialog(this, "Failed to connect to database", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error retrieving patient data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientMngmtTable = new javax.swing.JTable();
        choicesDropdown = new javax.swing.JComboBox<>();
        patientPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 119, 204));
        jLabel1.setText("Patient Management Page");

        patientMngmtTable.setBackground(new java.awt.Color(255, 255, 255));
        patientMngmtTable.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        patientMngmtTable.setForeground(new java.awt.Color(0, 119, 204));
        patientMngmtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "ID", "Names", "Contacts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientMngmtTable.setGridColor(new java.awt.Color(255, 255, 255));
        patientMngmtTable.setName(""); // NOI18N
        patientMngmtTable.setOpaque(false);
        patientMngmtTable.setRowHeight(25);
        patientMngmtTable.setSelectionBackground(new java.awt.Color(0, 119, 204));
        patientMngmtTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        patientMngmtTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientMngmtTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(patientMngmtTable);
        patientMngmtTable.getAccessibleContext().setAccessibleParent(patientMngmtTable);

        choicesDropdown.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        choicesDropdown.setForeground(new java.awt.Color(255, 255, 255));
        choicesDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Add Patient", "View All Patient", "Update Patient", "Find Patient by ID", "Find Patient by Name", "Delete Patient" }));
        choicesDropdown.setBorder(null);
        choicesDropdown.setRequestFocusEnabled(false);
        choicesDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choicesDropdownActionPerformed(evt);
            }
        });

        patientPanel.setBackground(new java.awt.Color(0, 119, 204));
        patientPanel.setMinimumSize(new java.awt.Dimension(100, 180));
        patientPanel.setPreferredSize(new java.awt.Dimension(100, 180));

        javax.swing.GroupLayout patientPanelLayout = new javax.swing.GroupLayout(patientPanel);
        patientPanel.setLayout(patientPanelLayout);
        patientPanelLayout.setHorizontalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        patientPanelLayout.setVerticalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choicesDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(patientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(choicesDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(patientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void choicesDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choicesDropdownActionPerformed
        // TODO add your handling code here:
        MouseClick.playClickSound();
        String selectedOption = (String) choicesDropdown.getSelectedItem();
        patientPanel.removeAll();

        if (null != selectedOption) {
            switch (selectedOption) {
                case "Add Patient":
                    //            MouseClick.playClickSound();
                    AddPatientPanel addPatientPanel = new AddPatientPanel();
                    addPatientPanel.setSize(patientPanel.getSize());
                    patientPanel.add(addPatientPanel);
                    break;
                case "View All Patient":
                    //            MouseClick.playClickSound();
                    // Load all patients from database and display in table
                    loadAllPatients();
                    // Clear patientPanel as the table is displayed above
                    patientPanel.removeAll();
                    break;
                case "Update Patient":
                    //            MouseClick.playClickSound();
                    UpdatePatient updatePanel = new UpdatePatient();
                    updatePanel.setSize(patientPanel.getSize());
                    patientPanel.add(updatePanel);
                    break;
                case "Find Patient by ID":
                    //            MouseClick.playClickSound();
                    FindPatientByID findByIDPanel = new FindPatientByID();
                    findByIDPanel.setSize(patientPanel.getSize());
                    patientPanel.add(findByIDPanel);
                    break;
                case "Find Patient by Name":
                    //            MouseClick.playClickSound();
                    FindPatientByName findByNamePanel = new FindPatientByName();
                    findByNamePanel.setSize(patientPanel.getSize());
                    patientPanel.add(findByNamePanel);
                    break;
                case "Delete Patient":
                    //            MouseClick.playClickSound();
                    DeletePatient deletePanel = new DeletePatient();
                    deletePanel.setSize(patientPanel.getSize());
                    patientPanel.add(deletePanel);
                    break;
                default:
                    break;
            }
        }
        patientPanel.revalidate();
        patientPanel.repaint();

    }//GEN-LAST:event_choicesDropdownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> choicesDropdown;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientMngmtTable;
    private javax.swing.JPanel patientPanel;
    // End of variables declaration//GEN-END:variables
}
