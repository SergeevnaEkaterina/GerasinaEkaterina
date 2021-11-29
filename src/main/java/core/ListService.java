package core;

import static constants.PropertyValues.URL_LIST;

import beans.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.Map;

public class ListService extends BaseService {
    public static final URI LIST_URL = URI.create(URL_LIST);

    public ListService(Method method, Map<String, String> queryPar, Map<String, String> pathPar) {
        super(method, queryPar, pathPar);
    }

    public Response sendRequest() {
        return super.sendRequest(requestSpecification(LIST_URL));
    }

    public static List extractListFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List>() {
        }.getType());
    }
}

