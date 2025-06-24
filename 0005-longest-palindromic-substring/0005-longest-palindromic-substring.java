class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // palíndromo de tamanho ímpar
            int len2 = expandAroundCenter(s, i, i + 1);   // palíndromo de tamanho par
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2; // novo início
                end = i + len / 2;         // novo fim
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expande para os lados enquanto for palíndromo
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Comprimento do palíndromo
        return right - left - 1;
    }
}