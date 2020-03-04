public class Day4b {
    public boolean containsDouble(int n) {
        int x = 10;
        while (n > 9) {
            if(n%10!=x)
            {
                if ((n%10 == ((n / 10) % 10)) && !(((n / 10) % 10) == (n / 100) % 10))
                    return true;
            }
            x=n%10;
            n = n / 10;
        }
        return false;
    }

    public boolean decreases(int n) {
        while (n > 9) {
            if (n % 10 < (n / 10) % 10)
                return true;
            n = n / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        Day4b x = new Day4b();
        for (int i = 356261; i < 846304; i++) {
            if (x.containsDouble(i) && !x.decreases(i))
                count++;
        }
        System.out.println(count);
        System.out.println(x.containsDouble(333333));
    }
}
