class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for(int i = 0; i < len - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            } else {
                candy[i + 1] = 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }
        for(int candyNum : candy) {
            res += candyNum;
        }
        return res;
    }
}