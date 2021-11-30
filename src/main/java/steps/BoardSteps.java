package steps;

import static constants.ParametersData.*;
import static constants.PropertyValues.*;

;
import static core.CommonService.*;

import beans.Board;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.net.URI;

public class BoardSteps {
    public static final URI BOARD_URL = URI.create(URL_BOARD);

    @Step("Create board")
    public String createNewBoard(Board board) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.POST)
                .setValue(NAME,board.getName());
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification())).getId();

    }

    @Step("Get board")
    public Board getBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification()));

    }

    @Step("Delete board")
    public void deleteBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.DELETE)
                .setId(boardId);
        sendRequestAndGetResponse(api, okResponseSpecification());
    }

    public Response sendRequestAndGetResponse(CommonService.CommonApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildCommonApiRequest()
                .sendRequest(BOARD_URL);
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }

    @Step("Get deleted board")
    public Response getDeletedBoard(String boardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpecification());
    }

    @Step("Update board")
    public Board modifyExistingBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardId);
        api.setValue(NAME,NEW_BOARD_NAME);
        api.setValue(DESCRIPTION,NEW_BOARD_DESCRIPTION);
        api.setValue(IS_CLOSED,NEW_ACCESS);
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification()));
    }
}
