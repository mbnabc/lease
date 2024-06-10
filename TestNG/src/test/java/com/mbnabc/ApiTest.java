package com.mbnabc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ApiTest {
    @BeforeClass
    public void setUp() {
        // 设置RestAssured的Base URI
        RestAssured.baseURI = "https://api.example.com"; // 替换为你的API基础URI
    }

    @Test
    public void testSearchProperties() {
        // 测试房源检索功能
        Response response = given()
                .queryParam("location", "San Francisco")
                .queryParam("minRent", "1000")
                .queryParam("maxRent", "3000")
                .when()
                .get("/properties/search")
                .then()
                .statusCode(200)
                .body("location", equalTo("San Francisco"))
                .body("properties.size()", hasItems(1, 10)) // 假设返回结果在1到10之间
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    public void testBookViewing() {
        // 测试预约看房功能
        String requestBody = "{"
                + "\"propertyId\": \"12345\","
                + "\"date\": \"2024-06-15\","
                + "\"time\": \"10:00 AM\""
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/viewings/book")
                .then()
                .statusCode(201)
                .body("status", equalTo("Booked"))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    public void testGetLeaseAgreement() {
        // 测试获取租约合同功能
        Response response = given()
                .pathParam("leaseId", "67890")
                .when()
                .get("/leases/{leaseId}")
                .then()
                .statusCode(200)
                .body("leaseId", equalTo("67890"))
                .body("status", equalTo("Active"))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    public void testGetBrowsingHistory() {
        // 测试获取浏览历史功能
        Response response = given()
                .header("Authorization", "Bearer your_token_here") // 替换为实际的Token
                .when()
                .get("/users/browsing-history")
                .then()
                .statusCode(200)
                .body("history.size()", hasItems(1, 10)) // 假设历史记录在1到10之间
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
