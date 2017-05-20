package org.david.datastructure;

import com.google.gag.annotation.disclaimer.HandsOff;
import com.google.gag.enumeration.Consequence;

/**
 * This is my implementation of an self-balancing binary tree
 * https://en.wikipedia.org/wiki/Red-black_tree
 * Created by David Marques on 20/05/2017.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private enum NodeColor {
        RED,
        BLACK;

        public static boolean isBlack(NodeColor color) {
            return color != null && color == BLACK;
        }

        public static boolean isRed(NodeColor color) {
            return color != null && color == RED;
        }

        public static NodeColor opposite(NodeColor color) {
            if (color == RED)
                return BLACK;
            return RED;
        }
    }

    private enum NodeRotation {
        RIGHT,
        LEFT;
    }

    private class Node {

        private Value val;
        private Key key;
        private Node left;
        private Node right;
        private NodeColor color;
        private int size;

        public Node(Key key, Value val, NodeColor color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }

    }

    private Node root;

    public RedBlackBST() {
    }

    public int size() {
        return size(root);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) throws IllegalArgumentException {
        if (key == null)
            throw new IllegalArgumentException("Invalid key");
        Node x = root;
        while (x != null) {
            int compareTo = key.compareTo(x.key);
            if (compareTo < 0) {
                x = x.left;
            } else if (compareTo > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) throws IllegalArgumentException {
        if (key == null)
            throw new IllegalArgumentException("Invalid key");
        root = put(root, key, val);
        root.color = NodeColor.BLACK;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("Invalid key");
        if (root == null)
            return;
        if (isBlack(root.left) && isBlack(root.right))
            root.color = NodeColor.RED;
        root = doDeleteNode(root, key);
        if (root != null)
            root.color = NodeColor.BLACK;
    }

    private Node doDeleteNode(Node root, Key key) {
        //TODO
        return null;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }

    @HandsOff(byOrderOf = "Mr. Nobody", onPainOf = Consequence.SILENT_TREATMENT)
    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val, NodeColor.RED, 1);

        int compResult = key.compareTo(node.key);

        if (compResult < 0) { // go left
            node.left = put(node.left, key, val);
        } else if (compResult > 0) { // go right
            node.right = put(node.right, key, val);
        } else { // found it
            node.val = val;
        }

        doNodeBalancing(node);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    // to preserve the Tree invariant
    private void doNodeBalancing(Node node) {
        if (isRed(node.right) && isBlack(node.left)) {
            node = doRotate(node, NodeRotation.LEFT);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = doRotate(node, NodeRotation.RIGHT);
        }
        if (isRed(node.right) && isRed(node.left)) {
            node = doSwapColors(node);
        }
        node.size = size(node.left) + size(node.right) + 1;

    }

    private boolean isRed(Node n) {
        return n != null && NodeColor.isRed(n.color);
    }

    private boolean isBlack(Node n) {
        return n != null && NodeColor.isBlack(n.color);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    private Node doSwapColors(Node node) {
        node.color = NodeColor.opposite(node.color);
        node.right.color = NodeColor.opposite(node.right.color);
        node.left.color = NodeColor.opposite(node.left.color);
        return node;
    }

    private Node doRotate(Node node, NodeRotation dirc) {

        Node rotNode;
        if (dirc == NodeRotation.LEFT) {
            rotNode = node.right;
            node.right = rotNode.left;
            rotNode.left = node;
            rotNode.color = rotNode.left.color;
            rotNode.left.color = NodeColor.RED;
        } else {
            rotNode = node.left;
            node.left = rotNode.right;
            rotNode.right = node;
            rotNode.color = rotNode.right.color;
            rotNode.right.color = NodeColor.RED;
        }
        rotNode.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        return rotNode;
    }


}
