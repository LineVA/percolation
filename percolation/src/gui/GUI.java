/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import percolation.Forest;
import percolation.ForestException;
import percolation.State;

/**
 *
 * @author doyenm
 */
public class GUI extends JFrame {

    public GUI(Forest forrest, int width, int height, float p) {
        super("Fire's wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);
        int size;
        if (width > height) {
            size = 500 / width;
        } else {
            size = 500 / height;
        }
        JCanvas canvas = new JCanvas(forrest.getForestArray(), width, height, size);

        JButton step = new JButton("Step by step");
        step.addActionListener(new StepListener(forrest.getForestArray()));
        JButton end = new JButton("To the end");

        // canvas.add(step);
        canvas.add(end);
        end.addActionListener(new EndListener(forrest, p, canvas));
        
        setContentPane(canvas);
        setSize(500, 530);
        setVisible(true);
    }

    private static class StepListener implements ActionListener {

        private State[] arrayState;

        public StepListener(State[] arrayState) {
            this.arrayState = arrayState;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private static class EndListener implements ActionListener {

        private Forest forrest;
        private Float p;
        private JCanvas canvas;

        public EndListener(Forest forrest, float p, JCanvas canvas) {
            this.forrest = forrest;
            this.p = p;
            this.canvas = canvas;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                forrest.fire(this.p);
                canvas.repaint();
            } catch (ForestException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
