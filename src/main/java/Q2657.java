import java.util.HashSet;
import java.util.Set;

public class Q2657 {
    /**
     * You are given two 0-indexed integer permutations A and B of length n.
     * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
     * Return the prefix common array of A and B.
     * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
     * 
     * Just using two sets to store the elements inside array A and array B
     * Sets can also used to find whether permutation is found in these arrays
     * Add the elements from A and B respectively
     * Check whether the elements in Set A also exist in set B, and also elements in Set B also exist in set A respectively
     * If yes, count++
     * 
     * @param A
     * @param B
     * @return
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int eleA = A[i];
            int eleB = B[i];
            if (eleA == eleB) {
                count++;
            } else {
                setA.add(eleA);
                setB.add(eleB);
                if (setA.contains(eleB)) {
                    count++;
                } 
                if (setB.contains(eleA)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
