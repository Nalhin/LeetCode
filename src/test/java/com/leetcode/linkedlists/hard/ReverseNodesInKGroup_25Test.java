package com.leetcode.linkedlists.hard;

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

class ReverseNodesInKGroup_25Test {
  private final ReverseNodesInKGroup_25 solution = new ReverseNodesInKGroup_25();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), 3, LinkedList.of(3, 2, 1, 4, 5)),
          arguments(LinkedList.of(1, 2, 3, 4, 5), 1, LinkedList.of(1, 2, 3, 4, 5)),
          arguments(LinkedList.of(1), 1, LinkedList.of(1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseKGroup(ListNode input, int k, ListNode expectedResult) {
    ListNode actualResult = solution.reverseKGroup(input, k);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
