package com.datastructure.tree;


public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder();
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1, "A");
        Node node2 = new Node(2, "B");
        Node node3 = new Node(3, "C");
        Node node4 = new Node(4, "D");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        binaryTree.root = root;

        System.out.println("前序遍历");
        binaryTree.preOrder(); // A, B, C, D

        System.out.println("中序遍历");
        binaryTree.midOrder(); // B, A, C, D

        System.out.println("后序遍历");
        binaryTree.postOrder(); // B, D, C, A
    }
}


class Node {
    private int no;
    private String text;
    private Node left;
    private Node right;

    public Node(int no, String text) {
        this.no = no;
        this.text = text;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", text='" + text + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }
}