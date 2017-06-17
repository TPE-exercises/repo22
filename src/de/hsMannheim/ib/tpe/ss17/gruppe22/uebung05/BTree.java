package de.hsMannheim.ib.tpe.ss17.gruppe23.uebung05;

import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.ArrayStack;
import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 *
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034) Gruppe 2-2:
 * @author Marco Präg
 * @author Marc Mehrer
 */
public class BTree implements ADTBTree {

    private static final char SPACECHARACTER = ' ';

    private BTreeNode root;
    private int degree;

    /**
     * Creates a new B-Tree with a specific degree.
     *
     * @param degree degree of the B-Tree
     */
    public BTree(int degree) {
        if (degree <= 0) {
            throw new GDIException("The order has to be positive.");
        } else {
            this.degree = degree;
        }
    }

    /**
     * Returns the degree of the B-Tree.
     *
     * @return degree of the tree.
     */
    public int getOrder() {
        return this.degree;
    }

    /**
     * Inserts an object in the B-Tree at the right position.
     *
     * @param o Object to insert in the tree.
     * @return Returns if the process was successful.
     */
    public boolean insert(Comparable o) {
        if (o == null || contains(o)) {
            return false;
        }

        if (root == null) {
            // Tree is empty
            root = new BTreeNode(degree);
            root.insert(o);

        } else if ((root.getValues()[0]).getClass() != o.getClass()) {
            // The element to be inserted is not type-equal to already existing
            // elements in the tree.
            return false;
        } else {
            BTreeNode newRoot = new BTreeNode(degree);
            insertRecursive(o, root, newRoot);

            if (!newRoot.isEmpty()) {
                root = newRoot;
            }

        }

        return true;
    }

    /**
     * Searches recursively for the right insertion node (leaf) and inserts the
     * object. If any node is over filled after the insertion, it bursts and
     * splits up in two nodes.
     *
     * @param o Object to insert in the tree.
     * @param currentNode Currently inspected node.
     * @param previousNode Parent node of the current node. A new node if the
     * node has no parent (root).
     */
    private void insertRecursive(Comparable o, BTreeNode currentNode, BTreeNode previousNode) {
        if (currentNode.isLeaf()) {
            currentNode.insert(o);
        } else {
            insertRecursive(o, currentNode.getNextNodeToSearch(o), currentNode);
        }

        if (currentNode.isOverFilled()) {
            currentNode.split(previousNode);
        }
    }

    /**
     * Inserts an Integer object in the B-Tree.
     *
     * @param o Integer to insert.
     * @return Returns if the insertion was successful.
     */
    @Override
    public boolean insert(Integer o) {
        return insert((Comparable) o);
    }

    @Override
    public boolean insert(String filename) { // TODO extract degree from file
        if (!isFilePresent(filename)) {
            throw new GDIException("File not found.");
        }

        int[] values = new int[0];
        Object file = openInputFile(filename);
        while (!isEndOfInputFile(filename)) {
            int val = readInt(file);
            int[] copy = new int[values.length + 1];
            for (int i = 0; i < values.length; i++) {
                copy[i] = values[i];
            }
            copy[copy.length - 1] = val;
            values = copy;
        }

        closeInputFile(file);

        if (values.length <= 0) {
            throw new GDIException("Invalid file format");
        } else {
            boolean success = true;
            for (int i = 0; i < values.length; i++) {
                if (!insert(values[i])) {
                    success = false;
                }
            }
            return success;
        }
    }

    /**
     * Checks if a given Integer object is contained in the tree.
     *
     * @param o Integer to search for in the tree.
     * @return Returns if the Integer is contained in the tree.
     */
    @Override
    public boolean contains(Integer o) {
        return contains((Comparable) o);
    }

