package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JewelsAndStones_771Test {

  private final JewelsAndStones_771 solution = new JewelsAndStones_771();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("aA", "aAAbbbb", 3), arguments("z", "ZZ", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numJewelsInStones(String jewels, String stones, int expectedResult) {

    int actualResult = solution.numJewelsInStones(jewels, stones);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
