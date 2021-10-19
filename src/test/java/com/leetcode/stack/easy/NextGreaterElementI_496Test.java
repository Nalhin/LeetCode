package com.leetcode.stack.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NextGreaterElementI_496Test {

  private final NextGreaterElementI_496 solution = new NextGreaterElementI_496();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}, new int[] {-1, 3, -1}),
          arguments(new int[] {2, 4}, new int[] {1, 2, 3, 4}, new int[] {3, -1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextGreaterElement(int[] nums1, int[] nums2, int[] expectedResult) {
    int[] actualResult = solution.nextGreaterElement(nums1, nums2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
