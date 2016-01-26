/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;
import percolation.State;
import static percolation.State.ASH;
import static percolation.State.EMPTY;
import static percolation.State.FIRE;
import static percolation.State.TREE;

/**
 *
 * @author doyenm
 */
public class JCanvas extends JPanel {

    private State[] arrayState;
    private int size;
    private int height;
    private int width;

    public JCanvas(State[] array, int width, int height, int size) {
        this.arrayState = array;
        this.size = size;
        this.width = width;
        this.height = height;
    }

    private void viewLine(State[] array, Graphics g, int line) {
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case TREE:
                    g.setColor(Color.GREEN);
                    g.fillRect(i * size, line * size, size, size);
                    break;
                case FIRE:
                    g.setColor(Color.ORANGE);
                    g.fillRect(i * size, line * size, size, size);
                    break;
                case ASH:
                    g.setColor(Color.GRAY);
                    g.fillRect(i * size, line * size, size, size);
                    break;
                case EMPTY:
                    g.setColor(Color.WHITE);
                    g.fillRect(i * size, line * size, size, size);
                    break;
                default:
                    throw new AssertionError(array[i].name());
            }
        }
        System.out.println();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < height; i++) {
            viewLine(Arrays.copyOfRange(this.arrayState, i * width, (i + 1) * width), g, i);
        }
        System.out.println();
        System.out.println();
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillRect(10, 10, 80, 80);
//        g.setColor(Color.BLUE);
//        g.fillOval(150, 50, 80, 80);
//        g.setColor(c);

    }

}
