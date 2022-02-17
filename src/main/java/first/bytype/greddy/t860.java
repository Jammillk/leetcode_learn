package first.bytype.greddy;

public class t860 {
    public boolean lemonadeChange(int[] bills) {
        // 20块不用找零，所以可以不用记录
        int c5 = 0, c10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                c5++;
            } else if (bill == 10) {
                c10++;
                c5--;
            } else if (bill == 20) {
                // 情况想漏了，找三张五块或者一张十块一张五块
                // 贪心！优先找10+5，因为5更万能。
                if (c10 > 0) {
                    c5--;
                    c10--;
                } else {
                    c5 -= 3;
                }
            }
            if (c5 < 0 || c10 < 0) {
                return false;
            }
        }
        return true;
    }
}
