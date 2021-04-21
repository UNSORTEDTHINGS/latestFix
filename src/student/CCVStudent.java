package student;

import javax.swing.*;

public class CCVStudent extends Person {

    private int studentID;
    private Campus campus;

    public CCVStudent(String name, int studentID, Campus campus) {
        super(name, "CCV-STUDENT");
        this.studentID = studentID;
        this.campus = campus;
    }

    public int getStudentID() {
        return studentID;
    }

    public Campus getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return   super.toString().toUpperCase()+
                "STUDENT ID :" + studentID +"\n"+
                "CAMPUS :" + campus +"\n";
    }

    @Override
    public void print(JTextArea out) {
        out.append("*************************" +
                super.toString().toUpperCase()+
                "STUDENT ID:" + studentID+
                "\nCAMPUS :" + campus + "\n" +
                "*************************\n");

    }
}
