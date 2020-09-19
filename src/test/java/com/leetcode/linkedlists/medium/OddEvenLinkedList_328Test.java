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

class OddEvenLinkedList_328Test {

  OddEvenLinkedList_328 solution = new OddEvenLinkedList_328();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), LinkedList.of(1, 3, 5, 2, 4)),
          arguments(LinkedList.of(2, 1, 3, 5, 6, 4, 7), LinkedList.of(2, 3, 6, 7, 1, 5, 4)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void oddEvenList(ListNode input, ListNode expectedResult) {

    LinkedList.ListNode actualResult = solution.oddEvenList(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
