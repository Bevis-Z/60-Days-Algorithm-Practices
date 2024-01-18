class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character>[] frequent = new ArrayList[s.length() + 1];
        for (char c : count.keySet()) {
            int f = count.get(c);
            if (frequent[f] == null) {
                frequent[f] = new ArrayList<>();
            }
            frequent[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequent.length - 1; i >= 0; i--) {
            if (frequent[i] == null) {
            continue;
            }
            for (char c : frequent[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}