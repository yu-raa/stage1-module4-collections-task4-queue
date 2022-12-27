package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();
        integerArrayDeque.add(firstQueue.remove());
        integerArrayDeque.add(firstQueue.remove());
        integerArrayDeque.add(secondQueue.remove());
        integerArrayDeque.add(secondQueue.remove());
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            firstQueue.add(integerArrayDeque.removeLast());
            try {
                integerArrayDeque.add(firstQueue.remove());
                integerArrayDeque.add(firstQueue.remove());
            }
            catch (NoSuchElementException e) {
                Logger logger = Logger.getGlobal();
                logger.info(e.getMessage());
            }

            secondQueue.add(integerArrayDeque.removeLast());
            try {
                integerArrayDeque.add(secondQueue.remove());
                integerArrayDeque.add(secondQueue.remove());
            }
            catch (NoSuchElementException e) {
                Logger logger = Logger.getGlobal();
                logger.info(e.getMessage());
            }
        }

        return integerArrayDeque;
    }
}
