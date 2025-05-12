package array

import kotlin.math.max
import kotlin.math.min

/**
 * 11. Container With Most Water
 * Medium
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */

fun main() {
    // Sample input array representing heights of vertical lines
    val heights = intArrayOf(7, 1, 2, 9, 2)
    // Calculate the maximum area using the maxArea function
    val result = maxArea(heights)
    // Print the result
    println("Max area: $result")
}

/**
 * Calculates the maximum area of water that can be trapped between two vertical lines.
 *
 * Given an array of non-negative integers [height], where each element represents the height of a vertical line
 * at that index, this function finds two lines that, together with the x-axis, form a container that holds
 * the maximum amount of water. The area is calculated as the minimum height of the two lines multiplied by
 * the distance between their indices.
 *
 * The algorithm uses a **two-pointer technique** to achieve O(n) time complexity:
 * - Start with two pointers: one at the beginning (`left`) and one at the end (`right`) of the array.
 * - Compute the area between the lines at these pointers.
 * - Move the pointer pointing to the shorter line inward, as the area is limited by the shorter line.
 * - Update the maximum area if the current area is larger.
 * - Continue until the pointers meet.
 *
 * @param height An array of non-negative integers representing the heights of vertical lines.
 * @return The maximum area of water that can be trapped between any two lines.
 * @throws IllegalArgumentException If the input array has fewer than 2 elements, as at least two lines are required.
 */
fun maxArea(height: IntArray): Int {
    // Validate input: ensure at least 2 lines are present
    if (height.size < 2) {
        throw IllegalArgumentException("Array must have at least 2 elements")
    }

    // Initialize variables
    var maxA = 0 // Tracks the maximum area found
    var left = 0 // Left pointer starting at the beginning
    var right = height.size - 1 // Right pointer starting at the end

    // Continue until pointers meet
    while (left < right) {
        // Calculate width as the distance between pointers
        val width = right - left
        // Height is the minimum of the two lines
        val minHeight = minOf(height[left], height[right])
        // Area = height * width
        val area = minHeight * width
        // Update maximum area if current area is larger
        maxA = maxOf(maxA, area)

        // Move the pointer of the shorter line inward
        if (height[left] < height[right]) {
            left++ // Shorter line at left, move left pointer
        } else {
            right-- // Shorter or equal line at right, move right pointer
        }
    }

    return maxA
}

