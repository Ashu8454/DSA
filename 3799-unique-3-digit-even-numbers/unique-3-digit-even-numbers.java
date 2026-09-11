class Solution {
    public int totalNumbers(int[] digits) {
        int[] originalCount = new int[10];
        for (int d : digits) {
            originalCount[d]++;
        }
        
        int totalDistinctEvenNumbers = 0;
        
        for (int num = 100; num <= 998; num += 2) {
            
            int[] currentNumCount = new int[10];
            int temp = num;
            
            while (temp > 0) {
                int digit = temp % 10;
                currentNumCount[digit]++;
                temp /= 10;
            }
            
            boolean isPossible = true;
            for (int i = 0; i < 10; i++) {
                if (currentNumCount[i] > originalCount[i]) {
                    isPossible = false; 
                    break;
                }
            }
            
            if (isPossible) {
                totalDistinctEvenNumbers++;
            }
        }
        
        return totalDistinctEvenNumbers;
    }
}
