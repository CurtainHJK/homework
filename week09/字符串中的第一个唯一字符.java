class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){//-1的情况
            return -1;
        }
        int[] c = new int[26];
        for(int i = 0; i < s.length(); i++) {//计算差值ascII码
            c[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(c[s.charAt(i) - 'a'] == 1) {//第二次出现同样的字符
                return i;
            }
        }
        return -1;
    }
}