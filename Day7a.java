import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day7a {
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
    public int op3(int[] a, int h){
        return a[h];
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
    static ArrayList<int[]> permute(int[] a, int k, ArrayList<int[]> p) {
        int[] r = new int[12];
        if (k == a.length) {
            for (int i = 0; i < 10; i+=2) {
                r[i]=a[i/2];
            }
            p.add(r);

        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1, p);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
        return p;
    }
    public static void main(String[] args) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day7-input.txt")));
        String[] lines = s.split(",");
        int[] code = new int[lines.length];
        Day7a x = new Day7a();
        ArrayList<int[]> n = new ArrayList<>();
        int c = 0;
        int h=0;
        int[] arr = new int[12];
        int[] sequence = {0,1,2,3,4};
        int max = 0;
        n=x.permute(sequence, 0, n);
        for(int i = 0; i<120;i++)
        {
            for(int j=0;j<code.length;j++)
                code[j]=Integer.parseInt(lines[j]);
            h=0;
            arr = n.get(i);
            arr[1] = 0;
            for(int q = 0;q<5;q++)
            {

                for(int l = 0;l<arr.length;l++)
                {
                    System.out.print(arr[l]+",");
                }
                System.out.println("");
                System.out.println("h: "+h);
                System.out.println("q: "+q);
                c=0;
                for(int j=0;j<code.length;j++)
                    code[j]=Integer.parseInt(lines[j]);
                while(c!=-1) {
                    System.out.println(code[c]);
                    if (x.getOp(code[c]) == 1) {
                        code[code[c + 3]] = x.op1(c, code);
                        c += 4;
                    }
                    if (x.getOp(code[c]) == 2) {
                        code[code[c + 3]] = x.op2(c, code);
                        c += 4;
                    }
                    if (x.getOp(code[c]) == 3) {
                        code[code[c + 1]] = x.op3(arr, h);
                        c += 2;
                        h++;
                    }
                    if (x.getOp(code[c]) == 4) {
                        arr[h+1] = code[code[c + 1]];
                        c += 2;
                    }
                    if (x.getOp(code[c]) == 5) {
                        c = x.op5(c, code);
                    }
                    if (x.getOp(code[c]) == 6) {
                        c = x.op6(c, code);
                    }
                    if (x.getOp(code[c]) == 7) {
                        code[code[c + 3]] = x.op7(c, code);
                        c += 4;
                    }
                    if (x.getOp(code[c]) == 8) {
                        code[code[c + 3]] = x.op8(c, code);
                        c += 4;
                    }
                    if (x.getOp(code[c]) == 99)
                        c = -1;
                }
            }
            max = Math.max(arr[11], max);
        }
        System.out.println(max);
    }
}
