package com.github.junyu.solution.leetCode.easy.tree;

import com.github.junyu.solution.leetCode.easy.tree.entity.TreeNode;

public class _606_Construct_String_from_Binary_Tree {



/*    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

    The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the
    empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

    Example 1:
    Input: Binary tree: [1,2,3,4]
            1
            /   \
            2     3
            /
            4

    Output: "1(2(4))(3)"

    Explanation: Originallay it needs to be "1(2(4)())(3()())",
    but you need to omit all the unnecessary empty parenthesis pairs.
    And it will be "1(2(4))(3)".
    Example 2:
    Input: Binary tree: [1,2,3,null,4]
            1
            /   \
            2     3
            \
            4

    Output: "1(2()(4))(3)"

    Explanation: Almost the same as the first example,
    except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.*/

    private StringBuilder sb = new StringBuilder();

    /**
     * 将二叉树构建成字符串，只有在左孩子是空，右孩子不为空，那么“（）”不能省略。
     * 我这里分了三部进行构建，第一步是添加root，添加完以后，需要特殊处理root左孩子为空而右孩子不为空的情况，
     * 剩下就是分别对root的左孩子和右孩子进行字符串的追加。
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null)
            return sb.toString();
        sb.append(t.val);
        if (t.left == null && t.right != null)
            sb.append("()");
        generateStr(t.left);
        generateStr(t.right);

        return sb.toString();
    }

    private void generateStr(TreeNode t) {
        if (t == null)
            return;

        sb.append("(" + t.val);
        if (t.left == null && t.right != null)
            sb.append("()");
        generateStr(t.left);
        generateStr(t.right);

        sb.append(")");

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;

        _606_Construct_String_from_Binary_Tree construct_string_from_binary_tree = new _606_Construct_String_from_Binary_Tree();
        System.out.println(construct_string_from_binary_tree.tree2str(treeNode));
    }

}
