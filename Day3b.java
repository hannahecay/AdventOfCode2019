import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3b {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:/Users/hanna/Desktop/AdventOfCode2019/day3-input.txt"));
        String line1 = lines.get(0);
        String line2 = lines.get(1);
        String[] w1 = line1.split(",");
        String[] w2 = line2.split(",");
        Map<Integer, HashMap<Integer,Integer>> co1 = new HashMap<>();
        Map<Integer, HashMap<Integer,Integer>> co2 = new HashMap<>();
        int z;
        int x = 0;
        int y = 0;
        int r = 0;
        int s = 0;
        int w1l = 0;
        int w2l = 0;
        int dis = 0;
        a:
        for (int d = 0; d < Math.min(w1.length, w2.length); d++) {
            z = Integer.parseInt(w1[d].substring(1));
            if (w1[d].charAt(0) == 'U') {
                if (co1.containsKey(x)) {
                    for (int i = 1; i < z + 1; i++)
                        if (!co2.containsKey(x) || !co2.get(x).containsKey(y + i)) {
                            if (!co1.get(x).containsKey(y + i))
                                co1.get(x).put(y + i, w1l+i);
                        } else {
                            dis = w1l+i+co2.get(x).get(y+i);
                            break a;
                        }
                } else {
                    HashMap<Integer, Integer> arr = new HashMap<>();
                    for (int i = 1; i < z + 1; i++)
                        if (!co2.containsKey(x) || !co2.get(x).containsKey(y + i)) {
                            arr.put(y + i, w1l+i);
                        } else {
                            dis = w1l+i+co2.get(x).get(y+i);
                            break a;
                        }
                    co1.put(x, arr);
                }
                y += z;
                w1l +=z;
            }
            if (w1[d].charAt(0) == 'D') {
                if (co1.containsKey(x)) {
                    for (int i = -1; i > -z - 1; i--)
                        if (!co2.containsKey(x) || !co2.get(x).containsKey(y + i)) {
                            if (!co1.get(x).containsKey(y + i))
                                co1.get(x).put(y + i, w1l+Math.abs(i));
                        } else {
                            dis = w1l+Math.abs(i)+co2.get(x).get(y+i);
                            break a;
                        }
                } else {
                    HashMap<Integer, Integer> arr = new HashMap<>();
                    for (int i = -1; i > -z - 1; i--)
                        if (!co2.containsKey(x) || !co2.get(x).containsKey(y + i)) {
                            arr.put(y + i, w1l+Math.abs(i));
                        } else {
                            dis = w1l+Math.abs(i)+co2.get(x).get(y+i);
                            break a;
                        }
                    co1.put(x, arr);
                }
                y -= z;
                w1l+=z;
            }
            if (w1[d].charAt(0) == 'R') {
                for (int i = 1; i < z + 1; i++) {
                    if (co1.containsKey(x + i)) {
                        if (!co2.containsKey(x + i) || !co2.get(x + i).containsKey(y)) {
                            if (!co1.get(x + i).containsKey(y))
                                co1.get(x + i).put(y,w1l+i);
                        } else {
                            dis = w1l+i+co2.get(x+i).get(y);
                            break a;
                        }

                    } else {
                        HashMap<Integer, Integer> arr = new HashMap<>();
                        if (!co2.containsKey(x + i) || !co2.get(x + i).containsKey(y)) {
                            arr.put(y,w1l+i);
                            co1.put(x + i, arr);
                        } else {
                            dis = w1l+i+co2.get(x+i).get(y);
                            break a;
                        }
                    }
                }
                x += z;
                w1l+=z;
            }
            if (w1[d].charAt(0) == 'L') {
                for (int i = -1; i > -z - 1; i--) {
                    if (co1.containsKey(x + i)) {
                        if (!co2.containsKey(x + i) || !co2.get(x + i).containsKey(y)) {
                            if (!co1.get(x + i).containsKey(y))
                                co1.get(x + i).put(y,w1l+Math.abs(i));
                        } else {
                            dis = w1l+Math.abs(i)+co2.get(x+i).get(y);
                            break a;
                        }
                    } else {
                        HashMap<Integer, Integer> arr = new HashMap<>();
                        if (!co2.containsKey(x + i) || !co2.get(x + i).containsKey(y)) {
                            arr.put(y,w1l+Math.abs(i));
                            co1.put(x + i, arr);
                        } else {
                            dis = w1l+Math.abs(i)+co2.get(x+i).get(y);
                            break a;
                        }
                    }
                }
                x -= z;
                w1l+=z;
            }
            z = Integer.parseInt(w2[d].substring(1));
            if (w2[d].charAt(0) == 'U') {
                if (co2.containsKey(r)) {
                    for (int i = 1; i < z + 1; i++)
                        if (!co1.containsKey(r) || !co1.get(r).containsKey(s + i)) {
                            if (!co2.get(r).containsKey(s + i))
                                co2.get(r).put(s + i,w2l+i);
                        } else {
                            dis = w2l+i+co1.get(r).get(s+i);
                            break a;
                        }
                } else {
                    HashMap<Integer, Integer> arr = new HashMap<>();
                    for (int i = 1; i < z + 1; i++)
                        if (!co1.containsKey(r) || !co1.get(r).containsKey(s + i)) {
                            arr.put(s + i,w2l+i);
                        } else {
                            dis = w2l+i+co1.get(r).get(s+i);
                            break a;
                        }
                    co2.put(r, arr);
                }
                s += z;
                w2l+=z;
            }
            if (w2[d].charAt(0) == 'D') {
                if (co2.containsKey(r)) {
                    for (int i = -1; i > -z - 1; i--)
                        if (!co1.containsKey(r) || !co1.get(r).containsKey(s + i)) {
                            if (!co2.get(r).containsKey(s + i))
                                co2.get(r).put(s + i,w2l+Math.abs(i));
                        } else {
                            dis = w2l+Math.abs(i)+co1.get(r).get(s+i);
                            break a;
                        }
                } else {
                    HashMap<Integer, Integer> arr = new HashMap<>();
                    for (int i = -1; i > -z - 1; i--)
                        if (!co1.containsKey(r) || !co1.get(r).containsKey(s + i)) {
                            arr.put(s + i,w2l+Math.abs(i));
                        } else {
                            dis = w2l+Math.abs(i)+co1.get(r).get(s+i);
                            break a;
                        }
                    co2.put(r, arr);
                }
                s -= z;
                w2l+=z;
            }
            if (w2[d].charAt(0) == 'R') {
                for (int i = 1; i < z + 1; i++) {
                    if (co2.containsKey(r + i)) {
                        if (!co1.containsKey(r + i) || !co1.get(r + i).containsKey(s)) {
                            if (!co2.get(r + i).containsKey(s))
                                co2.get(r + i).put(s,w2l+i);
                        } else {
                            dis = w2l+i+co1.get(r+i).get(s);
                            break a;
                        }
                    } else {
                        HashMap<Integer, Integer> arr = new HashMap<>();
                        if (!co1.containsKey(r + i) || !co1.get(r + i).containsKey(s)) {
                            arr.put(s,w2l+i);
                            co2.put(r + i, arr);
                        } else {
                            dis = w2l+i+co1.get(r+i).get(s);
                            break a;
                        }
                    }
                }
                r += z;
                w2l+=z;
            }
            if (w2[d].charAt(0) == 'L') {
                for (int i = -1; i > -z - 1; i--) {
                    if (co2.containsKey(r + i)) {
                        if (!co1.containsKey(r + i) || !co1.get(r + i).containsKey(s)) {
                            if (!co2.get(r + i).containsKey(s))
                                co2.get(r + i).put(s,w2l+Math.abs(i));
                        } else {
                            dis = w2l+Math.abs(i)+co1.get(r+i).get(s);
                            break a;
                        }
                    } else {
                        HashMap<Integer, Integer> arr = new HashMap<>();
                        if (!co1.containsKey(r + i) || !co1.get(r + i).containsKey(s)) {
                            arr.put(s,w2l+Math.abs(i));
                            co2.put(r + i, arr);
                        } else {
                            dis = w2l+Math.abs(i)+co1.get(r+i).get(s);
                            break a;
                        }
                    }
                }
                r -= z;
                w2l+=z;
            }
        }
        System.out.println(dis);
    }
}
