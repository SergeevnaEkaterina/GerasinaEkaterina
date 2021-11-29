package core;

import static constants.PropertyValues.URL_CARD;

import beans.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.Map;

public class CardService extends BaseService {
    public static final URI CARD_URL = URI.create(URL_CARD);

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
