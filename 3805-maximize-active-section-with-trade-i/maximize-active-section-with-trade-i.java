class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        
        // 1. Total '1's count karein
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }
        
        int maxZeroGain = 0;
        int prevZeros = 0;
        int currZeros = 0;
        
        // 2. Single pass mein zero blocks dhoondein aur valid pairs ko check karein
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                currZeros++;
            } else {
                // Agar pichla block aur current block dono valid ( > 0 ) hain, toh hi merge hoga
                if (currZeros > 0) {
                    if (prevZeros > 0) {
                        maxZeroGain = Math.max(maxZeroGain, prevZeros + currZeros);
                    }
                    prevZeros = currZeros;
                    currZeros = 0;
                }
            }
        }
        
        // 3. Loop khatam hone ke baad aakhri block ke liye check karein
        if (currZeros > 0 && prevZeros > 0) {
            maxZeroGain = Math.max(maxZeroGain, prevZeros + currZeros);
        }
        
        return totalOnes + maxZeroGain;
    }
}
