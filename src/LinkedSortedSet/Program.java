package LinkedSortedSet;

import java.util.Iterator;
import java.util.Set;

public class Program {
    
    public static void main(String[] args){
        
        Set<Integer> set = new LinkedSortedSet<>();
        
        // adding 0 - 9 with duplicates to check order
        set.add(0);
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(-20);
        set.add(-2);
        set.add(4);
        set.add(5);
        set.add(2);
        
        Iterator it = set.iterator();
        System.out.println("Number of Elements: " + set.size());
        
        while(it.hasNext())
        {
            System.out.println(it.next() + " ");
        }
    }
}