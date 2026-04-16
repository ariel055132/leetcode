package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Q760 {
    /**
     * You are given two integer arrays nums1 and nums2 where nums2 is an anagram of nums1. Both arrays may contain duplicates.
     * Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j means the ith element in nums1 appears in nums2 at index j. If there are multiple answers, return any of them.
     * An array a is an anagram of an array b means b is made by randomizing the order of the elements in a.
     * 
     * Approach 1. Use two loops for going through nums1, and nums2 respectively -> O(n^2)
     * Approach 2. Use HashMap to save the index of elements, look up each elements with hashmap -> O(n)
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], i));
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
