package core;

import static constants.ParametersData.KEY;
import static constants.ParametersData.TOKEN;
import static constants.PropertyValues.USER_KEY;
import static constants.PropertyValues.USER_TOKEN;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpStatus;

public class BaseService {
    protected Method requestedMethod;
    protected Map<String, String> queryParameters;
    protected Map<String, String> pathParameters;

    public BaseService(Method requestedMethod, Map<String, String> queryParameters,
                       Map<String, String> pathParameters) {
        this.requestedMethod = requestedMethod;
        this.queryParameters = queryParameters;
        this.pathParameters = pathParameters;
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

    public Response sendRequest(RequestSpecification resc) {
        return RestAssured
                .given(resc).log().all()
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
}
