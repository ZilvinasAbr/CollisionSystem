package com.zilabr.particlecollisionsimulation.priorityQueue;

/**
 * Created by Zilvinas on 2015-11-20.
 */
public interface PriorityQueue<E> {

    /**
     * @return true if priority queue is empty, false if not
     */
    boolean isEmpty();

    /**
     * Adds e to the priority queue
     * @param e
     * @return true, if insertion was successful, otherwise false
     */
    boolean add(E e);

    /**
     * Returns element with the biggest priority and deletes it
     * @return biggest priority element
     */
    E poll();

    /**
     * Returns element with the biggest priority and doesn't delete it
     * @return biggest priority element
     */
    E peek();

    /**
     * Removes all the elements from the priority queue
     */
    void clear();
}
