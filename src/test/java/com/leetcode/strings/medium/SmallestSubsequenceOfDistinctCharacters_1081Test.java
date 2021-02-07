package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmallestSubsequenceOfDistinctCharacters_1081Test {

    private final SmallestSubsequenceOfDistinctCharacters_1081 solution =
            new SmallestSubsequenceOfDistinctCharacters_1081();

    private static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(arguments("bcabc", "abc"), arguments("cbacdcbc", "acdb"));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void smallestSubsequence(String str, String expectedResult) {
        String actualResult = solution.smallestSubsequence(str);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}