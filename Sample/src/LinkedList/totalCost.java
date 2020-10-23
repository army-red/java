import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.lang.reflect.Array;

public class totalCost {

    public static void main(String[] args) throws Exception {

        String input;
        String[] nums_String;
        int[] nums, temp;
        int num = 0, s_length = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Queue<Integer> que = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<Integer>();

        while (true) {

            s_length = 0;
            System.out.println("input number counts: ");
            num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            System.out.println("input numbers: ");
            
            input = br.readLine();
            System.out.println("input success");
            //nums_String = null;
            nums_String = input.split(" ");

            nums = new int[nums_String.length];
            
            for (int j = 0; j < nums_String.length; j++) {
                nums[j] = Integer.parseInt(nums_String[j]);
            }

            Arrays.sort(nums);
            // System.out.println("--------------------------");
            // for (int j = 0; j < nums.length; j++) {
            //     System.out.println(nums[j]);
            // }
            // System.out.println("--------------------------");

            for (int j = nums.length - 1 ;j >= 0; j--) {
                s.add(nums[j]);
                s_length++;
            }

            int count = 0;
            temp = new int[nums.length - 1];
            while (s_length != 1) {
                temp[count] = s.pop() + s.pop();
                //System.out.println("temp: " + temp);
                s.add(temp[count]);
                s_length--;
                count++;
            }
            int sumCount = 0;
            for(int i = 0;i< count;i++){
                sumCount += temp[i];
            }
            System.out.println("output: " + sumCount);

            
        
        }

    }
}
