package steps;

import static api.CardApiBuilder.cardApiBuilder;
import static constants.PropertyValues.CARD_DESC;
import static constants.PropertyValues.CARD_NAME;
import static constants.PropertyValues.NEW_CARD_DESC;
import static constants.PropertyValues.NEW_CARD_NAME;
import static core.BaseService.notFoundResponseSpecification;
import static core.BaseService.okResponseSpecification;
import static core.CardService.extractCardFromJson;

import api.CardApiBuilder;
import beans.Card;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class CardSteps {
    @Step("Create new card")
    public String createCardInList(String listId, Card card) {
        CardApiBuilder builder = cardApiBuilder()
                .setMethod(Method.POST)
                .setName(card.getName())
                .setIdList(listId);
        return extractCardFromJson(sendRequestAndGetResponse(builder, okResponseSpecification())).getId();
    }

    @Step("Get existing card")
    public Card getExistingCard(String cardId) {
        CardApiBuilder builder = cardApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        return extractCardFromJson(sendRequestAndGetResponse(builder, okResponseSpecification()));
    }

    @Step("Delete card")
    public void deleteCard(String cardId) {
        CardApiBuilder builder = cardApiBuilder()
                .setMethod(Method.DELETE)
                .setId(cardId);
        sendRequestAndGetResponse(builder, okResponseSpecification());
    }

    @Step("Get deleted card")
    public void getDeletedCard(String cardId) {
        CardApiBuilder builder = cardApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        sendRequestAndGetResponse(builder, notFoundResponseSpecification());
    }

    @Step("Update card")
    public Card modifyCard(String cardId) {
        CardApiBuilder builder = cardApiBuilder()
                .setMethod(Method.PUT)
                .setId(cardId);
        builder.setName(NEW_CARD_NAME);
        builder.setDesc(NEW_CARD_DESC);
        return extractCardFromJson(sendRequestAndGetResponse(builder, okResponseSpecification()));
    }

    public Response sendRequestAndGetResponse(CardApiBuilder api, ResponseSpecification resp) {
        Response response = api
                .buildCardApiRequest()
                .sendRequest();
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }
}
