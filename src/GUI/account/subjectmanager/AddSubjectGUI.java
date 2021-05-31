package GUI.account.subjectmanager;

import DAO.SubjectDAO;
import POJO.Subject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSubjectGUI extends  JFrame{


    public class EditSubjectPane extends  JPanel{
        private JSpinner numberOfCreditSpinner;
        private JTextField subjectNameTextField;
        private JButton submitButton;
        private JTextField subjectIdTextField;

        public EditSubjectPane(){
            setTitle("Add Subject");
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Mã môn học:"));
            subjectIdTextField = new JTextField("", 25);
            add(subjectIdTextField, gbc);
            add(new JLabel("Tên môn học:"));
            subjectNameTextField = new JTextField("",25);
            add(subjectNameTextField, gbc);
            add(new JLabel("Số tín chỉ:"));
            SpinnerModel value =
                    new SpinnerNumberModel(3, //initial value
                            0, //minimum value
                            10, //maximum value
                            1); //step
            numberOfCreditSpinner = new JSpinner(value);
            add(numberOfCreditSpinner,gbc);
            submitButton = new JButton("Add");
            add(submitButton, gbc);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Subject newsubject = new Subject(
                            subjectIdTextField.getText(),
                            subjectNameTextField.getText(),
                            (int)numberOfCreditSpinner.getValue()
                    );

                    if(SubjectDAO.addSubject(newsubject)){
                        JOptionPane.showMessageDialog(null, "Successfully added.");
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot add, re-enter subject-id",
                                "Add failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }

    public AddSubjectGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(400, 200);
                add(new EditSubjectPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
