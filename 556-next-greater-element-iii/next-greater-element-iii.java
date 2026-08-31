class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        if (i < 0) {
            return -1;
        }
        
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        
        swap(digits, i, j);
        
        // Step 4: Index i ke baad wale saare digits ko reverse (palat) dein
        reverse(digits, i + 1, len - 1);
        
        // 32-bit Integer Overflow Check:
        // Kyunki constraint hai ki result 32-bit int mein fit hona chahiye, hum long mein convert karke check karenge
        long val = Long.parseLong(new String(digits));
        if (val > Integer.MAX_VALUE) {
            return -1;
        }
        
        return (int) val;
    }
    
    // Helper function to swap two characters
    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
    
    // Helper function to reverse a subarray
    private void reverse(char[] digits, int start, int end) {
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }
}
