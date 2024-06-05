package com.backspace.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Each box can hold a specific set of unit.
 * Truck size is the maximum number of boxes it can hold
 * With the given box:unit combination, we need to identify the maximum units(box*unit)
 * which can be shipped
 */
public class ShipMaxUnits {
    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        List<BoxUnitCombo<Long, Long>> totalProducts = new ArrayList<>();
        for(int i=0;i<boxes.size();i++) {
            totalProducts.add(new BoxUnitCombo<>(boxes.get(i), unitsPerBox.get(i)));
        }

        totalProducts.sort((p1, p2) -> Long.compare(p2.second, p1.second));

        long totalUnits = 0;

        for(BoxUnitCombo<Long, Long> product: totalProducts) {
            // My Solution
            /*long countOfBoxes = product.first;
            long boxUnit = product.second;

            if(truckSize < countOfBoxes) {
                totalUnits += truckSize * boxUnit;
                break;
            } else {
                totalUnits += countOfBoxes * boxUnit;
                truckSize -= boxUnit;
            }*/

            // Suggested Solution
            long boxesToLoad = Math.min(product.first, truckSize);
            totalUnits += boxesToLoad*product.second;
            truckSize -= boxesToLoad;

            if(truckSize <= 0)
                break;
        }
        return totalUnits;
    }

    record BoxUnitCombo<X, Y>(X first, Y second) {}

    public static void main(String[] args) {
        List<Long> boxes = Arrays.asList(3L, 1L, 6L);
        List<Long> unitsPerBox = Arrays.asList(2L, 7L, 4L);
        long truckSize = 6;

        System.out.println(getMaxUnits(boxes, unitsPerBox, truckSize));
    }
}
