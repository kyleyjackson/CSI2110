package P_ASSIGNMENTS.P1_300425781;

// imports
import java.util.ArrayList;
import java.util.Collections;

public class Partition {

    // instance variables
    private int numClusters;
    private ArrayList<Integer> clusterSizes = new ArrayList<>();
    private int size;

    // constructor
    public Partition(int s) {
        numClusters = 0;
        size = s;
        clusterSizes.add(size);

    }

    // methods
    public int makeCluster(int x) {

        return -1;
    }

    public void union (int p, int q) {}

    public int find(int p) {
        if ()


        return -1;
    }

    public int element(int p) {

        return -1;
    }

    public int numberOfClusters() { return numClusters; }

    public int clusterSize(int p) {

        return -1;
    }

    public int clusterPositions(int p) {
        
        return -1;
    }

    public ArrayList<Integer> clusterSizes() {
        Collections.sort(clusterSizes, Collections.reverseOrder());

        return clusterSizes;
    }
}