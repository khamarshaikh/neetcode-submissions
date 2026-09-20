class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer,List<Integer>> adjPre = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++) {
            adjPre.computeIfAbsent(prerequisites[i][0], k-> new ArrayList<Integer>()).add(prerequisites[i][1]);
        }

        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for(int course =0;course <numCourses ;course++) {
            if(!dfs(course,adjPre,cycle,visited,output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course,Map<Integer,List<Integer>> prereq,
    Set<Integer> cycle,Set<Integer> visited, List<Integer> output) {

        if(cycle.contains(course)) return false;
        if(visited.contains(course)) return true;

        cycle.add(course);

        for(int pre:prereq.getOrDefault(course,Collections.emptyList())) {
            if(!dfs(pre,prereq,cycle,visited,output)) {
                return false;
            }
        }

        cycle.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}
