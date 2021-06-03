package GUI.account.semestermanager;

import DAO.SemesterDAO;
import POJO.Semester;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class EditSemesterGUI extends JFrame {
    private class EditSemesterPane extends JPanel {
        private JComboBox semesterNameCB;
        private JComboBox yearComboBox;
        private DatePicker firstdayPicker;
        private DatePicker lastdayPicker;
        private JCheckBox isCurrentBox;
        private JButton submitButton;

        EditSemesterPane(Semester semester) {
            setTitle("Edit Semester");
            setBorder(new EmptyBorder(60, 60, 60, 60));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Tên học kỳ:"));

            String[] semesterNames = {"HK1", "HK2", "HK3"};
            semesterNameCB = new JComboBox(semesterNames);
            add(semesterNameCB, gbc);

            add(new JLabel("Năm học:"));

            String[] years = {"2015-2016", "2016-2017", "2017-2018", "2018-2019", "2019-2020", "2020-2021", "2021-2022", "2022-2023", "2023-2024", "2024-2025"};
            yearComboBox = new JComboBox(years);
            add(yearComboBox, gbc);

            add(new JLabel("Ngày bắt đầu:"));

            firstdayPicker = new DatePicker();
            add(firstdayPicker, gbc);

            add(new JLabel("Ngày kết thúc:"));

            lastdayPicker = new DatePicker();
            add(lastdayPicker, gbc);

            add(new JLabel("Là học kỳ hiện tại:"));

            isCurrentBox = new JCheckBox();
            add(isCurrentBox, gbc);

            submitButton = new JButton("Submit");
            add(submitButton, gbc);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String year = yearComboBox.getItemAt(yearComboBox.getSelectedIndex()).toString().split("-")[0];

                    semester.setSemesterName(semesterNameCB.getItemAt(semesterNameCB.getSelectedIndex()).toString());
                    semester.setYear(Integer.parseInt(year));
                    semester.setFirstDay(java.sql.Date.valueOf(firstdayPicker.getDate()));
                    semester.setLastDay(java.sql.Date.valueOf(lastdayPicker.getDate()));
                    semester.setIsCurrent(isCurrentBox.isSelected() ? (byte) 1 : (byte) 0);

                    if (SemesterDAO.updateSemester(semester)) {
                        JOptionPane.showMessageDialog(null, "Successfully edit.");
                    } else
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot edit",
                                "Edit failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });
        }
    }

    public EditSemesterGUI(Semester semester) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Edit Semester");
                setSize(500, 300);
                add(new EditSemesterPane(semester));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }


}
