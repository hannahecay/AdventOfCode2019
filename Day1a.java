import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1a {
    public static void main(String[] args) throws IOException {
        int total=0;
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day1-input.txt"));
        for(String line:lines)
        {
            total+= Integer.parseInt(line)/3-2;
        }
        System.out.println(total);
    }
}