    /**
     * Checks if a given object is contained in the tree.
     *
     * @param o Object to search for in the tree.
     * @return Returns if the Object is contained in the tree.
     */
    public boolean contains(Comparable o) {
        if (o == null) {
            return false;
        }
        if (isEmpty()) {
            return false;
        } else if ((root.getValues()[0]).getClass() != o.getClass()) {
            // The element to be inserted is not type-equal to already existing
            // elements in the tree.
            return false;
        }
        BTreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.contains(o)) {
                return true;
            } else {
                currentNode = currentNode.getNextNodeToSearch(o);
            }
        }

        return false;
    }

    /**
     * Returns the size of the tree.
     *
     * @return Number of elements in the tree.
     */
    @Override
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size();
        }
    }

    /**
     * Returns the height of the tree.
     *
     * @return The length of the longest path in the tree (height).
     */
    @Override
    public int height() {
        if (root == null) {
            return 0;
        } else {
            return height(root, 0);
        }
    }

    /**
     * Recursively calculates the length of the path to the smallest number in
     * the tree, stored in a leaf.
     *
     * @param currentNode Currently inspected node.
     * @param currentHeight The length of the path between the root and the
     * currentNode.
     * @return The height of the subtree with the current node as root.
     */
    private int height(BTreeNode currentNode, int currentHeight) {
        if (currentNode.isLeaf()) {
            return currentHeight + 1;
        } else {
            return height(currentNode.getMinNext(), currentHeight + 1);
        }
    }

    /**
     * Returns the largest value stored in the tree.
     *
     * @return Integer object with the largest value.
     */
    @Override
    public Comparable getMax() {
        if (root == null) {
            throw new GDIException("No maximum element in the B-Tree.");
        } else {
            return (Comparable) root.getMax();
        }
    }

    /**
     * Returns the smallest value stored in the tree.
     *
     * @return Integer object with the smallest value.
     */
    @Override
    public Comparable getMin() {
        if (root == null) {
            throw new GDIException("No minimum element in the B-Tree.");
        } else {
            return (Comparable) root.getMin();
        }
    }

    /**
     * Returns if the tree is empty (contains no elements).
     *
     * @return true if the tree is empty, false else.
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Prints the tree inorder to the console.
     */
    @Override
    public void printInorder() {
        println(toStringInorder(root));
    }

    /**
     * Recursively iterates over the elements of the tree and creates an
     * inordered string.
     *
     * @param node Current node to inspect.
     * @return A string with inordered subtree.
     */
    private String toStringInorder(BTreeNode node) { // Recursive
        if (node == null) {
            return new String();
        }
        if (node.isLeaf()) {
            return node.toString();
        } else {
            String string = new String();
            Object[] values = node.getValues();
            BTreeNode[] next = node.getNext();
            boolean hasEnded = false;
            int lastElement = 0;

            for (int i = 0; i < values.length && !hasEnded; i++) {
                if (values[i] == null) {
                    hasEnded = true;
                    lastElement = i;
                } else {
                    if (i != 0) {
                        string += ", ";
                    }
                    string += toStringInorder(next[i]);
                    string += ", ";
                    string += values[i];
                }
            }
            string += toStringInorder(next[lastElement]);

            return string;
        }
    }

    /**
     * Removes an element from this tree.
     *
     * @param o the element to be removed.
     */
    public void removeElement(Comparable o) {
        if (contains(o)) {
            ArrayStack stack = new ArrayStack(size() * 2);
            pushElementsToStack(root, stack);
            BTree bTree = new BTree(this.degree);
            while (!stack.isEmpty()) {
                Comparable temp = (Comparable) stack.pop();
                if (o != temp) {
                    bTree.insert(temp);
                }
            }
            this.root = bTree.root;
        }
    }

    /**
     * Recursively iterates over the elements of the tree and pushes these onto
     * a stack.
     *
     * @param node Current node to inspect.
     * @param array The abstract data type in which to be saved.
     */
    private void pushElementsToStack(BTreeNode node, ArrayStack stack) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            Object temp[] = node.getValues();
            for (int i = 0; i < temp.length; i++) {
                stack.push(temp[i]);
            }
        } else {
            Object temp[] = node.getValues();
            for (int i = 0; i < temp.length; i++) {
                stack.push(temp[i]);
            }
            for (int i = 0; i < temp.length - 1; i++) {
                // recursion step
                pushElementsToStack(node.getNext()[i], stack);
            }
        }
    }

    /**
     * Prints the tree postorder to the console.
     */
    @Override
    public void printPostorder() {
        println(toStringPostorder(root));
    }

    /**
     * Recursively iterates over the elements of the tree and creates a
     * postorder string.
     *
     * @param node Current node to inspect.
     * @return A sting with postorder subtree.
     */
    private String toStringPostorder(BTreeNode node) { // Recursive
        if (node == null) {
            return "";
        }
        if (node.isLeaf()) {
            return node.toString();
        } else {
            String string = "";
            // Next
            BTreeNode[] next = node.getNext();
            for (int i = 0; (i < next.length && next[i] != null); i++) {
                if (i > 0) {
                    string += ", ";
                }
                string += toStringPostorder(next[i]);
            }

            // Elements
            string += node.toString();

            return string;
        }
    }

    /**
     * Prints the tree preorder to the console.
     */
    @Override
    public void printPreorder() {
        println(toStringPreorder(root));
    }

    /**
     * Recursively iterates over the elements of the tree and creates a preorder
     * string.
     *
     * @param node Current node to inspect.
     * @return A sting with preorder subtree.
     */
    private String toStringPreorder(BTreeNode node) { // Recursive
        if (node == null) {
            return "";
        }
        if (node.isLeaf()) {
            return node.toString();
        } else {
            String string = "";
            // Elements
            string += node.toString();

            // Next
            BTreeNode[] next = node.getNext();
            for (int i = 0; (i < next.length && next[i] != null); i++) {
                if (i > 0) {
                    string += ", ";
                }
                string += toStringPreorder(next[i]);
            }

            return string;
        }
    }

    /**
     * Prints the tree in levelorder to the console.
     */
    @Override
    public void printLevelorder() {
        println(toStringLevelorder());
    }

    /**
     * Creates iteratively a sting with containing all nodes of the tree in
     * levelorder.
     *
     * @return A levelordered string of the tree.
     */
    private String toStringLevelorder() {
        String elements = "";
        // TODO eigene ADT Queue
        java.util.Queue<BTreeNode> queue = new java.util.LinkedList<BTreeNode>();
        //Queue queue = new MyQueue();
        queue.add(root);
        //queue.enter(root);
        while (!queue.isEmpty()) {
            BTreeNode node = queue.remove();
            //BTreeNode node = queue.leave();
            if (node != null) {
                elements += node + " ";
                BTreeNode[] next = node.getNext();
                for (BTreeNode currentNext : next) {
                    queue.add(currentNext);
                    //queue.enter(currentNext);
                }
            }
        }
        return elements;
    }

    /**
     * Creates a deep copy of the B-Tree.
     *
     * @return The deep copy of the tree.
     */
    @Override
    public BTree clone() {
        BTree clone = new BTree(degree);

        clone.root = root.cloneDeep();

        return clone;
    }

    /**
     * Returns a string with a levelordered representation of the B-Tree.
     */
    @Override
    public String toString() {
        return toStringLevelorder();
    }

    /**
     * Returns all values in the tree.
     *
     * @return All values in the tree as an array.
     */
    public Object[] values() {
        return root.getAll();
    }

    /**
     * Adds all values of the other Tree in the current Tree.
     *
     * @param otherTree A reference to the tree with the values to insert.
     */
    @Override
    public void addAll(BTree otherTree) {
        if (otherTree == null) {
            throw new GDIException("otherTree is null, adding impossible.");
        }
        Comparable[] otherValues = (Comparable[]) otherTree.values();

        for (Comparable o : otherValues) {
            insert(o);
        }
    }

    private String createNumberOfTabs(int nr) {
        String tabs = new String();
        for (int i = 0; i < nr; i++) {
            tabs += '\t';
        }
        return tabs;
    }

    private int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            throw new GDIException("Method isn't set up for negative exponents.");
        } else {
            return (base * pow(base, exponent - 1));
        }
    }

    private static String trim(String stringToRemoveLastSpaceCharacters) {
        String newString = stringToRemoveLastSpaceCharacters;
        for (int i = 1; (int) stringToRemoveLastSpaceCharacters.charAt(stringToRemoveLastSpaceCharacters.length() - i) == SPACECHARACTER; i++) {
            newString = "";
            for (int j = 0; j < stringToRemoveLastSpaceCharacters.length() - i; j++) {
                newString += stringToRemoveLastSpaceCharacters.charAt(j);
            }
        }
        return newString;
    }

    /**
     * Sketches the outline of the tree on the console in a graphical way to
     * increase clarity.
     */
    public void sketchElementsOnConsole() {
        String levelorderElements = toStringLevelorder();

        int maxAssignments = 2 * degree + 1;
        int currentAmount = 1;
        int currentAssignment = 0;

        levelorderElements = trim(levelorderElements);

        for (int i = 0; i < levelorderElements.length(); i++) {
            if ((int) levelorderElements.charAt(i) == SPACECHARACTER && (int) levelorderElements.charAt(i + 1) == SPACECHARACTER) {
                i++;
                currentAssignment++;
                if (currentAmount == 1) {
                    currentAmount++;
                }
                if (currentAssignment - 1 == pow(maxAssignments, currentAmount - 1)) {
                    currentAmount++;
                    currentAssignment = 1;
                }
            }
        }
        int maxAmount = currentAmount;

        println(levelorderElements);
        currentAssignment = 0;
        currentAmount = 1;
        final int maxfields = 2 * pow(2 * degree + 1, maxAmount - 1) - 1;
        int maxBlocks = pow(2 * degree + 1, currentAmount - 1);
        int freeFields = maxfields - maxBlocks;
        final int center = freeFields / 2;

        int innerDistance = (freeFields + 1) / maxBlocks;
        int border = (innerDistance - 1) / 2;

        //Printing the elements.
        for (int i = 0; i < levelorderElements.length(); i++) {
            if (currentAmount == 1 && i == 0) {
                println("Amount" + createNumberOfTabs(center) + "Elements");
                print(currentAmount + createNumberOfTabs(center) + "\t");
            }
            if ((int) levelorderElements.charAt(i) == SPACECHARACTER && (int) levelorderElements.charAt(i + 1) == SPACECHARACTER) {
                currentAssignment++;
                //Switch from Root to first assignments.
                if (currentAmount == 1) {
                    currentAmount++;
                    print("\n" + currentAmount + "\t");
                    //Define variables new for second amount
                    maxBlocks = pow(2 * degree + 1, currentAmount - 1);
                    freeFields = maxfields - maxBlocks;
                    innerDistance = (freeFields + 1) / maxBlocks;
                    border = (innerDistance - 1) / 2;
                    //
                    print(createNumberOfTabs(border));
                }
                //actualAmount - 1 cause we need in, for example amount 2, the maxAssignments in amount 1.
                //actualAssignment - 1 to slides the next amount to after the last elements of the actual amount.
                if (currentAssignment - 1 == pow(maxAssignments, currentAmount - 1)) {
                    currentAmount++;
                    currentAssignment = 1;
                    //Define variables new for next amount
                    maxBlocks = pow(2 * degree + 1, currentAmount - 1);
                    freeFields = maxfields - maxBlocks;
                    innerDistance = (freeFields + 1) / maxBlocks;
                    border = (innerDistance - 1) / 2;
                    //
                    print("\n" + currentAmount + "\t");
                    print(createNumberOfTabs(border));
                } else {
                    print(createNumberOfTabs(innerDistance));
                }
            } else if ((int) levelorderElements.charAt(i) != SPACECHARACTER) {
                print(levelorderElements.charAt(i));
            } else {
                print(" ");
            }
        }
    }
}
