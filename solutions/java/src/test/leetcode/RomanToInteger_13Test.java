import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RomanToInteger_13Test {

  RomanToInteger_13 solution = new RomanToInteger_13();

  public static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("III", 3),
          arguments("IV", 4),
          arguments("IX", 9),
          arguments("LVIII", 58),
          arguments("MCMXCIV", 1994));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void romanToInt(String input, int expected) {
    int result = solution.romanToInt(input);

    assertThat(result).isEqualTo(expected);
  }
}
