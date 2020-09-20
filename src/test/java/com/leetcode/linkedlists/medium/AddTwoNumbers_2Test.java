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

class AddTwoNumbers_2Test {

  AddTwoNumbers_2 solution = new AddTwoNumbers_2();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(2, 4, 3), LinkedList.of(5, 6, 4), LinkedList.of(7, 0, 8)),
          arguments(
              LinkedList.of(9, 9, 9, 8, 9, 9, 9, 9),
              LinkedList.of(5, 6, 4, 4, 4),
              LinkedList.of(4, 6, 4, 3, 4, 0, 0, 0, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addTwoNumbers(ListNode input1, ListNode input2, ListNode expectedResult) {

    ListNode actualResult = solution.addTwoNumbers(input1, input2);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
