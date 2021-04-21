package panels;

import student.JavaCourse;

import javax.swing.*;
import java.awt.*;

public class AllRecord extends JPanel {

    private final JButton backButton;
    private final JTextArea textArea;

    /**
     * Constructor Initialize the contents.
     */
    public AllRecord(JavaCourse course) {
        this.setLayout(new BorderLayout(0, 0));
        this.textArea = new JTextArea();
        this.backButton = new JButton("GO BACK TO MAIN WINDOW");
        allRecordPanelComponents();
        viewResult(course);


    }

    private void allRecordPanelComponents() {
        this.add(new LabelFor("ALL STUDENTS RECORDS"), BorderLayout.NORTH);
        this.add(backButton, BorderLayout.SOUTH);
        textArea.setEditable(false);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.backButton.addActionListener(a -> OptionsWindow.callBack());
        this.backButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

    public void viewResult(JavaCourse course) {
        course.readAllList(textArea);

    }

}
