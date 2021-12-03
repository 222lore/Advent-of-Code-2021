import java.io.*;
import java.util.*;

public class DayOne {

    public static void main(String[] args) {
        try {
            File file = new File("DayOne.txt");
            Scanner txt = new Scanner(file);
            ArrayList<Integer> arr = new ArrayList<>(), window = new ArrayList<>();
            
            /* PART 1
            while (txt.hasNextLine()) {
                arr.add(Integer.parseInt(txt.nextLine()));
            }
            System.out.println(increasingNums(arr));
            */

            // PART 2
            for (int i = 0; txt.hasNextLine(); i++) {
                arr.add(Integer.parseInt(txt.nextLine()));
                if (i > 1) window.add(arr.get(i) + arr.get(i-1) + arr.get(i-2)); 
            }
            System.out.println(increasingNums(window));
          
            txt.close();
        } 
        catch (Exception e) { System.out.println("fail"); }
    }

    private static int increasingNums(ArrayList<Integer> nums) {
        int count = 0, before = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > before) count++;
            before = nums.get(i);
        }

        return count;
    }
}