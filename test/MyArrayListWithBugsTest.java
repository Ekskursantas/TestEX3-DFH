import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListWithBugsTest {

    MyArrayListWithBugs array;

    @BeforeEach
    void setUp() {
        array = new MyArrayListWithBugs();
    }

    @Test
    void TC1() {
        assertEquals(0, array.size());
        array.add(new RandomObject());
        assertEquals(1, array.size());
    }

    @Test
    void TC2() {
        array.add(new RandomObject());
        array.add(new RandomObject());
        RandomObject o2 = new RandomObject();
        array.add(o2);
        assertEquals(3, array.size());
        assertEquals(array.get(2), o2);
    }

    @Test
    void TC3() {
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(3, array.size());
        array.remove(0);
        assertEquals(2, array.size());
    }

    @Test
    void TC4() {

        // This is no problem, since it shifts every other object downwards when you remove one from the list. Therefor the object at index 1 is the previus object that was populating 2 before.

        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(3, array.size());
        array.remove(1);
        assertEquals(2, array.size());
        assertThrows(IndexOutOfBoundsException.class, ()->{array.get(1);});
    }

    @Test
    void TC5() {

        // This is a legal move. On further inspeciton, it is just inserting object at index 0 and shifts rest of the objects upwards.

        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(3, array.size());
        RandomObject o4 = new RandomObject();
        assertThrows(IndexOutOfBoundsException.class, ()->{array.add(0, o4);});
    }

    @Test
    void TC6() {

        /////////// Cannot take in indexes higher than current free spot.

        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(3, array.size());
        array.remove(2);
        RandomObject o4 = new RandomObject();
        array.add(525, o4);
        assertEquals(array.get(525), o4);


    }

    @Test
    void TC7() {
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(2, array.size());
        assertThrows(IndexOutOfBoundsException.class, ()->{array.remove(3);});

    }

    @Test
    void TC8(){
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        array.add(new RandomObject());
        assertEquals(12, array.size());

    }

    @Test
    void BoundaryTest1(){
        RandomObject o = new RandomObject();
        assertThrows(IndexOutOfBoundsException.class, ()->{array.add(-1, o);});
    }

    @Test
    void BoundaryTest2(){
        RandomObject o = new RandomObject();
        array.add(0, o);
        assertEquals(1, array.size());
    }

    @Test
    void BoundaryTest3(){

        /////////// Cannot take in indexes higher than current free spot.

        RandomObject o = new RandomObject();
        array.add(Integer.MAX_VALUE, o);
    }

    @Test
    void BoundaryTest4(){
        RandomObject o = new RandomObject();
        assertThrows(IndexOutOfBoundsException.class, ()->{array.add(Integer.MAX_VALUE+1, o);});

    }







}