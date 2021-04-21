package student;

import javax.swing.*;

public abstract class Person {

    private final String Occupation;
    private final String name;

    public Person(String name, String occupation) {
        super();
        this.name = name;
        Occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return Occupation;
    }

    @Override
    public String toString() {
        return "\nNAME :" + name+"\n"
                + "OCCUPATION :" + Occupation+"\n";
    }

    public abstract void print(JTextArea out);


}
