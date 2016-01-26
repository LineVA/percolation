/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import percolation.Forest;
import percolation.ForestException;

/**
 *
 * @author doyenm
 */
public final class DefineGUI extends JFrame {

    public JTextField widthTF;
    public JTextField heightTF;
    public JTextField pTF;
    public JTextField eTF;
    public JTextField eMajTF;

    public void oneFieldBuilding(GridBagConstraints c, JPanel pane,
            String label, int gridy, JTextField tf) {
        JLabel jLabel = new JLabel(label);
        c.gridx = 0;
        c.gridy = gridy;
        pane.add(jLabel, c);
        widthTF = new JTextField("10", 20);
        c.gridx = 1;
        c.gridy = gridy;
        pane.add(tf, c);
    }

    public DefineGUI() {
        super("Definition of the wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);

        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        widthTF = new JTextField("10", 20);
        oneFieldBuilding(c, pane, "Width : ", 0, widthTF);
        heightTF = new JTextField("10", 20);
        oneFieldBuilding(c, pane, "Height : ", 1, heightTF);
        pTF = new JTextField("0.5", 20);
        oneFieldBuilding(c, pane, "p : ", 2, pTF);
        eTF = new JTextField("0.1", 20);
        oneFieldBuilding(c, pane, "e : ", 3, eTF);
        eMajTF = new JTextField("0.05", 20);
        oneFieldBuilding(c, pane, "eMaj : ", 4, eMajTF);

        JButton button = new JButton("Define");
        button.addActionListener(new CreateListener(this));
        c.gridx = 0;
        c.gridy = 5;
        pane.add(button, c);

        setContentPane(pane);
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
               // basicGUI.view(forrest.getForestArray(), width, height);
                GUI gui = new GUI(forrest, width, height, p);
             //   forrest.selectFirst();
                basicGUI.view(forrest.getForestArray(), width, height);
            } catch (ForestException fEx) {
                fEx.printStackTrace();
            }
        }
    }

}
