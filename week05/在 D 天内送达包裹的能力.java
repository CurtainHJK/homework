class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long sum = 0;
		long left = weights[0];
		for (int i : weights) {
			sum += i;
			left = left > i ? left : i;
			
		}
		if(days == 1){
			return (int) sum;
		}
		if(days == weights.length){
			return (int) left;
		}
		long right = sum;
		while (left != right) {
			long mid = (left + right) >> 1;
			long cur = 0;
			int need = 1;
			for (int i : weights) {
				if(cur + i > mid){
					cur = 0;
					need ++;
				}
				cur += i;
				
			}
			if(need > days){
				left = mid + 1;
			}else {
				right = mid;
			}
			
		}
		return (int) left;   
    }
}