package core;

import static constants.ParametersData.ID;
import static constants.ParametersData.ID_BOARD;
import static constants.ParametersData.IS_CLOSED;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.URL_LIST;

import beans.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ListService extends BaseService {
    public static final URI LIST_URL = URI.create(URL_LIST);

    public static ListApiBuilder listApiBuilder() {
        return new ListApiBuilder();
    }

    public static class ListApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;



        public ListApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public ListApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public ListApiBuilder setIdBoard(String idBoard) {
            queryParameters.put(ID_BOARD, idBoard);
            return this;
        }

        public ListApiBuilder setName(String name) {
            queryParameters.put(NAME, name);
            return this;
        }

        public ListApiBuilder setClosed(String closed) {
            queryParameters.put(IS_CLOSED, closed);
            return this;
        }

        public ListService buildListApiRequest() {
            return new ListService(requestedMethod, queryParameters, pathParameters);
        }
    }

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

