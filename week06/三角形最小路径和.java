class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {//如果triangle遍历完了就结束了
            return 0;
        }
        int[][] p = new int[triangle.size()][triangle.size()];
        for (int i=triangle.size()-1;i>=0;i--) {
            for (int j=0;j<i+1;j++) {
                if (i == triangle.size()-1) {
                    p[i][j] = triangle.get(i).get(j);
                    continue;
                }
                p[i][j] = Math.min(triangle.get(i).get(j) + p[i+1][j], triangle.get(i).get(j)+p[i+1][j+1]);
            }
        }
        return p[0][0];
    }
}