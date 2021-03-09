package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StrobogrammaticNumber_246Test {
  private final StrobogrammaticNumber_246 solution = new StrobogrammaticNumber_246();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("69", true),
          arguments("88", true),
          arguments("962", false),
          arguments("1", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isStrobogrammatic(String num, boolean expectedResult) {
    boolean actualResult = solution.isStrobogrammatic(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
