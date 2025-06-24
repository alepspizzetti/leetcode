class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Transformar a string: exemplo "abba" -> "^#a#b#b#a#$"
        StringBuilder t = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        t.append("#$");

        char[] chars = t.toString().toCharArray();
        int[] p = new int[chars.length];
        int center = 0, right = 0;

        for (int i = 1; i < chars.length - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expandir ao redor do centro
            while (chars[i + (1 + p[i])] == chars[i - (1 + p[i])]) {
                p[i]++;
            }

            // Atualizar centro e limite direito se o palíndromo atual se expandiu além do limite atual
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Encontrar o maior palíndromo
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}