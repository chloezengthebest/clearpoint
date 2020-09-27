package stepDefinitions;

import base.ApiBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONObject;
import org.junit.Assert;

public class APISteps extends ApiBase {

    @Given("Send GET http request")
    public void getTodosRequest() {
        try {
            response = request.get();
        }catch (Exception e){
            Assert.fail("GET Exception " + e);
        }
    }

    @Given("Send GET http request with Id {int}")
    public void getTodoRequest(int id) {
        try {
            response = request.get("/" + id);
        } catch (Exception e) {
            Assert.fail("GET Exception " + e);
        }
    }

    @Given("Send POST http request with Id {int}")
    public void addTodoRequest(int id) {
        // set test data
        requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("id", id);
        try {
            // Add a header stating the Request body is a JSON
            request.header("Content-Type", "application/json");

            // Add the Json to the body of the request
            request.body(requestParams);

            // Send the request and check the response
            response = request.post();
        } catch (Exception e) {
            Assert.fail("GET Exception:: " + e);
        }
    }

    @Given("Send PUT http request with Id {int}")
    public void updateTodoRequest(int todoId) {
        // arrange
        requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("id", 25);
        try {
            // Add a header stating the Request body is a JSON
            request.header("Content-Type", "application/json");

            // Add the Json to the body of the request
            request.body(requestParams);

            // Send the request and check the response
            response = request.put("/" + todoId);
        } catch (Exception e) {
            Assert.fail("PUT Exception:: " + e);
        }
    }


    @Given("Send DELETE http request with Id {int}")
    public void deleteTodoRequest(int id) {
        try {
            // Send the request and check the response
            response = request.delete("/" + id);
        } catch (Exception e) {
            Assert.fail("DELETE Exception:: " + e);
        }
    }

    @Then("I should receive SUCCESS response code {int}")
    public void getResponseCode(int responseCode) {
        try {
            // asString() method, convert the body into the string.
            body = response.getBody();
            System.out.println("Response Body is: " + body.asString());

            int statusCode = response.getStatusCode();
            Assert.assertEquals("Incorrect Success code was returned", responseCode, statusCode);

        } catch (Exception e) {
            Assert.fail("RESPONSE Exception:: " + e);
        }
    }
}
