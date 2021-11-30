package core;


import static constants.ParametersData.DESCRIPTION;
import static constants.ParametersData.ID;
import static constants.ParametersData.ID_LIST;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.URL_CARD;

import beans.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CardService extends BaseService {
    public static final URI CARD_URL = URI.create(URL_CARD);

    public static CardApiBuilder cardApiBuilder() {
        return new CardApiBuilder();
    }

    public static class CardApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;

        public CardApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public CardApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public CardApiBuilder setIdList(String idList) {
            queryParameters.put(ID_LIST, idList);
            return this;
        }

        public CardApiBuilder setName(String name) {
            queryParameters.put(NAME, name);
            return this;
        }

        public CardApiBuilder setDesc(String desc) {
            queryParameters.put(DESCRIPTION, desc);
            return this;
        }

        public CardService buildCardApiRequest() {
            return new CardService(requestedMethod, queryParameters, pathParameters);
        }
    }

    public CardService(Method method, Map<String, String> queryPar, Map<String, String> pathPar) {
        super(method, queryPar, pathPar);
    }

    public Response sendRequest() {
        return super.sendRequest(requestSpecification(CARD_URL));
    }

    public static Card extractCardFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Card>() {
        }.getType());
    }
}
