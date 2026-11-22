class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int b=0;
        int a=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                b++;
            }
            else if(b>0&&s.charAt(i)=='a'){
               return false; 
            }
            else{
                a++;
            }
        }
        if(a==0&&b>0||b==0){
            return true;
        }
        return true;

    }
}