package TwoPointers;

import java.util.Arrays;

public class Q923 {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == target) {
                    int countLeft = 1;
                    int countRight = 1;
                    while (left < right && arr[left] == arr[left+1]) {
                        countLeft++;
                        left++;
                    }
                    while (left < right && arr[right] == arr[right-1]) {
                        countRight++;
                        right--;
                    }
                    if (left == right) {

                    }
                    left++;
                    right--;
                } else if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return (int) (result%(1000000000 + 7));
    }
}
