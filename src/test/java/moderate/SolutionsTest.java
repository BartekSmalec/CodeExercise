package moderate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    Solutions solutions;

    @BeforeEach
    void beforeAll() {
        solutions = new Solutions();
    }

    @Test
    @DisplayName("Fizz buzz test")
    void fizzBuzzTest() {
        assertEquals("Fizz", solutions.fizzBuzz(3), "For 3 should return 'Fizz' ");
        assertEquals("Buzz", solutions.fizzBuzz(5), "For 5 should return 'Buzz' ");
        assertEquals("Fizz", solutions.fizzBuzz(9), "For 9 should return 'Fizz' ");
        assertEquals("FizzBuzz", solutions.fizzBuzz(15), "For 15 should return 'FizzBuzz' ");
        assertEquals("11", solutions.fizzBuzz(11), "For 11 should return 11");
        assertNotEquals("Fizz", solutions.fizzBuzz(2), "For 2 should not return 'Fizz'");

    }

    @Test
    @DisplayName("Prime numberTest")
    void primeNumberTest() {
        assertTrue(solutions.isPrime(5));
        assertTrue(solutions.isPrime(7));
        assertTrue(solutions.isPrime(2));
        assertTrue(solutions.isPrime(61));
        assertFalse(solutions.isPrime(6));
        assertFalse(solutions.isPrime(99));
        assertFalse(solutions.isPrime(70));;
    }

    @Test
    @DisplayName("Test fibonnaci number")
    void testFibonnaciNumber() {
        assertEquals(0, solutions.fibonacci(0));
        assertEquals(8, solutions.fibonacci(6));
        assertEquals(21, solutions.fibonacci(8));
        assertEquals(55, solutions.fibonacci(10));

        assertNotEquals(3,solutions.fibonacci(22));
        assertNotEquals(144,solutions.fibonacci(5));
        assertNotEquals(34,solutions.fibonacci(6));

    }

    @Test
    @DisplayName("Test if a string is palindrome")
    void testIfAStringIsPalindrome() {
        assertTrue(solutions.isPalindrome("adada"));
        assertTrue(solutions.isPalindrome("abcba"));

        assertFalse(solutions.isPalindrome("Bartek"));
        assertFalse(solutions.isPalindrome("Test"));

    }

    @Test
    @DisplayName("Test even Fibonacci sum")
    void testEvenFibonacciSum() {
        assertEquals(44, solutions.evenFibonacciSum(50));
        assertEquals(188, solutions.evenFibonacciSum(450));
        assertEquals(798, solutions.evenFibonacciSum(1000));

        assertNotEquals(312,solutions.evenFibonacciSum(22));
        assertNotEquals(567,solutions.evenFibonacciSum(1200));
        assertNotEquals(400,solutions.evenFibonacciSum(750));
    }

    @Test
    @DisplayName("Test greatest common divisor")
    void testGreatestCommonDivisor() {
        assertEquals(20, solutions.gcd(20,1000));
        assertEquals(1, solutions.gcd(7,123));
        assertEquals(5, solutions.gcd(5,55));
        assertEquals(5, solutions.gcd(15,65));
        assertEquals(4, solutions.gcd(1052,52));
    }

    @Test
    @DisplayName("Test filter strings")
    void testFilterStrings() {
        List<String> inputs = List.of("ada","Bartek","aaa","kot","Domek");
        List<String> expected = List.of("ada", "aaa");

        assertIterableEquals(expected, solutions.search(inputs));
    }

    @Test
    @DisplayName("Test comma separated")
    void testCommaSeparated() {
        assertEquals("o3,e44",solutions.getString(List.of(3,44)));
    }

    @Test
    @DisplayName("Test cipher decoder")
    void testCipherDecoder() {
        assertEquals("bartek",solutions.decode("gfwyjp"));
        assertEquals("v",solutions.decode("a"));
        assertEquals("w",solutions.decode("b"));
    }

    @Test
    @DisplayName("Test two sum")
    void testTwoSum() {
        Integer[] arr = {1,2,3};
        Integer[] arr_one = {2,4,6};
        Integer[] arr_two = {-1,4,2,1};
        assertTrue(solutions.sumsToTarget(arr,5));
        assertFalse(solutions.sumsToTarget(arr_one,5));
        assertTrue(solutions.sumsToTarget(arr_two,0));
    }
}