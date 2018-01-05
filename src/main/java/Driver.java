/**
 * Created by Anders on 2017-09-18.
 */

import edu.princeton.cs.introcs.StdIn;

public class Driver {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int amountOfSwaps;

        System.out.println("Wellcome to a sort of sort program, that Bubble sorts a list for you." +
                "\nEnter some numbers");
        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();
            for (int i = string.length()-1; i >=0; i--){
                linkedList.addNode(Integer.parseInt(Character.toString(string.charAt(i))));
            }
            System.out.println("Your list: " + linkedList.toSting());
            System.out.println("Number of inversions: " + linkedList.countInversions());
            amountOfSwaps = linkedList.bubbleSort();
            System.out.println("Bubble sorted list: " + linkedList.toSting() +
                    "\nIt took " + amountOfSwaps + " swaps to get there...");
        }
    }
}

