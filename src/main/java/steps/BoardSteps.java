package steps;

import static constants.PropertyValues.NEW_ACCESS;
import static constants.PropertyValues.NEW_BOARD_DESCRIPTION;
import static constants.PropertyValues.NEW_BOARD_NAME;
import static core.BaseService.notFoundResponseSpecification;
import static core.BaseService.okResponseSpecification;
import static core.BoardService.boardApiBuilder;
import static core.BoardService.extractBoardFromJson;

import beans.Board;
import core.BoardService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class BoardSteps {
    @Step("Create board")
    public String createNewBoard(Board board) {
        BoardService.BoardApiBuilder api = boardApiBuilder()
                .setMethod(Method.POST)
                .setName(board.getName());
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpecification())).getId();

    }

    @Step("Get board")
    public Board getBoard(String boardId) {
        BoardService.BoardApiBuilder api = boardApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpecification()));

    }

    @Step("Delete board")
    public void deleteBoard(String boardId) {
        BoardService.BoardApiBuilder api = boardApiBuilder()
                .setMethod(Method.DELETE)
                .setId(boardId);
        sendRequestAndGetResponse(api, okResponseSpecification());
    }

    public Response sendRequestAndGetResponse(BoardService.BoardApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildBoardApiRequest()
                .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }

    @Step("Get deleted board")
    public Response getDeletedBoard(String boardId) {
        BoardService.BoardApiBuilder builder = boardApiBuilder()
                .setMethod(Method.GET)
                .setId(boardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpecification());
    }

    @Step("Update board")
    public Board modifyExistingBoard(String boardId) {
        BoardService.BoardApiBuilder api = boardApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardId);
        api.setName(NEW_BOARD_NAME);
        api.setDesc(NEW_BOARD_DESCRIPTION);
        api.setClosed(NEW_ACCESS);
        return extractBoardFromJson(sendRequestAndGetResponse(api, okResponseSpecification()));
    }
}
