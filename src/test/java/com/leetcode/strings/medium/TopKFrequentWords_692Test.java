package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TopKFrequentWords_692Test {

  private final TopKFrequentWords_692 solution = new TopKFrequentWords_692();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[]{"i","love","leetcode","i","love","coding"}, 2, List.of("i", "love")),
          arguments(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4, List.of("the", "is", "sunny", "day"))
      );
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void topKFrequent(String[] words, int k, List<String> expectedResult) {
    List<String> actualResult = solution.topKFrequent(words, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

}