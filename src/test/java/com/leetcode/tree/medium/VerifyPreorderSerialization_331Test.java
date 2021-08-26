package com.leetcode.tree.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VerifyPreorderSerialization_331Test {

  private final VerifyPreorderSerialization_331 solution = new VerifyPreorderSerialization_331();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
          arguments("1,#", false),
          arguments("9,#,#,1", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValidSerialization(String preorder, boolean expectedResult) {
    boolean actualResult = solution.isValidSerialization(preorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
