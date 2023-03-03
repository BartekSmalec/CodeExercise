package easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static easy.Solutions.*;
import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    @Test
    @DisplayName("Sum of two number")
    void testSumOfTwoNumber() {
        assertEquals(10, sumOfTwoNumbers(5, 5), "5 + 5 should be equal 10");
        assertNotEquals(20, sumOfTwoNumbers(10, 5), "10 + 5 should not be equal 20");
    }

    @Test
    @DisplayName("Sum multiples of three and five")
    void testSumOfMultiplesOfThreeAndFive() {
        assertEquals(33, sumOfMultiplesOfThreeAndFive(10), "Sum multiples of 3 and 5 from 1 to 10 should be 28");
        assertNotEquals(20, sumOfMultiplesOfThreeAndFive(5), "Sum multiples of 3 and 5 from 1 to 5 should not be 20");
    }

    @Test
    @DisplayName("Factorial")
    void testFactorial() {
        assertEquals(120, factorial(5), "Factorial of 5 should be 120");
        assertNotEquals(721, factorial(6), "Factorial of 6 can't be equal 721");
    }

    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @DisplayName("Factorial parameterized test")
    void testSmallDataFactorial(int value, int expected) {
        assertEquals(expected, factorial(value), "Factorial of: " + value + " should be: " + expected);
    }

    @Test
    @DisplayName("Test indexes of first occurrence")
    void testIndexOfFirstOccurrence() {
        Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22};
        assertEquals(4, search(5, list), "Index of 5 should be 5");
        assertEquals(10, search(22, list), "Index of 22 should be 11");
        assertNotEquals(9, search(5, list), "");
    }

    @Test
    @DisplayName("Reverse string")
    void testReverseString() {
        StringBuilder value = new StringBuilder("Some string");
        assertEquals("gnirts emoS", reverse(value.toString()), "Some string reversed should be equal gnirts emoS");
        assertNotEquals("string Some", reverse(value.toString()), "Some string reversed should not be equal string Some");
    }

    @Test
    void testMaximum() {
        Integer[] list = {1, 2, 3, 4, 5, 120, 7, 8, 9, 10, 22};

        assertEquals(120, maximum(list), "Maximum should be 120");
        assertNotEquals(20, maximum(list), "Maximum should not be 20");
    }

    @Test
    @DisplayName("Test average value")
    void testAverage() {
        assertEquals(0.5, average(List.of(0, 1)), "Average of [0,1] should be 0.5");
        assertEquals(55, average(List.of(100, 10)), "Average of [100,10] should be 55");
        assertEquals(20, average(List.of(20, 20, 20)), "Average of [20,20,20] should be 20");
        assertNotEquals(20, average(List.of(5, 5, 10)), "Average of [5,5,10] should not be 20");
    }


    @Test
    @DisplayName("Test upper case")
    void testUpperCase() {
        List<String> values = List.of("Ada", "Basia", "Kasia");
        List<String> expected = List.of("Ada".toUpperCase(), "Basia".toUpperCase(), "Kasia".toUpperCase());

        assertLinesMatch(expected, upperCase(values));
    }

    @Test
    void testNthOddElement() {
        List<Integer> value = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(5, getElement(value, 2), "2 odd element of list should be 5");
        assertEquals(3, getElement(value, 1), "1 odd element of list should be 3");
        assertEquals(7, getElement(value, 3), "3 odd element of list should be 7");
        assertEquals(-1, getElement(value, 11), "11 odd element of list should be -1");
        assertNotEquals(4, getElement(value, 2), "2 odd element of list should not be 4");
    }

    @Test
    @DisplayName("Test find second largest number")
    void testFindSecondLargestNumber() {
        Integer[] values = {1, 2, 322, 4, 5, 58, 7, 8, 119, 10};
        Integer[] values_two = {1, 2, 322, 4, 5, 58, 7, 222, 119, 10};
        assertEquals(119, find(values), "Second largest number of array values should be 119");
        assertEquals(222, find(values_two), "Second largest number of array values_two should be 222");
        assertNotEquals(119, find(values_two), "Second largest number of array values_two should not be 119");
    }
}