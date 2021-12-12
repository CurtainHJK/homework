class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		int n=nums.length;
		//int[]数组中0为元素，1为下标
		PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] a,int[] b){
			if(a[0]==b[0]){
					//若值相等，则下标降序排列
					return b[1]-a[1];
				}
				else{
					//降序排列
					return b[0]-a[0];
				}
			}
		});
		
		//把前k个压入优先队列
		for(int i=0;i<k;i++){
			queue.offer(new int[]{nums[i],i});
		}
		
		int[] res=new int[n-k+1];
		res[0]=queue.peek()[0];
		
		for(int i=k;i<n;i++){
			queue.offer(new int[]{nums[i],i});
			while(queue.peek()[1]<i-k+1){
				queue.poll();
			}
			res[i-k+1]=queue.peek()[0];
		}
		return res;
	}
}