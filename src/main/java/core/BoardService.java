package core;

import static constants.PropertyValues.URL_BOARD;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import java.util.Map;

public class BoardService extends BaseService {
    public static final URI BOARD_URL = URI.create(URL_BOARD);

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
