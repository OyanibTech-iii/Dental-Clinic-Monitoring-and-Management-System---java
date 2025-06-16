/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class UpdatePatient extends javax.swing.JPanel implements PatientServiceAware {

    private PatientService patientService;
    private Patient currentPatient;
    private final updatePatientModal updateModal;

    public UpdatePatient() {
        initComponents();
        resultModal.setVisible(false);
        editDetails.setVisible(false);
        updateModal = new updatePatientModal();
    }

    @Override
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    private void searchPatient() {
        try {
            // Get the entered patient ID
            String idText = IDenteredTxt.getText().trim();
            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a Patient ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int patientID = Integer.parseInt(idText);
            currentPatient = patientService.getPatient(patientID);

            if (currentPatient != null) {
                // Update UI with patient details
                fullnameContainer.setText(currentPatient.getLastName() + ", " + currentPatient.getFirstName() + " "
                        + (currentPatient.getMiddleName() != null ? currentPatient.getMiddleName() : ""));
                emailContainer.setText(currentPatient.getEmail() != null ? currentPatient.getEmail() : "None");
                adressContainer.setText(currentPatient.getAddress() != null ? currentPatient.getAddress() : "None");
                contactContainer.setText(currentPatient.getContactNumber() != null ? currentPatient.getContactNumber() : "None");
                ageContainer.setText(String.valueOf(currentPatient.getAge()));
                bdayContainer.setText(currentPatient.getBirthdate() != null
                        ? new SimpleDateFormat("yyyy-MM-dd").format(currentPatient.getBirthdate()) : "None");

                // Show result modal and edit button
                resultModal.setVisible(true);
                editDetails.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Patient not found, try again.", "Error", JOptionPane.ERROR_MESSAGE);
                clearFields();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Patient ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error retrieving patient: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }

    private void showUpdateModal() {
        if (currentPatient == null) {
            JOptionPane.showMessageDialog(this, "No patient selected for editing.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Populate fields with current patient data
        updateModal.setPatientData(
                currentPatient.getFirstName() != null ? currentPatient.getFirstName() : "",
                currentPatient.getMiddleName() != null ? currentPatient.getMiddleName() : "",
                currentPatient.getLastName() != null ? currentPatient.getLastName() : "",
                String.valueOf(currentPatient.getAge()),
                currentPatient.getAddress() != null ? currentPatient.getAddress() : "",
                currentPatient.getBirthdate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(currentPatient.getBirthdate()) : "",
                currentPatient.getContactNumber() != null ? currentPatient.getContactNumber() : "",
                currentPatient.getEmail() != null ? currentPatient.getEmail() : ""
        );

        // Set save action for customButton1
        updateModal.setSaveAction(() -> savePatientDetails());

        // Hide all current components
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        IDenteredTxt.setVisible(false);
        searchBtn.setVisible(false);
        resultModal.setVisible(false);
        editDetails.setVisible(false);

        // Clear the panel and add the updateModal to fill the entire area
        this.removeAll();
        this.setLayout(new java.awt.BorderLayout());
        this.add(updateModal, java.awt.BorderLayout.CENTER);

        // Add a back button or modify existing button behavior
//        editDetails.setText("Save");
//        editDetails.setVisible(true);
//        this.add(editDetails, java.awt.BorderLayout.SOUTH);

        // Remove existing action listeners and add new save action
        for (java.awt.event.ActionListener al : editDetails.getActionListeners()) {
            editDetails.removeActionListener(al);
        }
        editDetails.addActionListener(evt -> savePatientDetails());

        this.revalidate();
        this.repaint();
    }

    private void savePatientDetails() {
        try {
            // Update patient object with new values from updateModal fields
            currentPatient.setFirstName(updateModal.getFirstName().trim());
            currentPatient.setMiddleName(updateModal.getMiddleName().trim());
            currentPatient.setLastName(updateModal.getLastName().trim());
            currentPatient.setAge(Integer.parseInt(updateModal.getAge().trim()));
            currentPatient.setAddress(updateModal.getAddress().trim());
            currentPatient.setContactNumber(updateModal.getContactNumber().trim());
            currentPatient.setEmail(updateModal.getEmail().trim());

            // Parse birthdate
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            currentPatient.setBirthdate(dateFormat.parse(updateModal.getBirthdate().trim()));

            // Update patient in the database
            int updateResult = patientService.updatePatient(currentPatient);

            if (updateResult > 0) {
                JOptionPane.showMessageDialog(this, "Patient updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Restore the original layout
                restoreOriginalLayout();

                // Refresh displayed details
                searchPatient();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update patient.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid age format.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid birthdate format (use yyyy-MM-dd).", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating patient: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void restoreOriginalLayout() {
        // Remove all components
        this.removeAll();

        // Restore the original layout by calling initComponents() logic
        // You might need to recreate the layout manually or call initComponents()
        // Since initComponents() is generated code, it's better to recreate manually
        // Reset to the original GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        // Make all original components visible again
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        IDenteredTxt.setVisible(true);
        searchBtn.setVisible(true);
        resultModal.setVisible(true);
        editDetails.setVisible(true);

        // Add all components back to the panel
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(IDenteredTxt);
        this.add(searchBtn);
        this.add(resultModal);
        this.add(editDetails);

        // Recreate the original layout constraints
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(resultModal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(IDenteredTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                                        .addComponent(editDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(IDenteredTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(resultModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        // Reset editDetails button
        editDetails.setText("Edit Details");
        for (java.awt.event.ActionListener al : editDetails.getActionListeners()) {
            editDetails.removeActionListener(al);
        }
        editDetails.addActionListener(evt -> showUpdateModal());

        this.revalidate();
        this.repaint();
    }

    private void clearFields() {
        fullnameContainer.setText("None");
        emailContainer.setText("None");
        adressContainer.setText("None");
        contactContainer.setText("None");
        ageContainer.setText("None");
        bdayContainer.setText("None");
        resultModal.setVisible(false);
        editDetails.setVisible(false);
        currentPatient = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDenteredTxt = new javax.swing.JTextField();
        searchBtn = new test.CustomButton();
        resultModal = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        fullnameContainer = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        emailContainer = new javax.swing.JLabel();
        adress = new javax.swing.JLabel();
        adressContainer = new javax.swing.JLabel();
        contactContainer = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        patientAge = new javax.swing.JLabel();
        ageContainer = new javax.swing.JLabel();
        bday = new javax.swing.JLabel();
        bdayContainer = new javax.swing.JLabel();
        editDetails = new test.CustomButton();

        jLabel4.setText("jLabel4");

        setBackground(new java.awt.Color(0, 119, 204));
        setMaximumSize(new java.awt.Dimension(452, 180));
        setMinimumSize(new java.awt.Dimension(452, 180));
        setPreferredSize(new java.awt.Dimension(452, 180));

        jLabel1.setBackground(new java.awt.Color(0, 119, 204));
        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Patient Details");

        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Patient ID to update: ");

        IDenteredTxt.setBackground(new java.awt.Color(0, 119, 204));
        IDenteredTxt.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        IDenteredTxt.setForeground(new java.awt.Color(255, 255, 255));
        IDenteredTxt.setBorder(null);

        searchBtn.setBackground(new java.awt.Color(0, 51, 0));
        searchBtn.setBorder(null);
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchBtn.png"))); // NOI18N
        searchBtn.setText("Search Patient");
        searchBtn.setBorderColor(new java.awt.Color(0, 51, 0));
        searchBtn.setColor(new java.awt.Color(0, 51, 0));
        searchBtn.setColorClick(new java.awt.Color(1, 22, 1));
        searchBtn.setColorOver(new java.awt.Color(51, 102, 0));
        searchBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        searchBtn.setRadius(10);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        resultModal.setBackground(new java.awt.Color(0, 119, 204));

        name.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name:");

        fullnameContainer.setBackground(new java.awt.Color(0, 119, 204));
        fullnameContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        fullnameContainer.setForeground(new java.awt.Color(255, 255, 255));
        fullnameContainer.setText("None");

        email.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("email:");

        emailContainer.setBackground(new java.awt.Color(0, 119, 204));
        emailContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        emailContainer.setForeground(new java.awt.Color(255, 255, 255));
        emailContainer.setText("None");

        adress.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        adress.setForeground(new java.awt.Color(255, 255, 255));
        adress.setText("Adress:");

        adressContainer.setBackground(new java.awt.Color(0, 119, 204));
        adressContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        adressContainer.setForeground(new java.awt.Color(255, 255, 255));
        adressContainer.setText("None");

        contactContainer.setBackground(new java.awt.Color(0, 119, 204));
        contactContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        contactContainer.setForeground(new java.awt.Color(255, 255, 255));
        contactContainer.setText("None");

        contact.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        contact.setForeground(new java.awt.Color(255, 255, 255));
        contact.setText("contact:");

        patientAge.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        patientAge.setForeground(new java.awt.Color(255, 255, 255));
        patientAge.setText("age:");

        ageContainer.setBackground(new java.awt.Color(0, 119, 204));
        ageContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        ageContainer.setForeground(new java.awt.Color(255, 255, 255));
        ageContainer.setText("None");

        bday.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        bday.setForeground(new java.awt.Color(255, 255, 255));
        bday.setText("B-date:");

        bdayContainer.setBackground(new java.awt.Color(0, 119, 204));
        bdayContainer.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        bdayContainer.setForeground(new java.awt.Color(255, 255, 255));
        bdayContainer.setText("None");

        javax.swing.GroupLayout resultModalLayout = new javax.swing.GroupLayout(resultModal);
        resultModal.setLayout(resultModalLayout);
        resultModalLayout.setHorizontalGroup(
            resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultModalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultModalLayout.createSequentialGroup()
                        .addComponent(contact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(resultModalLayout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fullnameContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(resultModalLayout.createSequentialGroup()
                        .addComponent(email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, resultModalLayout.createSequentialGroup()
                            .addComponent(adress)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(adressContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, resultModalLayout.createSequentialGroup()
                            .addComponent(patientAge)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bday)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bdayContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        resultModalLayout.setVerticalGroup(
            resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultModalLayout.createSequentialGroup()
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(fullnameContainer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailContainer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adress)
                    .addComponent(adressContainer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contact)
                    .addComponent(contactContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(patientAge)
                        .addComponent(ageContainer))
                    .addGroup(resultModalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bday)
                        .addComponent(bdayContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editDetails.setBackground(new java.awt.Color(0, 51, 0));
        editDetails.setForeground(new java.awt.Color(255, 255, 255));
        editDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        editDetails.setText("Edit Details");
        editDetails.setBorderColor(new java.awt.Color(0, 51, 0));
        editDetails.setColor(new java.awt.Color(0, 51, 0));
        editDetails.setColorClick(new java.awt.Color(6, 22, 1));
        editDetails.setColorOver(new java.awt.Color(0, 102, 0));
        editDetails.setFont(new java.awt.Font("Poppins Light", 0, 10)); // NOI18N
        editDetails.setMaximumSize(new java.awt.Dimension(88, 20));
        editDetails.setMinimumSize(new java.awt.Dimension(88, 20));
        editDetails.setPreferredSize(new java.awt.Dimension(88, 20));
        editDetails.setRadius(10);
        editDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDenteredTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resultModal, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(editDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDenteredTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(resultModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        searchPatient();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void editDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDetailsActionPerformed
        // TODO add your handling code here:
        showUpdateModal();
    }//GEN-LAST:event_editDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDenteredTxt;
    private javax.swing.JLabel adress;
    private javax.swing.JLabel adressContainer;
    private javax.swing.JLabel ageContainer;
    private javax.swing.JLabel bday;
    private javax.swing.JLabel bdayContainer;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel contactContainer;
    private test.CustomButton editDetails;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailContainer;
    private javax.swing.JLabel fullnameContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel name;
    private javax.swing.JLabel patientAge;
    private javax.swing.JPanel resultModal;
    private test.CustomButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
