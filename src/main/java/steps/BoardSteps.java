package steps;

import static constants.ParametersData.DESCRIPTION;
import static constants.ParametersData.IS_CLOSED;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.NEW_ACCESS;
import static constants.PropertyValues.NEW_BOARD_DESCRIPTION;
import static constants.PropertyValues.NEW_BOARD_NAME;
import static constants.PropertyValues.URL_BOARD;
import static core.CommonService.commonApiBuilder;
import static core.CommonService.extractBoardFromJsonCommon;
import static core.CommonService.notFoundResponseSpecification;
import static core.CommonService.okResponseSpecification;
import static core.CommonService.sendRequestAndGetResponse;

import beans.Board;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;

public class BoardSteps {
    public static final URI BOARD_URL = URI.create(URL_BOARD);

    @Step("Create board")
    public String createNewBoard(Board board) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, board.getName());
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification(), BOARD_URL)).getId();
    }

    @Step("Get board")
    public Board getBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification(), BOARD_URL));
    }

    @Step("Delete board")
    public void deleteBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.DELETE)
                .setId(boardId);
        sendRequestAndGetResponse(api, okResponseSpecification(), BOARD_URL);
    }

    @Step("Get deleted board")
    public Response getDeletedBoard(String boardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpecification(), BOARD_URL);
    }

    @Step("Update board")
    public Board modifyExistingBoard(String boardId) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardId);
        api.setQueryParameter(NAME, NEW_BOARD_NAME);
        api.setQueryParameter(DESCRIPTION, NEW_BOARD_DESCRIPTION);
        api.setQueryParameter(IS_CLOSED, NEW_ACCESS);
        return extractBoardFromJsonCommon(sendRequestAndGetResponse(api, okResponseSpecification(), BOARD_URL));
    }
}
