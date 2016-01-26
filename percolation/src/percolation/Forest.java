package percolation;

import gui.basicGUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author doyenm
 */
public class Forest {

    private State[] forestArray;
    private int width;
    private int height;
    private ArrayList<Integer> burnArray;
    private boolean isBurning = false;

    public State[] getForestArray() {
        return forestArray;
    }

    public Forest(int width, int height, float e, float eMaj) throws ForestException {
        if (width > 0 && height > 0) {
            this.height = height;
            this.width = width;
            forestArray = new State[width * height];
            burnArray = new ArrayList<>();
            initForrest(e, eMaj);
        } else {
            throw new ForestException("At least one dimension of the forest "
                    + "is lower or equals to zero.");
        }
    }

    public int[] findNeighbors(int i) {
        int[] tmp = new int[4];
        tmp[0] = i - 1;
        tmp[1] = i + 1;
        tmp[2] = i - width;
        tmp[3] = i + width;
        return tmp;
    }

    public void emptingNeighbors(int empty, float e, float eMaj) {
        int[] neighbors = findNeighbors(empty);
        for (int j = 0; j < neighbors.length; j++) {
            if (this.isInForest(neighbors[j], empty) && this.forestArray[neighbors[j]].equals(State.UNDEFINED)) {
                if (Math.random() < (e + eMaj)) {
                    this.forestArray[neighbors[j]] = State.EMPTY;
                    emptingNeighbors(neighbors[j], e, eMaj);
                }
            }
        }
    }

    public void initForrest(float e, float eMaj) throws ForestException {
        Arrays.fill(this.forestArray,State.UNDEFINED);
        for (int i = 0; i < this.forestArray.length; i++) {
            if (Math.random() < e) {
                this.forestArray[i] = State.EMPTY;
                emptingNeighbors(i, e, eMaj);
            } else if(this.forestArray[i].equals(State.UNDEFINED)){
                this.forestArray[i] = State.TREE;
            }
        }
        selectFirst();
    }

    public boolean toFire(int i) throws ForestException {
        if (i >= 0 && i < this.width * this.height) {
            if (forestArray[i].equals(State.TREE)) {
                forestArray[i] = State.FIRE;
                isBurning = true;
                return true;
            } else {
                return false;
            }
        } else {
            throw new ForestException("You cannot burn anything outside "
                    + "the forest");
        }
    }

    public boolean toAsh(int i) throws ForestException {
        if (i >= 0 && i < this.width * this.height) {
            if (forestArray[i].equals(State.FIRE)) {
                forestArray[i] = State.ASH;
                return true;
            } else {
                return false;
            }
        } else {
            throw new ForestException("You cannot turn anything to ash outside "
                    + "the forest");
        }
    }

    public void selectFirst() throws ForestException {
        int first = (int) (Math.random() * width * height);
        while (!toFire(first)) {
            first = (int) (Math.random() * width * height);
        }
        System.out.println(first);
    }

    public boolean isInForest(int i, int previous) {
        // We test if we are in the forrest
        if (i >= 0 && i < this.width * this.height) {
            // If yes, we test if we are on the first or the last column
            // This test is only interessant we change the column
            if ((i % (width - 1) == 0 && previous % width == 0)
                    || (previous % (width - 1) == 0 && i % width == 0)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void tryToBurn(int i, float p, int previous)
            throws ForestException {
        if (isInForest(i, previous)) {
            if (Math.random() < p) {
                toFire(i);
            }
        }
    }

    public void fireNeighbors(int fire, float p) throws ForestException {
        int[] neighbors = findNeighbors(fire);
        for (int i = 0; i < 4; i++) {
            tryToBurn(neighbors[i], p, fire);
        }
    }

    public void fire(float p) throws ForestException {
        if (isBurning == true) {
            isBurning = false;
            // To find which trees are burning
            for (int i = 0; i < this.forestArray.length; i++) {
                if (this.forestArray[i].equals(State.FIRE)) {
                    burnArray.add(i);
                }
            }
            // We try to fire our neighboors
            Iterator it = burnArray.iterator();
            while (it.hasNext()) {
                fireNeighbors((Integer) it.next(), p);
            }
            // The trees, which were previously burning are now turning to ash.
            Iterator it2 = burnArray.iterator();
            while (it2.hasNext()) {
                toAsh((Integer) it2.next());
                it2.remove();
            }
            basicGUI.view(forestArray, width, height);
            fire(p);
        } else {
            System.out.println("Fin de la simulation, "
                    + "plus aucun arbre n'est en flamme.");
        }
    }

}
