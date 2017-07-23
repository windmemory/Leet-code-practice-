// find all shortest paths
// bfs + dfs


public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (dict == null) {
            return result;
        }

        int length = getShortestLength(start, end, dict);
        // System.out.println(length);

        List<String> subSet = new ArrayList<String>();
        HashSet<String> hash = new HashSet<String>();
        HashMap<String, List<String>> graph = new HashMap<>();
        subSet.add(start);
        hash.add(start);
        dfs(start, end, dict, subSet, hash, result, length, graph);

        return result;
    }

    private void dfs(String start, String end, Set<String> dict, List<String> currSet, HashSet<String> visited, List<List<String>> result, int length, HashMap<String, List<String>> graph) {
        if (currSet.size() == length) {
            if (currSet.get(currSet.size() - 1).equals(end)) {
                result.add(new ArrayList<>(currSet));
            }
            return;
        }

        List<String> neighbors = new ArrayList<>();
        if (graph.containsKey(start)) {
            neighbors = graph.get(start);
        } else {
            neighbors = findNeighbors(start, dict);
            graph.put(start, neighbors);
        }
        for (String word : neighbors) {
            if (visited.contains(word)) {
                continue;
            }
            currSet.add(word);
            visited.add(word);

            dfs(word, end, dict, currSet, visited, result, length, graph);

            currSet.remove(currSet.size() - 1);
            visited.remove(word);
        }
    }

    private int getShortestLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        if (dict == null) {
            return 0;
        }

        // create a map from all the words
        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String nei : findNeighbors(curr, dict)) {
                    if (!hash.contains(nei)) {
                        queue.offer(nei);
                        hash.add(nei);
                    }

                    if (nei.equals(end)) {
                        return length;
                    }
                }
            }

        }

        return 0;
    }

    private List<String> findNeighbors(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        int l = word.length();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int j = 0; j < l; j++) {
                if (c == word.charAt(j)) {
                    continue;
                }

                String next = replaceAt(j, word, c);
                if (dict.contains(next)) {
                    result.add(next);
                }
            }
        }

        return result;
    }


    private String replaceAt(int index, String str, char c) {
        char[] chars = str.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
