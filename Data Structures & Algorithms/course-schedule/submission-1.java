class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer,List<Integer>> adp = new HashMap<>();

        for(int[] edge:prerequisites) {
            adp.computeIfAbsent(edge[0], k-> new ArrayList<Integer>()).add(edge[1]);
        }

        Set<Integer> cycle = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        for(int i=0;i<numCourses;i++) {
            if(!dfs(i,adp,cycle,visited)) {
                return false;
            };
        }
        return true;
    }

    private boolean dfs(int course,Map<Integer,List<Integer>> adj, Set<Integer> cycle, Set<Integer> visited) {
        if(cycle.contains(course)) return false;
        if(visited.contains(course)) return true;


        cycle.add(course);
        for(int pre:adj.getOrDefault(course,Collections.emptyList())) {
            if(!dfs(pre,adj,cycle,visited)){
                return false;
            }
        }

        cycle.remove(course);
        visited.add(course);
        return true;
    }
}
