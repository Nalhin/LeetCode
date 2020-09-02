import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ImplementStrStr_28Test {

//  ImplementStrStr_28 solution = new ImplementStrStr_28();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("hello", "ll", 2),
          arguments("aaaaaa", "bba", -1),
          arguments("a", "", 0),
          arguments("a", "a", 0),
          arguments("", "a", -1),
          arguments("mississippi", "a", -1),
          arguments("mississippi", "issip", 4),
          arguments("", "", 0));
    }
  }

  //TODO
//  @ParameterizedTest
//  @ArgumentsSource(TestArgumentsProvider.class)
//  void removeArguments(String haystack, String needle, int expected) {
//    int result = solution.strStr(haystack, needle);
//
//    assertThat(result).isEqualTo(expected);
//  }
}
