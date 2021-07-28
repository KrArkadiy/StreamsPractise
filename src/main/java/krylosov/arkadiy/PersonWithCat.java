package main.java.krylosov.arkadiy;

public class PersonWithCat {
    private String name;
    private Cat[] cats;
    private int age;

    public PersonWithCat(String name, Cat[] cats, int age) {
        this.name = name;
        this.cats = cats;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }
}
