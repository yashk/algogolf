package yashk.github.com;

import java.util.*;

/**
 * Created by ykochare on 7/28/16.
 */
public class GoogleTest {

    public static void main(String[] args) {

    }


    public static List<Integer> topKFrequent(int []nums,int k){
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // find frequency of numbers

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                map.put(num, freq + 1);
            } else {
                map.put(num, 1);
            }
        }

        // min heap to find top k

        final PriorityQueue<Pair> topKHeap = new PriorityQueue<Pair>(k);

        // populate min heap

        for (final java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (topKHeap.size() < k) {
                topKHeap.add(new Pair(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > topKHeap.peek().freq) {
                topKHeap.remove();
                topKHeap.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }



        while (topKHeap.size() > 0) {
            result.add(topKHeap.remove().num);
        }

        return result;
    }


    static class Pair implements Comparable<Pair>{
        int num;
        int freq;


        public Pair(final int num, final int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.freq, o.freq);        }
    }


    static int maxSubarraySize(int arr[], int n)
    {
        int maxCount = 0;
        int prevZero = -1;
        int prevPrevZero = -1;

        // Traverse the input array
        for (int curr=0; curr<n; ++curr)
        {
            if (arr[curr] == 0)
            {
                if (curr - prevPrevZero > maxCount)
                {
                    maxCount = curr - prevPrevZero;
                }

                prevPrevZero = prevZero;
                prevZero = curr;
            }
        }



        return maxCount+1;
    }


}
