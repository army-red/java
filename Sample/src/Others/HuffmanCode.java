import java.io.*;
import java.util.*;
import java.util.regex.*;

public class HuffmanCode {
    public static void main(String[] args) throws IOException {

        Map<String, String> map = TreeConstruct();

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Input the message: ");
            String input = br.readLine();

            if (Pattern.matches("^[a-z]+$", input)) {
                System.out.println("get answer: ");
                System.out.println(coding(input, map));
            } else if (Pattern.matches("^[0-1]+$", input)) {
                System.out.println("get answer: ");
                System.out.println(decode(input, map));
            } else {
                System.out.println("Input error! Please input correct sample.");
                break;
            }
        }
    }

    private static Map<String, String> TreeConstruct() {

        Map<String, String> map = new HashMap<>();
        List<HuffmanNode> unlinked = new ArrayList<>();
        HuffmanNode i = new HuffmanNode(9, "i");
        unlinked.add(i);
        HuffmanNode c = new HuffmanNode(4, "c");
        unlinked.add(c);
        HuffmanNode n = new HuffmanNode(3, "n");
        unlinked.add(n);
        HuffmanNode l = new HuffmanNode(3, "l");
        unlinked.add(l);
        HuffmanNode f = new HuffmanNode(2, "f");
        unlinked.add(f);
        HuffmanNode o = new HuffmanNode(2, "o");
        unlinked.add(o);
        HuffmanNode a = new HuffmanNode(2, "a");
        unlinked.add(a);
        HuffmanNode u = new HuffmanNode(1, "u");
        unlinked.add(u);
        HuffmanNode h = new HuffmanNode(1, "h");
        unlinked.add(h);
        HuffmanNode p = new HuffmanNode(1, "p");
        unlinked.add(p);
        HuffmanNode t = new HuffmanNode(1, "t");
        unlinked.add(t);

        while (unlinked.size() != 1) {

            // 排序
            Collections.sort(unlinked, new Comparator<HuffmanNode>() {

                @Override
                public int compare(HuffmanNode o1, HuffmanNode o2) {
                    // 升序
                    return o1.getValue() - o2.getValue();
                    // 降序
                    // return o2.getAge()-o1.getAge();
                }
            });
            // System.out.println("=======================================");
            // for (HuffmanNode huff : unlinked) {
            // System.out.println(huff.getValue() + " " + huff.getRepre());
            // }
            HuffmanNode n1 = unlinked.get(0);
            HuffmanNode n2 = unlinked.get(1);

            // System.out.println("n1: " + n1.getRepre() + " " + n1.getValue() + " n2: " +
            // n2.getRepre() + " " + n2.getValue());
            HuffmanNode node = new HuffmanNode(n1, n2, n1.getValue() + n2.getValue());
            n1.setParent(node);
            n2.setParent(node);

            unlinked.remove(0);
            unlinked.remove(0);
            unlinked.add(node);

        }
        // System.out.println("final: " + unlinked.get(0).getValue());
        HuffmanNode root = unlinked.get(0);
        preOrderTraveral(root, map, "0");
        System.out.println("======  Get Code  ======");
        for (String s : map.keySet()) {
            System.out.println("Key: " + s + " Value: " + map.get(s));
        }
        System.out.println("========================");
        return map;
    }

    /**
     * 二叉树前序遍历 根-> 左-> 右
     * 
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(HuffmanNode node, Map<String, String> map, String s) {
        if (node == null) {
            return;
        }
        if (node.getRepre() != null) {
            map.put(node.getRepre(), s.substring(1));
        }
        // System.out.println(node.getRepre()+" ");
        preOrderTraveral(node.leftChild, map, s + "0");
        preOrderTraveral(node.rightChild, map, s + "1");
    }

    private static String coding(String input, Map<String, String> map) {
        String out = "";

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                if (map.containsKey(input.substring(i, j + 1))) {
                    // System.out.println(input.substring(i , j + 1));
                    out += map.get(input.substring(i, j + 1));
                    i = j;
                    break;
                }
            }

        }
        return out;
    }

    private static String decode(String input, Map<String, String> map) {
        String out = "";
        Map<String, String> reverse = new HashMap<>();
        for (String s : map.keySet()) {
            reverse.put(map.get(s), s);
        }

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                if (reverse.containsKey(input.substring(i, j + 1))) {
                    // System.out.println(input.substring(i , j + 1));
                    out += reverse.get(input.substring(i, j + 1));
                    i = j;
                    break;
                }
            }

        }
        return out;
    }
}

class HuffmanNode {

    int value;
    String repre;

    HuffmanNode parent;
    HuffmanNode leftChild;
    HuffmanNode rightChild;

    public HuffmanNode(HuffmanNode leftChild, HuffmanNode rightChild, int value) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }

    public HuffmanNode(int value, String repre) {
        this.value = value;
        this.repre = repre;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRepre() {
        return repre;
    }

    public void setRepre(String repre) {
        this.repre = repre;
    }

    public HuffmanNode getParent() {
        return parent;
    }

    public void setParent(HuffmanNode parent) {
        this.parent = parent;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

}