package com.epam.tc.hw5.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Values {
    public static final List<String> LOGS = List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
            "Wind: condition changed to true", "Water: condition changed to true");
    public static final Map<String, Integer> CHECKBOXES = new HashMap<>() {{
            put("Water", 0);
            put("Earth", 1);
            put("Wind", 2);
            put("Fire", 3);
        }};
    public static final Map<String, Integer> RADIO_BUTTONS = new HashMap<>() {{
            put("Gold", 0);
            put("Silver", 1);
            put("Bronze", 2);
            put("Selen", 3);
        }};
    public static final Map<String, Integer> DROPDOWNS = new HashMap<>() {{
            put("Red", 0);
            put("Green", 1);
            put("Blue", 2);
            put("Yellow", 3);
        }};
}
