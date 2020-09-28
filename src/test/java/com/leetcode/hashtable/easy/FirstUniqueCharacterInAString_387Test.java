package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FirstUniqueCharacterInAString_387Test {

  private final FirstUniqueCharacterInAString_387 solution =
      new FirstUniqueCharacterInAString_387();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("leetcode", 0), arguments("loveleetcode", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void firstUniqChar(String first, int expectedResult) {

    int actualResult = solution.firstUniqChar(first);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
