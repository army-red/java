import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class minRoute {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int loop = Integer.parseInt(s.nextLine());
        Map<String, node> map = new HashMap<String, node>();
        Map<String, node> inputMap = new HashMap<String, node>();

        List<nodeLink> list = new ArrayList<nodeLink>();
        for (int i = 0; i < loop; i++) {
            int point = Integer.parseInt(s.nextLine());
            int read = Integer.parseInt(s.nextLine());
            for (int j = 0; j < read; j++) {
                try {
                    String input = s.nextLine();
                    String address[] = input.split(" ");
                    node n1 = new node(address[0]);
                    map.put(address[0], n1);
                    node n2 = new node(address[1]);
                    map.put(address[1], n2);
                    nodeLink nl = new nodeLink(n1, n2, Integer.parseInt(address[2]));
                    list.add(nl);

                } catch (Exception e) {
                    System.out.println("error: " + e);
                }

            }
            //System.out.println(list.toString());

            int total = 0;
            while (inputMap.size() != map.size()) {
                // find min nodelink

                //System.out.println(map.size());
                //System.out.println(inputMap.size());

                nodeLink minNodeLink = list.get(0);
                int minPos = 0;
                for (int j = 0; j < list.size(); j++) {

                    if (list.get(j).length < minNodeLink.length) {
                        // System.out.println("in if");
                        minNodeLink = list.get(j);
                        minPos = j;
                    }
                    // System.out.println("count " + j);

                }
                // System.out.println(minNodeLink.n1.name + " " + minNodeLink.n2.name + " " +
                // minNodeLink.length);
                inputMap.put(minNodeLink.n1.name, minNodeLink.n1);
                inputMap.put(minNodeLink.n2.name, minNodeLink.n2);
                total += list.get(minPos).length;
                list.remove(minPos);

                //System.out.println(list.toString());
            }
            System.out.println(total);
        }

    }
}

class node {
    String name;

    public node(String name) {
        this.name = name;
    }

}

class nodeLink {
    node n1 = null;
    node n2 = null;
    int length;

    public nodeLink(node n1, node n2, int length) {
        this.n1 = n1;
        this.n2 = n2;
        this.length = length;
    }

    public nodeLink(int length) {

        this.length = length;
    }

}
