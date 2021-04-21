package panels;

import student.Campus;
import student.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NewRecord extends JPanel {
    private final JComboBox<Campus> campusList;
    private final JButton backButton, addButton;
    private final JPanel panel;
    //fields
    private final JTextField idInput;
    private final JTextField nameInput;
    private final JTextArea addedResult;

    /**
     * Constructor Initialize the contents.
     */
    public NewRecord(JavaCourse course) {
        setLayout(new BorderLayout(0, 0));
        panel = new JPanel(new GridLayout(4, 2, 0, 0));
        idInput = new JTextField();
        nameInput = new JTextField();
        campusList = new JComboBox<>(Campus.values());
        backButton = new JButton("GO BACK");
        addButton = new JButton("ADD STUDENT");
        addedResult = new JTextArea();
        registerButtonsListeners(course);
        NewStudentPanelComponents();

    }

    private void NewStudentPanelComponents() {
        add(new LabelFor("ADD NEW STUDENT "), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(addedResult), BorderLayout.SOUTH);
        addToPanel(new LabelFor("STUDENT NAME"), nameInput
                , new LabelFor("STUDENT ID#"), idInput, new LabelFor("CAMPUS"), campusList
                , backButton, addButton);

    }

    private void addToPanel(JComponent... components) {
        for (JComponent c : components) {
            c.setFont(new Font("Tahoma", Font.PLAIN, 20));
            panel.add(c);
        }
        campusList.setSelectedIndex(-1);

        addedResult.setRows(8);
        addedResult.setEditable(false);
        addedResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
        idInput.setHorizontalAlignment(SwingConstants.CENTER);
        nameInput.setHorizontalAlignment(SwingConstants.CENTER);

    }

private void registerButtonsListeners(JavaCourse course){

    addButton.addActionListener(a->{
            course.newRecords(
                    nameInput.getText(),
                    Integer.parseInt(idInput.getText()),
                    campusList).print(addedResult);
            addedResult.append("NEW STUDENT ADDED ON:\n"+ LocalDate.now());

            });
    backButton.addActionListener(a -> OptionsWindow.callBack());

}


}
