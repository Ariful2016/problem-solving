package array

import kotlin.math.max
import kotlin.math.min

fun main() {
    val heights = intArrayOf(7,1,2,9,2)
    val  result = maxArea(heights)
    print("Max area: $result")
}

fun maxArea(height : IntArray) : Int{

    var maxA = 0
    var left = 0
    var right = height.size - 1

    while (left < right) {
        val width = right - left
        val minHeight = minOf(height[left], height[right])
        val area = minHeight * width
        maxA = maxOf(maxA, area)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxA
}

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