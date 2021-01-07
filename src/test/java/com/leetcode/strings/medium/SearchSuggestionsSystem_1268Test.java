package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchSuggestionsSystem_1268Test {

  private final SearchSuggestionsSystem_1268 solution = new SearchSuggestionsSystem_1268();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"mobile", "mouse", "moneypot", "monitor", "mousepad"},
              "mouse",
              List.of(
                  List.of("mobile", "moneypot", "monitor"),
                  List.of("mobile", "moneypot", "monitor"),
                  List.of("mouse", "mousepad"),
                  List.of("mouse", "mousepad"),
                  List.of("mouse", "mousepad"))),
          arguments(
              new String[] {"havana"},
              "havana",
              List.of(
                  List.of("havana"),
                  List.of("havana"),
                  List.of("havana"),
                  List.of("havana"),
                  List.of("havana"),
                  List.of("havana"))),
          arguments(
              new String[] {"bags", "baggage", "banner", "box", "cloths"},
              "bags",
              List.of(
                  List.of("baggage", "bags", "banner"),
                  List.of("baggage", "bags", "banner"),
                  List.of("baggage", "bags"),
                  List.of("bags"))),
          arguments(
              new String[] {"havana"},
              "tatiana",
              List.of(
                  Collections.emptyList(),
                  Collections.emptyList(),
                  Collections.emptyList(),
                  Collections.emptyList(),
                  Collections.emptyList(),
                  Collections.emptyList(),
                  Collections.emptyList())));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void suggestedProducts(String[] products, String search, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.suggestedProducts(products, search);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
