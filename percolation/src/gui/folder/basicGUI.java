/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.folder;

import java.util.Arrays;
import percolation.State;

/**
 *
 * @author doyenm
 */
public class basicGUI {

    private static void viewLine(State[] array) {
        for (int i = 0; i < array.length; i++) {
             switch (array[i]) {
                case TREE:
                    System.out.print("t");
                    break;
                case FIRE:
                    System.out.print("f");
                    break;
                case ASH:
                    System.out.print("a");
                    break;
                case EMPTY:
                    System.out.print("e");
                    break;
                default:
                    throw new AssertionError(array[i].name());
            }
        }
        System.out.println();
    }

    public static void view(State[] array, int width, int height) {
        for (int i = 0; i < height; i++) {
            viewLine(Arrays.copyOfRange(array, i * width, (i + 1) * width));
        }
        System.out.println();
        System.out.println();

    }
}
