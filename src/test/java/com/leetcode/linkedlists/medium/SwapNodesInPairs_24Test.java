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

class SwapNodesInPairs_24Test {

  private final SwapNodesInPairs_24 solution = new SwapNodesInPairs_24();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4), LinkedList.of(2, 1, 4, 3)),
          arguments(LinkedList.of(1, 2, 3, 4, 5), LinkedList.of(2, 1, 4, 3, 5)),
          arguments(LinkedList.empty(), LinkedList.empty()),
          arguments(LinkedList.of(1), LinkedList.of(1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void swapPairs(ListNode input, ListNode expectedResult) {

    ListNode actualResult = solution.swapPairs(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
