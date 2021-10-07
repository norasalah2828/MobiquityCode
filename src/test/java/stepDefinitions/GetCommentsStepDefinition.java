package stepDefinitions;

import Pojo.Comments;
import Pojo.Posts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import resources.APIResources;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class GetCommentsStepDefinition extends Utils {
    String userID;
    Response userResponse;
    Response postsResponse;
    Response commentsResponse;
    Posts[] posts;
    Comments[] comments;
    Response emptyComments;

    @Given("user search for {string} to get his id using getUsersAPI")
    public void userSearchForToGetHisIdUsingGetUsersAPI(String username) throws IOException {
        userResponse = given()
                .log().all().spec(requestSpecification())
                .queryParam("username", username)
                .when().get(APIResources.getUsersAPI.getResource());
        userID = getJsonPath(userResponse, "id").replaceAll("[\\[\\]]", "");
        Assert.assertFalse(userID.isEmpty());
    }

    @When("search for all posts written with this user using getPostsAPI")
    public void searchForAllPostsWrittenWithThisUserUsingGetPostsAPI() throws IOException {
        postsResponse = given()
                .log().all().spec(requestSpecification())
                .queryParam("userId", userID)
                .when().get(APIResources.getPostsAPI.getResource());
        posts = postsResponse.as(Posts[].class);
        Assert.assertTrue(posts.length > 0);
    }

    @Then("user get all posts comments and Validate each email")
    public void userGetAllPostsCommentsAndValidateEachEmail() throws IOException {

        for (Posts postId : posts) {
            commentsResponse = given().log().all()
                    .spec(requestSpecification())
                    .queryParam("postId", postId.getId())
                    .when()
                    .get(APIResources.getCommentsAPI.getResource());

            comments = commentsResponse.as(Comments[].class);

            for (Comments commentId : comments) {
                Assert.assertTrue(Utils.validateEmail(commentId.getEmail()));
            }
        }
    }

    @Given("user search for comments with invalid {string}")
    public void userSearchForCommentsWithInvalid(String postId) throws IOException {
        requestSpecification = given().log().all()
                .spec(requestSpecification())
                .queryParam("postId", postId);

    }

    @When("user hit get http request")
    public void userHitGetHttpRequest() {
        emptyComments = requestSpecification.when()
                .get(APIResources.getCommentsAPI.getResource());
    }

    @Then("response will be empty")
    public void responseWillBeEmpty() {
        emptyComments.then().body("", Matchers.hasSize(0));
    }
}