package first.bytype.dp;

public class t509 {
    public static void main(String[] args) {
        t509 t509 = new t509();
        System.out.println(t509.fib(5));
    }
    public int fib(int n) {
        if  (n <= 1){
            return n;
        }
        int first = 0, second = 1;
        for(int i = 2;i <= n;i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
