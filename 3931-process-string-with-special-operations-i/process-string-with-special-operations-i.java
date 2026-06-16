class Solution {
    public String processStr(String s) {
        int totalLength = s.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < totalLength; i++) {
            char currentCharacter = s.charAt(i);
            
            if (currentCharacter == '*') {
                int currentLength = result.length();
                if (currentLength > 0) {
                    result.deleteCharAt(currentLength - 1);
                }
            } else if (currentCharacter == '#') {
                result.append(result.toString());
            } else if (currentCharacter == '%') {
                result.reverse();
            } else {
                result.append(currentCharacter);
            }
        }
        
        return result.toString();
    }
}