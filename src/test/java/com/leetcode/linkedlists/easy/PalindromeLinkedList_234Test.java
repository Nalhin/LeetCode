package com.leetcode.linkedlists.easy;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PalindromeLinkedList_234Test {

  private final PalindromeLinkedList_234 solution = new PalindromeLinkedList_234();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 2, 1), true),
          arguments(LinkedList.of(1, 2, 3, 3, 2, 1), true),
          arguments(LinkedList.of(1, 2, 3, 3, 2, 3), false),
          arguments(LinkedList.of(1, 2, 3, 3, 2), false),
          arguments(LinkedList.of(1, 2), false),
          arguments(LinkedList.empty(), true),
          arguments(LinkedList.of(1), true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPalindrome(ListNode input, boolean expectedResult) {

    boolean result = solution.isPalindrome(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
