package GUI.account.coursemanager;

import DAO.CourseDAO;
import DAO.SemesterDAO;
import GUI.account.semestermanager.AddSemesterGUI;
import GUI.account.semestermanager.SearchSemesterGUI;
import POJO.Course;
import POJO.Semester;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseManagerGUI extends JFrame {

    private class CourseManagerPane extends  JPanel{
        private JButton refreshButton;
        private JTextField searchBox;
        private JButton searchButton;
        private JButton addButton;
        private Semester currentSemester;
        CourseManagerPane(){
            setTitle("Semesters");
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            if(SemesterDAO.getCurrentSemesters()!=null)
                currentSemester = SemesterDAO.getCurrentSemesters().get(0);
            else{
                JOptionPane.showMessageDialog(
                        null,
                        "Mã học phần không tồn tại",
                        "Search failed",
                        JOptionPane.WARNING_MESSAGE);
                dispose();
            }

            refreshButton = new JButton("Refresh");
            add(refreshButton);
            refreshButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    CourseManagerGUI newsjmnGUI = new CourseManagerGUI();
                }
            });
            add(new JLabel("              Xóa học phần bằng mã học phần:"));

            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Remove");

            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Course course = currentSemester.getCourseById(searchBox.getText());
                    if(course != null){
                        if(CourseDAO.removeCourse(course))
                            JOptionPane.showMessageDialog(null, "Successfully removed.");
                        else
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Không thể xóa học phần",
                                    "Search failed",
                                    JOptionPane.WARNING_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã học phần không tồn tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);
            add(new JLabel("Các học phần trong học kỳ hiện tại ("+currentSemester.getSemesterId()+"):"), gbc);

            DefaultTableModel courseModel = new DefaultTableModel();
            JTable semesterTable = new JTable(courseModel);
            semesterTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            courseModel.addColumn("Mã học phần");
            courseModel.addColumn("Tên mã môn học");
            courseModel.addColumn("Tên môn học");
            courseModel.addColumn("Mã học kỳ");
            courseModel.addColumn("Phòng học");
            courseModel.addColumn("Ngày trong tuần");
            courseModel.addColumn("Ca");
            courseModel.addColumn("Slot tối đa");

            Set<Course> courses = currentSemester.getCourses();
            if(courses != null){
                for(Course i: courses){

                    courseModel.addRow(new Object[]{
                            i.getCourseId(),
                            i.getSubject().getSubjectId(),
                            i.getSubject().getSubjectName(),
                            i.getSemester(),
                            i.getClassroom(),
                            i.getWeekday(),
                            i.getShift(),
                            i.getMaximumNumberOfSlot()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(semesterTable);
            scrollPane.setPreferredSize(new Dimension(600, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm học phần vào học kỳ hiện tại");
            add(addButton, gbc);


            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    AddCourseGUI addCourseGUI = new AddCourseGUI();
                }
            });
        }
    }
    public CourseManagerGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Course Manager");
                setSize(650, 500);
                add(new CourseManagerPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
