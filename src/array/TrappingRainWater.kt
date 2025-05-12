package array

/**
 * 42. Trapping Rain Water
 * Hard
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */

fun main() {
    // Sample input array representing heights of vertical lines
    val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    // Calculate the maximum area using the maxArea function
    val result = trwOptimized(height)
    // Print the result
    println("total water: $result")
}


/**
 * bruteforce solution
 * A brute-force solution is a straightforward approach to solving a problem by trying all possible options
 * and selecting the best one based on the problem's requirements.
 * It doesn’t use any shortcuts or optimizations—it simply explores every possible outcome exhaustively.
 * Time complexity: O(N*N)
 * Space complexity: O(1)
 */

fun trw(height: IntArray): Int {
    var totalWater = 0;
    for (i in height.indices) {
        var leftP = i
        var rightP = i
        var rightMax = 0
        var leftMax = 0

        while (leftP >= 0) {
            leftMax = maxOf(leftMax, height[leftP])
            leftP--
        }
        while (rightP < height.size) {
            rightMax = maxOf(rightMax, height[rightP])
            rightP++
        }
        val currentWater = minOf(leftMax, rightMax) - height[i]
        if (currentWater >= 0) {
            totalWater += currentWater
        }
    }
    return totalWater;
}

/**
 * Optimized solution
 * The two-pointer technique is a popular algorithmic strategy used to
 * reduce time complexity by using two pointers (indices) to traverse a data structure—usually an array or a string.
 */

fun trwOptimized(height: IntArray): Int {
    var totalWater = 0;
    var left = 0
    var right = height.size - 1;
    var rightMax = 0
    var leftMax = 0

    while (left < right) {
        if (height[left] <= height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left]
            } else {
                totalWater += leftMax - height[left]
            }
            left++
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right]
            } else {
                totalWater += rightMax - height[right]
            }
            right--
        }
    }
    return totalWater;
}