import java.util.Arrays;

public class Q3024 {
    public String triangleType(int[] nums) {
        // Edge Case: If nums is null, just return null (cannot form triangle)
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        int side1 = nums[0];
        int side2 = nums[1];
        int side3 = nums[2];
        if (side1 + side2 <= side3) {
            // Case 1: If sum of length of side1 and side2 < side3, that means cannot form a triangle
            return "none";
        } else if (side1 == side2 && side2 == side3) {
            // Case 2: All sides are equal -> return equilateral
            return "equilateral";
        } else if ((side1 == side2) && (side2 != side3)) {
            // Case 3: Two sides have equal length -> return isosceles
            return "isosceles";
        } else if ((side2 == side3) && (side1 != side3)) {
            // Case 3: Two sides have equal length -> return isosceles
            return "isosceles";
        }
        // Case 4: Other case, all sides are not equal to each other -> return scalene
        return "scalene";
    }
}
