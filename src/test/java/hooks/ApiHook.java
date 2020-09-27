package hooks;

import base.ApiBase;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class ApiHook extends ApiBase {

    @Before("@api")
    public static void setEndpoint() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";

        // Create a Request pointing to the Service Endpoint
        request = RestAssured.given();
    }
}
