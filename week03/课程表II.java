class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 记录邻接表
        Map<Integer,List<Integer>> outMap=new HashMap<>();
        // 记录当前表的入度
        int []inMap=new int[numCourses];
        // 输出数组
        List<Integer> result=new ArrayList<>();
        // 初始化
        for(int[] pre:prerequisites){
            List<Integer> preNeighbor=null;
            if(outMap.containsKey(pre[1])){
                preNeighbor=outMap.get(pre[1]);
            } else{
                preNeighbor=new ArrayList<>();
            }
            preNeighbor.add(pre[0]);
            outMap.put(pre[1],preNeighbor);
            inMap[pre[0]]++;
        }
        // 把无任何关联的点加入结果集合

        Queue<Integer> queue=new LinkedList<>();
        // 找到初始点集合
        for(int i=0;i<inMap.length;i++){
            if(inMap[i]==0){
                if(outMap.containsKey(i)){
                    queue.offer(i);
                } else{
                   result.add(i);
                }
            }
        }
        // 开始迭代
        while(!queue.isEmpty()){
            Integer pop=queue.poll();
            result.add(pop);
            List<Integer> neighbor=outMap.get(pop);
            for(Integer neigh:neighbor){
                inMap[neigh]--;
                if(inMap[neigh]==0){
                    if(outMap.containsKey(neigh)){
                        queue.offer(neigh);
                    } else{
                        result.add(neigh);
                    }
                }
            }
            outMap.remove(pop);
        }
        int [] fina=new int[0];
        if(result.size()!=numCourses){
            return fina;
        }
        fina=new int[numCourses];
        for(int i=0;i<result.size();i++){
            fina[i]=result.get(i);
        }
        return fina;
    }
    
}