package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Task {

    public static void main(String[] args) {
    }

    // Завдання 1
    public void removeShorterStrings(List<String> list) {
        ArrayList<Integer> toRemove = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                toRemove.add(i);
            } else {
                toRemove.add(i + 1);
            }
        }
        for (int i = toRemove.size() - 1; i >= 0; i--) {
            list.remove((int) toRemove.get(i));
        }
    }

    // Завдання 2
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String value = list.get(i);
            list.add(i + 1, value);
        }
    }

    // Завдання 3
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    // Завдання 4
    public void removeDuplicates(List<String> list) {
        int i = 0;
        while (i < list.size() - 1) {
            String cur = list.get(i);
            String next = list.get(i + 1);
            if (cur.equals(next)) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    // Завдання 5
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);
            if (value.length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    // Завдання 6
    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        if (size <= 1) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            Integer value = queue.remove();
            stack.push(value);
            queue.add(value);
        }

        boolean result = true;

        for (int i = 0; i < size; i++) {
            Integer fromQueue = queue.remove();
            Integer fromStack = stack.pop();

            if (!fromQueue.equals(fromStack)) {
                result = false;
            }

            queue.add(fromQueue);
        }

        return result;
    }

    // Завдання 7
    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        if (size <= 1) {
            return;
        }

        for (int i = 0; i < size; i++) {
            Integer x = queue.remove();
            if (x < 0) {
                stack.push(x);
            } else {
                queue.add(x);
            }
        }

        int positiveCount = queue.size();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < positiveCount; i++) {
            queue.add(queue.remove());
        }
    }

    // Завдання 8
    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        if (size <= 1) {
            return;
        }

        for (int i = 0; i < size; i++) {
            Integer x = queue.remove();
            if (x % 2 != 0) {
                stack.push(x);
            } else {
                queue.add(x);
            }
        }

        int evenCount = queue.size();
        int oddCount = stack.size();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < evenCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < oddCount; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    // Завдання 9
    public int maxLength(Set<String> set) {
        if (set.isEmpty()) {
            return 0;
        }

        int max = 0;
        for (String s : set) {
            int len = s.length();
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    // Завдання 10
    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    // Завдання 11
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> first = new HashSet<>(list1);
        Set<Integer> second = new HashSet<>(list2);
        int count = 0;

        for (Integer value : first) {
            if (second.contains(value)) {
                count++;
            }
        }

        return count;
    }

    // Завдання 12
    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String v : map.values()) {
            if (values.contains(v)) {
                return false;
            }
            values.add(v);
        }
        return true;
    }

    // Завдання 13
    public Map<String, Integer> intersect(Map<String, Integer> map1,
                                          Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map2.containsKey(key) && value.equals(map2.get(key))) {
                result.put(key, value);
            }
        }

        return result;
    }

    // Завдання 14
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            result.put(value, key);
        }

        return result;
    }

    // Завдання 15
    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer value : map.values()) {
            Integer old = freq.get(value);
            if (old == null) {
                freq.put(value, 1);
            } else {
                freq.put(value, old + 1);
            }
        }

        int bestValue = Integer.MAX_VALUE;
        int bestCount = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int cnt = entry.getValue();

            if (cnt < bestCount || (cnt == bestCount && value < bestValue)) {
                bestCount = cnt;
                bestValue = value;
            }
        }

        return bestValue;
    }

    // Завдання 16
    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer value : list) {
            Integer old = freq.get(value);
            if (old == null) {
                freq.put(value, 1);
            } else {
                freq.put(value, old + 1);
            }
        }

        int max = 0;
        for (Integer cnt : freq.values()) {
            if (cnt > max) {
                max = cnt;
            }
        }

        return max;
    }
}
