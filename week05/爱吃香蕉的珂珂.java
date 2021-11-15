class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            if(piles[i]>right){
                right=piles[i];
            }
        }
        while(left < right) {
            int mid = left + (right - left)/2;
            int count = 0;
            for (int i = 0; i < piles.length; i++) { //记录吃完这堆香蕉需要的时间
                count += (piles[i] + mid -1)/mid;         
            }
            System.out.println(left+" "+mid+" "+right+" "+count);
            if(count > h) { //如果需要的时间比H大，说明速度慢了
                left = mid + 1;              
            }else { //如果小，说明速度快了
                right = mid;
            }
        }
        return left;
    }
}