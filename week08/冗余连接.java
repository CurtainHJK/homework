class Solution {
    int[] f;
    boolean union(int a,int b){
        int n=0;
        //找a的父级
        while(a!=f[a]){
            a=f[a];
            n++;
        }
        //找b的父级
        while(b!=f[b]){
            b=f[b];
            n--;
        }
        //如果相等，就可以跳出了，
        if(a==b){
            return false;
        }
        //不相等，n>0说明a的深度高，就把a给f[b]
        //反之，b的深度高，就把b给f[a]
        if(n>0){
            f[b]=a;
        }else{
            f[a]=b;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        f=new int[edges.length+1];
        for(int i=0;i<f.length;i++){
            f[i]=i;
        }
        for(int[] e:edges){
            if(!union(e[0],e[1])){
                return e;
            }
        }
        return new int[]{};
    }
}