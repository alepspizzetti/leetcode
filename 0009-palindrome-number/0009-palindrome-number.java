class Solution {
    public boolean isPalindrome(int x) {
        String numero = Integer.toString(x);
        int left = 0;
        int right = numero.length() -1;
        
        if( x < 0) {
            return false;
        }
        
        for(int index = 0; index <= numero.length() -1; index ++) {
            if(left > right) {break;}
            
            if(numero.charAt(left) == numero.charAt(right)) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}