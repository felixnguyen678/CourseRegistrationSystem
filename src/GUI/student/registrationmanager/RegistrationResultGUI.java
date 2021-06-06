package GUI.student.registrationmanager;

import DAO.CourseDAO;
import DAO.RegistrationDAO;
import DAO.SemesterDAO;
import DAO.StudentDAO;
import GUI.account.semestermanager.SemesterManagerGUI;
import POJO.Course;
import POJO.Registration;
import POJO.Semester;
import POJO.Student;
import utils.RunTimeUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

public class RegistrationResultGUI extends JFrame {
    private class RegistrationResultPane extends JPanel{
        private JTextField searchBox;
        private JButton searchButton;

        RegistrationResultPane(){
            setBorder(new EmptyBorder(60, 60, 60, 60));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JButton refreshButton = new JButton("Refresh");
            add(refreshButton);
            refreshButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    RegistrationResultGUI registrationResultGUI = new RegistrationResultGUI();
                }
            });

            add(new JLabel("              Hủy đăng ký học phần đã đăng ký bằng mã học phần:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Hủy đăng ký");
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

            Student st = StudentDAO.getStudentById(RunTimeUtil.getUserId());
            Set<Registration> res = st.getRegistrations();
            if(res != null){
                for(Registration i: res){

                    courseModel.addRow(new Object[]{
                            i.getCourse().getCourseId(),
                            i.getCourse().getSubject().getSubjectId(),
                            i.getCourse().getSubject().getSubjectName(),
                            i.getCourse().getSubject().getNumberOfCredit(),
                            i.getCourse().getSemester(),
                            i.getCourse().getTeacherName(),
                            i.getCourse().getClassroom(),
                            i.getCourse().getWeekday(),
                            i.getCourse().getShift(),
                            i.getCourse().getMaximumNumberOfSlot()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(courseTable);
            scrollPane.setPreferredSize(new Dimension(900, 200));
            add(scrollPane, gbc);

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Registration re = RegistrationDAO.getRegistrationByStudentAndCourse(st,
                            CourseDAO.getCourseById(searchBox.getText())
                            );
                    if(re == null){
                        JOptionPane.showMessageDialog(
                                null,
                                "mã học phần không hợp lệ",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        Timestamp ts = Timestamp.from(Instant.now());
                        if(ts.getTime() - re.getCourse().getSemester().getRegistrationSession().getLastDay().getTime() > 0){
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Đã quá hạn điều chỉnh học phần",
                                    "Remove failed",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        else
                        {
                            if(RegistrationDAO.removeRegistration(re))
                                JOptionPane.showMessageDialog(null, "Successfully deregsitrated.");
                            else
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Khong the huy",
                                        "Remove failed",
                                        JOptionPane.WARNING_MESSAGE);
                        }
                    }

                }
            });
        }
    }
    public RegistrationResultGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Registrate Courses");
                setSize(1000, 500);
                add(new RegistrationResultPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
