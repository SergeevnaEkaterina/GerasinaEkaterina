package com.epam.tc.hw7.data;

import static java.lang.String.join;

import com.epam.tc.hw7.model.MetalsAndColors;
import java.util.List;

public class ExpectedJsonInfo {

    public static List<String> formJsonInfoToList(MetalsAndColors metalsAndColors) {

        return List.of(String.format("Summary: %s", ((metalsAndColors.getSummary().get(0)
                + metalsAndColors.getSummary().get(1)))),
                String.format("Elements: %s", join(", ", metalsAndColors.getElements())),
                String.format("Color: %s", metalsAndColors.getColor()),
                String.format("Metal: %s", metalsAndColors.getMetals()),
                String.format("Vegetables: %s", join(", ", metalsAndColors.getVegetables())));
    }
}
