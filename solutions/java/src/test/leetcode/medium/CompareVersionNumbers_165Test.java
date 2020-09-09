package medium;

import easy.LongestCommonPrefix_14;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CompareVersionNumbers_165Test {

  CompareVersionNumbers_165 solution = new CompareVersionNumbers_165();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("0.1", "1.1", -1),
          arguments("1.0.1", "1", 1),
          arguments("7.5.2.4", "7.5.3", -1),
          arguments("1.01", "1.001", 0),
          arguments("1.0", "1.0.0", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonPrefix(String input1, String input2, int expected) {

    int result = solution.compareVersion(input1, input2);

    assertThat(result).isEqualTo(expected);
  }
}
