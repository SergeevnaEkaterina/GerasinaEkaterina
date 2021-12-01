package steps;

import static constants.ParametersData.ID_BOARD;
import static constants.ParametersData.IS_CLOSED;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.NEW_ACCESS;
import static constants.PropertyValues.NEW_LIST_NAME;
import static constants.PropertyValues.URL_LIST;
import static core.CommonService.commonApiBuilder;
import static core.CommonService.extractListFromJsonCommon;
import static core.CommonService.okResponseSpecification;
import static core.CommonService.sendRequestAndGetResponse;

import beans.List;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import java.net.URI;

public class ListSteps {
    public static final URI LIST_URL = URI.create(URL_LIST);

    @Step("Create new list")
    public String createListInBoard(String boardId, List list) {
        CommonService.CommonApiBuilder apiBuilder = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, list.getName())
                .setQueryParameter(ID_BOARD, boardId);
        return extractListFromJsonCommon(sendRequestAndGetResponse(apiBuilder,
                okResponseSpecification(), LIST_URL)).getId();
    }

    @Step("Get list")
    public List getList(String listId) {
        CommonService.CommonApiBuilder apiBuilder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(listId);
        return extractListFromJsonCommon(sendRequestAndGetResponse(apiBuilder, okResponseSpecification(), LIST_URL));
    }

    @Step("Update list")
    public List modifyList(String listId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(listId);
        builder.setQueryParameter(NAME, NEW_LIST_NAME);
        builder.setQueryParameter(IS_CLOSED, NEW_ACCESS);
        return extractListFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification(), LIST_URL));
    }
}

