package homeWork17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {

    private static String bearerToken;
    private static String userId;
    private static String userEmail;
    private static String bodyString;

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        bearerToken = "";
        userId = "";
    }

    @Test
    @Order(1)
    @DisplayName("проверка получения списка пользователей")
    public void shouldGetAllUsers(){

        //запрос списка пользователей
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        //проверяем статус ответа 200
        assertThat(response.getStatusCode(), equalTo(200));

        //проверяем заголовок Контента
        assertThat(response.getHeader("Content-Type"), containsString("application/json"));

        //проверяем что quantidade не пустое
        assertThat(response.jsonPath().getInt("quantidade"), notNullValue());

        //проверяем что usuarios не пустое
        assertThat(response.jsonPath().getList("usuarios"), notNullValue());
    }

    @Test
    @Order(2)
    @DisplayName("проверка поиска пользователя по емайл")
    public void shouldFindUserByEmail(){

        //переменная для емейла юзера
        String emailUsuario;

        //получаем значение емейла первого юзера
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        //выковыриваем емейл первого юзера из массива
        emailUsuario = response.jsonPath().getString("usuarios[0].email");

        //отправляем новый запрос только по юзеру с полученным емейлом в виде параметра
        response = given()
                .contentType(ContentType.JSON)
                .queryParam("email", emailUsuario)
                .when()
                .get("/usuarios")
                .then()
                .extract()
                .response();

        //проверяем статус ответа 200
        assertThat(response.getStatusCode(), equalTo(200));

        //проверяем значение quantidade
        assertThat(response.jsonPath().get("quantidade"), equalTo(1));

        //проверяем значение емейла юзера из ответа
        assertThat(response.jsonPath().get("usuarios[0].email").toString(), equalTo(emailUsuario));

        /*System.out.println(emailUsuario);
        System.out.println(response.getBody().asPrettyString());*/

    }

    @Test
    @Order(3)
    @DisplayName("проверка возможности создания пользователя")
    public void shouldCreateNewUser(){

        String time = String.valueOf(System.currentTimeMillis());

        //емайл нового пользователя
        userEmail = "spy_НОМЕР" + time + "@qa.com";

        //тело запроса
        bodyString = "{\n" +
                "  \"nome\": \"Тайный Покупатель\",\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";
        //запрос на создание пользователя
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .post("/usuarios")
                .then()
                .extract()
                .response();

        //проверка статуса ответа
        assertThat(response.getStatusCode(), equalTo(201));

        //проверка текста ответа
        assertThat(response.jsonPath().getString("message"), equalTo("Cadastro realizado com sucesso"));

        //сохранение id нового юзера
        userId = response.jsonPath().getString("_id");

    }

    @Test ()
    @Order(4)
    @DisplayName("проверка обновления данных пользователя")
    public void shouldUpdateUser(){

        String newUserName = "Обновлённый Покупатель";
        String newRoleUser = "false";

        //тело запроса
        bodyString = "{\n" +
                "  \"nome\": \"" + newUserName + "\",\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\",\n" +
                "  \"administrador\": \"" + newRoleUser + "\"\n" +
                "}";

        //запрос на изменение пользователя
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .put("/usuarios/" + userId)
                .then()
                .extract()
                .response();

        //проверка статуса ответа
        assertThat(response.getStatusCode(), equalTo(200));

        //проверка текста ответа
        assertThat(response.jsonPath().getString("message"),equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(5)
    @DisplayName("проверка удаления данных пользователя")
    public void deleteUser(){

        //получение токена
        bodyString = "{\n" +
                "  \"email\": \"" + userEmail + "\",\n" +
                "  \"password\": \"secret123\"\n" +
                "}";
        //запрос на логин пользователя для получения временного токена авторизации
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .post("/login")
                .then()
                .extract()
                .response();

        bearerToken = response.jsonPath().getString("authorization");

        //запрос на удаление пользователя
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", bearerToken)
                .when()
                .delete(" /usuarios/" + userId)
                .then()
                .extract()
                .response();

        //проверка статуса ответа
        assertThat(response.getStatusCode(), equalTo(200));

        //проверка текста ответа
        assertThat(response.jsonPath().getString("message"), equalTo("Registro excluído com sucesso"));
    }

    @Test
    @Order(6)
    @DisplayName("проверка цен товаров")
    public void shouldGetAllProducts(){

        List<Integer> prises;
        List<String> names;

        //отправляем новый запрос только по юзеру с полученным емейлом в виде параметра
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/produtos")
                .then()
                .extract()
                .response();

        prises = response.jsonPath().getList("produtos.preco");
        names = response.jsonPath().getList("produtos.nome");

        //проверка статуса ответа
        assertThat(response.getStatusCode(), equalTo(200));

        //проверка значения quantidade
        assertThat(response.jsonPath().get("quantidade"), greaterThan(0));

        //проверка, что все имена не пустые
        assertThat(names, allOf(notNullValue()));

        //проверка цен больше нуля, хз почему, но не могу заставить работать everyItem (greaterThan())
        for (Integer pris : prises) {
            assertThat(pris, greaterThan(0));
        }

        //проверка на наличие какого-то товара по названию
        assertThat(names, hasItem("Logitech MX Vertical"));

    }
}
