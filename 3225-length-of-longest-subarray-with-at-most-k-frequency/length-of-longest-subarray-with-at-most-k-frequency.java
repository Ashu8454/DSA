import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        // HashMap टू ट्रैक फ्रीक्वेंसी
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        int left = 0;
        int maxLength = 0;
        
        // right पॉइंटर से पूरे एरे को ट्रैवर्स करो
        for (int right = 0; right < n; right++) {
            int currentNum = nums[right];
            
            // वर्तमान नंबर की फ्रीक्वेंसी बढ़ाओ
            freqMap.put(currentNum, freqMap.getOrDefault(currentNum, 0) + 1);
            
            // अगर वर्तमान नंबर की फ्रीक्वेंसी k से ज़्यादा हो गई, 
            // तो left पॉइंटर को खिसका कर विंडो को श्रिंक करो
            while (freqMap.get(currentNum) > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                left++; // विंडो छोटी कर रहे हैं
            }
            
            // जब विंडो वैलिड हो, तो मैक्सिमम लेंथ कैलकुलेट करो
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}