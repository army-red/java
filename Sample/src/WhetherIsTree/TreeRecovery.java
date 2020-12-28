import java.io.*;
import java.util.*;

// DBACEGF ABCDEFG
// BCAD CBAD

public class TreeRecovery {

    static String preOrder = null;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String[] words = null;
        while (true) {
            try {
                System.out.println("Input preorder and inorder traversal: ");
                String words = br.readLine();
                // word[0] = preorder word[1] = inorder
                String word[] = words.split(" ");
                // System.out.println(word[0] + " # " + word[1]);
                preOrder = word[0];

                SeparateInorder(word[1]);
                System.out.println();
                System.out.println("=--------------------=");
            } catch (Exception e) {
                System.out.println("error: " + e);
                break;
            }
        }
        System.out.println("exit~");
    }

    public static void SeparateInorder(String str) {

        if (str.length() == 1) {
            String node = preOrder.substring(0, 1);
            preOrder = preOrder.substring(1);

            //System.out.println("node： " + node + " get in: " + str + " preOrder is: " + preOrder);

            //System.out.println("=-------------------=");
            //System.out.println("from 01: " + str);
            System.out.print(str);
            //System.out.println("=-------------------=");
            return;
        } else if (str.equals(null) || str.equals("")) {
            //System.out.println("get null");
            return;
        } else {
            String node = preOrder.substring(0, 1);
            preOrder = preOrder.substring(1);

            //System.out.println("node： " + node + " get in: " + str + " preOrder is: " + preOrder);
            
            String word[] = str.split(node);
            // System.out.println("word[0] " + word[0]);
            // try {
            //     System.out.println("word[1] " + word[1]);
            // } catch (Exception e) {
                
            //     System.out.println("word[1] not exit :" + e);
            // }
            
            if(word.length == 2){
                SeparateInorder(word[0]);

                SeparateInorder(word[1]);
            }else{
                SeparateInorder(word[0]);
            }
            // System.out.println("=-------------------=");
            // System.out.println("from else: " + node);
            System.out.print(node);
            //System.out.println("=-------------------=");
            return;
        }

    }
}
