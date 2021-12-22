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

class ReorderList_143Test {

  private final ReorderList_143.Stack solutionStack = new ReorderList_143.Stack();
  private final ReorderList_143.Reverse solutionReverse = new ReorderList_143.Reverse();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4), LinkedList.of(1, 4, 2, 3)),
          arguments(LinkedList.of(1, 2, 3, 4, 5), LinkedList.of(1, 5, 2, 4, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reorderListStack(ListNode input, ListNode expectedResult) {
    solutionStack.reorderList(input);

    assertThatLinkedList(input).isEqualTo(expectedResult);
  }


  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reorderListReverse(ListNode input, ListNode expectedResult) {
    solutionReverse.reorderList(input);

    assertThatLinkedList(input).isEqualTo(expectedResult);
  }
}
