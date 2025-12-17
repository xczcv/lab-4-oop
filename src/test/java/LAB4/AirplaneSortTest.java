package LAB4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneSortTest {

    @Test
    void variant4216_c11_is3() {
        int recordBookNumber = 4216;
        int c11 = Math.floorMod(recordBookNumber, 11);
        assertEquals(3, c11);
    }

    @Test
    void sort_capacityAsc_then_rangeDesc() {
        Airplane a1 = new Airplane("A1", "M1", "X", 2010, 100, 3000, 800);
        Airplane a2 = new Airplane("A2", "M1", "X", 2010, 100, 5000, 800);
        Airplane a3 = new Airplane("A3", "M1", "X", 2010, 80,  2000, 800);
        Airplane a4 = new Airplane("A4", "M1", "X", 2010, 120, 1000, 800);

        Airplane[] arr = new Airplane[] { a1, a2, a3, a4 };

        Comparator<Airplane> comp =
                Comparator.comparingInt(Airplane::getCapacity)
                        .thenComparing(Comparator.comparingInt(Airplane::getRangeKm).reversed());
        Arrays.sort(arr, comp);
        assertEquals("A3", arr[0].getTailNumber());
        assertEquals("A2", arr[1].getTailNumber());
        assertEquals("A1", arr[2].getTailNumber());
        assertEquals("A4", arr[3].getTailNumber());
    }

    @Test
    void constructor_validation_works() {
        assertThrows(IllegalArgumentException.class,
                () -> new Airplane("  ", "Boeing", "737", 2010, 10, 1000, 800));
        assertThrows(IllegalArgumentException.class,
                () -> new Airplane("X1", "Boeing", "737", 2010, -1, 1000, 800));
    }
}
