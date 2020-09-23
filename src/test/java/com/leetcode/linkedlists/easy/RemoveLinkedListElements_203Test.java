package com.leetcode.linkedlists.easy;

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

class RemoveLinkedListElements_203Test {

  private final RemoveLinkedListElements_203 solution = new RemoveLinkedListElements_203();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(3, 2, 1, 3, 4, 5, 1, 1), 1, LinkedList.of(3, 2, 3, 4, 5)),
          arguments(LinkedList.of(1), 1, LinkedList.empty()),
          arguments(LinkedList.of(1, 2, 3, 4, 5, 6), 6, LinkedList.of(1, 2, 3, 4, 5)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeElements(ListNode head, int val, ListNode expectedResult) {

    ListNode result = solution.removeElements(head, val);

    assertThatLinkedList(result).isEqualTo(expectedResult);
  }
}
