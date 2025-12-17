package LAB4;

import java.util.Objects;

/**
 * Airplane entity for LAB4.
 * Variant 4216 -> C11 = 3 => Визначити клас літак, який складається як мінімум з 5-и полів.
 */
public final class Airplane {

    private final String tailNumber;
    private final String manufacturer;
    private final String model;
    private final int year;
    private final int capacity;
    private final int rangeKm;
    private final int maxSpeedKmh;

    /**
     * Creates an Airplane instance.
     *
     * @param tailNumber unique identifier (non-empty)
     * @param manufacturer manufacturer name (non-empty)
     * @param model model name (non-empty)
     * @param year production year
     * @param capacity passenger capacity (>= 0)
     * @param rangeKm maximum range in kilometers (>= 0)
     * @param maxSpeedKmh maximum speed in km/h (>= 0)
     */
    public Airplane(
            String tailNumber,
            String manufacturer,
            String model,
            int year,
            int capacity,
            int rangeKm,
            int maxSpeedKmh
    ) {
        if (isBlank(tailNumber)) throw new IllegalArgumentException("tailNumber is empty");
        if (isBlank(manufacturer)) throw new IllegalArgumentException("manufacturer is empty");
        if (isBlank(model)) throw new IllegalArgumentException("model is empty");
        if (capacity < 0) throw new IllegalArgumentException("capacity must be >= 0");
        if (rangeKm < 0) throw new IllegalArgumentException("rangeKm must be >= 0");
        if (maxSpeedKmh < 0) throw new IllegalArgumentException("maxSpeedKmh must be >= 0");

        this.tailNumber = tailNumber.trim();
        this.manufacturer = manufacturer.trim();
        this.model = model.trim();
        this.year = year;
        this.capacity = capacity;
        this.rangeKm = rangeKm;
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRangeKm() {
        return rangeKm;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "tailNumber='" + tailNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", capacity=" + capacity +
                ", rangeKm=" + rangeKm +
                ", maxSpeedKmh=" + maxSpeedKmh +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airplane)) return false;
        Airplane airplane = (Airplane) o;
        return year == airplane.year
                && capacity == airplane.capacity
                && rangeKm == airplane.rangeKm
                && maxSpeedKmh == airplane.maxSpeedKmh
                && tailNumber.equals(airplane.tailNumber)
                && manufacturer.equals(airplane.manufacturer)
                && model.equals(airplane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tailNumber, manufacturer, model, year, capacity, rangeKm, maxSpeedKmh);
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
