class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces "\\s+"
        String[] words = s.trim().split("\\s+");
        
        StringBuilder result = new StringBuilder();
        
        // Iterate backwards through the words array
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" "); // Add a single space between words
            }
        }
        
        return result.toString();
    }
}
