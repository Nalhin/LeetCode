package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StrobogrammaticNumberII_247Test {

  private final StrobogrammaticNumberII_247 solution = new StrobogrammaticNumberII_247();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2, List.of("11", "69", "96", "88")), arguments(1, List.of("0", "1", "8")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findStrobogrammatic(int n, List<String> expectedResult) {
    List<String> actualResult = solution.findStrobogrammatic(n);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
