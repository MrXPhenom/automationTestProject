import API.Address;
import API.BaseApiTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class APITestHomeWork extends BaseApiTest{

    String API_key = "f64de71caae815e25c74070ab1aadbd1";

    private Map<String, Object> reqBody = new HashMap<>();


    @BeforeEach
    public void setReqBody() {
        Map<String, Object> methodProperties = new HashMap<>();

        methodProperties.put("Warehouse", 1);
        methodProperties.put("FindByString", "Єрки");

        reqBody.put("apiKey", API_key);
        reqBody.put("modelName", "Address");
        reqBody.put("calledMethod", "getSettlements");
        reqBody.put("methodProperties", methodProperties);
    }

    @Test
    public void validateThatSuccess(){
        given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    public void validateJsonSchema() {
        given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body(matchesJsonSchema(new File(System.getProperty("user.dir") +
                        "//src/main/resources/validators/np_directory_of_settlements_schema.json")));
    }

    @Test
    public void validateRegions() {
        given()
                .spec(requestSpecification)
                .body(reqBody)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body("success", equalTo(true))
                .body("data[0].Description", equalTo("Єрки"))
                .body("data[0].DescriptionTranslit", equalTo("Yerky"));
    }

    @Test
    public void validateYerkyIsPresent() {

        List<Address> addressList = given()
                .spec(requestSpecification)
                .when()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .post()
                .then()
                .spec(responseSpecification)
                .extract()
                .body().jsonPath().getList("data[0].Address", Address.class);
        System.out.println(addressList);
    }
}
