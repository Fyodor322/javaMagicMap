import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private Potok potok;

    public Student(String name, Potok potok) {
        this.potok = potok;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + potok.getFaculty() + "до-" + potok.getYear() + ")";
    }

    public Potok getPotok() {
        return potok;
    }

    public String getName() {
        return name;
    }
}
