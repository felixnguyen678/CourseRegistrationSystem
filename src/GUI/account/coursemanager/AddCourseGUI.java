package GUI.account.coursemanager;

import DAO.CourseDAO;
import DAO.SemesterDAO;
import DAO.SubjectDAO;
import GUI.account.studentmanager.SearchStudentGUI;
import POJO.Course;
import POJO.Semester;
import POJO.Student;
import POJO.Subject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddCourseGUI extends JFrame {
    private class AddCoursePane extends JPanel{
        private JTextField courseIdTf;
        private JComboBox subjectCb;
        private JTextField classroomTf;
        private JComboBox weekdayCb;
        private JComboBox shiftCb;
        private JSpinner maxSlotSp;
        private JButton addBtn;
        AddCoursePane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Mã học phần:"));
            courseIdTf = new JTextField("", 25);
            add(courseIdTf, gbc);

            add(new JLabel("Môn học:"));
            List<Subject> subjects = SubjectDAO.getAllSubjects();
            List<String> subjectStrings = new ArrayList<String>();
            if(subjects != null){
                for(Subject i : subjects){
                    subjectStrings.add(i.getSubjectId() + " - " + i.getSubjectName());
                }
            }
            subjectCb = new JComboBox(subjectStrings.toArray());
            add(subjectCb, gbc);

            add(new JLabel("Phòng học:"));
            classroomTf = new JTextField("", 25);
            add(classroomTf, gbc);

            add(new JLabel("Ngày trong tuần:"));
            String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            weekdayCb = new JComboBox(weekdays);
            add(weekdayCb, gbc);

            add(new JLabel("Ca:"));
            String[] shifts = {"Ca 1 (7:30-9:30)", "Ca 2 (9:30-11:30)", "Ca 3 (13:30-15:30)", "Ca 4 (15:30-17:30)"};
            shiftCb = new JComboBox(shifts);
            add(shiftCb, gbc);

            add(new JLabel("Số lượng slot tối đa:"));
            SpinnerModel value =
                    new SpinnerNumberModel(50, //initial value
                            0, //minimum value
                            100, //maximum value
                            10); //step
            maxSlotSp = new JSpinner(value);
            add(maxSlotSp, gbc);

            addBtn = new JButton("Thêm học phần vào học kỳ hiện tại");
            add(addBtn, gbc);
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(CourseDAO.addCourse(new Course(
                            courseIdTf.getText(),
                            classroomTf.getText(),
                            weekdayCb.getItemAt(weekdayCb.getSelectedIndex()).toString(),
                            shiftCb.getSelectedIndex() + 1,
                            (int)maxSlotSp.getValue(),
                            subjects.get(subjectCb.getSelectedIndex()),
                            SemesterDAO.getCurrentSemesters().get(0)
                    )))
                        JOptionPane.showMessageDialog(null, "Successfully added.");
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã học phần đã tồn tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }
    public AddCourseGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Add Course to semester");
                setSize(500, 300);
                add(new AddCoursePane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
