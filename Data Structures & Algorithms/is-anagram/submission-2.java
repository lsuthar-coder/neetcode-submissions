class Solution {
    public boolean isAnagram(String s, String t) {
        int[] car = new int[26+1];
        for(int i=0; i<s.length(); i++){
            car[s.charAt(i)-97]++;
        }
        for(int i=0; i<t.length(); i++){
            car[t.charAt(i)-97]--;
        }
        for(int i=0; i<car.length; i++){
            if(car[i]!=0)
            return false;
        }
        return true;
    }
}
