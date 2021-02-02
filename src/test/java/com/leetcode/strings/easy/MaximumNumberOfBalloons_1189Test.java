package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumNumberOfBalloons_1189Test {

  private final MaximumNumberOfBalloons_1189 solution = new MaximumNumberOfBalloons_1189();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("nlaebolko", 1), arguments("loonbalxballpoon", 2), arguments("leetcode", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxNumberOfBalloons(String str, int expectedResult) {
    int actualResult = solution.maxNumberOfBalloons(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
