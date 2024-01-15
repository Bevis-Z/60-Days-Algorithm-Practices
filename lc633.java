class Solution {
    public boolean judgeSquareSum(int target) {
    if (target < 0) return false;
    long i = 0, j = (int) Math.sqrt(target);
    while (i <= j) {
        long powSum = i * i + j * j;
        if (powSum == target) {
            return true;
        } else if (powSum > target) {
            j--;
        } else {
            i++;
        }
    }
    return false;
}
}