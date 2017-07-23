public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }

        if (dict == null) {
            return 0;
        }

        // create a map from all the words
        dict.add(start);
        dict.add(end);
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String word : dict) {
            graph.put(word, findNeighbors(word, dict));
        }

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
                 for (String nei : graph.get(curr)) {
                // for (String nei : findNeighbors(curr, dict)) {
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
