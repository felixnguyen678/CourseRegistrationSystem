package GUI.account.courseregistrationsessionmanager;

import DAO.CourseRegistrationSessionDAO;
import DAO.SemesterDAO;
import POJO.CourseRegistrationSession;
import POJO.Semester;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class AddSessionGUI extends  JFrame{

    private class AddSessionPane extends JPanel{
        private DateTimePicker firstdayDP;
        private DateTimePicker lastdayDP;
        private JButton addBtn;
        AddSessionPane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            firstdayDP = new DateTimePicker();
            lastdayDP = new DateTimePicker();

            add(new JLabel("Thoi gian bắt đầu:"));
            add(firstdayDP, gbc);
            add(new JLabel("Thoi gian kết thúc"));
            add(lastdayDP, gbc);
            addBtn = new JButton("Thêm đợt đăng ký");
            add(addBtn,gbc);
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Semester> crsm = SemesterDAO.getCurrentSemesters();
                    if(CourseRegistrationSessionDAO.addCourseRegistrationSession(
                            new CourseRegistrationSession(
                                    crsm.get(0).getSemesterId(),
                                    Timestamp.valueOf(firstdayDP.getDateTimePermissive()),
                                    Timestamp.valueOf(lastdayDP.getDateTimePermissive()),
                                    crsm.get(0)
                            )
                    ))
                        JOptionPane.showMessageDialog(null, "Successfully added.");
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Khong them duoc",
                                "",
                                JOptionPane.WARNING_MESSAGE);


                }
            });
        }
    }
    public AddSessionGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Các đợt đăng ký học phần");
                setSize(600, 500);
                add(new AddSessionPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
