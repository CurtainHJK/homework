class Solution {
	//用到回溯，需要注意剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        //结果
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        //使用标记
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        //遍历
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        //终止条件
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            //两个数相等且前一个刚被取消使用
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //将结果往后添加
            path.addLast(nums[i]);
            //标记使用
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }
}