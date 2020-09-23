package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveNthNodeFromEndOfList_19Test {

  private final RemoveNthNodeFromEndOfList_19 solution = new RemoveNthNodeFromEndOfList_19();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4), 1, LinkedList.of(1, 2, 3)),
          arguments(LinkedList.of(1, 2), 1, LinkedList.of(1)),
          arguments(LinkedList.of(1, 2), 2, LinkedList.of(2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeNthFromEnd(ListNode input, int position, ListNode expectedResult) {

    ListNode actualResult = solution.removeNthFromEnd(input, position);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
