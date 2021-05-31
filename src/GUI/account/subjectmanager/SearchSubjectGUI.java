package GUI.account.subjectmanager;

import DAO.ClazzDAO;
import DAO.SubjectDAO;
import GUI.account.clazzmanager.EditClazzGUI;
import POJO.Subject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchSubjectGUI extends JFrame{
    private JLabel subjectIDLabel;
    private JLabel subjectNameLabel;
    private JLabel numberOfCreditLabel;
    private JButton removeButton;
    private JButton editButton;
    private JPanel panel;

    public SearchSubjectGUI(Subject sj) {

        subjectIDLabel.setText(sj.getSubjectId());
        subjectNameLabel.setText(sj.getSubjectName());
        numberOfCreditLabel.setText(sj.getNumberOfCredit().toString());

        add(panel);
        setSize(400, 200);
        setTitle("Search Class");
        setLocationRelativeTo(null);
        setVisible(true);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditSubjectGUI editSubjectGUI = new EditSubjectGUI(sj);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SubjectDAO.removeSubject(sj)){
                    dispose();
                    JOptionPane.showMessageDialog(null, "Successfully Removed.");
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "Cannot remove",
                            "Remove failed",
                            JOptionPane.WARNING_MESSAGE);


            }
        });
    }
}
