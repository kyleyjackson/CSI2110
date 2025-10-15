package P_ASSIGNMENTS.P1_300425781;

import java.util.*;

public class Partition<E> {

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        Cluster<E> cluster; 

        Node(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
            this.cluster = null;
        }
    }

    private static class Cluster<E> {
        Node<E> head;
        Node<E> tail;
        int size;

        Cluster(Node<E> node) {
            this.head = node;
            this.tail = node;
            this.size = 1;
        }
    }

    // partition instance variables
    private int numClusters;                 
    private List<Cluster<E>> clusters;       

    public Partition() {
        clusters = new LinkedList<>();
        numClusters = 0;
    }

    public Node<E> makeCluster(E x) {
        Node<E> node = new Node<>(x);
        Cluster<E> c = new Cluster<>(node);

        node.cluster = c;
        clusters.add(c);
        numClusters++;

        return node;
    }

    public Node<E> find(Node<E> p) {
        if (p == null) throw new IllegalArgumentException("Position cannot be null");

        return p.cluster.head; 
    }

    public void union(Node<E> p, Node<E> q) {
        Cluster<E> clusterP = p.cluster;
        Cluster<E> clusterQ = q.cluster;

        if (clusterP == clusterQ) return; 

        if (clusterP.size > clusterQ.size) {
            merge(clusterQ, clusterP);
        } else {
            merge(clusterP, clusterQ);
        }

        numClusters--;
    }

    private void merge(Cluster<E> small, Cluster<E> large) {
        large.tail.next = small.head;
        small.head.prev = large.tail;
        large.tail = small.tail;
        large.size += small.size;

        Node<E> current = small.head;

        while (current != null) {
            current.cluster = large;
            current = current.next;
        }

        clusters.remove(small);
    }

    public E element(Node<E> p) { return p.element; }

    public int numberClusters() { return numClusters; }

    public int clusterSize(Node<E> p) { return p.cluster.size; }

    public List<Node<E>> clusterPositions(Node<E> p) {
        List<Node<E>> list = new ArrayList<>();
        Node<E> current = p.cluster.head;

        while (current != null) {
            list.add(current);
            current = current.next;
        }

        return list;
    }

    public List<Integer> clusterSizes() {
        List<Integer> sizes = new ArrayList<>();

        for (Cluster<E> c : clusters) {
            sizes.add(c.size);
        }
        
        sizes.sort(Collections.reverseOrder());
        return sizes;
    }
}
