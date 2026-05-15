package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

//tests
public class ArrayStatsTest {

    private ArrayStats stats;

    @BeforeEach
    void setUp() {
        stats = new ArrayStats();
    }

    //  Shared test arrays
    private final int[] typical = {3, 1, 4, 1, 5, 9, 2, 6};   // mixed values
    private final int[] allSame = {7, 7, 7, 7};               // all identical
    private final int[] single = {42};                        // single element
    private final int[] negatives = {-5, -1, -8, -3};         // all negative
    private final int[] mixed = {-10, 0, 10, -20, 20};        // negative + zero + positive
    private final int[] twoElems = {100, 200};                // two elements


    //MAXIMUM – for loop
    @Test void testMaxForLoop_typical()   { assertEquals(9, stats.maximumUsingForLoop(typical)); }
    @Test void testMaxForLoop_allSame()   { assertEquals(7, stats.maximumUsingForLoop(allSame)); }
    @Test void testMaxForLoop_single()    { assertEquals(42, stats.maximumUsingForLoop(single)); }
    @Test void testMaxForLoop_negatives() { assertEquals(-1, stats.maximumUsingForLoop(negatives)); }
    @Test void testMaxForLoop_mixed()     { assertEquals(20, stats.maximumUsingForLoop(mixed)); }


    //MINIMUM – for loop
    @Test void testMinForLoop_typical()   { assertEquals(1, stats.minimumUsingForLoop(typical)); }
    @Test void testMinForLoop_allSame()   { assertEquals(7, stats.minimumUsingForLoop(allSame)); }
    @Test void testMinForLoop_single()    { assertEquals(42, stats.minimumUsingForLoop(single)); }
    @Test void testMinForLoop_negatives() { assertEquals(-8, stats.minimumUsingForLoop(negatives)); }
    @Test void testMinForLoop_mixed()     { assertEquals(-20, stats.minimumUsingForLoop(mixed)); }


    //SUM – for loop
    @Test void testSumForLoop_typical()   { assertEquals(31, stats.sumUsingForLoop(typical)); }
    @Test void testSumForLoop_allSame()   { assertEquals(28, stats.sumUsingForLoop(allSame)); }
    @Test void testSumForLoop_single()    { assertEquals(42, stats.sumUsingForLoop(single)); }
    @Test void testSumForLoop_negatives() { assertEquals(-17, stats.sumUsingForLoop(negatives)); }
    @Test void testSumForLoop_mixed()     { assertEquals(0, stats.sumUsingForLoop(mixed)); }
    @Test void testSumForLoop_twoElems()  { assertEquals(300, stats.sumUsingForLoop(twoElems)); }


    //AVERAGE – for loop
    @Test void testAvgForLoop_typical()   { assertEquals(31.0 / 8,  stats.averageUsingForLoop(typical), 1e-9); }
    @Test void testAvgForLoop_allSame()   { assertEquals(7.0, stats.averageUsingForLoop(allSame), 1e-9); }
    @Test void testAvgForLoop_single()    { assertEquals(42.0, stats.averageUsingForLoop(single), 1e-9); }
    @Test void testAvgForLoop_negatives() { assertEquals(-17.0 / 4,  stats.averageUsingForLoop(negatives), 1e-9); }
    @Test void testAvgForLoop_mixed()     { assertEquals(0.0, stats.averageUsingForLoop(mixed), 1e-9); }
    @Test void testAvgForLoop_twoElems()  { assertEquals(150.0, stats.averageUsingForLoop(twoElems), 1e-9); }


    //MAXIMUM – stream
    @Test void testMaxStream_typical()    { assertEquals(9, stats.maximumUsingStream(typical)); }
    @Test void testMaxStream_allSame()    { assertEquals(7, stats.maximumUsingStream(allSame)); }
    @Test void testMaxStream_single()     { assertEquals(42, stats.maximumUsingStream(single)); }
    @Test void testMaxStream_negatives()  { assertEquals(-1, stats.maximumUsingStream(negatives)); }
    @Test void testMaxStream_mixed()      { assertEquals(20, stats.maximumUsingStream(mixed)); }


    //MINIMUM – stream
    @Test void testMinStream_typical()    { assertEquals(1, stats.minimumUsingStream(typical)); }
    @Test void testMinStream_allSame()    { assertEquals(7, stats.minimumUsingStream(allSame)); }
    @Test void testMinStream_single()     { assertEquals(42, stats.minimumUsingStream(single)); }
    @Test void testMinStream_negatives()  { assertEquals(-8, stats.minimumUsingStream(negatives)); }
    @Test void testMinStream_mixed()      { assertEquals(-20, stats.minimumUsingStream(mixed)); }


    //SUM – stream
    @Test void testSumStream_typical()    { assertEquals(31, stats.sumUsingStream(typical)); }
    @Test void testSumStream_allSame()    { assertEquals(28, stats.sumUsingStream(allSame)); }
    @Test void testSumStream_single()     { assertEquals(42, stats.sumUsingStream(single)); }
    @Test void testSumStream_negatives()  { assertEquals(-17, stats.sumUsingStream(negatives)); }
    @Test void testSumStream_mixed()      { assertEquals(0, stats.sumUsingStream(mixed)); }
    @Test void testSumStream_twoElems()   { assertEquals(300, stats.sumUsingStream(twoElems)); }


    //AVERAGE – stream
    @Test void testAvgStream_typical()    { assertEquals(31.0 / 8, stats.averageUsingStream(typical), 1e-9); }
    @Test void testAvgStream_allSame()    { assertEquals(7.0, stats.averageUsingStream(allSame), 1e-9); }
    @Test void testAvgStream_single()     { assertEquals(42.0, stats.averageUsingStream(single), 1e-9); }
    @Test void testAvgStream_negatives()  { assertEquals(-17.0 / 4, stats.averageUsingStream(negatives), 1e-9); }
    @Test void testAvgStream_mixed()      { assertEquals(0.0, stats.averageUsingStream(mixed), 1e-9); }
    @Test void testAvgStream_twoElems()   { assertEquals(150.0, stats.averageUsingStream(twoElems), 1e-9); }


    //Cross-checks; for-loop and stream agree
    @Test
    void testForLoopAndStreamAgree_max() {
        int[] arr = {15, -3, 99, 0, 42, -100};
        assertEquals(stats.maximumUsingForLoop(arr), stats.maximumUsingStream(arr));
    }

    @Test
    void testForLoopAndStreamAgree_min() {
        int[] arr = {15, -3, 99, 0, 42, -100};
        assertEquals(stats.minimumUsingForLoop(arr), stats.minimumUsingStream(arr));
    }

    @Test
    void testForLoopAndStreamAgree_sum() {
        int[] arr = {15, -3, 99, 0, 42, -100};
        assertEquals(stats.sumUsingForLoop(arr), stats.sumUsingStream(arr));
    }

    @Test
    void testForLoopAndStreamAgree_average() {
        int[] arr = {15, -3, 99, 0, 42, -100};
        assertEquals(stats.averageUsingForLoop(arr), stats.averageUsingStream(arr), 1e-9);
    }
}
