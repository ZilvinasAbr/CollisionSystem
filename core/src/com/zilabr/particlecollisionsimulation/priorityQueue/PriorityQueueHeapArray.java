package com.zilabr.particlecollisionsimulation.priorityQueue;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Zilvinas on 2015-11-22.
 */

/**
 * Priority queue, implemented with a Heap, which is implemented with an array
 * @param <E> Class that is comparable for priority queue to compare its elements
 */
public class PriorityQueueHeapArray<E extends Comparable> implements PriorityQueue<E> {
    private ArrayList<E> heap;
    private int size;

    /**
     * Empty constructor
     */
    public PriorityQueueHeapArray(){
        heap = new ArrayList<E>();
        size = 0;
    }

    /**
     * Constructor with initial capacity for the ArrayList
     * @param initialCapacity initial capacity for the ArrayList
     */
    public PriorityQueueHeapArray(int initialCapacity){
        heap = new ArrayList<E>(initialCapacity);
        size = 0;
    }

    /**
     * @return true if priority queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Adds element e to the priority queue
     * @param e element to be added
     * @return true - if successful, false otherwise
     */
    public boolean add(E e){
        heap.add(e);
        balanceHeap(size);
        size++;
        return true;
    }

    /**
     * Returns and removes highest priority element
     * @return null when size==0, otherwise highest priority element
     */
    public E poll(){
        if(size == 0)
            return null;
        int currentIndex = 0;
        boolean end = false;
        //swapping highest priority element to the bottom of the heap
        while(!end){
            int left = (currentIndex+1)*2     -1;
            int right = (currentIndex+1)*2 +1 -1;

            if(left >= size && right >= size){
                end = true;
            }else if(right >= size){
                Collections.swap(heap, currentIndex, left);
                currentIndex = left;
            }else{
                int cmp = heap.get(left).compareTo(heap.get(right));

                if(cmp >= 0){ //left
                    Collections.swap(heap, currentIndex, left);
                    currentIndex = left;
                }else{ //right
                    Collections.swap(heap, currentIndex, right);
                    currentIndex = right;
                }
            }


        }//end swapping
        //swap highest priority element with the last element of the heap array
        Collections.swap(heap,currentIndex,heap.size()-1);
        //delete the last element of the heap
        if(heap.size()-1 == currentIndex){
            E removedElement = heap.remove(heap.size()-1);
            size--;
            return removedElement;
        }
        E removedElement = heap.remove(heap.size()-1);
        size--;
        //there are cases when last element is bigger than his parent, then it is necesary to balance the heap
        int parentIndex = (currentIndex-1)/2;
        int cmp = heap.get(parentIndex).compareTo(heap.get(currentIndex));
        if(cmp == -1)
            balanceHeap(currentIndex);

        return removedElement;
    }

    /**
     * Returns and doesn't remove highest priority element
     * @return null if size==0, highest priority element otherwise
     */
    public E peek(){
        if(size == 0)
            return null;
        return heap.get(0);
    }

    /**
     * Clears the priority queue
     */
    public void clear(){
        heap.clear();
        size = 0;
    }
    /**
     * Balances the heap after element insertion.
     * The element of index insertedIndex is being swapped with its children elements, if it is
     * smaller than them
     * @param insertedIndex index, at which rests added element
     */
    private void balanceHeap(int insertedIndex){
        boolean balanced = false;
        while(!balanced && insertedIndex != 0){
            int parentIndex = (insertedIndex-1)/2;
            int cmp = heap.get(parentIndex).compareTo(heap.get(insertedIndex));
            if(cmp == -1){
                Collections.swap(heap, parentIndex, insertedIndex);
                insertedIndex = parentIndex;
            }else{
                balanced = true;
            }
        }

    }
}
