package easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveDuplicatesFromSortedArray_26Test {

  RemoveDuplicatesFromSortedArray_26 solution = new RemoveDuplicatesFromSortedArray_26();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {1, 1, 2}, new int[] {1, 2}, 2),
          arguments(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeArguments(int[] input, int[] transformedInput, int expected) {
    int result = solution.removeDuplicates(input);

    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(result).isEqualTo(expected);
          softly.assertThat(input).startsWith(transformedInput);
        });
  }
}
