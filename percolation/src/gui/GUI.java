/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.event.*;
import percolation.State;

/**
 *
 * @author doyenm
 */
public class GUI extends JFrame {

    public GUI(State[] arrayState, int width, int height) {
        super("Fire's wood");
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);
        int size;
        if(width>height){
            size = 500/width;
        } else {
            size = 500/height;
        }
        JCanvas canvas = new JCanvas(arrayState, width, height, size);
        
        setContentPane(canvas);
        setSize(500, 530);
        setVisible(true);
    
    
    }

}
