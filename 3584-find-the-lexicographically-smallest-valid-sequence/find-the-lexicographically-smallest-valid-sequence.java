class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // rightMatch[i] स्टोर करेगा कि word1 के इंडेक्स i से लेकर आख़िर तक, 
        // word2 के आख़िरी कितने कैरेक्टर्स हूबहू मैच हो सकते हैं।
        int[] rightMatch = new int[n + 1];
        
        int p2 = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            // अगर कैरेक्टर मैच होता है, तो p2 को पीछे खिसकाओ
            if (p2 >= 0 && word1.charAt(i) == word2.charAt(p2)) {
                p2--;
            }
            // कितने कैरेक्टर्स मैच हो गए, वो स्टोर करो
            rightMatch[i] = m - 1 - p2;
        }
        
        int[] ans = new int[m];
        boolean changed = false; // ट्रैक करने के लिए कि हमने अपनी पावर यूज़ की है या नहीं
        int j = 0;
        
        // बाएँ से दाएँ Greedy तरीके से इंडेक्स चुनो
        for (int i = 0; i < n && j < m; i++) {
            // Case 1: हूबहू मैच हो गया (बिना पावर यूज़ किए)
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            // Case 2: मैच नहीं हुआ, लेकिन हम पावर (change) यूज़ कर सकते हैं
            else if (!changed && rightMatch[i + 1] >= m - 1 - j) {
                ans[j] = i;
                changed = true; // पावर यूज़ कर ली
                j++;
            }
        }
        
        // अगर हमने word2 के सारे (m) कैरेक्टर्स ढूँढ लिए हैं, तो आंसर भेज दो
        if (j == m) {
            return ans;
        }
        
        // अगर पूरा सीक्वेंस नहीं बन पाया, तो खाली ऐरे भेज दो
        return new int[0];
    }
}