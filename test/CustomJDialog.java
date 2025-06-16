/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 * Modern CustomJDialog with rounded corners and clean design
 * @author Admin
 */
public class CustomJDialog extends JDialog {
    
    public enum DialogType {
        SUCCESS, ERROR, WARNING
    }
    
    private static final Color WHITE = new Color(255, 255, 255);
    private static final Color SUCCESS_COLOR = new Color(34, 197, 94); // Modern green
    private static final Color ERROR_COLOR = new Color(239, 68, 68); // Modern red  
    private static final Color WARNING_COLOR = new Color(245, 158, 11); // Modern amber
    private static final Color TEXT_PRIMARY = new Color(60, 60, 60); // Dark gray for better readability on light glass
    private static final Color TEXT_SECONDARY = new Color(100, 100, 100); // Medium gray for light background
    private static final Color LIGHT_GREY_BG = new Color(245, 245, 245); // Light grey background
    private static final Color LIGHT_GREY_BORDER = new Color(220, 220, 220); // Slightly darker grey border
    private static final Font FONT_TITLE = new Font("Poppins-Light", Font.BOLD, 18);
    private static final Font FONT_MESSAGE = new Font("Poppins-Light", Font.PLAIN, 14);
    private static final Font FONT_BUTTON = new Font("Poppins-Light", Font.BOLD, 13);

    public CustomJDialog(JFrame parent, String message, DialogType type) {
        super(parent, "", true);
        initializeDialog(parent, message, type);
    }
    
    // Backward compatibility constructor
    public CustomJDialog(JFrame parent, String message, boolean isSuccess) {
        super(parent, "", true);
        DialogType type = isSuccess ? DialogType.SUCCESS : DialogType.ERROR;
        initializeDialog(parent, message, type);
    }
    
    private void initializeDialog(JFrame parent, String message, DialogType type) {
        setUndecorated(true);
        setSize(432, 235); // Width increased by 20% (360 * 1.2 = 432), Height reduced by 20% (280 * 0.8 = 224)
        setLocationRelativeTo(parent);
        setBackground(new Color(0, 0, 0, 0)); // Transparent background for rounded corners
        
        // Create main content panel with rounded corners
        JPanel contentPanel = createContentPanel(message, type);
        add(contentPanel);
        
        // Add subtle drop shadow effect
        setVisible(true);
    }
    
    private JPanel createContentPanel(String message, DialogType type) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Draw subtle drop shadow
                g2d.setColor(new Color(0, 0, 0, 15));
                for (int i = 0; i < 6; i++) {
                    g2d.fillRoundRect(i, i + 2, getWidth() - 2 * i, getHeight() - 2 * i - 2, 12 - i, 12 - i);
                }
                
                // Draw main light grey background with rounded corners
                g2d.setColor(LIGHT_GREY_BG);
                g2d.fillRoundRect(4, 4, getWidth() - 8, getHeight() - 8, 12, 12);
                
                // Draw subtle border
                g2d.setColor(LIGHT_GREY_BORDER);
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.drawRoundRect(4, 4, getWidth() - 8, getHeight() - 8, 12, 12);
                
