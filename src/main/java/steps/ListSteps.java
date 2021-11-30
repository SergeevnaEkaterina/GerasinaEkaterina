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

import beans.List;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;

public class ListSteps {
    public static final URI LIST_URL = URI.create(URL_LIST);

    @Step("Create new list")
    public String createListInBoard(String boardId, List list) {
        CommonService.CommonApiBuilder apiBuilder = commonApiBuilder()
                .setMethod(Method.POST)
                .setValue(NAME, list.getName())
                .setValue(ID_BOARD, boardId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpecification()).getId();
    }

    @Step("Get list")
    public List getList(String listId) {
        CommonService.CommonApiBuilder apiBuilder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(listId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpecification());
    }

    @Step("Update list")
    public List modifyList(String listId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(listId);
        builder.setValue(NAME, NEW_LIST_NAME);
        builder.setValue(IS_CLOSED, NEW_ACCESS);
        return sendRequestAndGetResponse(builder, okResponseSpecification());
    }

    public List sendRequestAndGetResponse(CommonService.CommonApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildCommonApiRequest()
                .sendRequest(LIST_URL);
        response.then()
                .assertThat()
                .spec(resp);
        return extractListFromJsonCommon(response);
    }
}

