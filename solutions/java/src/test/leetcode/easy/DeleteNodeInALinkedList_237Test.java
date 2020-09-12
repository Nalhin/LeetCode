package easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import utils.LinkedList;
import utils.LinkedList.ListNode;

import java.util.stream.Stream;

import static assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static utils.LinkedList.findFirstOccurrence;

class DeleteNodeInALinkedList_237Test {

  DeleteNodeInALinkedList_237 solution = new DeleteNodeInALinkedList_237();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(1,2,3,4), 3, LinkedList.of(1, 2, 4)),
          arguments(LinkedList.of(0, 1), 0, LinkedList.of(1)),
          arguments(LinkedList.of(-3, 5, -99), -3, LinkedList.of(5, -99)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void deleteNode(ListNode input, int val, ListNode expectedResult) {
    ListNode node = findFirstOccurrence(input, val);

    solution.deleteNode(node);

    assertThatLinkedList(input).isEqualTo(expectedResult);
  }
}
