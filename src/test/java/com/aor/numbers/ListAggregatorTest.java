package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
        public void helper(){
        list = Arrays.asList(1,2,4,2);
    }
    @Test
    public void sum() {


        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(9, sum);
    }

    @Test
    public void max() {


        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);
    }

    @Test
    public void min() {


        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        class ListDeduplicatorStub implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter sorter){
                return Arrays.asList(1,2,4);
            }
        }

        class ListSorterStub implements GenericListSorter{
            public List<Integer> sort(List<Integer> list){return Arrays.asList(1,2,2,4);}
        }

        ListDeduplicatorStub deduplicator = new ListDeduplicatorStub();

        int distinct = aggregator.distinct(list,deduplicator, new ListSorterStub());

        Assertions.assertEquals(3, distinct);
    }
    @Test
    public void max_bug_7263(){
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);


    }
    @Test
    public void distinct_bug_8726() {
        ListAggregator aggregator = new ListAggregator();
        class ListDeduplicatorStub implements GenericListDeduplicator {
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter sorter) {
                return Arrays.asList(1, 2, 4);
            }
        }
        class ListSorterStub implements GenericListSorter{
            public List<Integer> sort(List<Integer> list){return Arrays.asList(1,2,2,4);}
        }
        GenericListDeduplicator deduplicator = new ListDeduplicatorStub();
        GenericListSorter sorter = new ListSorterStub();
        int distinct = aggregator.distinct(list, deduplicator,sorter);

        Assertions.assertEquals(3, distinct);
    }
}
