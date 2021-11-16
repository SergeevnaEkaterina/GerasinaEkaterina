package com.epam.tc.hw7.model;

import com.epam.jdi.tools.DataClass;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetalsAndColors extends DataClass<MetalsAndColors> {
    private List<Integer> summary;
    private List<String> elements;
    private List<String> vegetables;
    private String color;
    private String metals;

}
