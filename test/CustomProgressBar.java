/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import javax.swing.JProgressBar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class CustomProgressBar extends JProgressBar {
    private final int cornerRadius = 6;

    public CustomProgressBar() {
        super();
        setOpaque(false); 
        setBorder(null); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int progressWidth = (int) ((double) width * (getValue() / (double) getMaximum()));

        // Draw background
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius));

        // Draw progress
        g2.setColor(getForeground());
        g2.fill(new RoundRectangle2D.Double(0, 0, progressWidth, height, cornerRadius, cornerRadius));

        g2.dispose();
    }
}
