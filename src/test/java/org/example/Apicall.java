package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class Apicall {
    public static void getRequest() {

        RestAssured.baseURI = "http://localhost:8080/api/v1";

        Response responseStatus = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/path")
                .then()
                .extract().response();

        String  jsonString = responseStatus.getBody().asString();
        int finalPath = JsonPath.from(jsonString).get("savedPath");

            System.out.println("Сохраненный путь:" + " " + finalPath + "\n");

            }
    public static void deleteRequest() {

        RestAssured.baseURI = "http://localhost:8080/api/v1";

        Response responseStatus = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/path")
                .then()
                .extract().response();

        System.out.println("Данные успешно удалены" + "\n");

    }
    public static void updateRequest(String pathNumber) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("savedPath", pathNumber);

        RestAssured.baseURI = "http://localhost:8080/api/v1";


        Response responseStatus = (Response) given()
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .post("/path")
                .then()
                .extract().response();

        System.out.println("Путь успешно добавлен" + "\n");

    }
    }
