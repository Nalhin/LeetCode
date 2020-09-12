package com.leetcode.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseString_344Test {

    ReverseString_344 solution = new ReverseString_344();

    private static class TestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

            return Stream.of(
                    arguments(new char[] {'h','e','l','l','o'}, new char[] {'o','l','l','e','h'}),
                    arguments(new char[] {'H','a','n','n','a','h'}, new char[] {'h','a','n','n','a','H'}));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(TestArgumentsProvider.class)
    void longestCommonPrefix(char[] input, char[] expectedResult) {

        solution.reverseString(input);

        assertThat(input).isEqualTo(expectedResult);
    }
}
