package com.datastructure.tree;

public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    private void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }

        System.out.print(arr[index] + " ");

        int nextLeftIndex = 2 * index + 1;
        if (nextLeftIndex < arr.length) {
            preOrder(nextLeftIndex);
        }

        int nextRightIndex = 2 * index + 2;
        if (nextRightIndex < arr.length) {
            preOrder(nextRightIndex);
        }
    }

    public void midOrder() {
        midOrder(0);
    }

    private void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int nextLeftIndex = 2 * index + 1;
        if (nextLeftIndex < arr.length) {
            midOrder(nextLeftIndex);
        }

        System.out.print(arr[index] + " ");

        int nextRightIndex = 2 * index + 2;
        if (nextRightIndex < arr.length) {
            midOrder(nextRightIndex);
        }
    }

    public void postOrder() {
        postOrder(0);
    }

    private void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int nextLeftIndex = 2 * index + 1;
        if (nextLeftIndex < arr.length) {
            postOrder(nextLeftIndex);
        }

        int nextRightIndex = 2 * index + 2;
        if (nextRightIndex < arr.length) {
            postOrder(nextRightIndex);
        }

        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        arrBinaryTree.preOrder(); // 1, 2, 4, 5, 3, 6, 7
        System.out.println();
        arrBinaryTree.midOrder(); // 4, 2, 5, 1, 6, 3, 7
        System.out.println();
        arrBinaryTree.postOrder(); // 4, 5, 2, 6, 7, 3, 1
    }
}
