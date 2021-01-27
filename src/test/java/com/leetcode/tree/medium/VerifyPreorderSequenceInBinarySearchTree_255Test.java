package com.leetcode.tree.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VerifyPreorderSequenceInBinarySearchTree_255Test {

  private final VerifyPreorderSequenceInBinarySearchTree_255 solution =
      new VerifyPreorderSequenceInBinarySearchTree_255();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 2, 6, 1, 3}, false), arguments(new int[] {5, 2, 1, 3, 6}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void verifyPreorder(int[] preorder, boolean expectedResult) {
    boolean actualResult = solution.verifyPreorder(preorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
