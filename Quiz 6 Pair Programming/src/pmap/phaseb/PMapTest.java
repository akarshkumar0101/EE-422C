/*
 * Phase A <studentA EID><studentB EID>
 * Phase B <studentB EID><studentA EID>
 */

package pmap.phaseb;

import org.junit.Test;

import static org.junit.Assert.*;

public class PMapTest {

    @Test
    public void testPut() {
        PMap m = new PMap();
        assertTrue(m.isEmpty());
        assertEquals(null, m.put(1, 2));
        assertEquals(1, m.size().intValue());
        assertEquals(2, m.put(1, 3).intValue());
        assertEquals(1, m.size().intValue());
    }

    @Test
    public void testGet() {
        PMap m = new PMap();
        m.put(1, 2);
        assertEquals(2, m.get(1).intValue());
        assertEquals(null, m.get(2));
    }

    @Test
    public void testSize(){
        PMap m = new PMap();
        m.put(1, 2);
        assertEquals(1, m.size().longValue());
        m.put(10, 2);
        assertEquals(2, m.size().longValue());
    }

    @Test
    public void testEmpty(){
        PMap m = new PMap();
        assertEquals(true, m.isEmpty());
        m.put(10, 2);
        assertEquals(false, m.isEmpty());
    }
    @Test
    public void testContainsKey(){
        PMap m = new PMap();
        m.put(1, 2);
        assertEquals(true, m.containsKey(1));
        assertEquals(false, m.containsKey(3));
    }

    @Test
    public void testContainsValue(){
        PMap m = new PMap();
        m.put(1, 2);
        assertEquals(true, m.containsValue(2));
        assertEquals(false, m.containsValue(1));
    }

    @Test
    public void testRemove(){
        PMap m = new PMap();
        m.put(1, 2);
        assertEquals(true, m.containsKey(1));
        m.remove(1);
        assertEquals(false, m.containsValue(1));
    }

    @Test
    public void testPutAll(){
        Integer[] keys = new Integer[]{0,1,2,3,4,5};
        Integer[] values = new Integer[]{21,21,32,53,42,53};

        PMap m = new PMap();
        m.putAll(keys,values);
        for(int i=0;i<6;i++){
            assertEquals(values[i],m.get(i));
        }
    }
    @Test
    public void testClear(){
        PMap m = new PMap();
        m.put(10, 2);
        m.put(11, 2);
        assertEquals(false, m.isEmpty());
        m.clear();
        assertEquals(true, m.isEmpty());
    }

    @Test
    public void testKeySet(){
        Integer[] keys = new Integer[]{0,1,2,3,4,5};
        Integer[] values = new Integer[]{21,21,32,53,42,53};

        PMap m = new PMap();
        m.putAll(keys,values);

        assertArrayEquals(keys, m.keySet());
    }
    @Test
    public void testValueSet(){
        Integer[] keys = new Integer[]{0,1,2,3,4,5};
        Integer[] values = new Integer[]{21,21,32,53,42,53};

        PMap m = new PMap();
        m.putAll(keys,values);

        assertArrayEquals(values, m.values());
    }

    @Test
    public void testEntrySet(){
        Integer[] keys = new Integer[]{0,1,2,3,4,5};
        Integer[] values = new Integer[]{21,21,32,53,42,53};

        PMap m = new PMap();
        m.putAll(keys,values);

        PEntry[] ans = m.entrySet();


        for(int i=0;i<ans.length;i++){
            assertEquals(keys[i],ans[i].getKey());
            assertEquals(values[i],ans[i].getValue());
        }
    }

    // TODO add more test cases to test all implemented methods
}
