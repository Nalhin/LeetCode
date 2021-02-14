package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PrintWordsVertically_1324Test {

  private final PrintWordsVertically_1324 solution = new PrintWordsVertically_1324();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("HOW ARE YOU", List.of("HAY", "ORO", "WEU")),
          arguments("TO BE OR NOT TO BE", List.of("TBONTB", "OEROOE", "   T")),
          arguments("CONTEST IS COMING", List.of("CIC", "OSO", "N M", "T I", "E N", "S G", "T")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void printVertically(String s, List<String> expectedResult) {
    List<String> actualResult = solution.printVertically(s);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
