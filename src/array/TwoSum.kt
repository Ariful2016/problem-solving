package array

fun main() {
    val num = intArrayOf(1, 3, 7, 9, 2)
    val result = twoSum(num, 11)

    if (result.isNotEmpty()) {
        println("Indices: ${result[0]}, ${result[1]}")
    } else {
        println("No match found")
    }
}

fun twoSum(num: IntArray, target: Int): IntArray {
    val hm = mutableMapOf<Int, Int>() // value to index

    for (i in num.indices) {
        if (hm.containsKey( target - num[i])) {
            return intArrayOf(hm[ target - num[i]]!!, i)
        } else {
            hm[num[i]] = i
        }
    }

    return intArrayOf() // return empty array if no match
}


/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */