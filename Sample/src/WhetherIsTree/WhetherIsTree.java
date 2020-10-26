import java.io.*;
import java.util.*;

public class WhetherIsTree {

    static Map<String, TreeNode> map = new HashMap<String, TreeNode>();

    public static void main(String[] args) throws Exception {

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input nums: ");
            String input = br.readLine();
            String nums_String[] = input.split(" ");
            Boolean flag = true;
            map.clear();

            if (nums_String[nums_String.length - 1].equals("-1" ) && nums_String[nums_String.length - 2].equals("-1" )) {
                break;
            }
            //System.out.println("end with : " + nums_String[nums_String.length - 1] + " " + nums_String[nums_String.length - 2]);

            for (int i = 0; i < nums_String.length; i += 2) {
                //System.out.println(nums_String[i] + " " + nums_String[i + 1]);
                if (nums_String[i] == "0" && nums_String[i + 1] == "0") {
                    break;
                } else {
                    //System.out.println("me is exit? " + map.containsKey(nums_String[i + 1]));
                    if (!map.containsKey(nums_String[i + 1])) { // me not exist
                        
                        TreeNode node = new TreeNode(nums_String[i + 1]);// new me
                        map.put(nums_String[i + 1], node);
                        //System.out.println("parent is exit? " + map.containsKey(nums_String[i]));

                        //TreeNode temp = map.get(nums_String[i]);
                        if (map.containsKey(nums_String[i])) { // parent exist
                            node.setParentNode(map.get(nums_String[i]));
                        } else { // parent not exist
                            TreeNode parentNode = new TreeNode(nums_String[i]);
                            node.setParentNode(parentNode);
                            map.put(nums_String[i], parentNode);
                        }

                        map.put(nums_String[i + 1], node);
                    } else { // me exist
                        //System.out.println("parent is exit? " + map.containsKey(nums_String[i]));

                        //TreeNode temp = map.get(nums_String[i]);
                        //System.out.println("temp is : " + map.get(nums_String[i + 1]));
                        if (map.get(nums_String[i + 1]).hasParent()) { // parent exist

                            flag = false;
                            break;
                        } else { // parent not exist
                            TreeNode parentNode = new TreeNode(nums_String[i]);
                            map.get(nums_String[i + 1]).setParentNode(parentNode);
                            map.put(nums_String[i], parentNode);

                        }
                    }

                }
            }
            if (!flag) {
                System.out.println("It's not a Tree!!");
            } else {
                System.out.println("It's a Tree~");
            }

        }
        System.out.println("finish");
    }
}

class TreeNode {
    String NodeName = null;
    TreeNode parentNode = null;

    public TreeNode(String nodeName, TreeNode parentNode) {
        NodeName = nodeName;
        this.parentNode = parentNode;
    }

    public TreeNode(String nodeName) {
        NodeName = nodeName;
    }
    public TreeNode() {
        
    }

    public String getNodeName() {
        try {
            return NodeName;
        } catch (Exception e) {
            System.out.println("null at getNodeName");
            return null;
        }
    }

    public void setNodeName(String nodeName) {
        NodeName = nodeName;
    }

    public TreeNode getParentNode() {
        try {
            return parentNode;
        } catch (Exception e) {
            System.out.println("null at getPNode");
            return null;
        }
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }


	public boolean hasParent() {
		try {

            if (this.parentNode == null){
                return false;
            }else if (this.parentNode.equals(null)){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            System.out.println("md bug:" + e);
            return false;
        }
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (parentNode == null) {
			if (other.parentNode != null)
				return false;
		} else if (!parentNode.equals(other.parentNode))
			return false;
		return true;
	}
    
}