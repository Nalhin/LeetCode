package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DIStringMatch_942Test {

  private final DIStringMatch_942 solution = new DIStringMatch_942();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("IDID", new int[] {2, 3, 1, 4, 0}),
          arguments("III", new int[] {0, 1, 2, 3}),
          arguments("DDI", new int[] {2, 1, 0, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void diStringMatch(String address, int[] expectedResult) {
    int[] actualResult = solution.diStringMatch(address);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
