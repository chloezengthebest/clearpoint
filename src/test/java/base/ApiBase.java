package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ApiBase {
    public static Response response;
    public static ResponseBody body;
    public static RequestSpecification request;
    public static JSONObject requestParams;
}
