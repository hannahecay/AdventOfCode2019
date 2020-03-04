import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6b {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day6-input.txt"));
        HashMap<String, String> map1 = new HashMap<>();
        ArrayList<String> you = new ArrayList<>();
        ArrayList<String> san = new ArrayList<>();
        for (String line : lines) {
            String[] orbits = line.split("\\)");
            map1.put(orbits[1], orbits[0]);
        }
        you.add("YOU");
        san.add("SAN");
        for(int i=0;i>-1;i++)
        {
            you.add(map1.get(you.get(i)));
            if(you.get(i+1).equals("COM")) break;
        }
        for(int i=0;i>-1;i++)
        {
            san.add(map1.get(san.get(i)));
            if(san.get(i+1).equals("COM")) break;
        }
        int x=0;
        int d = Math.abs(you.size()-san.size());
        if(you.size()<=san.size())
        {
            x=san.size()-1;
            while(you.get(x-d).equals(san.get(x)))
                x--;
            x=san.size()-x-1;
        }
        else
        {
            x=you.size()-1;
            while(you.get(x).equals(san.get(x-d)))
                x--;
            x=you.size()-x-1;
        }
        System.out.println(you.size()-1+san.size()-1-2*x);
    }
}
