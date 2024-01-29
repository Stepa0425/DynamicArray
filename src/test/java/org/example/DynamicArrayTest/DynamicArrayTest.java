package org.example.DynamicArrayTest;

import org.example.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The class demonstrate functions of DynamicArray")
class DynamicArrayTest {
    private DynamicArray actualArray;

    @BeforeEach
    void setup() {
        actualArray = new DynamicArray(new int[]{6, 7, 8, 9});
    }

    @DisplayName("Testing size.")
    @Test
    void testSize() {
        int length = actualArray.size();
        Assertions.assertEquals(4, length);
    }

    @DisplayName("Testing execution with empty array.")
    @Test
    void testSizeReturnZeroInCaseOfEmptyArray() {
        DynamicArray dynamicArrayWithSize0 = new DynamicArray(0);
        int length = dynamicArrayWithSize0.size();
        Assertions.assertEquals(0, length);
    }

    @DisplayName("Testing size with empty array(another constructor).")
    @Test
    void testSizeReturnZeroInCaseOfEmptyArrayAnotherConstructor() {
        DynamicArray dynamicArrayWithEmptyArray0 = new DynamicArray(new int[]{});
        int lengthEmptyArray = dynamicArrayWithEmptyArray0.size();
        Assertions.assertEquals(0, lengthEmptyArray);
    }

    @DisplayName("Testing add.")
    @Test
    void testAdd() {
        int[] expectedArray = new int[]{6, 7, 8, 9, 10};
        actualArray.add(10);
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing size with empty array.")
    @Test
    void testAddReturnOneElementArray() {
        DynamicArray dynamicArrayEmpty = new DynamicArray(new int[]{});
        dynamicArrayEmpty.add(3);
        int[] expectedArrayOneElement = new int[]{3};
        Assertions.assertArrayEquals(expectedArrayOneElement, dynamicArrayEmpty.toIntArray());
    }

    @DisplayName("Testing size with empty array with another constructor.")
    @Test
    void testAddReturnAlsoOneElementArray() {
        int[] expectedArrayOneElement = new int[]{3};
        DynamicArray dynamicArraySize0 = new DynamicArray(0);
        dynamicArraySize0.add(3);
        Assertions.assertArrayEquals(expectedArrayOneElement, dynamicArraySize0.toIntArray());
    }

    @DisplayName("Testing add with an array of zeros.")
    @Test
    void testAddArrayOfZeros() {
        DynamicArray dynamicArraySize6 = new DynamicArray(6);
        dynamicArraySize6.add(3);
        int[] expectedArray7Elem = new int[]{0, 0, 0, 0, 0, 0, 3};
        Assertions.assertArrayEquals(expectedArray7Elem, dynamicArraySize6.toIntArray());
    }

    @DisplayName("Testing addAll.")
    @Test
    void testAddAllSimpleArray() {
        int[] expectedArray = new int[]{6, 7, 8, 9, 10, 11, 12, 13};
        actualArray.addAll(new int[]{10, 11, 12, 13});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing addAll with an empty array.")
    @Test
    void testAddAllEmptyArray() {
        int[] expectedArray = new int[]{6, 7, 8, 9};
        actualArray.addAll(new int[]{});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing remove.")
    @Test
    void testRemove() {
        int[] expectedArray = new int[]{6, 8, 9};
        actualArray.remove(7);
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing removeAll.")
    @Test
    void testRemoveAll() {
        int[] expectedArray = new int[]{6, 9};
        actualArray.removeAll(new int[]{7, 8});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing removeAll with an empty array.")
    @Test
    void testRemoveAllEmptyArray() {
        int[] expectedArray = new int[]{6, 7, 8, 9};
        actualArray.removeAll(new int[]{});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing removeAll with an non-existent array.")
    @Test
    void testRemoveAllNonExistentArray() {
        int[] expectedArray = new int[]{6, 7, 8, 9};
        actualArray.removeAll(new int[]{6, 7, 9});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing removeAll with the biggest array.")
    @Test
    void testRemoveAllTheBiggestArray() {
        int[] expectedArray = new int[]{6, 7, 8, 9};
        actualArray.removeAll(new int[]{6, 7, 8, 9, 10});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }

    @DisplayName("Testing removeAll with identical array.")
    @Test
    void testRemoveAllIdenticalArray() {
        int[] expectedArray = new int[]{};
        actualArray.removeAll(new int[]{6, 7, 8, 9});
        Assertions.assertArrayEquals(expectedArray, actualArray.toIntArray());
    }


    @DisplayName("Testing index of")
    @Test
    void testIndexOf() {
        int indexOf7 = 1;
        Assertions.assertEquals(indexOf7, actualArray.indexOf(7));
    }

    @DisplayName("Testing index of if array has 2 identical elements.")
    @Test
    void testIndexOfTwoIdenticalElem() {
        DynamicArray dynamicArray = new DynamicArray(new int[]{4, 5, 7, 9, 3, 7, 6, 90, 5});
        int indexOf7 = 5;
        Assertions.assertEquals(indexOf7, dynamicArray.indexOf(5));

    }


    @DisplayName("Testing index of with non-existent element. ")
    @Test
    void testIndexOfNonExistentElement() {
        int indexOf10 = -1;
        Assertions.assertEquals(indexOf10, actualArray.indexOf(10));
    }

    @DisplayName("Testing simple execution of function contains")
    @Test
    void testContains() {
        Assertions.assertTrue(actualArray.contains(7));
    }

    @DisplayName("Testing simple execution of function contains with not-founded element.")
    @Test
    void testContainsWithNotFoundElement() {
        Assertions.assertFalse(actualArray.contains(10));
    }

    @DisplayName("Testing simple execution of function reversed")
    @Test
    void testReversed() {
        int[] expectedArray = new int[]{9, 8, 7, 6};
        Assertions.assertArrayEquals(expectedArray, actualArray.reversedToInt());
    }


}
