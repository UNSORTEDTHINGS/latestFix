package panels;

import student.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OptionsWindow extends JFrame {

    private static JLayeredPane layeredPane;
    private static JPanel frontPanel;
    private final JButton goAddButton, goListButton, goSearchButton;

    public OptionsWindow(JavaCourse course) {
        layeredPane = new JLayeredPane();
        frontPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        layeredPane.setLayout(new CardLayout());
        goAddButton = new JButton("REGISTER NEW STUDENT");
        goListButton = new JButton("VIEW ALL RECORDS");
        goSearchButton = new JButton("SEARCH RECORD");
        registerListeners(course);
        selectionsWindowComponents();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                course.writeData();

            }
        });
    }


    public static void callBack() {
        layeredPane.removeAll();
        layeredPane.add(frontPanel);
        layeredPane.repaint();
        layeredPane.revalidate();

    }

    private void selectionsWindowComponents() {
        getContentPane().add(new LabelFor("STUDENTS RECORD"), BorderLayout.NORTH);
        getContentPane().add(layeredPane, BorderLayout.CENTER);
        layeredPane.add(frontPanel);
        frontPanel.add(new LabelFor("SELECT ONE OF THE OPTIONS BELOW"));
        buttonsAddAndSetProperties(goAddButton, goListButton, goSearchButton);
    }

    private void buttonsAddAndSetProperties(JButton... buttons) {
        //add to panel and set properties
        for (JButton b : buttons) {
            frontPanel.add(b);
            b.setFont(new Font("Tahoma", Font.PLAIN, 30));
            b.setFocusable(false);
        }

    }

    private void jumpTo(JPanel panel) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    private void registerListeners(JavaCourse course) {
        goAddButton.addActionListener(add -> jumpTo(new NewRecord(course)));
        goSearchButton.addActionListener(sr -> jumpTo(new SearchFix(course)));
        goListButton.addActionListener(lis -> jumpTo(new AllRecord(course)));

    }
}