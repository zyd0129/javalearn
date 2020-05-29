package org.example.gc;

//-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintGCDateStamps

// 2 2 2 2  gc + full gc
// 2 2 3 3  gc

public class GCDemo {
    public static void main(String[] args) {
        int _1M= 1024*1024;
        byte[] a = new byte[_1M * 2];
        byte[] a1 = new byte[_1M * 2];
        byte[] a2 = new byte[_1M * 3];
        byte[] a3 = new byte[_1M * 3];


        System.out.println("hello");
    }
}

/**
 * Heap
 *  PSYoungGen      total 9216K, used 3939K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 41% used [0x00000007bf600000,0x00000007bf950c68,0x00000007bfe00000)
 *   from space 1024K, 53% used [0x00000007bfe00000,0x00000007bfe88020,0x00000007bff00000)
 *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *  ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
 *  Metaspace       used 2972K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 327K, capacity 388K, committed 512K, reserved 1048576K
 *
 *   这个 是 -XX:PrintGCDetails 产生的
 */
