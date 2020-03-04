public class Day4a {
    public boolean containsDouble(int n) {
        while (n > 9) {
            if (n % 10 == (n / 10) % 10)
                return true;
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
        Day4a x = new Day4a();
        for (int i = 356261; i < 846304; i++) {
            if (x.containsDouble(i) && !x.decreases(i))
                count++;
        }
        System.out.println(count);
    }
}
