package com.leetcode.hashtable.easy;

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

class VerifyingAnAlienDictionary_953Test {

  private final VerifyingAnAlienDictionary_953 solution = new VerifyingAnAlienDictionary_953();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
          arguments(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false),
          arguments(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false),
          arguments(new String[] {"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isAlienSorted(String[] words, String order, boolean expectedResult) {
    boolean actualResult = solution.isAlienSorted(words, order);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
