package core;

import static constants.ParametersData.ID;
import static constants.ParametersData.KEY;
import static constants.ParametersData.TOKEN;
import static constants.PropertyValues.USER_KEY;
import static constants.PropertyValues.USER_TOKEN;
import static org.hamcrest.Matchers.lessThan;

import beans.Board;
import beans.Card;
import beans.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public class CommonService {
    protected Method requestedMethod;
    protected Map<String, String> queryParameters;
    protected Map<String, String> pathParameters;

    public static CommonService.CommonApiBuilder commonApiBuilder() {
        return new CommonService.CommonApiBuilder();
    }

    public static class CommonApiBuilder {
        private final Map<String, String> queryParameters = new HashMap<>();
        private final Map<String, String> pathParameters = new HashMap<>();
        private Method requestedMethod = Method.GET;

        public CommonService.CommonApiBuilder setMethod(Method method) {
            requestedMethod = method;
            return this;
        }

        public CommonService.CommonApiBuilder setId(String id) {
            pathParameters.put(ID, id);
            return this;
        }

        public CommonApiBuilder setQueryParameter(String parameter, String value) {
            queryParameters.put(parameter, value);
            return this;
        }

        public CommonService buildCommonApiRequest() {
            return new CommonService(requestedMethod, queryParameters, pathParameters);
        }
    }

    public static ResponseSpecification okResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(30000L))
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public String convertToString() {
        StringBuilder builder = new StringBuilder();
        pathParameters.keySet().forEach(p -> builder.append("{").append(p).append("}").append("/"));
        return builder.toString();
    }

    public Response sendRequest(URI url) {
        return RestAssured
                .given(requestSpecification(url)).log().all()
                .pathParams(pathParameters)
                .queryParams(queryParameters)
                .queryParam(KEY, USER_KEY)
                .queryParam(TOKEN, USER_TOKEN)
                .request(requestedMethod, convertToString())
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification(URI url) {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build();
    }

    public CommonService(Method requestedMethod, Map<String, String> queryParameters,
                         Map<String, String> pathParameters) {
        this.requestedMethod = requestedMethod;
        this.queryParameters = queryParameters;
        this.pathParameters = pathParameters;
    }

    public static Card extractCardFromJsonCommon(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Card>() {
        }.getType());
    }

    public static Board extractBoardFromJsonCommon(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {
        }.getType());
    }

    public static List extractListFromJsonCommon(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List>() {
        }.getType());
    }

    public static Response sendRequestAndGetResponse(CommonService.CommonApiBuilder api,
                                                     ResponseSpecification resp, URI url) {
        Response response = api
                .buildCommonApiRequest()
                .sendRequest(url);
        response.then()
                .assertThat()
                .spec(resp);
        return response;
    }
}
