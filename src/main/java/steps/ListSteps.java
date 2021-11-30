package steps;

import static constants.PropertyValues.NEW_ACCESS;
import static constants.PropertyValues.NEW_LIST_NAME;
import static core.BaseService.okResponseSpecification;
import static core.ListService.extractListFromJson;
import static core.ListService.listApiBuilder;

import beans.List;
import core.ListService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ListSteps {
    @Step("Create new list")
    public String createListInBoard(String boardId, List list) {
        ListService.ListApiBuilder apiBuilder = listApiBuilder()
                .setMethod(Method.POST)
                .setName(list.getName())
                .setIdBoard(boardId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpecification()).getId();
    }

    @Step("Get list")
    public List getList(String listId) {
        ListService.ListApiBuilder apiBuilder = listApiBuilder()
                .setMethod(Method.GET)
                .setId(listId);
        return sendRequestAndGetResponse(apiBuilder, okResponseSpecification());
    }

    @Step("Update list")
    public List modifyList(String listId) {
        ListService.ListApiBuilder builder = listApiBuilder()
                .setMethod(Method.PUT)
                .setId(listId);
        builder.setName(NEW_LIST_NAME);
        builder.setClosed(NEW_ACCESS);
        return sendRequestAndGetResponse(builder, okResponseSpecification());
    }

    public List sendRequestAndGetResponse(ListService.ListApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildListApiRequest()
                .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return extractListFromJson(response);
    }
}

