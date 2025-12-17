package LAB4;

import java.util.Arrays;
import java.util.Comparator;

public class Lab4 {

    public static void main(String[] args) {
        int recordBookNumber = 4216;

        int c11 = Math.floorMod(recordBookNumber, 11); // для 4216 => 3
        int expectedVariant = 3;

        try {
            if (c11 != expectedVariant) {
                throw new IllegalStateException("This solution is written for C11=3 (Airplane). Current C11=" + c11);
            }

            Airplane[] airplanes = new Airplane[] {
                    new Airplane("UR-PSA", "Antonov", "An-148", 2010, 80, 2100, 870),
                    new Airplane("UR-BAA", "Boeing", "737-800", 2013, 189, 5436, 842),
                    new Airplane("UR-A320", "Airbus", "A320", 2012, 180, 6150, 871),
                    new Airplane("UR-EMB", "Embraer", "E190", 2015, 114, 4537, 871),
                    new Airplane("UR-CRJ", "Bombardier", "CRJ900", 2011, 90, 2956, 871),
                    new Airplane("UR-B737", "Boeing", "737-700", 2008, 140, 6230, 850)
            };

            Comparator<Airplane> byCapacityAscThenRangeDesc =
                    Comparator.comparingInt(Airplane::getCapacity)
                            .thenComparing(Comparator.comparingInt(Airplane::getRangeKm).reversed());

            System.out.println("Record book number: " + recordBookNumber);
            System.out.println("C11 = recordBook % 11 = " + c11);
            System.out.println("Class: Airplane");
            System.out.println("Sorting: capacity ASC, rangeKm DESC");
            System.out.println();

            System.out.println("Before sorting:");
            printArray(airplanes);

            Arrays.sort(airplanes, byCapacityAscThenRangeDesc);

            System.out.println();
            System.out.println("After sorting:");
            printArray(airplanes);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void printArray(Airplane[] airplanes) {
        if (airplanes == null) {
            System.out.println("(null)");
            return;
        }
        for (Airplane a : airplanes) {
            System.out.println(a);
        }
    }
}
