package com.epam.collections.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new AlphabeticReverseComparator());
        priorityQueue.addAll(firstList);
        priorityQueue.addAll(secondList);
        return priorityQueue;
    }
}

class AlphabeticReverseComparator implements Comparator<String> {
    @Override
    public int compare(String firstString, String secondString) {
        for (int i = 0; i < Math.min(firstString.length(), secondString.length()); i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                return secondString.charAt(i) - firstString.charAt(i);
            }
        }

        if (firstString.length() != secondString.length()) {
            return secondString.length() - firstString.length();
        }

        return 0;
    }
}
