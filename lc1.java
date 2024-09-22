import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    // Correct the method signature and parameter names
    void twosum(int[] nums, int target, int i, int j) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                // Avoid duplicates for i and j
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;

                // Add the triplet to result
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        // If fewer than 3 elements, return empty list
        if (n < 3) {
            return new ArrayList<>();  // Return an empty list
        }

        result.clear();  // Clear the result list if it has previous values
        Arrays.sort(nums);  // Sort the array

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;  // Skip duplicates for the current number
            }

            int target = -nums[i];  // The target for twoSum becomes -nums[i]
            twosum(nums, target, i + 1, n - 1);  // Call twoSum for remaining elements
        }

        return result;  // Return the result list
    }
}
