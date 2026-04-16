package HashTable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Q760_test {

    private final Q760 q760 = new Q760();

    // Validates correctness: nums2[mapping[i]] == nums1[i] for all i
    private void assertValidMapping(int[] nums1, int[] nums2, int[] mapping) {
        assertEquals(nums1.length, mapping.length);
        for (int i = 0; i < nums1.length; i++) {
            assertEquals(nums1[i], nums2[mapping[i]],
                "mapping[" + i + "]=" + mapping[i] + " but nums2[" + mapping[i] + "]=" + nums2[mapping[i]] + " != nums1[" + i + "]=" + nums1[i]);
        }
    }

    @Test
    @DisplayName("Basic example - no duplicates")
    void testBasic() {
        int[] nums1 = {12, 28, 46, 32, 50};
        int[] nums2 = {50, 12, 32, 46, 28};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("Single element")
    void testSingleElement() {
        int[] nums1 = {5};
        int[] nums2 = {5};
        assertArrayEquals(new int[]{0}, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("Already same order")
    void testSameOrder() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("Reversed order")
    void testReversed() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("All elements identical (all duplicates)")
    void testAllSame() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("With duplicates - multiple valid answers exist")
    void testWithDuplicates() {
        // nums2[mapping[i]] == nums1[i] is the only constraint
        int[] nums1 = {1, 2, 1};
        int[] nums2 = {1, 1, 2};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("Two elements swapped")
    void testTwoElements() {
        int[] nums1 = {7, 3};
        int[] nums2 = {3, 7};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }

    @Test
    @DisplayName("Duplicates appear more than twice")
    void testMultiDuplicates() {
        int[] nums1 = {4, 1, 4, 1, 4};
        int[] nums2 = {4, 4, 1, 1, 4};
        assertValidMapping(nums1, nums2, q760.anagramMappings(nums1, nums2));
    }
}
