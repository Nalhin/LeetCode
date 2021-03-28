package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReconstructOriginalDigitsFromEnglish_423Test {
  private final ReconstructOriginalDigitsFromEnglish_423 solution = new ReconstructOriginalDigitsFromEnglish_423();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("owoztneoer", "012"), arguments("fviefuro", "45"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void originalDigits(String target, String expectedResult) {
    String actualResult = solution.originalDigits(target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}