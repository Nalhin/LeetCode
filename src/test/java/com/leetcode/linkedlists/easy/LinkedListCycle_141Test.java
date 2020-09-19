package com.leetcode.linkedlists.easy;

import com.leetcode.utils.LinkedList.ListNode;
import com.leetcode.utils.LinkedList;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListCycle_141Test {

  LinkedListCycle_141 solution = new LinkedListCycle_141();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(3, 2, 0, -4), 1, true),
          arguments(LinkedList.of(1, 2), 0, true),
          arguments(LinkedList.of(1, 2), -1, false),
          arguments(LinkedList.empty(), -1, false),
          arguments(LinkedList.of(1), -1, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void hasCycle(ListNode input, int cycleIndex, boolean expectedResult) {

    boolean result = solution.hasCycle(LinkedList.addCycle(input, cycleIndex));

    assertThat(result).isEqualTo(expectedResult);
  }
}
