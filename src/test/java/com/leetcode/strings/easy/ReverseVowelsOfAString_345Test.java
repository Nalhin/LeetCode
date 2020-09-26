package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseVowelsOfAString_345Test {

    private final ReverseVowelsOfAString_345 solution = new ReverseVowelsOfAString_345();

    private static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

            return Stream.of(
                    arguments("hello", "holle"),
                    arguments("leetcode", "leotcede"));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void reverseVowels(String input, String expectedResult) {

        String actualResult = solution.reverseVowels(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
