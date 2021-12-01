package com.epam.tc.hw7.data;


import com.epam.tc.hw7.model.MetalsAndColors;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class InfoDataProvider {
    private static final String JSON_PATH = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "jsonData")
    public static Object[][] mapToObject() {
        Map<String, MetalsAndColors> dataFromJson = JsonParser.convertJsonToMap(JSON_PATH);
        Deque<MetalsAndColors> data = new ArrayDeque<>();
        for (Map.Entry<String, MetalsAndColors> entry : dataFromJson.entrySet()) {
            data.addLast(entry.getValue());
        }
        Object[][] dataArray = new Object[dataFromJson.size()][1];
        for (int i = 0; i < dataFromJson.size(); i++) {
            dataArray[i][0] = data.removeFirst();
        }
        return dataArray;
    }

}
