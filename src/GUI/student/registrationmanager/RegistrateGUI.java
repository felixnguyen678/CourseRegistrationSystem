package GUI.student.registrationmanager;

import DAO.CourseDAO;
import DAO.RegistrationDAO;
import DAO.StudentDAO;
import POJO.Course;
import POJO.Registration;
import POJO.Semester;
import utils.RunTimeUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Set;

public class RegistrateGUI extends JFrame {
    private class RegistratePane extends JPanel {
        private JTextField searchBox;
        private JButton searchButton;

        RegistratePane(Semester se) {
            setBorder(new EmptyBorder(60, 60, 60, 60));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("              Đăng ký học phần bằng mã học phần:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Đăng ký");
            add(searchButton, gbc);


            DefaultTableModel courseModel = new DefaultTableModel();
            JTable courseTable = new JTable(courseModel);
            courseTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            courseModel.addColumn("Mã học phần");
            courseModel.addColumn("Tên mã môn học");
            courseModel.addColumn("Tên môn học");
            courseModel.addColumn("Số tín chỉ");
            courseModel.addColumn("Mã học kỳ");
            courseModel.addColumn("Tên giáo viên");
            courseModel.addColumn("Phòng học");
            courseModel.addColumn("Ngày trong tuần");
            courseModel.addColumn("Ca");
            courseModel.addColumn("Slot tối đa");

            Set<Course> courses = se.getCourses();
            if(courses != null){
                for(Course i: courses){

                    courseModel.addRow(new Object[]{
                            i.getCourseId(),
                            i.getSubject().getSubjectId(),
                            i.getSubject().getSubjectName(),
                            i.getSubject().getNumberOfCredit(),
                            i.getSemester(),
                            i.getTeacherName(),
                            i.getClassroom(),
                            i.getWeekday(),
                            i.getShift(),
                            i.getMaximumNumberOfSlot()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(courseTable);
            scrollPane.setPreferredSize(new Dimension(900, 200));
            add(scrollPane, gbc);
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Course course = se.getCourseById(searchBox.getText());
                    if (course != null) {
                        List<Registration> re = RegistrationDAO.getRegistrationsByStudentAndSemester(
                                StudentDAO.getStudentById(RunTimeUtil.getUserId()), se
                        );
                        boolean check = true;
                        for (Registration i: re){
                            if(i.getCourse().getShift() == course.getShift() && i.getCourse().getWeekday().equals(course.getWeekday()))
                                check = false;
                        }
                        if(re.size()<=7){
                            if(check){
                                if (RegistrationDAO.addRegistration(new Registration(
                                        RunTimeUtil.getUserId() + "-" + course.getCourseId(),
                                        StudentDAO.getStudentById(RunTimeUtil.getUserId()),
                                        course,
                                        Timestamp.from(Instant.now()
                                )))) {
                                    JOptionPane.showMessageDialog(null, "Successfully registrated.");
                                    dispose();
                                    RegistrateGUI registrateGUI = new RegistrateGUI(se);
                                } else
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Không thể đăng ký học phần",
                                            "Registration failed",
                                            JOptionPane.WARNING_MESSAGE);
                            }
                            else
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Học phần đã được đăng ký hoặc bị trùng giờ học với các học phần còn lại",
                                        "Registration failed",
                                        JOptionPane.WARNING_MESSAGE);


                        }
                        else
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Không thể đăng ký quá 8 học phần",
                                    "Registration failed",
                                    JOptionPane.WARNING_MESSAGE);

                    } else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã học phần không tồn tại trong học kỳ hiện tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });
        }
    }

    public RegistrateGUI(Semester se) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Registrate Courses");
                setSize(1000, 500);
                add(new RegistratePane(se));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
