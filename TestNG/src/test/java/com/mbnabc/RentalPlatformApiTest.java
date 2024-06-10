package com.mbnabc;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RentalPlatformApiTest {

    @BeforeClass
    public void setup() {
        // 设置基础URI
        RestAssured.baseURI = "http://localhost:8080/api";
    }

    @Test
    public void testLogin() {
        // 准备请求数据
        String requestBody = "{ \"username\": \"admin\", \"password\": \"password\" }";

        // 发送POST请求并获取响应
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response();

        // 验证响应
        String token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Login token should not be null");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testGetApartments() {
        // 发送GET请求并获取响应
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("/apartments")
                .then()
                .statusCode(200)
                .extract().response();

        // 验证响应
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "Apartments list should not be empty");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testCreateApartment() {
        // 准备请求数据
        String requestBody = "{ \"name\": \"Test Apartment\", \"address\": \"123 Test St.\", \"contact\": \"123-456-7890\" }";

        // 发送POST请求并获取响应
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/apartments")
                .then()
                .statusCode(201)
                .extract().response();

        // 验证响应
        String apartmentId = response.jsonPath().getString("id");
        Assert.assertNotNull(apartmentId, "Created apartment ID should not be null");
    }

    @Test(dependsOnMethods = "testCreateApartment")
    public void testGetRooms() {
        // 发送GET请求并获取响应
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("/rooms")
                .then()
                .statusCode(200)
                .extract().response();

        // 验证响应
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "Rooms list should not be empty");
    }

    @Test(dependsOnMethods = "testCreateApartment")
    public void testCreateRoom() {
        // 准备请求数据
        String requestBody = "{ \"roomNumber\": \"101\", \"type\": \"Single\", \"area\": \"30\", \"rent\": \"1000\", \"apartmentId\": \"1\" }";

        // 发送POST请求并获取响应
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/rooms")
                .then()
                .statusCode(201)
                .extract().response();

        // 验证响应
        String roomId = response.jsonPath().getString("id");
        Assert.assertNotNull(roomId, "Created room ID should not be null");
    }
}
