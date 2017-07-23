
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // target between [start, maximum]
            if (target > nums[end]) {
                // move towards end if only order == start, mid, target, maximum
                if (nums[mid] >= nums[end] && nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            // target between [minimum, end]
            } else {
                // move towards start if only order == minimum, target, mid, end
                if (nums[mid] <= nums[end] && nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
