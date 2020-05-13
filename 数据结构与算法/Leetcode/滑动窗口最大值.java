package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ywg
 * @version 1.0
 * @description 滑动窗口最大值
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * @date 2020/5/12 9:30
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        //结果数组长度即为 nums.length-k+1
        int[] res = new int[nums.length - k + 1];
        //用双端队列实现
        //deque 存放索引下标
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //删除元素面第一个
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            //滑动窗口的最后一个数小于当前数  把最后这个删除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            //向滑动窗口中添加当前元素
            deque.addLast(i);
            //队头元素即为最大值
            if (i + 1 >= k)
                res[i + 1 - k] = nums[deque.peekFirst()];
        }
        return res;
    }
}
