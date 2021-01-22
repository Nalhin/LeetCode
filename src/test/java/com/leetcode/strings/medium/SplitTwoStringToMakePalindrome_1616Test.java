package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SplitTwoStringToMakePalindrome_1616Test {
  private final SplitTwoStringToMakePalindrome_1616 solution =
      new SplitTwoStringToMakePalindrome_1616();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("x", "y", true),
          arguments("abdef", "fecab", true),
          arguments("ulacfd", "jizalu", true),
          arguments("xbdef", "xecab", false),
          arguments(
              "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",
              "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea",
              true),
          arguments("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkPalindromeFormation(String a, String b, boolean expectedResult) {
    boolean actualResult = solution.checkPalindromeFormation(a, b);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
