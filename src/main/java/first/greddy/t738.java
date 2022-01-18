package first.greddy;

public class t738 {
    /**
     * 后往前遍历，
     * 若出现332，前一个比后一个大的数字，即让它减1（222），然后后面变成9（299）
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int start = 0;
        for(int i = arr.length - 1;i > 0;i--){
            if (arr[i - 1] > arr[i]){
                start = i;
                arr[i - 1]--;
            }
        }
        for(int i = start;i < arr.length;i++){
            arr[i] = '9';
        }
        return Integer.parseInt(new String(arr));
    }
}

