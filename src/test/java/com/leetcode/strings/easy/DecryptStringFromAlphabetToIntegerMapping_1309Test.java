package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecryptStringFromAlphabetToIntegerMapping_1309Test {
  private final DecryptStringFromAlphabetToIntegerMapping_1309 solution =
      new DecryptStringFromAlphabetToIntegerMapping_1309();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("10#11#12", "jkab"),
          arguments("1326#", "acz"),
          arguments("25#", "y"),
          arguments(
              "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#",
              "abcdefghijklmnopqrstuvwxyz"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void freqAlphabets(String str, String expectedResult) {
    String actualResult = solution.freqAlphabets(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
