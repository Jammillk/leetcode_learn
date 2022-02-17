package first.bytype.greddy;

import java.util.Arrays;

class t135 {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]){
                candyVec[i] = candyVec[i - 1] + 1;
            }else {
                candyVec[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        return Arrays.stream(candyVec).sum();
    }
}