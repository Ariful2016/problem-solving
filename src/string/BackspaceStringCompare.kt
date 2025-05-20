package string

import array.trwOptimized
import java.util.Stack

/**
 * 844. Backspace String Compare
 * Easy
 * Topics
 * Companies
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */

fun main() {
    val s1 = "ab#c"
    val s2 = "ad#c"
    val result = backspaceStringCompare(s1,s2)
    // Print the result
    println("Is same: $result")
}

/**
 * Bruteforce solution
 * Time: O(s1+s2)
 * Space: 0(s1_s2)
 */


fun backspaceStringCompare (s1: String, s2: String): Boolean{
    val str1 = buildString(s1)
    val str2 = buildString(s2)

    if (str1.size != str2.size){
        return false
    }
    while (str1.isNotEmpty()) {
        val char1 = str1.pop()
        val char2 = str2.pop()
        if (char1 != char2) {
            return false
        }
    }

    return true

}

fun buildString(s: String) : Stack<String>{
    var result = Stack<String>()

    for (i in s.indices){
        if (s[i] != '#'){
            result.push(s[i].toString())
        }else{
            if (result.isNotEmpty()) {
                result.pop()
            }
        }
    }
    return result
}