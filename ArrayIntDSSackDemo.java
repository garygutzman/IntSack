package com.abc.ds.integer;

public class ArrayIntDSSackDemo {
    private static IntDSSack createSackA() {
        IntDSSack sack = new ArrayIntDSSack();
        sack.add(15);
        sack.add(25);
        sack.add(11);
        sack.add(18);
        sack.add(25);
        return sack;
    }
    
    public static void main(String[] args) {
        IntDSSack sackA = createSackA();
        System.out.println("sackA=" + sackA);
        sackA.remove(25);
        System.out.println("sackA=" + sackA);

        System.out.println("=== sackA contents ======");
        IntDSIterator iterator = sackA.createIterator();
        while ( iterator.hasNext() ) {
           int value = iterator.next();
           System.out.println("   value=" + value);
        }
        System.out.println("=================");
        
        
        System.out.println("sackA.contains(11)=" + sackA.contains(11));
        System.out.println("sackA.contains(99)=" + sackA.contains(99));
        System.out.println("sackA.isEmpty()=" + sackA.isEmpty());
        sackA.clear();
        System.out.println("sackA.isEmpty()=" + sackA.isEmpty());
        
    }
}
