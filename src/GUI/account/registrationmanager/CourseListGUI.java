package GUI.account.registrationmanager;

import DAO.CourseDAO;
import GUI.account.coursemanager.CourseManagerGUI;
import POJO.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CourseListGUI extends JFrame {
    private class CourseListPane extends JPanel{

        CourseListPane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("              Xem kết quả đăng ký học phần theo từng mã học phần:"));
            JTextField searchBox = new JTextField("", 25);
            add(searchBox);
            JButton searchBtn = new JButton("Xem" );
            add(searchBtn, gbc);

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

            List<Course> courses = CourseDAO.getAllCourses();
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

            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Course c = CourseDAO.getCourseById(searchBox.getText());
                    StudentInCourseGUI studentInCourseGUI = new StudentInCourseGUI(c);
                }
            });
        }
    }
    public CourseListGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Course Manager");
                setSize(1000, 500);
                add(new CourseListPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
