class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        int start = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandAroundCenter(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}