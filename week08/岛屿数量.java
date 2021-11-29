class Solution {
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 存储1的位置
        List<Integer> list = new ArrayList<>();
        UnionFind unionFind = new UnionFind(n * m);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    list.add(i * n + j);
                    for(int[] t : d){
                        int x = i + t[0];
                        int y = j + t[1];
                        if(x < 0 || x >= m || y < 0 || y >= n){
                            continue;
                        }
                        if(grid[x][y] == '1'){
                            unionFind.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int e : list){
            int rootE = unionFind.find(e);
            set.add(rootE);
        }
        return set.size();
    }

    class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}