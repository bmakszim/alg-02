package recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KFactorizationTest {

    @Test
    void testCase0() {
        var result = Solution.kFactorization(12, new ArrayList<>(List.of(2, 3, 4)));
        assertIterableEquals(List.of(1, 3, 12), result);
    }

    @Test
    void testCase1() {
        var result = Solution.kFactorization(15, new ArrayList<>(List.of(2, 10, 6, 9, 11)));
        assertIterableEquals(List.of(-1), result);
    }

    @Test
    void testCase2() {
        var result = Solution.kFactorization(72, new ArrayList<>(List.of(2, 4, 6, 9, 3, 7, 16, 10, 5)));
        assertIterableEquals(List.of(1, 2, 8, 72), result);
    }
}