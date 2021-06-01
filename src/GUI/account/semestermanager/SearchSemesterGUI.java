package GUI.account.semestermanager;

import DAO.SemesterDAO;
import DAO.SubjectDAO;
import POJO.Semester;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchSemesterGUI extends JFrame {
    private JPanel panel;
    private JButton editButton;
    private JButton removeButton;
    private JLabel semesterIdLabel;
    private JLabel semesterNameLabel;
    private JLabel yearLabel;
    private JLabel firstdayLabel;
    private JLabel lastdayLabel;
    private JLabel iscurrentLabel;

    public SearchSemesterGUI(Semester semester) {
        semesterIdLabel.setText(semester.getSemesterId());
        semesterNameLabel.setText(semester.getSemesterName());
        yearLabel.setText(semester.getYear().toString());
        firstdayLabel.setText(semester.getFirstDay().toString());
        lastdayLabel.setText(semester.getLastDay().toString());
        iscurrentLabel.setText(semester.getIsCurrent() == 1 ? "Có" : "Không");
        add(panel);
        setSize(500, 300);
        setTitle("Search Class");
        setLocationRelativeTo(null);
        setVisible(true);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditSemesterGUI editSemesterGUI = new EditSemesterGUI(semester);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SemesterDAO.removeSemester(semester)){
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
