class Solution {
    public String toLowerCase(String s) {
        String res="";
        for(int i=0;i<s.length();i++){          
            char c=s.charAt(i);
            if(c>='A'&&c<='Z'){//通过ascii判断是否在大写的区间内
                c+=32;//ascii大小写差值在32
            }
            res+=c;
        }
        return res;
    }
}