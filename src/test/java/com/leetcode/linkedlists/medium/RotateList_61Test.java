package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RotateList_61Test {

  RotateList_61 solution = new RotateList_61();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), 2, LinkedList.of(4, 5, 1, 2, 3)),
          arguments(LinkedList.of(0, 1, 2), 4, LinkedList.of(2, 0, 1)),
          arguments(LinkedList.empty(), 4, LinkedList.empty()),
          arguments(LinkedList.of(1), 2, LinkedList.of(1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rotateRight(LinkedList.ListNode input, int k, LinkedList.ListNode expectedResult) {

    LinkedList.ListNode actualResult = solution.rotateRight(input, k);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
