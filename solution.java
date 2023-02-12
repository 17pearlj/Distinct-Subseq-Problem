class Solution {
    String s_;
    String t_;
    
    public int numDistinct(String s, String t) {
        s_ = s;
        t_ = t;
        int[][] arr = new int[s_.length()][t_.length()];
        for (int i = 0; i < s_.length(); i++) {
            Arrays.fill(arr[i], -1);
        }
        int sol = numDistinct(0, 0, arr);
        if (sol < 0) { sol = 0; }
        return sol;
    }
    
    public int numDistinct(int r, int c, int[][] arr) {
        if (c >= t_.length()) { return 1; }
        if (r >= s_.length()) { return 0; }
        if (arr[r][c] == -1) {
            arr[r][c] = numDistinct(r + 1, c, arr);
            if (s_.charAt(r) == t_.charAt(c)) {
                arr[r][c] += numDistinct(r + 1, c + 1, arr);
            }
        }
        return arr[r][c];
    }
}
