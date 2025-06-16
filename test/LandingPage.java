package test;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class LandingPage extends javax.swing.JFrame {

    private String loggedInUsername;

    public LandingPage() {
        this("Guest");
    }

    public LandingPage(String username) {
        this.loggedInUsername = username;
        initComponents();
        setIconImage();
        applyCustomFont();
        updateWelcomeMessage();

    }

    private void updateWelcomeMessage() {
        guestTxt.setText(loggedInUsername);
    }

    private void applyCustomFont() {
        try {

            InputStream is = getClass().getResourceAsStream("../fonts/VarelaRound-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(16f);

            // Register the font with the system (optional)
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Application of font inGUI component
//            taglineTxt.setFont(customFont);
//            taglineTxt1.setFont(customFont);
//            jLabel2.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guestTxt = new javax.swing.JLabel();
        patientManagementLabel = new javax.swing.JLabel();
        transcationType = new javax.swing.JLabel();
        transactionManagement = new javax.swing.JLabel();
        taglineTxt1 = new javax.swing.JLabel();
        taglineTxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        locationFinderBtn = new test.CustomButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PACIFIC KINGS DENTAL CLINIC (LANDING PAGE)");
        setSize(new java.awt.Dimension(800, 600));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setMaximumSize(new java.awt.Dimension(500, 500));
        contentPanel.setMinimumSize(new java.awt.Dimension(500, 500));
        contentPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        contentPanel.setRequestFocusEnabled(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bannerCorrected.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(1000, 500));
        jLabel11.setPreferredSize(new java.awt.Dimension(1000, 500));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel2.setBackground(new java.awt.Color(0, 119, 204));
        jPanel2.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit_to_app_24dp_FFFFFF_FILL0_wght100_GRAD200_opsz24.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome,");

        guestTxt.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        guestTxt.setForeground(new java.awt.Color(255, 255, 255));
        guestTxt.setText("Guest");

        patientManagementLabel.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        patientManagementLabel.setForeground(new java.awt.Color(255, 255, 255));
        patientManagementLabel.setText("Patient Management");
        patientManagementLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientManagementLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientManagementLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientManagementLabelMouseExited(evt);
            }
        });

        transcationType.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        transcationType.setForeground(new java.awt.Color(255, 255, 255));
        transcationType.setText("Transaction Type");
        transcationType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transcationTypeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transcationTypeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transcationTypeMouseExited(evt);
            }
        });

        transactionManagement.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        transactionManagement.setForeground(new java.awt.Color(255, 255, 255));
        transactionManagement.setText("Transaction Management");
        transactionManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionManagementMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionManagementMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionManagementMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guestTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(patientManagementLabel)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(transcationType)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(transactionManagement)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(guestTxt)
                        .addComponent(patientManagementLabel)
                        .addComponent(transcationType)
                        .addComponent(transactionManagement)))
                .addGap(16, 16, 16))
        );

        taglineTxt1.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        taglineTxt1.setForeground(new java.awt.Color(0, 119, 204));
        taglineTxt1.setText("Smiles Begin");
        taglineTxt1.setFocusable(false);

        taglineTxt.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        taglineTxt.setForeground(new java.awt.Color(0, 119, 204));
        taglineTxt.setText("Where Your Healthy ");
        taglineTxt.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 119, 204));
        jLabel3.setText("Book your appointment today");

        jLabel4.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 119, 204));
        jLabel4.setText("and start your journey with a");

        jLabel5.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 119, 204));
        jLabel5.setText("brighter smile.");

        footerPanel.setBackground(new java.awt.Color(0, 119, 204));

        jLabel7.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" ©2025 Pacific Kings. All Rights Reserved");

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 119, 204));
        jLabel8.setText("Facebook");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-facebook-24.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-instagram-24.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-tiktok-24.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/replacement.png"))); // NOI18N

        locationFinderBtn.setBackground(new java.awt.Color(0, 119, 204));
        locationFinderBtn.setBorder(null);
        locationFinderBtn.setForeground(new java.awt.Color(255, 255, 255));
        locationFinderBtn.setText("Visit our Location");
        locationFinderBtn.setBorderColor(new java.awt.Color(0, 119, 204));
        locationFinderBtn.setColor(new java.awt.Color(0, 119, 204));
        locationFinderBtn.setColorOver(new java.awt.Color(0, 119, 204));
        locationFinderBtn.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        locationFinderBtn.setRadius(10);
        locationFinderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationFinderBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(taglineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(taglineTxt1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(locationFinderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taglineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taglineTxt1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationFinderBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(823, 642));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here
        MouseClick.playClickSound();
        try {
            // Specify the URL to open
            String url = "https://www.facebook.com/profile.php?id=61576496683252";
            // Use Desktop to open the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            // Handle potential exceptions
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error opening browser: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        MouseClick.playClickSound();
        try {
            // Specify the URL to open
            String url = "http://10.0.27.23:8081/winRor/404.php";
            // Use Desktop to open the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            // Handle potential exceptions
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error opening browser: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        MouseClick.playClickSound();
        try {
            // Specify the URL to open
            String url = "http://10.0.27.23:8081/winRor/404.php";
            // Use Desktop to open the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (java.io.IOException | java.net.URISyntaxException e) {
            // Handle potential exceptions
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error opening browser: " + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel16MouseClicked

    private void transactionManagementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionManagementMouseExited
        // TODO add your handling code here:
        transactionManagement.setFont(new java.awt.Font("Poppins Medium", 0, 14));
    }//GEN-LAST:event_transactionManagementMouseExited

    private void transactionManagementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionManagementMouseEntered
        // TODO add your handling code here:
        transactionManagement.setFont(new java.awt.Font("Poppins Medium", java.awt.Font.BOLD, 14));
    }//GEN-LAST:event_transactionManagementMouseEntered

    private void transactionManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionManagementMouseClicked
        // TODO add your handling code here:
        MouseClick.playClickSound();
        contentPanel.removeAll();

        // Create new instance of PatientManagement
        TransactionManagement transactionMgmt = new TransactionManagement();

        // Set the panel to fill the entire content area
        transactionMgmt.setSize(contentPanel.getSize());

        // Add the PatientManagement panel to content panel
        contentPanel.add(transactionMgmt);

        // Refresh the display
        contentPanel.revalidate();
        contentPanel.repaint();
    }//GEN-LAST:event_transactionManagementMouseClicked

    private void transcationTypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transcationTypeMouseExited
        // TODO add your handling code here:
        transcationType.setFont(new java.awt.Font("Poppins Medium", 0, 14));
    }//GEN-LAST:event_transcationTypeMouseExited

    private void transcationTypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transcationTypeMouseEntered
        // TODO add your handling code here:
        transcationType.setFont(new java.awt.Font("Poppins Medium", java.awt.Font.BOLD, 14));
    }//GEN-LAST:event_transcationTypeMouseEntered

    private void transcationTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transcationTypeMouseClicked
        // TODO add your handling code here:
        MouseClick.playClickSound();
        contentPanel.removeAll();

        // Create new instance of PatientManagement
        TransactionTypePage transactionTp = new TransactionTypePage();

        // Set the panel to fill the entire content area
        transactionTp.setSize(contentPanel.getSize());

        // Add the PatientManagement panel to content panel
        contentPanel.add(transactionTp);

        // Refresh the display
        contentPanel.revalidate();
        contentPanel.repaint();
    }//GEN-LAST:event_transcationTypeMouseClicked

    private void patientManagementLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientManagementLabelMouseExited
        // TODO add your handling code here:
        patientManagementLabel.setFont(new java.awt.Font("Poppins Medium", 0, 14));
    }//GEN-LAST:event_patientManagementLabelMouseExited

    private void patientManagementLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientManagementLabelMouseEntered
        // TODO add your handling code here:
        patientManagementLabel.setFont(new java.awt.Font("Poppins Medium", java.awt.Font.BOLD, 14));
    }//GEN-LAST:event_patientManagementLabelMouseEntered

    private void patientManagementLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientManagementLabelMouseClicked
        // TODO add your handling code here:

        MouseClick.playClickSound();
        contentPanel.removeAll();

        // Create new instance of PatientManagement
        PatientManagement patientMgmt = new PatientManagement();

        // Set the panel to fill the entire content area
        patientMgmt.setSize(contentPanel.getSize());

        // Add the PatientManagement panel to content panel
        contentPanel.add(patientMgmt);

        // Refresh the display
        contentPanel.revalidate();
        contentPanel.repaint();
    }//GEN-LAST:event_patientManagementLabelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        MouseClick.playNotificationSound();
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to Log out?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            MouseClick.playClickSound();
            this.dispose();
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
        } else if (choice == JOptionPane.NO_OPTION) {
            MouseClick.playClickSound();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void locationFinderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationFinderBtnMouseClicked
        // TODO add your handling code here:
        MouseClick.playClickSound();
        contentPanel.removeAll();
        MapLocation mapLocation = new MapLocation();
        mapLocation.setSize(contentPanel.getSize());
        contentPanel.add(mapLocation);
        contentPanel.revalidate();
        contentPanel.repaint();
    }//GEN-LAST:event_locationFinderBtnMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../icon/32x32LOGO.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel guestTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private test.CustomButton locationFinderBtn;
    private javax.swing.JLabel patientManagementLabel;
    private javax.swing.JLabel taglineTxt;
    private javax.swing.JLabel taglineTxt1;
    private javax.swing.JLabel transactionManagement;
    private javax.swing.JLabel transcationType;
    // End of variables declaration//GEN-END:variables
}
