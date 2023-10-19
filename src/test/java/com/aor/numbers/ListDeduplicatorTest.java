package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {

        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        class ListSorterStub implements GenericListSorter{
            public List<Integer> sort(List<Integer> list){return Arrays.asList(1,2,2,4);}
                }
        List<Integer> distinct = deduplicator.deduplicate(list, new ListSorterStub());

        Assertions.assertEquals(expected, distinct);
    }
}
