package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumIndexSumOfTwoLists_599Test {

  private final MinimumIndexSumOfTwoLists_599 solution = new MinimumIndexSumOfTwoLists_599();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
              new String[] {
                "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
              },
              new String[] {"Shogun"}),
          arguments(
              new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
              new String[] {"KFC", "Burger King", "Tapioca Express", "Shogun"},
              new String[] {"KFC", "Burger King", "Tapioca Express", "Shogun"}),
          arguments(
              new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
              new String[] {"KFC", "Shogun", "Burger King"},
              new String[] {"Shogun"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findRestaurant(String[] first, String[] second, String[] expectedResult) {

    String[] actualResult = solution.findRestaurant(first, second);

    assertThat(actualResult).containsExactlyInAnyOrder(expectedResult);
  }
}
