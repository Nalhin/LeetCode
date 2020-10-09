package com.leetcode.linkedlists.easy;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConvertBinaryNumberInALinkedListToInteger_1290Test {
  private final ConvertBinaryNumberInALinkedListToInteger_1290 solution =
      new ConvertBinaryNumberInALinkedListToInteger_1290();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 0, 1), 5),
          arguments(LinkedList.of(0), 0),
          arguments(LinkedList.of(1), 1),
          arguments(LinkedList.of(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0), 18880),
          arguments(LinkedList.of(0, 0), 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getDecimalValue(ListNode input, int expectedResult) {
    int result = solution.getDecimalValue(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
