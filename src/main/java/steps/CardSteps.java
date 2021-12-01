package steps;

import static constants.ParametersData.DESCRIPTION;
import static constants.ParametersData.ID_LIST;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.CARD_DESC;
import static constants.PropertyValues.NEW_CARD_DESC;
import static constants.PropertyValues.NEW_CARD_NAME;
import static constants.PropertyValues.URL_CARD;
import static core.CommonService.commonApiBuilder;
import static core.CommonService.extractCardFromJsonCommon;
import static core.CommonService.notFoundResponseSpecification;
import static core.CommonService.okResponseSpecification;
import static core.CommonService.sendRequestAndGetResponse;

import beans.Card;
import core.CommonService;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;

public class CardSteps {
    public static final URI CARD_URL = URI.create(URL_CARD);

    @Step("Create new card")
    public String createCardInList(String listId, Card card) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, card.getName())
                .setQueryParameter(DESCRIPTION, CARD_DESC)
                .setQueryParameter(ID_LIST, listId);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder,
                okResponseSpecification(), CARD_URL)).getId();
    }

    @Step("Get existing card")
    public Card getExistingCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification(), CARD_URL));
    }

    @Step("Delete card")
    public void deleteCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.DELETE)
                .setId(cardId);
        sendRequestAndGetResponse(builder, okResponseSpecification(), CARD_URL);
    }

    @Step("Get deleted card")
    public Response getDeletedCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(cardId);
        return sendRequestAndGetResponse(builder, notFoundResponseSpecification(), CARD_URL);
    }

    @Step("Update card")
    public Card modifyCard(String cardId) {
        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(cardId);
        builder.setQueryParameter(NAME, NEW_CARD_NAME);
        builder.setQueryParameter(DESCRIPTION, NEW_CARD_DESC);
        return extractCardFromJsonCommon(sendRequestAndGetResponse(builder, okResponseSpecification(), CARD_URL));
    }
}
