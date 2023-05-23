package selenide.other;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;


public class Testovyy extends BaseTest {


    @Disabled
    @Test
    void t() {

//        Configuration.holdBrowserOpen = true;
        Selenide.open("https://demoqa.com/automation-practice-form");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Student2 Registration Form", $x("//h5").getText()),
                () -> Assertions.assertEquals("Current00 Address", $("label#currentAddress-label").getText())

        );

    }


    @DisplayName("tectovyy")
    @Tags({
            @Tag("kuk"),
            @Tag("muk")
    })
    @Test
    void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Assertions.assertAll(
                () -> MatcherAssert.assertThat(list, Matchers.hasItems(1, 3)),
                () -> MatcherAssert.assertThat(list, Matchers.hasSize(4)),
                () -> Assertions.assertTrue(1 == 2)
        );
    }


    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    @ParameterizedTest
    void paramTest(int i, String s) {
        show(i, s);

    }


    public void show(int a, String t) {
        System.out.println(String.format("Под номером %d находится %s", a, t));
    }


    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1, delimiter = '/')
    @ParameterizedTest(name = "number {0}, value {1}")
    void testParam2(int i, String s) {
        show(i, s);
    }


    @CsvSource(
            value = {
                    "stroka 1 / znach 1",
                    "stroka 2 / znach 2"
            },
            delimiter = '/'
    )
    @ParameterizedTest(name = "first = {0} and second = {1}")
    void testP(String s, String st) {
        System.out.println(String.format("stroka : %s , znachenie : %s", s, st));
    }

    static Stream<Arguments> sel(){
        return Stream.of(
                Arguments.of(Localya.EN, Arrays.asList("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Localya.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }
    @MethodSource("sel")
    @ParameterizedTest
    void paramT(Localya localya, List<String> list) {
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://ru.selenide.org/");
        $$("div#languages a").findBy(Condition.text(localya.name())).click();
        $$("div.main-menu-pages a").filter(Condition.visible).shouldHave(CollectionCondition.texts(list));
    }

    @ValueSource(
            strings = {
                    "one",
                    "two",
                    "three",
                    "four"
            }
    )
    @ParameterizedTest(name = "valushki")
    void valueSourceTest(String o) {

        System.out.println(o);
    }

    static Stream<Arguments> testo() {
        return Stream.of(
                Arguments.of("first ", List.of("one", "two", "three")),
                Arguments.of("second", List.of("odin", "dva", "tree"))
        );
    }

    @MethodSource("testo")
    @ParameterizedTest
    void testM(String s, List<String> list) {
        System.out.println(s + " : " + list);
    }

    static Stream<Arguments> selenide() {
        return Stream.of(
                Arguments.of(Localya.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Localya.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @MethodSource("selenide")
    @ParameterizedTest
    void selenideTest(Localya localya, List<String> list) {
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://selenide.org/");
        $$x("//div[@id = 'languages']/a").findBy(Condition.text(localya.name())).click();
        $$("div.main-menu-pages a").filter(Condition.visible).shouldHave(CollectionCondition.texts(list));
    }

    static Stream<Arguments> jd(){
        return Stream.of(
                Arguments.of("Поддержка", List.of("Акции и скидки", "Поддержка","Избранное", "Мои поездки",
                        "Журнал"))
        );
    }
    @MethodSource("jd")
    @ParameterizedTest
    void biletyTest(String st, List<String> list){
        Selenide.open("https://travel.yandex.ru/avia/");
        $$("span.UzfXr.TQ2-5.i9Gsh").find(Condition.text(st)).click();
        $$("span.UzfXr.TQ2-5.i9Gsh").filter(Condition.visible).shouldHave(CollectionCondition.texts(list));
    }

}

