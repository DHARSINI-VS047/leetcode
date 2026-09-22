class Solution {
    public int lengthOfLastWord(String s) {
        s.trim();
        String b[]=s.split("\\s");
        return b[b.length-1].length();
        
    }
}