                g2d.dispose();
            }
        };
        
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header section with icon and title
        JPanel headerPanel = createHeaderPanel(type);
        panel.add(headerPanel, BorderLayout.NORTH);
        
        // Message section
        JPanel messagePanel = createMessagePanel(message, type);
        panel.add(messagePanel, BorderLayout.CENTER);
        
        // Button section
        JPanel buttonPanel = createButtonPanel(type);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createHeaderPanel(DialogType type) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0)); // Reduced bottom margin
        
        // Icon panel
        JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        iconPanel.setOpaque(false);
        
        JLabel iconLabel = createIconLabel(type);
        iconPanel.add(iconLabel);
        
        // Title label
        JLabel titleLabel = new JLabel(getTitleText(type), SwingConstants.CENTER);
        titleLabel.setForeground(TEXT_PRIMARY);
        titleLabel.setFont(FONT_TITLE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0)); // Reduced top margin
        
        headerPanel.add(iconPanel, BorderLayout.CENTER);
        headerPanel.add(titleLabel, BorderLayout.SOUTH);
        
        return headerPanel;
    }
    
    private JLabel createIconLabel(DialogType type) {
        // Create a circular background for the icon
        JLabel iconLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                Color bgColor = getIconBackgroundColor(type);
                // Light background for icon
                g2d.setColor(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), 30));
                g2d.fillOval(0, 0, getWidth(), getHeight());
                
                // Add subtle border to icon background
                g2d.setColor(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), 80));
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.drawOval(1, 1, getWidth() - 2, getHeight() - 2);
                
                super.paintComponent(g2d);
                g2d.dispose();
            }
        };
        
        iconLabel.setPreferredSize(new Dimension(64, 64));
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLabel.setVerticalAlignment(JLabel.CENTER);
        
        // Try to load custom icon, fallback to emoji if not found
        ImageIcon icon = loadIcon(type);
        if (icon != null) {
            iconLabel.setIcon(icon);
        } else {
            iconLabel.setText(getIconEmoji(type));
            iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
            iconLabel.setForeground(getIconBackgroundColor(type));
        }
        
        return iconLabel;
    }
    
    private ImageIcon loadIcon(DialogType type) {
        try {
            String iconPath;
            switch (type) {
                case SUCCESS:
                    iconPath = "../icon/success.png";
                    break;
                case ERROR:
                    iconPath = "../icon/fail.png";
                    break;
                case WARNING:
                    iconPath = "../icon/warning.png";
                    break;
                default:
                    return null;
            }
            
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
            Image scaledImage = originalIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            // Icon file not found, will use emoji fallback
            return null;
        }
    }
    
    private String getIconEmoji(DialogType type) {
        switch (type) {
            case SUCCESS:
                return "✓";
            case ERROR:
                return "✕";
            case WARNING:
                return "⚠";
            default:
                return "ℹ";
        }
    }
    
    private Color getIconBackgroundColor(DialogType type) {
        switch (type) {
            case SUCCESS:
                return SUCCESS_COLOR;
            case ERROR:
                return ERROR_COLOR;
            case WARNING:
                return WARNING_COLOR;
            default:
                return TEXT_SECONDARY;
        }
    }
    
    private String getTitleText(DialogType type) {
        switch (type) {
            case SUCCESS:
                return "Success";
            case ERROR:
                return "Error";
            case WARNING:
                return "Warning";
            default:
                return "Information";
        }
    }
    
    /**
     * Enhanced message panel with dynamic color based on dialog type
     */
    private JPanel createMessagePanel(String message, DialogType type) {
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setOpaque(false);
        messagePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Reduced bottom margin
        
        JLabel messageLabel = new JLabel("<html><div style='text-align: center; line-height: 1.5;'>" + 
                                       message + "</div></html>");
        
        // Set message color to match dialog type color
        messageLabel.setForeground(getMessageColor(type));
        messageLabel.setFont(FONT_MESSAGE);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        messagePanel.add(messageLabel, BorderLayout.CENTER);
        
        return messagePanel;
    }
    
    /**
     * Get message text color based on dialog type
     * @param type The dialog type
     * @return Color for the message text
     */
    private Color getMessageColor(DialogType type) {
        switch (type) {
            case SUCCESS:
                return SUCCESS_COLOR;
            case ERROR:
                return ERROR_COLOR;
            case WARNING:
                return WARNING_COLOR;
            default:
                return TEXT_SECONDARY;
        }
    }
    
    private JPanel createButtonPanel(DialogType type) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        
        JButton actionButton = createModernButton(type);
        buttonPanel.add(actionButton);
        
        return buttonPanel;
    }
    
    private JButton createModernButton(DialogType type) {
        JButton button = new JButton(getButtonText(type)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                Color bgColor = getButtonColor(type);
                
                // Solid button background with hover effects
                if (getModel().isPressed()) {
                    bgColor = bgColor.darker();
                } else if (getModel().isRollover()) {
                    bgColor = new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), 220);
                }
                
                // Button background
                g2d.setColor(bgColor);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                
                // Draw text with white color
                g2d.setColor(WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(getText(), textX, textY);
                
                g2d.dispose();
            }
        };
        
        button.setPreferredSize(new Dimension(100, 32)); // Reduced button size from 120x40 to 100x32
        button.setFont(FONT_BUTTON);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addActionListener(e -> dispose());
        
        return button;
    }
    
    private String getButtonText(DialogType type) {
        switch (type) {
            case SUCCESS:
                return "Continue";
            case ERROR:
                return "Try Again";
            case WARNING:
                return "Understood";
            default:
                return "OK";
        }
    }
    
    private Color getButtonColor(DialogType type) {
        switch (type) {
            case SUCCESS:
                return SUCCESS_COLOR;
            case ERROR:
                return ERROR_COLOR;
            case WARNING:
                return WARNING_COLOR;
            default:
                return TEXT_SECONDARY;
        }
    }
    
    @Override
    public void setShape(Shape shape) {
        super.setShape(shape);
    }
    
    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            // Set rounded shape for the dialog
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 12, 12));
        }
        super.setVisible(visible);
    }
}