package panels;

import student.Campus;
import student.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SearchFix extends JPanel {

    private final JButton backButton, saveButton, printButton, searchButton, deleteButton;
    private final JTextField currentId;
    private final JTextField searchInput;
    private final JTextField currentName;
    private final JComboBox<Campus> currentCampus;
    private final JPanel editsPanel;

    /**
     * Constructor Initialize the contents.
     */
    public SearchFix(JavaCourse course) {
        setLayout(new BorderLayout(0, 0));
        editsPanel = new JPanel(new GridLayout(6, 2, 0, 0));
        currentCampus = new JComboBox<>(Campus.values());
        backButton = new JButton("GO BACK");
        searchInput = new JTextField();
        saveButton = new JButton("SAVE CHANGES");
        searchButton = new JButton("SEARCH");
        currentId = new JTextField();
        currentName = new JTextField();
        printButton = new JButton("PRINT RECORD");
        deleteButton = new JButton("REMOVE STUDENT");
        addListener(course);
        enabled(false,currentCampus,currentName,currentId,saveButton,printButton,deleteButton);
        panelComponents();

    }

    private void panelComponents() {
        add(new LabelFor("ENTER STUDENT ID TO MAKE CHANGES"), BorderLayout.NORTH);
        backButton.addActionListener(a -> OptionsWindow.callBack());
        add(backButton, BorderLayout.SOUTH);
        add(editsPanel, BorderLayout.CENTER);
        editsPanelComponents(new LabelFor("STUDENT NAME"),
                searchInput, saveButton, searchButton,
                new LabelFor("CURRENT ID NUMBER"), currentId, new LabelFor("STUDENT NAME"),
                currentName, new LabelFor("CAMPUS"), currentCampus, printButton, deleteButton);
    }

    private void editsPanelComponents(JComponent... components) {
        for (JComponent com : components) {
            editsPanel.add(com);
            com.setFont(new Font("Tahoma", Font.PLAIN, 20));
        }
        currentCampus.setSelectedIndex(-1);

    }

    private void addListener(JavaCourse course){
        //addActionListeners
        searchButton.addActionListener(s->{
                course.lookupFor(searchInput.getText(), currentName, currentId);
        if(course.getExistStudent()!=null){
            enabled(true,currentCampus,currentName,currentId,saveButton,printButton,deleteButton);

            currentCampus.setSelectedItem(course.getExistStudent().getCampus());
        }});

        deleteButton.addActionListener(d->
                course.deletes());
        reset();

        printButton.addActionListener(p->{
            File file;
            try {
                file = new File("fixedRecord.csv");
                FileWriter writer = new FileWriter(file);
                writer.append("Record FIXED/ PRINTED DATE :")
                        .append(String.valueOf(LocalDate.now()))
                        .append("\n")
                        .append("*****************************************\n")
                 .append(course.getExistStudent().toString())
                 .append("Campus Phone Number :")
                        .append(course.getExistStudent().getCampus().getPhoneNumber())
                 .append("\n*****************************************\n");
                Desktop.getDesktop().open(file);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        saveButton.addActionListener(v->{
           course.getStudents().remove(course.getExistStudent());
           course.newRecords(currentName.getText(), Integer.parseInt(currentId.getText()), currentCampus);
        });
    }

    private void reset(){
        currentName.setText("");
        currentId.setText("");
        currentCampus.setSelectedIndex(-1);
        searchInput.setText("");
        enabled(false,currentCampus,currentName,currentId,saveButton,printButton,deleteButton);
    }
    private void enabled(boolean setting,JComponent...components){
        for(JComponent jComponent:components){
            jComponent.setEnabled(setting);
        }


    }

}


