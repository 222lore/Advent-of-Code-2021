import java.io.*;
import java.util.*;

public class DayTwo {
    static int ford = 0, depth = 0, aim = 0;

    public static void main(String[] args) {
        try { 
            File file = new File("DayTwo.txt");
            Scanner txt = new Scanner(file);
            ArrayList<String> movements = new ArrayList<>();

            while (txt.hasNextLine()) {
                movements.add(txt.nextLine());
            }

            handler(movements);
            System.out.println(ford * depth);

            txt.close();
        }
        catch (Exception e) { System.out.println("fail"); }
    }

    // Remove the stuff with aim for part 1 and undo the comments
    private static void handler(ArrayList<String> movements) {
        for (int i = 0; i < movements.size(); i++) {
            String line = movements.get(i);
            if (line.charAt(0) == 'f') {
                ford += Integer.parseInt(line.substring(8));
                depth += aim * Integer.parseInt(line.substring(8));
            }
            else if (line.charAt(0) == 'd') {
                //depth += Integer.parseInt(line.substring(5));
                aim += Integer.parseInt(line.substring(5));
            }
            else if (line.charAt(0) == 'u') {
                //depth -= Integer.parseInt(line.substring(3));
                aim -= Integer.parseInt(line.substring(3));
            }
        }
    }
}