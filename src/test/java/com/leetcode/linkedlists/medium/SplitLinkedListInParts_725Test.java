package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SplitLinkedListInParts_725Test {

  private final SplitLinkedListInParts_725 solution = new SplitLinkedListInParts_725();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              LinkedList.of(1, 2, 3),
              5,
              new ListNode[] {
                LinkedList.of(1),
                LinkedList.of(2),
                LinkedList.of(3),
                LinkedList.empty(),
                LinkedList.empty()
              }),
          arguments(
              LinkedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
              3,
              new ListNode[] {
                LinkedList.of(1, 2, 3, 4), LinkedList.of(5, 6, 7), LinkedList.of(8, 9, 10)
              }));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void splitListToParts(ListNode input, int k, ListNode[] expectedResult) {
    ListNode[] actualResult = solution.splitListToParts(input, k);

    for (int i = 0; i < expectedResult.length; i++) {
      assertThatLinkedList(actualResult[i]).isEqualTo(expectedResult[i]);
    }
  }
}
