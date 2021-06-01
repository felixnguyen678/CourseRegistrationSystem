package GUI.account.semestermanager;

import DAO.SemesterDAO;
import POJO.Semester;
import com.github.lgooddatepicker.components.DatePicker;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AddSemesterGUI extends JFrame {
    private class AddSemesterPane extends JPanel{
        private JTextField semesterIdTextField;
        private JTextField semesterNameTextField;
        private JComboBox yearComboBox;
        private DatePicker firstdayPicker;
        private DatePicker lastdayPicker;
        private JCheckBox isCurrentBox;
        private JButton submitButton;

        AddSemesterPane(){
            setTitle("Add Semester");
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Mã học kỳ:"));

            semesterIdTextField = new JTextField("", 25);
            add(semesterIdTextField, gbc);

            add(new JLabel("Tên học kỳ:"));

            semesterNameTextField = new JTextField("", 25);
            add(semesterNameTextField, gbc);

            add(new JLabel("Năm học:"));

            String[] years = {"2015-2016", "2016-2017", "2017-2018", "2018-2019", "2019-2020", "2020-2021", "2021-2022", "2022-2023", "2023-2024", "2024-2025"};
            yearComboBox = new JComboBox(years);
            add(yearComboBox,gbc);

            add(new JLabel("Ngày bắt đầu:"));

            firstdayPicker = new DatePicker();
            add(firstdayPicker, gbc);

            add(new JLabel("Ngày kết thúc:"));

            lastdayPicker = new DatePicker();
            add(lastdayPicker, gbc);

            add(new JLabel("Là học kỳ hiện tại:"));

            isCurrentBox = new JCheckBox();
            add(isCurrentBox, gbc);

            submitButton = new JButton("Thêm");
            add(submitButton, gbc);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String year = yearComboBox.getItemAt(yearComboBox.getSelectedIndex()).toString().split("-")[0];
                    try {
                        Semester semester = new Semester(
                                semesterIdTextField.getText(),
                                semesterNameTextField.getText(),
                                Integer.parseInt(year),
                                java.sql.Date.valueOf(firstdayPicker.getDate()),
                                java.sql.Date.valueOf(lastdayPicker.getDate()),
                                isCurrentBox.isSelected() ? (byte)1 : (byte)0
                        );

                        if(SemesterDAO.addSemester(semester)){
                            JOptionPane.showMessageDialog(null, "Successfully added.");
                        }
                        else
                            JOptionPane.showMessageDialog(
                                null,
                                "Cannot add, re-enter subject-id",
                                "Add failed",
                                JOptionPane.WARNING_MESSAGE);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                }
            });
        }
    }
    public AddSemesterGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Add Semester");
                setSize(500, 300);
                add(new AddSemesterPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }


}
