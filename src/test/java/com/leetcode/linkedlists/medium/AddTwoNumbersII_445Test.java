package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddTwoNumbersII_445Test {

  private final AddTwoNumbersII_445 solution = new AddTwoNumbersII_445();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(7, 2, 4, 3), LinkedList.of(5, 6, 4), LinkedList.of(7, 8, 0, 7)),
          arguments(LinkedList.empty(), LinkedList.of(1, 2), LinkedList.of(1, 2)),
          arguments(LinkedList.empty(), LinkedList.empty(), LinkedList.empty()),
          arguments(
              LinkedList.of(7, 2, 4, 3), LinkedList.of(5, 6, 4, 0), LinkedList.of(1, 2, 8, 8, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addTwoNumbers(
      LinkedList.ListNode input1, LinkedList.ListNode input2, LinkedList.ListNode expectedResult) {

    LinkedList.ListNode actualResult = solution.addTwoNumbers(input1, input2);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
