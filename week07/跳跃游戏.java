class Solution {
    public boolean canJump(int[] nums) {
        //数组长度为一return true
        if(nums.length==1){
            return true;
        }
        int farthest=nums[0];
		//通过贪心，记录能去到的最远地方，当最远地方超过数组长度即可
        for(int i=0;i<=farthest;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}