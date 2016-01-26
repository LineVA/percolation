/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.DefineGUI;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author doyenm
 */
public class GUI extends JFrame {

    public GUI() {
        super("Fire's wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);
        
        JButton bouton = new JButton("Define the woods");
        
        bouton.addActionListener(new defineListener(this));
        JPanel panneau = new JPanel();
        panneau.add(bouton);

        setContentPane(panneau);
        setSize(1500, 750);
        setVisible(true);
    }
    
    class defineListener implements ActionListener{
        
        GUI gui;
        
        private defineListener(GUI gui) {
            this.gui = gui;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Priut");
            DefineGUI define = new DefineGUI();
        }
        
    }

}
