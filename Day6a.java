import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6a {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day6-input.txt"));
        HashMap<String, ArrayList<String>> map1 = new HashMap<>();
        HashMap<Integer, ArrayList<String>> map2 = new HashMap<>();
        int f;
        int count = 0;
        for (String line : lines) {
            String[] orbits = line.split("\\)");
            if (!map1.containsKey(orbits[0])) {
                ArrayList<String> d = new ArrayList<>();
                d.add(orbits[1]);
                map1.put(orbits[0], d);
            } else map1.get(orbits[0]).add(orbits[1]);
        }
        map2.put(1, map1.get("COM"));
        for (int i = 1; i > 0; i++) {
            f = 0;
            for (String planet : map2.get(i)) {
                if (map1.containsKey(planet)) {
                    if (map2.containsKey(i + 1))
                        for (String x : map1.get(planet)) map2.get(i + 1).add(x);
                    else {
                        ArrayList<String> g = new ArrayList();
                        for (String x : map1.get(planet))
                            g.add(x);
                        map2.put(i + 1, g);
                    }
                    f++;
                }
            }
            if (f == 0) i = -1;
        }
        for (HashMap.Entry<Integer, ArrayList<String>> entry : map2.entrySet()) {
            Integer l = entry.getKey();
            ArrayList<String> values = entry.getValue();
            count += values.size() * l;
        }
        System.out.println(count);
    }
}
