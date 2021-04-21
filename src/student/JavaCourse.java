package student;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class JavaCourse {

    private final ArrayList<CCVStudent> students ;
    private CCVStudent existStudent;


    public JavaCourse() {
        this.students  = new ArrayList<>();
        this.existStudent = null;
        loadRecordInfo();

    }

    public void loadRecordInfo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Records.csv"));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] part = line.split(",");

                String ST_NAME = part[0];
                //String OCCUPATION = part[1];
                int id = Integer.parseInt(part[2]);
                String COMP = part[3];
                students.add(new CCVStudent(ST_NAME, id, Campus.valueOf(COMP)));

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readAllList(JTextArea textArea){
        students.forEach(x->x.print(textArea));
    }

    public void writeData(){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Records.csv"));
                for (CCVStudent student : students) {
                    writer
                            .append(student.getName()).append(",")
                            .append(student.getOccupation()).append(",")
                            .append(String.valueOf(student.getStudentID())).append(",")
                            .append(student.getCampus().toString()) .append("\n");

                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public CCVStudent newRecords(String name, int id, JComboBox<Campus> camp) {
        CCVStudent newEnrolled = new CCVStudent(name, id, Campus.valueOf((Objects.requireNonNull(camp.getSelectedItem())).toString()));
         students.add(newEnrolled);

        return newEnrolled;
    }
    public void lookupFor(String studentName, JTextField nameField, JTextField idField) {

        for (CCVStudent student : students)
        {
            if (student.getName().equalsIgnoreCase(studentName)) {
                nameField.setText(student.getName().toUpperCase());
                idField.setText(String.valueOf(student.getStudentID()));
                existStudent = student;

            }

        }

        if (existStudent == null) {
            JOptionPane.showMessageDialog(null, "NOT FOUND");


        }
    }
    public void deletes(){
        if (existStudent !=null){
            students.remove(existStudent);
            JOptionPane.showMessageDialog(null,"DELETED", "RECORD REMOVING", JOptionPane.INFORMATION_MESSAGE);

        }
        else {
            JOptionPane.showMessageDialog(null,"UNABLE TO DELETE", "ERROR", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public CCVStudent getExistStudent(){
       return existStudent;
    }

    public ArrayList<CCVStudent> getStudents() {
        return students;
    }
}