package org.example;

import java.util.Arrays;

//driver
public class ArrayStats {

    // FOR-LOOP implementations
    public int maximumUsingForLoop(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int minimumUsingForLoop(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public int sumUsingForLoop(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public double averageUsingForLoop(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }

    //  STREAM API implementations
    public int maximumUsingStream(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    public int minimumUsingStream(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    public int sumUsingStream(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public double averageUsingStream(int[] nums) {
        return Arrays.stream(nums).average().getAsDouble();
    }
}


