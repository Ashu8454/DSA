import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) {
            return "0";
        }
        
        char[] stack = new char[len];
        int top = 0;
        
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (k > 0 && top > 0 && stack[top - 1] > digit) {
                top--;
                k--;
            }
            stack[top++] = digit;
        }
        
        top -= k;
        
        int start = 0;
        while (start < top && stack[start] == '0') {
            start++;
        }
        
        if (start == top) {
            return "0";
        }
        
        return new String(stack, start, top - start);
    }
}
