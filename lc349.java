class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || num2.length == 0 || nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                intersect.add(i);
            }
        }

        int[] result = new int[intersect.size()];
        int index = 0;
        for (int i : intersect) {
            result[index++] = i;
        }
        return result;

    }
}