/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.folder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class DefineGUI extends JFrame{
     public DefineGUI() {
        super("Definition of the wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);

        JButton button = new JButton("Define");
        button.addActionListener(new CreateListener(this));
        
        JTextField width = new JTextField(20);
        JTextField height = new JTextField(20);
        JTextField p = new JTextField(20);
        JTextField e = new JTextField(20);
        JTextField eMaj = new JTextField(20);
        
        
        
        JPanel panel = new JPanel();
        panel.add(width, BorderLayout.CENTER);
        panel.add(height, BorderLayout.CENTER);
        panel.add(p);
        panel.add(e);
        panel.add(eMaj);
        panel.add(button);

        setContentPane(panel);
        setSize(500, 300);
        setVisible(true);
    }
     
     class CreateListerner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
         
     }
}
