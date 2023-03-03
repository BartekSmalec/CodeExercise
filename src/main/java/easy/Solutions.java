package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {
    public static Integer sumOfTwoNumbers(Integer i, Integer j) {
        return i + j;
    }

    public static Integer sumOfMultiplesOfThreeAndFive(Integer n) {

        return IntStream.rangeClosed(1, n)
                .filter((i) -> (i % 3 == 0) || (i % 5 == 0))
                .sum();
    }

    public static Integer factorial(Integer n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int search(Integer n, Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            if (n == list[i]) return i;
        }
        return -1;
    }

    public static String reverse(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    public static Integer maximum(Integer[] list) {
        return Arrays.stream(list).max(Integer::compareTo).get();
    }

    public static Double average(List<Integer> list) {
        return list.stream().mapToDouble(i -> i).average().getAsDouble();
    }

    public static List<String> upperCase(List<String> list) {
        return list.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
    }

    public static Integer getElement(List<Integer> value, int i) {
        List<Integer> oddNumbers = value.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
        if (i >= oddNumbers.size()) return -1;
        return oddNumbers.get(i);
    }

    public static Integer find(Integer[] arr) {
        Integer max = arr[0];
        Integer secondMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max.intValue();
                max = arr[i];
            }
        }
        int indexOdMax = Arrays.asList(arr).indexOf(max);

        for (int i = indexOdMax +1 ; i < arr.length; i++) {
            if (arr[i] > secondMax) secondMax = arr[i];
        }

        return secondMax;
    }
}
