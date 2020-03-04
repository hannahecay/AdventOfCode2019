import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day3-input.txt"));
        String line1 = lines.get(0);
        String line2 = lines.get(1);
        String[] w1 = line1.split(",");
        String[] w2 = line2.split(",");
        Map<Integer, ArrayList<Integer>> co = new HashMap<Integer, ArrayList<Integer>>();
        int z = 0;
        int x = 0;
        int y = 0;
        int minDis = Integer.MAX_VALUE;
        for (String w : w1) {
            z = Integer.parseInt(w.substring(1));
            if (w.charAt(0) == 'U') {
                if (co.containsKey(x)) {
                    for (int i = 1; i < z + 1; i++)
                        if (!co.get(x).contains(y + i))
                            co.get(x).add(y + i);
                } else {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    for (int i = 1; i < z + 1; i++)
                        arr.add(y + i);
                    co.put(x, arr);
                }
                y += z;
            }
            if (w.charAt(0) == 'D') {
                if (co.containsKey(x)) {
                    for (int i = -1; i > -z - 1; i--)
                        if (!co.get(x).contains(y + i))
                            co.get(x).add(y + i);
                } else {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    for (int i = -1; i > -z - 1; i--)
                        arr.add(y + i);
                    co.put(x, arr);
                }
                y -= z;
            }
            if (w.charAt(0) == 'R') {
                for (int i = 1; i < z + 1; i++) {
                    if (co.containsKey(x + i)) {
                        if (!co.get(x + i).contains(y))
                            co.get(x + i).add(y);
                    } else {
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(y);
                        co.put(x + i, arr);
                    }
                }
                x += z;
            }
            if (w.charAt(0) == 'L') {
                for (int i = -1; i > -z - 1; i--) {
                    if (co.containsKey(x + i)) {
                        if (!co.get(x + i).contains(y))
                            co.get(x + i).add(y);
                    } else {
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(y);
                        co.put(x + i, arr);
                    }
                }
                x -= z;
            }
        }
        x = 0;
        y = 0;
        for (String w : w2) {
            z = Integer.parseInt(w.substring(1));
            if (w.charAt(0) == 'U') {
                for (int i = 1; i < z + 1; i++)
                    if (co.containsKey(x) && co.get(x).contains(y + i) && Math.abs(x) + Math.abs(y + i) < minDis)
                        minDis = Math.abs(x) + Math.abs(y + i);
                y += z;
            }
            if (w.charAt(0) == 'D') {
                for (int i = -1; i > -z - 1; i--)
                    if (co.containsKey(x) && co.get(x).contains(y + i) && Math.abs(x) + Math.abs(y + i) < minDis)
                        minDis = Math.abs(x) + Math.abs(y + i);
                y -= z;
            }
            if (w.charAt(0) == 'R') {
                for (int i = 1; i < z + 1; i++)
                    if (co.containsKey(x + i) && co.get(x + i).contains(y) && Math.abs(x + i) + Math.abs(y) < minDis)
                        minDis = Math.abs(x + i) + Math.abs(y);
                x += z;
            }
            if (w.charAt(0) == 'L') {
                for (int i = -1; i > -z - 1; i--)
                    if (co.containsKey(x + i) && co.get(x + i).contains(y) && Math.abs(x + i) + Math.abs(y) < minDis)
                        minDis = Math.abs(x + i) + Math.abs(y);
                x -= z;
            }
        }
        System.out.println(minDis);
    }
}
