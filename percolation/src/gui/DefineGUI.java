/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import percolation.Forest;
import percolation.ForestException;

/**
 *
 * @author doyenm
 */
public class DefineGUI extends JFrame {

    public JTextField widthTF;
    public JTextField heightTF;
    public JTextField pTF;
    public JTextField eTF;
    public JTextField eMajTF;

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

        widthTF = new JTextField("10", 20);
        heightTF = new JTextField("10", 20);
        pTF = new JTextField("0.5", 20);
        eTF = new JTextField("0.1", 20);
        eMajTF = new JTextField("0.05", 20);

        JPanel panel = new JPanel();
        panel.add(widthTF, BorderLayout.CENTER);
        panel.add(heightTF, BorderLayout.CENTER);
        panel.add(pTF);
        panel.add(eTF);
        panel.add(eMajTF);
        panel.add(button);

        setContentPane(panel);
        setSize(500, 300);
        setVisible(true);
    }

    private static class CreateListener implements ActionListener {

        int width;
        int height;
        float p;
        float e;
        float eMaj;
        DefineGUI gui;

        public CreateListener(DefineGUI aThis) {
            this.gui = aThis;
        }

        @Override
        public void actionPerformed(ActionEvent ex) {
            this.width = Integer.parseInt(this.gui.widthTF.getText());
            this.height = Integer.parseInt(this.gui.heightTF.getText());
            this.p = Float.parseFloat(this.gui.pTF.getText());
            this.e = Float.parseFloat(this.gui.eTF.getText());
            this.eMaj = Float.parseFloat(this.gui.eMajTF.getText());

            System.out.println(width);
            Forest forrest;
            try {
                forrest = new Forest(width, height, e, eMaj);
                System.out.println("Situation initiale : ");
                basicGUI.view(forrest.getForestArray(), width, height);
                forrest.fire(p);
            } catch(ForestException fEx){
                fEx.printStackTrace();
            }
        }
    }

}
