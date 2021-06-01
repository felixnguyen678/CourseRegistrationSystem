package GUI.account.subjectmanager;

import DAO.SubjectDAO;
import POJO.Subject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditSubjectGUI extends  JFrame{


    private class EditSubjectPane extends  JPanel{
        private JSpinner numberOfCreditSpinner;
        private JTextField subjectNameTextField;
        private JButton submitButton;

        public EditSubjectPane(Subject sj){
            setTitle("Edit Subject");
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Tên môn học:"));
            subjectNameTextField = new JTextField(sj.getSubjectName());
            add(subjectNameTextField, gbc);
            add(new JLabel("Số tín chỉ:"));
            SpinnerModel value =
                    new SpinnerNumberModel(sj.getNumberOfCredit().intValue(), //initial value
                            0, //minimum value
                            10, //maximum value
                            1); //step
            numberOfCreditSpinner = new JSpinner(value);
            add(numberOfCreditSpinner,gbc);
            submitButton = new JButton("Submit");
            add(submitButton, gbc);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Subject newsubject = new Subject(sj);
                    newsubject.setSubjectName(subjectNameTextField.getText());
                    newsubject.setNumberOfCredit((int)numberOfCreditSpinner.getValue());
                    if(SubjectDAO.updateSubject(newsubject)){
                        JOptionPane.showMessageDialog(null, "Successfully updated.");
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot update",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }

    public EditSubjectGUI(Subject sj) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(400, 200);
                add(new EditSubjectPane(sj));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
