class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String cpdomain:cpdomains){
            String[] a=cpdomain.split(" ");
            int n=Integer.valueOf(a[0]);
            String domain=a[1];
            String[] b=domain.split("\\.");
            for(int i=0;i<b.length;i++){
                String[] c=Arrays.copyOfRange(b,i,b.length);
                String subdomain=String.join(".",c);
                int oldCount=map.getOrDefault(subdomain,0);
                map.put(subdomain,oldCount+n);
            }
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String domain=e.getKey();
            int n=e.getValue();
            String s=String.format("%d %s",n,domain);
            list.add(s);
        }
        return list;
    }
}