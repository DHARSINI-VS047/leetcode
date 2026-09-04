class Solution {
    public boolean isPalindromic(String s) {
        int l=0;
        int r= s.length()-1;

        while(l<=r){
            int a= s.charAt(l);
            int b= s.charAt(r);

            for(int i=0;i<8;i++){
                int leftA = (a>>(7-i))& 1;
                int rightB= (b>> i) & 1;

                if(leftA != rightB){
                    return false;
                }
            }
            l++;r--;
        }
        return true;
    }
}