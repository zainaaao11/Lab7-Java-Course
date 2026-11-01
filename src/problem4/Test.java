package problem4;


public class Test {
    public static void main(String[] args) {
        /*
        //Test case for the LinkedList class
        ListItem item=null;
        MyLinkedList list = new MyLinkedList(item);
        //TEST 1: Empty list
        System.out.println("=== TEST 1: Empty list ===");
        list.traverse(list.getRoot());
        // TEST 2: Add items in random order
        System.out.println("\n=== TEST 2: Add items ===");
        System.out.println(list.addItem(new Node("Charlie")));
        System.out.println(list.addItem(new Node("Alice")));
        System.out.println(list.addItem(new Node("David")));
        System.out.println(list.addItem(new Node("Bob")));
        System.out.println("Sorted list:");
        list.traverse(list.getRoot());
        // TEST 3: Add a duplicate
        System.out.println("\n=== TEST 3: Duplicate ===");
        System.out.println(list.addItem(new Node("Bob")));
        list.traverse(list.getRoot());
        // TEST 4: Remove a middle element
        System.out.println("\n=== TEST 4: Remove Bob ===");
        System.out.println(list.removeItem(new Node("Bob")));
        list.traverse(list.getRoot());
        // TEST 5: Remove the first element
        System.out.println("\n=== TEST 5: Remove Alice ===");
        System.out.println(list.removeItem(new Node("Alice")));
        list.traverse(list.getRoot());
        // TEST 6: Remove the last element
        System.out.println("\n=== TEST 6: Remove David ===");
        System.out.println(list.removeItem(new Node("David")));
        list.traverse(list.getRoot());
        // TEST 7: Remove a non-existing element
        System.out.println("\n=== TEST 7: Remove unknown ===");
        System.out.println(list.removeItem(new Node("Zoe")));
        // TEST 8: Remove the only remaining element
        System.out.println("\n=== TEST 8: Remove last remaining ===");
        System.out.println(list.removeItem(new Node("Charlie")));
        list.traverse(list.getRoot());
*/
        //Test case for the searchTree class
        SearchTree empty = new SearchTree(null);
        empty.traverse(empty.getRoot());
        System.out.println("Remove 10: "+ empty.removeItem(new Node(10)));
        SearchTree tree = new SearchTree(null);
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            System.out.println("Add " + value + ": " + tree.addItem(new Node(value)));
        }
        System.out.println("In-order traversal:");
        tree.traverse(tree.getRoot());
        System.out.println("Add 30 again: " + tree.addItem(new Node(30)));
        testRemoval("Remove leaf", new int[]{50, 30, 70, 20, 40}, 20);
        testRemoval("Only left child", new int[]{50, 30, 70, 20}, 30);
        testRemoval("Only right child", new int[]{50, 30, 70, 40}, 30);
        testRemoval("Two children (non-root)", new int[]{50, 30, 70, 20, 40, 35, 45}, 30);
        testRemoval("Two children (root)", new int[]{50, 30, 70, 20, 40, 60, 80, 55, 57, 65}, 50);
        testRemoval("Only element", new int[]{50}, 50);
        testRemoval("Nonexistent element", new int[]{50, 30, 70}, 99);
    }
    public static void testRemoval(String label, int[] values, int target) {
        SearchTree tree = new SearchTree(null);
        for (int value : values) {
            tree.addItem(new Node(value));
        }
        System.out.println("\n=== " + label + " ===");
        System.out.println("Remove " + target + ": " + tree.removeItem(new Node(target)));
        tree.traverse(tree.getRoot());
    }
}
