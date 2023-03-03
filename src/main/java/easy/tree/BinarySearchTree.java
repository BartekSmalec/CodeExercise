package easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }

        Node temp = root;
        while (temp != null) {
            if (temp.getValue() == value) return true;
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            } else if (value > temp.getValue()) {
                temp = temp.getRight();
            }
        }
        return false;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) return false;
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                }
                temp = temp.getLeft();
            } else if (newNode.getValue() > temp.getValue()) {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                }
                temp = temp.getRight();
            }

        }
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        traverse(root, results);

        return results;
    }

    public void traverse(Node currentNode, ArrayList<Integer> results) {
        results.add(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            traverse(currentNode.getLeft(), results);
        }
        if (currentNode.getRight() != null) {
            traverse(currentNode.getRight(), results);
        }
    }

    private Integer getNumberOfNodes(Node node) {
        if (node == null) return 0;
        return 1 + getNumberOfNodes(node.getLeft()) + getNumberOfNodes(node.getRight());
    }

    public Integer getNumberOfNodes() {
        return getNumberOfNodes(this.root);
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
