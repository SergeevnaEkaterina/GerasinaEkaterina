package steps;

import static constants.ParametersData.*;
import static constants.PropertyValues.*;
import static core.CommonService.*;

import beans.Card;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import java.net.URI;

public class CardSteps {
    public static final URI CARD_URL = URI.create(URL_CARD);
    @Step("Create new card")
    public String createCardInList(String listId, Card card) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.POST)
                .setValue(NAME,card.getName())
                .setValue(ID_LIST,listId);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification())).getId();
    }

    @Step("Get existing card")
    public Card getExistingCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification()));
    }

    @Step("Delete card")
    public void deleteCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.DELETE)
                .setId(cardId);
        sendRequestAndGetResponse(builder, okResponseSpecification());
    }

    @Step("Get deleted card")
    public Response getDeletedCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpecification());
    }

    @Step("Update card")
    public Card modifyCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(cardId);
        builder.setValue(NAME,NEW_CARD_NAME);
        builder.setValue(DESCRIPTION,NEW_CARD_DESC);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification()));
    }

    public Response sendRequestAndGetResponse(CommonService.CommonApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildCommonApiRequest()
                .sendRequest(CARD_URL);
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }
}
