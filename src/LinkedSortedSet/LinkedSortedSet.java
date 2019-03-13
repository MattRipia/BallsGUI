package LinkedSortedSet;

import java.util.Collection;
import java.util.Iterator;

public class LinkedSortedSet<E extends Comparable<E>> extends LinkedSet<E>{
    
    public LinkedSortedSet(){
        super();
    }
    
    @Override
    public boolean add(E toAdd){

        Node<E> newNode = new Node<E>(toAdd);
        Node<E> current = this.firstNode;
        
        // check for empty list
        if(this.firstNode == null){
            this.firstNode = newNode;
            this.numElements++;
            return true;
        }
        
        // check the first node
        int compare = toAdd.compareTo(current.element);
        if(compare == 0)
                return false;

        if(compare < 0)
        {
            newNode.next = this.firstNode;
            this.firstNode = newNode;
            numElements++;
            return true;
        }

        // loop over each node, checking the next node to see if the object fits in that position
        while(current != null)
        {
            // if the end is reached, add the element to the back of the linked list
            if(current.next == null){
                // add the element to the end
                current.next = newNode;
                numElements++;
                return true;
            }

            // calls the compare function to compare the element to add vs the next element
            compare = toAdd.compareTo(current.next.element);

            // if compare is less than 0, then the toAdd element is less than the next element
            // therefore we want to add it inbetween the current and next node
            if(compare <= 0)
            {
                // same element if compare returned 0
                if(compare == 0)
                    return false;

                // keeps the current.next reference
                newNode.next = current.next;
                current.next = newNode;
                numElements++;
                return true;
            }

            // move to the next node as the object was not added yet
            current = current.next;
        }

        return false;
    }
}
