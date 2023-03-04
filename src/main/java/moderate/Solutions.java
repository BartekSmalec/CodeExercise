package moderate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solutions {
    public String fizzBuzz(Integer i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        if (i % 3 == 0) return "Fizz";
        if (i % 5 == 0) return "Buzz";
        return String.valueOf(i);
    }

    public Boolean isPrime(Integer n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public Integer fibonacci(Integer n) {
        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        for (int i = 1; i <= n; i++) {
            fib.add(fib.get(i) + fib.get(i - 1));
        }
        return fib.get(n);
    }

    public boolean isPalindrome(String word) {
        char[] array = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (array[left] != array[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public Integer evenFibonacciSum(Integer n) {
        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        for (int i = 1; i <= n; i++) {
            if ((fib.get(i) + fib.get(i - 1)) > n) break;
            fib.add(fib.get(i) + fib.get(i - 1));
        }

        return fib.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(m -> m)
                .sum();
    }

    public Integer gcd(Integer p, Integer q) {
        int smaller = p;
        if (p > q) smaller = q;

        for (int i = smaller; i > 1; i--) {
            if (p % i == 0 && q % i == 0) return i;
        }
        return 1;
    }

    public Boolean packageRice(Integer big, Integer small, Integer goal) {
        boolean result = false;
        if (big * 5 >= goal) {
            if (small >= goal % 5)
                result = true;
        } else {
            if (small >= goal - big * 5) {
                result = true;
            }
        }
        return result;
    }

    public List<String> search(List<String> list) {
        return list.stream()
                .filter(str -> str.length() == 3 && str.startsWith("a"))
                .collect(Collectors.toList());
    }

    public String getString(List<Integer> list) {
        return list.stream()
                .map(num -> {
                    if (num % 2 == 0) {
                        return "e" + num;
                    } else {
                        return "o" + num;
                    }
                })
                .collect(Collectors.joining(","));
    }


    public static String decode(String code) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        char[] charCode = code.toCharArray();
        char[] message = new char[code.length()];

        for (int i = 0; i < code.length(); i++) {
            int index = findIndex(alphabet, charCode[i]);
            int newIndex = index - 5 < 0 ? index - 5 + 26 : index - 5;
            message[i] = alphabet[newIndex];
        }

        return new String(message);
    }

    private static int findIndex(char[] chars, char c) {
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) return i;
        }
        return -1;
    }


    public Boolean sumsToTarget(Integer[] arr, Integer target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if(map.containsKey(complement)) return true;
            map.put(arr[i], i);
        }

        return false;
    }
}
