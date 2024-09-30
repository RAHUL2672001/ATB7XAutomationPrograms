package ex_26092024;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JSONPath02 {
    //POST - Create -> Verify the Response
    public static void main(String[] args) {
        String response = "{\"firstName\":\"John\",\"lastName\":\"doe\",\"age\":26,\"address\":{\"streetAddress\":\"naiststreet\",\"city\":\"Nara\",\"postalCode\":\"630-0192\"},\"phoneNumbers\":[{\"type\":\"iPhone\",\"number\":\"0123-4567-8888\"},{\"type\":\"home\",\"number\":\"0123-4567-8910\"}]}";
        JsonPath jsonPath = JsonPath.from(response);
        System.out.println(jsonPath.getString("firstName"));

        System.out.println(jsonPath.getString("phoneNumbers[1].type"));

        Assert.assertEquals(jsonPath.getString("firstName"),"John");
        assertThat(jsonPath.getString("firstName")).isNotNull().isNotEmpty().isEqualTo("John");
    }
}
