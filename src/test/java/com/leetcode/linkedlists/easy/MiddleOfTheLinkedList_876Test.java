package com.leetcode.linkedlists.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MiddleOfTheLinkedList_876Test {

  private final MiddleOfTheLinkedList_876 solution = new MiddleOfTheLinkedList_876();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), LinkedList.of(3, 4, 5)),
          arguments(LinkedList.of(1, 2, 3, 4, 5, 7, 6, 321, 432), LinkedList.of(5, 7, 6, 321, 432)),
          arguments(LinkedList.of(1, 2, 3, 4, 5, 6), LinkedList.of(4, 5, 6)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void middleNode(ListNode input, ListNode expectedResult) {

    ListNode result = solution.middleNode(input);

    assertThatLinkedList(result).isEqualTo(expectedResult);
  }
}
