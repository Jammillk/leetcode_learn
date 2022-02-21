package first.top;

public class t26 {
    public static void main(String[] args) {
        t26 obj = new t26();
        System.out.println(obj.removeDuplicates(new int[]{
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        }));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                nums[j++] = nums[i];
            }
        }
        return ++j;
    }


    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
