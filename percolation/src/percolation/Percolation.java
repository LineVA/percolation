
package percolation;

import gui.folder.basicGUI;
import gui.folder.GUI;


/**
 *
 * @author doyenm
 */
public class Percolation {

    /**
     * @param args the command line arguments
     * @throws percolation.ForestException
     */
    public static void main(String[] args) throws ForestException {
        // TO DO : FEATURE : CORRECT MANAGEMENT OF THE CREATION OF EMPTY SPACES

        GUI gui = new GUI();
        
        
        
        // The width of the forrest
//        int width = 10;
//        // The height of the forrest
//        int height = 10;
//        // The parameter of the percolation
//        float p = (float) 0.6;
//        // The probability to have, for a given case, an empty block instead of
//        // a tree
//        float e = (float) 0.2;
//        // The "bonus" probabbility to have, for a given case, an empty block instead of
//        // a tree, if a neighbors is already empty.
//        float eMaj = (float)0.1;
        Forest forrest = new Forest(width, height, e, eMaj);
        System.out.println("Situation initiale : ");
        basicGUI.view(forrest.getForestArray(), width, height);
        //System.out.println("Embrasement du premier arbre : ");
       // forrest.selectFirst();
        //basicGUI.view(forrest.getForestArray(), width, height);
        System.out.println("Premier pas : ");
        forrest.fire(p);
        
    }

}
