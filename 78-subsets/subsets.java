import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void findSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 1. Pick Condition:
        current.add(nums[index]);
        findSubsets(index + 1, nums, current, result);

        // Backtrack:
        current.remove(current.size() - 1);

        // 2. Skip Condition: 
        findSubsets(index + 1, nums, current, result);
    }
}
