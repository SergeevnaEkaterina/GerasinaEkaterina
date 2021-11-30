package core;

import static constants.ParametersData.DESCRIPTION;
import static constants.ParametersData.ID;
import static constants.ParametersData.IS_CLOSED;
import static constants.ParametersData.NAME;
import static constants.PropertyValues.URL_BOARD;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class BoardService extends BaseService {
    public static final URI BOARD_URL = URI.create(URL_BOARD);

    public static BoardApiBuilder boardApiBuilder() {
        return new BoardApiBuilder();
    }

    public static class BoardApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;



        public BoardApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public BoardApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public BoardApiBuilder setName(String name) {
            queryParameters.put(NAME, name);
            return this;
        }

        public BoardApiBuilder setDesc(String desc) {
            queryParameters.put(DESCRIPTION, desc);
            return this;
        }

        public BoardApiBuilder setClosed(String closed) {
            queryParameters.put(IS_CLOSED, closed);
            return this;
        }

        public BoardService buildBoardApiRequest() {
            return new BoardService(requestedMethod, queryParameters, pathParameters);
        }
    }


    public BoardService(Method method, Map<String, String> queryPar, Map<String, String> pathPar) {
        super(method, queryPar, pathPar);
    }

    public Response sendRequest() {
        return super.sendRequest(requestSpecification(BOARD_URL));
    }

    public static Board extractBoardFromJson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {
        }.getType());
    }
}
