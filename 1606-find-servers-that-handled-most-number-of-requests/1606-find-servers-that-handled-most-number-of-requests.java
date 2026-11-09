class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for(int i=0;i<k;i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int []reqHandled = new int[k];
        for(int i=0;i<arrival.length;i++) {
            while(!busy.isEmpty() && busy.peek()[0]<=arrival[i]) {
                int []server = busy.poll();
                available.add(server[1]);
            }
            if(available.isEmpty()) {
                continue;
            }
            int target = i%k;
            Integer server = available.ceiling(target);
            if(server==null) {
                server = available.first();
            }
            available.remove(server);
            reqHandled[server]++;
            busy.offer(new int[]{arrival[i]+load[i], server});
        }
        int max = 0;
        for(int num: reqHandled) {
            max = Math.max(max, num);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++) {
            if(reqHandled[i]==max) {
                result.add(i);
            }
        }
        return result;
    }
}