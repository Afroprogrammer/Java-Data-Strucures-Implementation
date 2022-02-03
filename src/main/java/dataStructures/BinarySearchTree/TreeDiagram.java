package dataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//special thanks to Techie share for providing this algorithm for printing the tree in the console
//follow his YouTube channel https://www.youtube.com/channel/UCYzuLXpeHnBHgpac4-QCEyw
public class TreeDiagram {
    Node root;

    int i = 0;

    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);

        }
    }

    private Object[] getLevelOrder(Node root, int h) {
        int i;
        List<Integer> arr = new ArrayList<>();
        for (i = 1; i <= h; i++)
            getDataByLevel(root, i, arr);
        return arr.toArray();
    }

    private void getDataByLevel(Node root, int level, List<Integer> arr) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            arr.add(root.data);
        } else if (level > 1) {
            getDataByLevel(root.left, level - 1, arr);
            getDataByLevel(root.right, level - 1, arr);
        }

    }

    private void makeDrawTree(Node node) {
        int level = height(node);
        Object arr[] = getLevelOrder(node, level);
        makeDrawTree(level);
        for (int i = 0; i < arr.length; i++) {
            add((int) arr[i]);
        }
    }


    private void makeDrawTree(int height) {
        if (height != 0) {
            root = createNode(root);
            makeDrawTree(height - 1);
        }
    }

    private Node createNode(Node n) {
        if (n == null) {
            return new Node(-1);
        }
        n.left = createNode(n.left);
        n.right = createNode(n.right);
        return n;
    }

    public void add(int data) {
        root = add(root, data);
    }

    private Node add(Node root, int data) {
        if (root.data == -1) {
            root.data = data;
            return root;
        } else if (root.data > data) {
            root.left = add(root.left, data);
        } else if (root.data < data) {
            root.right = add(root.right, data);
        }
        return root;
    }

    public void print(Node bnode) {
        i = 0;
        this.root = null;
        makeDrawTree(bnode);
        int level = height(this.root);
        Object arr[] = getLevelOrder(root, level);
        List<StringBuffer> ls = new LinkedList<>();
        for (int i = 0; i < level; i++) {
            StringBuffer b = new StringBuffer();
            ls.add(b);
        }
        List<StringBuffer> node = new LinkedList<>();
        for (int i = 0; i < level; i++) {
            StringBuffer b = new StringBuffer();
            node.add(b);
        }
        StringBuffer buf2 = null;
        int nIdx = 0;
        int i = ls.size() - 1;
        for (StringBuffer buf : ls) {
            int children = (int) Math.pow(2, i);
            int pos = (int) Math.pow(2, i + 1) - 1;

            if (i == ls.size() - 1) {
                for (int j = children - 1; j <= pos - 1; j++) {
                    buf.append(" ");
                    buf.append(String.valueOf(arr[j]));
                    buf.append("  ");
                }
                buf.deleteCharAt(0);
                buf.delete(buf.length() - 2, buf.length());
                buf2 = buf;
            } else {
                StringBuffer nBuf = node.get(nIdx++);
                for (int j = 0; j < buf2.length(); j++) {
                    buf.append(" ");
                    nBuf.append("  ");
                }
                int start = 0;
                for (int j = children - 1; j <= pos - 1; j++) {
                    int LIdx = buf2.indexOf(String.valueOf(arr[(2 * j) + 1]), start);
                    int RIdx = buf2.indexOf(String.valueOf(arr[(2 * j) + 2]), LIdx + 2);
                    start = RIdx + 2;
                    int mid = (RIdx - LIdx) / 2;
                    String data = String.valueOf(arr[j]);
                    if ((int) arr[(2 * j) + 1] != -1)
                        nBuf.replace(LIdx + 1, LIdx + 2, "/");
                    if ((int) arr[(2 * j) + 2] != -1)
                        nBuf.replace(RIdx - 1, RIdx, "\\");
                    buf.replace(LIdx + mid, LIdx + mid + data.length(), data);
                }
                buf2 = buf;
            }
            i--;
        }

        for (StringBuffer buf : ls) {
            int rIdx = buf.lastIndexOf("-1");
            while (rIdx != -1) {
                buf.replace(rIdx, rIdx + 2, "  ");
                rIdx = buf.lastIndexOf("-1");
            }
        }

        Collections.reverse(ls);
        int k = level - 1;
        for (int j = 0; j < level; j++) {
            ls.add(k--, node.get(j));
        }
        System.out.println("Diagram:");
        for (StringBuffer buf : ls) {
            System.out.println(buf.toString());
        }
        System.out.println();
    }
}
