import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2a {
    public static void main(String[] args) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day2-input.txt")));
        String[] lines = s.split(",");
        int[] code = new int[lines.length];
        for(int i=0;i<code.length;i++)
        {
            code[i]=Integer.parseInt(lines[i]);
        }
        code[1]=12;
        code[2]=2;
        for(int x=0;x<code.length;x+=4)
        {
            if(code[x]==1) {
                code[code[x+3]] = code[code[x + 1]] + code[code[x + 2]];
            }
            else if(code[x]==2) {
                code[code[x+3]] = code[code[x + 1]] * code[code[x + 2]];
            }
            else {
                System.out.println(code[0]);
                x = code.length;
            }
        }
    }
}
