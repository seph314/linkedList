/**
 * Created by Anders on 2017-09-18.
 * LinkedList is a single linked list implementation
 * The list contains nodes that contains a item and a reference to the next node
 * The list can be sorted with a bubble sort algorithm through the method bubbleSort()
 *
 * @param <Item> is the item in the linked list
 */
public class LinkedList<Item extends Comparable<Item>> {
    private int sizeOfList;
    private Node first;

    /**
     * Nested class Node
     * represents a node in the linked list
     */
    public class Node {
        private Item item;
        private Node nextNode;
    }

    /**
     * Constructor for an empty list
     * No referense, and zero items
     */
    public LinkedList() {
        first = null;
        sizeOfList = 0;
    }

    /**
     * Checks if a LinkedList is empty
     *
     * @return if first element in the list is empty
     */
    public boolean isEmty() {
        return first == null;
    }

    /**
     * returns the first element in a LinkedList
     *
     * @return
     */
    public Item getFirst() {
        return first.item;
    }

    /**
     * Returns the next node
     *
     * @return next node in chain
     */
    public Node next() {
        return first.nextNode;
    }

    /**
     * Swaps place of two nodes
     *
     * @param currentNode
     * @param nextNode
     */
    public void swap(Node currentNode, Node nextNode) {
        Item item = currentNode.item;
        currentNode.item = nextNode.item;
        nextNode.item = item;
    }

    /**
     * Adds a new node and linkes it to the previousFirstNode
     * increments the varable that keeps track of the list size
     *
     * @param item is the new item that goes in the list
     */
    public void addNode(Item item) {
        Node peviousFirstNode = first;
        first = new Node();
        first.item = item;
        first.nextNode = peviousFirstNode;
        sizeOfList++;
    }

    /**
     * Gets a node at a specific place in the list
     *
     * @param index of the node we want to find
     * @return
     */
    public Item getNodeAtIndex(int index) {
        for (Node findNode = first; findNode != null; findNode = findNode.nextNode) {
            if (index == 0)
                return findNode.item;
            index--;
        }
        return null;
    }

    /**
     * Getter for size
     *
     * @return size of LinkedList
     */
    public int getSizeOfList() {
        return sizeOfList;
    }

    /**
     * Customized toString medthod
     *
     * @return result + the last item when nextNode = null
     */
    public String toSting() {
        String result = "";
        Node currentNode = first;
        while (currentNode.nextNode != null) {
            result += currentNode.item;
            currentNode = currentNode.nextNode;
        }
        return result + currentNode.item;
    }

    /**
     * Sorts a linked list via a bubble sort algorithm
     * Implementation via lab 3 PDF
     */
    public int bubbleSort() {
        int R = sizeOfList - 2;
        boolean swapped = true;
        int amountOfSwaps = 0;

        while (R >= 0 && swapped) {
            swapped = false;
            Node node = first;
            for (int i = 0; i <= R; i++) {
                if (node.item.compareTo(node.nextNode.item) > 0) {
                    swapped = true;
                    swap(node, node.nextNode);
                    amountOfSwaps++;
                }
                node = node.nextNode;
            }
            R--;
        }
        return amountOfSwaps;
    }

    /**
     * Counts number of inversions in bubbleSort
     * @return number of inversions
     */
    public int countInversions() {
        int numberOfInversions = 0;

        for (int i = 0; i < sizeOfList; i++)
            for (int j = i + 1; j < sizeOfList; j++) {
                if (getNodeAtIndex(i).compareTo(getNodeAtIndex(j)) > 0) {
                     numberOfInversions++;
                }
            }
        return numberOfInversions;
    }
}
