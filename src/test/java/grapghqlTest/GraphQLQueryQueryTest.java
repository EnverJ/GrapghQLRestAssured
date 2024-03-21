package grapghqlTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.GraphQLQuery;
import pojos.QueryVariables;

import  static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class GraphQLQueryQueryTest {
    @Test
    public void getAllItems(){
        RestAssured.baseURI= "https://hasura.io";
       // https://hasura.io/learn/graphql/graphiql
        // /learn/graphql
                String query = "{\"query\":\"query ($limit: Int!, $title: String!) {\\n  todos(where: {title: {_eq: $title}}, limit: $limit) " +
                        "{\\n    title\\n    id\\n  }\\n}\\n\",\"variables\":{\"limit\":10,\"title\":\"Enver's\"}}\n";


                given().log().all()
                        .contentType("application/json")
                        .body(query)
                        .when().log().all()
                        .post("/learn/graphql/graphiql")
                                 .then().log().all()
                                      .assertThat().
                                          statusCode(200)
                                                .and()
                                                   .body("data.todos[0].title",equalTo("Enver's"));

    }
    @Test
    public void getAllUsers(){
        RestAssured.baseURI="https://hasura.io";
        String query = "{\"query\":\"query($limit:Int!)\\n{\\n  users(limit: $limit) {\\n    id\\n    todos {\\n      title\\n    }\\n    name\\n  }\\n}\\n\",\"variables\":{\"limit\":10}}";
        given().log().all()
                .contentType("application/json")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiJ9LCJuaWNrbmFtZSI6ImVubGVtMTk4NyIsIm5hbWUiOiJlbmxlbTE5ODdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzRhNWJkYTZjYzc3MmU3ZTBlMmFhNWFiYWQ3OTEwMGQwP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGZW4ucG5nIiwidXBkYXRlZF9hdCI6IjIwMjMtMTItMTBUMjE6MzM6NTYuMjk3WiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNzAyMzE0NjMxLCJleHAiOjE3MDIzNTA2MzEsInN1YiI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiIsImF0X2hhc2giOiJPTkpBdUxBbzgwcjBBWVUtcjJkVjlBIiwic2lkIjoieFlNTzlTVDZtRjRlLUtfUVRuMnQwNHNvMURaaGx4Q2oiLCJub25jZSI6Ik00SGFDVS5wcWI1aEdlSVVVSjN4VGE4eENELjNwNy10In0.UNHT0M8cE9x6hij7BK9dQlKuJAUFSD0Su6vX9Xm0opmtCKdWecc-6lwHwd2GWuqQ2kr_zsbcLZ8KaXZLENtMcbgQsjxy6uPknW7zV0nBN-py4MwDCiUDCYhjcb3sKZvzikquGivgPNMGXsJSBG5ZigREQ9q_nQ-5yaTw_EMffAvGZxVI5ufEoUAEMQpQessDNflnWOiisO6UHylc5vMEgxE5u-2IFyWrmEDeg8ia9k2DR3rbjxx0ldpOJBNtaAgb-JNrEmQHFZIHtWzrnF27ajekNbQTr1n-GjJZfiX9Px3XJMKm357Af5fjZ5ZE5TVsQhr159da-jkHXkADEDvgQA")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("data.users[0].name",equalTo("tui.glen"))
                .and()
                .body("data.users[0].id",equalTo("auth0|5cc0ea100e618b11b031bb99"));
    }


    @DataProvider
    public Object[][] getQueryDat(){
        return new Object[][]{{"10","akshayapsangi123","Flutter development"},{"5","tui.glen","Flutter development"}};
    }
    @Test(dataProvider = "getQueryDat")
    public void getAllUsers(String limit, String name, String todosTitle){
        RestAssured.baseURI="https://hasura.io";
      //  String query = "{\"query\":\"query($limit:Int!)\\n{\\n  users(limit: $limit) {\\n    id\\n    todos {\\n      title\\n    }\\n    name\\n  }\\n}\\n\",\"variables\":{\"limit\":"+limit+"}}";
        String query="{\"query\":\"query ($limit: Int!) {\\n  users(limit: $limit, where: {name: {_eq: \\\""+name+"\\\"}}) {\\n    id\\n    name\\n  }\\n}\\n\",\"variables\":{\"limit\":"+limit+"}}";
    //   String query = "{\"query\":\"query ($limit: Int!) {\\n  users(limit: $limit, where: {name: {_eq: \\\""+name+"\\\"}}) {\\n    id\\n    name\\n    todos(where: {title: {_eq: \\\""+todosTitle+"\\\"}}) {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":{\"limit\":"+limit+"}}}}";
        given().log().all()
                .contentType("application/json")
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiJ9LCJuaWNrbmFtZSI6ImVubGVtMTk4NyIsIm5hbWUiOiJlbmxlbTE5ODdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzRhNWJkYTZjYzc3MmU3ZTBlMmFhNWFiYWQ3OTEwMGQwP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGZW4ucG5nIiwidXBkYXRlZF9hdCI6IjIwMjMtMTItMTBUMjE6MzM6NTYuMjk3WiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNzAyMzE0NjMxLCJleHAiOjE3MDIzNTA2MzEsInN1YiI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiIsImF0X2hhc2giOiJPTkpBdUxBbzgwcjBBWVUtcjJkVjlBIiwic2lkIjoieFlNTzlTVDZtRjRlLUtfUVRuMnQwNHNvMURaaGx4Q2oiLCJub25jZSI6Ik00SGFDVS5wcWI1aEdlSVVVSjN4VGE4eENELjNwNy10In0.UNHT0M8cE9x6hij7BK9dQlKuJAUFSD0Su6vX9Xm0opmtCKdWecc-6lwHwd2GWuqQ2kr_zsbcLZ8KaXZLENtMcbgQsjxy6uPknW7zV0nBN-py4MwDCiUDCYhjcb3sKZvzikquGivgPNMGXsJSBG5ZigREQ9q_nQ-5yaTw_EMffAvGZxVI5ufEoUAEMQpQessDNflnWOiisO6UHylc5vMEgxE5u-2IFyWrmEDeg8ia9k2DR3rbjxx0ldpOJBNtaAgb-JNrEmQHFZIHtWzrnF27ajekNbQTr1n-GjJZfiX9Px3XJMKm357Af5fjZ5ZE5TVsQhr159da-jkHXkADEDvgQA")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("data.users[0].name",equalTo(name));
             //   .body("data.users[0].id",equalTo("auth0|5cc0ea100e618b11b031bb99"));
    }

    @Test
    public void getAllUser_WithPojoClass(){
        RestAssured.baseURI="https://hasura.io";
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("query ($limit: Int!,$name:String!) {\n" +
                "  users(limit: $limit, where: {name: {_eq: $name}}) {\n" +
                "    id\n" +
                "    name\n" +
                "  }\n" +
                "}\n");

        QueryVariables variables =new QueryVariables();
         variables.setLimit(2);
         variables.setName("dassad");

        query.setVariables(variables);
        given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiJ9LCJuaWNrbmFtZSI6ImVubGVtMTk4NyIsIm5hbWUiOiJlbmxlbTE5ODdAZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyLzRhNWJkYTZjYzc3MmU3ZTBlMmFhNWFiYWQ3OTEwMGQwP3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGZW4ucG5nIiwidXBkYXRlZF9hdCI6IjIwMjMtMTItMTBUMjE6MzM6NTYuMjk3WiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwiaWF0IjoxNzAyMzE0NjMxLCJleHAiOjE3MDIzNTA2MzEsInN1YiI6ImF1dGgwfDY1NzYyZWMzMDYyOGVlOTU2ZTM3OTIxNiIsImF0X2hhc2giOiJPTkpBdUxBbzgwcjBBWVUtcjJkVjlBIiwic2lkIjoieFlNTzlTVDZtRjRlLUtfUVRuMnQwNHNvMURaaGx4Q2oiLCJub25jZSI6Ik00SGFDVS5wcWI1aEdlSVVVSjN4VGE4eENELjNwNy10In0.UNHT0M8cE9x6hij7BK9dQlKuJAUFSD0Su6vX9Xm0opmtCKdWecc-6lwHwd2GWuqQ2kr_zsbcLZ8KaXZLENtMcbgQsjxy6uPknW7zV0nBN-py4MwDCiUDCYhjcb3sKZvzikquGivgPNMGXsJSBG5ZigREQ9q_nQ-5yaTw_EMffAvGZxVI5ufEoUAEMQpQessDNflnWOiisO6UHylc5vMEgxE5u-2IFyWrmEDeg8ia9k2DR3rbjxx0ldpOJBNtaAgb-JNrEmQHFZIHtWzrnF27ajekNbQTr1n-GjJZfiX9Px3XJMKm357Af5fjZ5ZE5TVsQhr159da-jkHXkADEDvgQA")
                .body(query)
                .when().log().all()
                .post("/learn/graphql")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.users[0].name",equalTo("dassad"));


    }
}
