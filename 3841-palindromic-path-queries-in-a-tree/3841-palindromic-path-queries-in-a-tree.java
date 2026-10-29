class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    int []parent, depth, size, heavy, head, pos;
    int timer;
    char []values;
    SegmentTree segTree;
    class SegmentTree {
        int []tree;
        int n;
        SegmentTree(int []arr) {
            n = arr.length;
            tree = new int[4*n];
            build(1, 0, n-1, arr);
        }
        public void build(int node, int start, int end, int[] arr) {
            if(start==end) {
                tree[node] = arr[start];
                return;
            }
            int mid = start+(end-start)/2;
            build(node*2, start, mid, arr);
            build(node*2+1, mid+1, end, arr);
            tree[node] = tree[node*2]^tree[node*2+1];
        }
        public void update(int index, int value) {
            update(1, 0, n-1, index, value);
        }
        public void update(int node, int start, int end, int index, int value) {
            if(start==end) {
                tree[node] = value;
                return;
            }
            int mid = start+(end-start)/2;
            if(index<=mid) {
                update(node*2, start, mid, index, value);
            }
            else {
                update(node*2+1, mid+1, end, index, value);
            }
            tree[node] = tree[node*2]^tree[node*2+1];
        }
        public int query(int left, int right) {
            if(left>right) {
                return 0;
            }
            return query(1, 0, n-1, left, right);
        }
        public int query(int node, int start, int end, int left, int right) {
            if(right<start || end<left) {
                return 0;
            }
            if(left<=start && end<=right) {
                return tree[node];
            }
            int mid = start+(end-start)/2;
            int a = query(node*2, start, mid, left, right);
            int b = query(node*2+1, mid+1, end, left, right);
            return a^b;
        }
    }
    public void dfs1(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        heavy[u] = -1;
        int maxSubtreeSize = 0;
        for(int v: adj.get(u)) {
            if(v==p) {
                continue;
            }
            depth[v] = depth[u]+1;
            dfs1(v, u);
            size[u] += size[v];
            if(size[v]>maxSubtreeSize) {
                maxSubtreeSize = size[v];
                heavy[u] = v;
            }
        }
    }
    void dfs2(int u, int chainHead) {
        head[u] = chainHead;
        pos[u] = timer++;
        if(heavy[u]!=-1) {
            dfs2(heavy[u], chainHead);
        }
        for(int v: adj.get(u)) {
            if(v==parent[u] || v==heavy[u]) {
                continue;
            }
            dfs2(v, v);
        }
    }
    int getPathMask(int u, int v) {
        int mask = 0;
        while(head[u]!=head[v]) {
            if(depth[head[u]]<depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            mask ^= segTree.query(pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if(depth[u]>depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        mask ^= segTree.query(pos[u], pos[v]);
        return mask;
    }
    boolean canFormPalindrome(int mask) {
        return (mask&(mask-1))==0;
    }
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        values = s.toCharArray();
        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        timer = 0;
        dfs1(0, -1);
        dfs2(0, 0);
        int[] base = new int[n];
        for(int u=0;u<n;u++) {
            base[pos[u]] = 1<<(values[u]-'a');
        }
        segTree = new SegmentTree(base);
        List<Boolean> result = new ArrayList<>();
        for(String str: queries) {
            String[] arr = str.trim().split("\\s+");
            if(arr[0].equals("query")) {
                int u = Integer.parseInt(arr[1]);
                int v = Integer.parseInt(arr[2]);
                int mask = getPathMask(u, v);
                result.add(canFormPalindrome(mask));
            }
            else {
                int index = Integer.parseInt(arr[1]);
                char newChar = arr[2].charAt(0);
                if(values[index]!=newChar) {
                    values[index] = newChar;
                    int newMask = 1<<(newChar-'a');
                    segTree.update(pos[index], newMask);
                }
            }
        }
        return result;
    }
}