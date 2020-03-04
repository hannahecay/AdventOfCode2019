import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Day5a {
    private int v1 = 0;
    private int v2 = 0;
    public int getOp(int n) {
        return n%100;
    }
    public int op1(int n, int[] co) {
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        return v1+v2;
    }
    public int op2(int n, int[] co){
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        return v1*v2;
    }
    public int op3(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("input: ");
        return keyboard.nextInt();
    }
    public int op5(int n, int[] co){
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        if(v1!=0)
            return v2;
        else return n+3;
    }
    public int op6(int n, int[] co){
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        if(v1==0)
            return v2;
        else return n+3;
    }
    public int op7(int n, int[] co){
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        if(v1<v2)
            return 1;
        else return 0;
    }
    public int op8(int n, int[] co){
        v1=getPm1(n, co);
        v2=getPm2(n, co);
        if(v1==v2)
            return 1;
        else return 0;
    }
    public int getPm1(int n, int[] co){
        if((co[n]/100)%10==0)
            return co[co[n+1]];
        else return co[n+1];
    }
    public int getPm2(int n, int[] co){
        if((co[n]/1000)%10==0)
            return co[co[n+2]];
        else return co[n+2];
    }

    public static void main(String[] args) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day5-input.txt")));
        String[] lines = s.split(",");
        int[] code = new int[lines.length];
        for(int i=0;i<code.length;i++)
        {
            code[i]=Integer.parseInt(lines[i]);
        }
        Day5a x = new Day5a();
        int c = 0;
        while(c!=-1)
        {
            if(x.getOp(code[c])==1) {
                code[code[c + 3]] = x.op1(c, code);
                c += 4;
            }
            if(x.getOp(code[c])==2) {
                code[code[c + 3]] = x.op2(c, code);
                c += 4;
            }
            if(x.getOp(code[c])==3) {
                code[code[c + 1]] = x.op3();
                c += 2;
            }
            if(x.getOp(code[c])==4) {
                System.out.println("output: " + code[code[c + 1]]);
                c += 2;
            }
            if(x.getOp(code[c])==5){
                c=x.op5(c, code);
            }
            if(x.getOp(code[c])==6){
                c=x.op6(c, code);
            }
            if(x.getOp(code[c])==7){
                code[code[c+3]]=x.op7(c, code);
                c+=4;
            }
            if(x.getOp(code[c])==8){
                code[code[c+3]]=x.op8(c, code);
                c+=4;
            }
            if(x.getOp(code[c])==99)
                c=-1;
        }
    }
}