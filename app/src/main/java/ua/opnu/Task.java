package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String a = list.get(i);
            String b = list.get(i + 1);
            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String t = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, t);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; ) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            queue.add(x);
            stack.push(x);
        }

        boolean ok = true;
        for (int i = 0; i < size; i++) {
            int a = queue.remove();
            int b = stack.pop();
            if (a != b) ok = false;
            queue.add(a);
        }

        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x < 0) stack.push(x);
            else queue.add(x);
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        java.util.ArrayDeque<Integer> even = new java.util.ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            if (x % 2 == 0) even.add(x);
            else queue.add(x);
        }

        while (!even.isEmpty()) queue.add(even.remove());
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) max = s.length();
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        java.util.Set<Integer> a = new java.util.HashSet<>(list1);
        java.util.Set<Integer> res = new java.util.HashSet<>();

        for (int x : list2) {
            if (a.contains(x)) res.add(x);
        }
        return res.size();
    }

    public boolean isUnique(Map<String, String> map) {
        return new java.util.HashSet<>(map.values()).size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> out = new java.util.HashMap<>();
        for (var e : map1.entrySet()) {
            if (map2.containsKey(e.getKey()) && map2.get(e.getKey()).equals(e.getValue())) {
                out.put(e.getKey(), e.getValue());
            }
        }
        return out;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> out = new java.util.HashMap<>();
        for (var e : map.entrySet()) {
            out.put(e.getValue(), e.getKey());
        }
        return out;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) return 0;

        Map<Integer, Integer> freq = new java.util.HashMap<>();
        for (int val : map.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        int bestVal = Integer.MAX_VALUE;
        int bestCnt = Integer.MAX_VALUE;

        for (var e : freq.entrySet()) {
            int v = e.getKey();
            int c = e.getValue();
            if (c < bestCnt || (c == bestCnt && v < bestVal)) {
                bestCnt = c;
                bestVal = v;
            }
        }
        return bestVal;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> freq = new java.util.HashMap<>();
        for (int x : list) freq.put(x, freq.getOrDefault(x, 0) + 1);

        int max = 0;
        for (int c : freq.values()) max = Math.max(max, c);

        return max;
    }
}


