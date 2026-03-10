package dsa_advance;

import java.util.*;

public class Day36_TopKFrequent {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }

        System.out.println("Top K Frequent: " + pq);
    }
}