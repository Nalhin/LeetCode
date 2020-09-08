import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordPattern_290Test {

  WordPattern_290 solution = new WordPattern_290();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("abba", "dog cat cat dog", true),
          arguments("abba", "dog cat cat fish", false),
          arguments("aaaa", "dog cat cat dog", false),
          arguments("abba", "dog dog dog dog", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wordPattern(String pattern, String str, boolean expected) {

    boolean actualResult = solution.wordPattern(pattern, str);

    assertThat(actualResult).isEqualTo(expected);
  }
}
