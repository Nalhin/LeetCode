package com.leetcode.bitmanipulation.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOf1Bits_191Test {

    private final NumberOf1Bits_191 solution = new NumberOf1Bits_191();

    private static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(arguments(11, 3), arguments(128, 1), arguments(-3, 31));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void hammingWeight(int input, int expectedResult) {

        int actualResult = solution.hammingWeight(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
