package GUI.account.registrationmanager;

import DAO.RegistrationDAO;
import POJO.Course;
import POJO.Registration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentInCourseGUI extends JFrame {
    private class StudentInCoursePane extends JPanel{

        StudentInCoursePane(Course course){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            table.setPreferredScrollableViewportSize(new Dimension(500,80));

            model.addColumn("MSSV");
            model.addColumn("Họ tên");
            model.addColumn("Mã môn");
            model.addColumn("Tên môn");
            model.addColumn("Tên GV");
            model.addColumn("Bắt đầu học");
            model.addColumn("SV đăng ký lúc");

            List<Registration> registrations = RegistrationDAO.getRegistrationsByCourse(course);
            for(Registration i:registrations){
                model.addRow(new Object[]{
                        i.getStudent().getStudentId(),
                        i.getStudent().getFullName(),
                        i.getCourse().getSubject().getSubjectId(),
                        i.getCourse().getSubject().getSubjectName(),
                        i.getCourse().getTeacherName(),
                        i.getCourse().getSemester().getFirstDay(),
                        i.getRegistrationTime()
                });
            }
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(900, 200));
            add(scrollPane, gbc);
        }

    }
    StudentInCourseGUI(Course course){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Course Manager");
                setSize(1000, 500);
                add(new StudentInCoursePane(course));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
