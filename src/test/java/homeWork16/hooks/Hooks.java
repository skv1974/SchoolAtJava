package homeWork16.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void before(Scenario scenario) {
        System.out.println("--- Начинается сценарий: " + scenario.getName() + " ---");
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("!!! Сценарий " + scenario.getName() + " УПАЛ !!!");
        } else {
            System.out.println("--- Сценарий " + scenario.getName() + " прошел успешно ---");
        }
    }
}