package selenide.other;

import java.util.List;

public class Animal {
    private String pet;
    private String name;
    private List<String> hobbies;
    private Meal meal;

    public String getPet() {
        return pet;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Meal getMeal() {
        return meal;
    }
}

class Meal{
    private String morning;
    private String evening;

    public String getMorning() {
        return morning;
    }

    public String getEvening() {
        return evening;
    }
}
