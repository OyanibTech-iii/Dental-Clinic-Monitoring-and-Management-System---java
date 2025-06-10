/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
/**
 *
 * @author Admin
 */
public class scrollpane extends JScrollBar  {
    

    public scrollpane() {
        setUI(new CustomScrollBar());
        setPreferredSize(new Dimension(12, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
