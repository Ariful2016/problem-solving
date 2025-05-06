package array

fun main() {
    // Define an array of integers
    val num = intArrayOf(1, 3, 7, 9, 2)

    // Call the twoSum function with the array and target value 11
    val result = twoSum(num, 11)

    // Check if a valid result (non-empty array) was returned
    if (result.isNotEmpty()) {
        // Print the indices of the two numbers that add up to the target
        println("Indices: ${result[0]}, ${result[1]}")
    } else {
        // No matching pair was found
        println("No match found")
    }
}

/**
 * Function to find two indices in the array whose values add up to the given target.
 *
 * @param num The array of integers to search within.
 * @param target The target sum we are looking for.
 * @return An IntArray containing the two indices that satisfy the condition, or an empty array if none found.
 */
fun twoSum(num: IntArray, target: Int): IntArray {
    // Create a HashMap to store numbers and their corresponding indices
    val hm = mutableMapOf<Int, Int>() // key: number, value: index

    // Iterate over the array using indices
    for (i in num.indices) {
        // Check if the target - num[i] exists in the map
        if (hm.containsKey(target - num[i])) {
            // If found, return the index of the target - num[i] and the current index
            return intArrayOf(hm[target - num[i]]!!, i)
        } else {
            // Otherwise, store the current number with its index in the map
            hm[num[i]] = i
        }
    }

    // If no such pair is found, return an empty array
    return intArrayOf()
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