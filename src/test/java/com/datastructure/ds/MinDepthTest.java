package com.datastructure.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinDepthTest {

    @Test
    void minDepth() {

        /**
         *
         *          0
         *     1         2
         *   3   4         6
         * 7                 10
         */

        TreeNode root = new TreeNode(0);


        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(4);

        node1.left.left = new TreeNode(7);


        TreeNode node2 = new TreeNode(2);
        node2.right = new TreeNode(6);
        node2.right.right = new TreeNode(10);

        root.left = node1;
        root.right = node2;


        MinDepth minDepth = new MinDepth();
        int depth = minDepth.minDepth(root);
        assertEquals(3, depth);
    }

}