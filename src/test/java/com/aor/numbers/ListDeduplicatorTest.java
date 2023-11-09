package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {


    @Test
    public void deduplicate() {

        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);

        //GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        //Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        GenericListDeduplicator deduplicator=new ListDeduplicator();

        List<Integer> distinct = deduplicator.deduplicate(list, new ListSorter());

        Assertions.assertEquals(expected, distinct);
    }

}
