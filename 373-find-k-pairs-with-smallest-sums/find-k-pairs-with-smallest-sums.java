import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            
            result.add(Arrays.asList(current[0], current[1]));
            
            int nums2Idx = current[2];
            
            if (nums2Idx + 1 < nums2.length) {
                minHeap.offer(new int[]{current[0], nums2[nums2Idx + 1], nums2Idx + 1});
            }
        }
        
        return result;
    }
}