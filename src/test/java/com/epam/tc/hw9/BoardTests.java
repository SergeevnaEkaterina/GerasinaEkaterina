package com.epam.tc.hw9;

import static constants.ParametersData.NOT_FOUND_MESSAGE;
import static constants.ParametersData.NOT_FOUND_STATUS;
import static constants.PropertyValues.NEW_ACCESS;
import static constants.PropertyValues.NEW_BOARD_DESCRIPTION;
import static constants.PropertyValues.NEW_BOARD_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

import beans.Board;
import data.DataProviders;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BoardTests extends BaseTests {

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void createNewBoardTest(Board board) {
        sharedBoardId = boardSteps.createNewBoard(board);
        Board createdBoard = boardSteps.getBoard(sharedBoardId);
        assertThat(createdBoard.getName(), equalTo(board.getName()));
    }

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void deleteBoardTest(Board board) {
        sharedBoardId = boardSteps.createNewBoard(board);
        boardSteps.deleteBoard(sharedBoardId);
        Response response = boardSteps.getDeletedBoard(sharedBoardId);
        assertThat(response.getStatusCode(), equalTo(NOT_FOUND_STATUS));
        assertThat(response.getStatusLine(), containsStringIgnoringCase(NOT_FOUND_MESSAGE));
        sharedBoardId = null;
    }

    @Test(dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void modifyBoardTest(Board board) {
        sharedBoardId = boardSteps.createNewBoard(board);
        Board boardToUpdate = boardSteps.modifyExistingBoard(sharedBoardId);
        assertThat(boardToUpdate.getDesc(), equalTo(NEW_BOARD_DESCRIPTION));
        assertThat(boardToUpdate.getName(), equalTo(NEW_BOARD_NAME));
        assertThat(String.valueOf(boardToUpdate.getClosed()), equalTo(NEW_ACCESS));
    }
}
