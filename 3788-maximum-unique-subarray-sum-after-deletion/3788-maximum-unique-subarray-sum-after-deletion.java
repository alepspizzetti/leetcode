class Solution {
    public int maxSum(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        Set<Integer> unicos = new HashSet<>();
        
        for (int numero : nums) {
            unicos.add(numero);
        }
        
        int maior = Collections.max(unicos);
        int maximo = maior;
        
        

        for (int numero : unicos) {
            if(numero != maior && (maximo + numero) > maximo) {
                maximo += numero;
            }    
        }

        return maximo;
    }
}