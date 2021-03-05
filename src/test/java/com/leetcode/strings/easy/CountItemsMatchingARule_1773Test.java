package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountItemsMatchingARule_1773Test {
  private final CountItemsMatchingARule_1773 solution = new CountItemsMatchingARule_1773();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              List.of(
                  List.of("phone", "blue", "pixel"),
                  List.of("computer", "silver", "lenovo"),
                  List.of("phone", "gold", "iphone")),
              "color",
              "silver",
              1),
          arguments(
              List.of(
                  List.of("phone", "blue", "pixel"),
                  List.of("computer", "silver", "lenovo"),
                  List.of("phone", "gold", "iphone")),
              "type",
              "phone",
              2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countMatches(
      List<List<String>> items, String ruleKey, String ruleValue, int expectedResult) {
    int actualResult = solution.countMatches(items, ruleKey, ruleValue);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
