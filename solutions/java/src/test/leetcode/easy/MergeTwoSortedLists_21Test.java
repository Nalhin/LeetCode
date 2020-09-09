package easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeTwoSortedLists_21Test {

  MergeTwoSortedLists_21 solution = new MergeTwoSortedLists_21();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(List.of(1, 2, 4), List.of(1, 3, 4), List.of(1, 1, 2, 3, 4, 4)),
          arguments(List.of(1, 2, 4), Collections.emptyList(), List.of(1, 2, 4)),
          arguments(Collections.emptyList(), List.of(1, 2, 4), List.of(1, 2, 4)),
          arguments(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
    }
  }

  private MergeTwoSortedLists_21.ListNode initLinkedList(List<Integer> values) {
    if (values.size() == 0) {
      return null;
    }
    MergeTwoSortedLists_21.ListNode result = new MergeTwoSortedLists_21.ListNode();
    MergeTwoSortedLists_21.ListNode next = result;
    MergeTwoSortedLists_21.ListNode prev = null;
    for (int i : values) {
      next.val = i;
      next.next = new MergeTwoSortedLists_21.ListNode();
      prev = next;
      next = next.next;
    }
    prev.next = null;
    return result;
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mergeTwoLists(List<Integer> input1, List<Integer> input2, List<Integer> expected) {
    MergeTwoSortedLists_21.ListNode l1 = this.initLinkedList(input1);
    MergeTwoSortedLists_21.ListNode l2 = this.initLinkedList(input2);

    MergeTwoSortedLists_21.ListNode result = solution.mergeTwoLists(l1, l2);

    List<Integer> resultValues = new ArrayList<>();
    while (result != null) {
      resultValues.add(result.val);
      result = result.next;
    }

    assertThat(resultValues).isEqualTo(expected);
  }
}
