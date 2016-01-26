/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.folder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author doyenm
 */
public class defineGUI extends JFrame {

    public defineGUI() {
        super("Definition of the wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);

        JButton bouton = new JButton("Create the wood");
        JTextField width = new JTextField("Create the wood");
        JPanel panel = new JPanel();
        panel.add(bouton);
        panel.add(width);

        setContentPane(panel);
        setSize(500, 300);
        setVisible(true);
    }
}
