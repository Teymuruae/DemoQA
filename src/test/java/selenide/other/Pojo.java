package selenide.other;

import java.util.ArrayList;

public class Pojo {
    public String id;
    public String name;
    public String cat;
    public String releaseDate;
    public ArrayList<Actor> actors;
    public String title;

    public Pojo() {
    }

    public Pojo(String id, String name, String cat, String releaseDate, ArrayList<Actor> actors, String title) {
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCat() {
        return cat;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }
}

class Actor{
    public String id;
    public String fullName;

    public Actor() {
    }

    public Actor(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
