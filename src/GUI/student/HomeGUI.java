package GUI.student;

import DAO.SemesterDAO;
import DAO.StudentDAO;
import GUI.LoginGUI;
import GUI.student.profilemanager.ProfileGUI;
import GUI.student.registrationmanager.RegistrateGUI;
import GUI.student.registrationmanager.RegistrationResultGUI;
import POJO.Semester;
import POJO.Student;
import utils.RunTimeUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class HomeGUI extends JFrame{
    private JButton courseRegistrationButton;
    private JButton yourRegistrationButton;
    private JButton yourProfileButton;
    private JButton logOutButton;
    private JPanel panel;


    public HomeGUI(Student student){
        add(panel);
        setSize(300, 300);
        setTitle("Home");
        setLocationRelativeTo(null);
        setVisible(true);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });
        yourProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfileGUI profileGUI = new ProfileGUI(StudentDAO.getStudentById(RunTimeUtil.getUserId()));
            }
        });
        courseRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Semester> currentSemesters = SemesterDAO.getCurrentSemesters();
                if(currentSemesters == null || currentSemesters.size() == 0)
                    JOptionPane.showMessageDialog(
                            null,
                            "Có lỗi xảy ra, không có học kỳ hiện tại",
                            "failed",
                            JOptionPane.WARNING_MESSAGE);
                else
                {
                    Semester se = currentSemesters.get(0);
                    Timestamp ts = Timestamp.from(Instant.now());

                    if(se.getLastDay().getTime() - ts.getTime() < 0) {
                        RegistrateGUI registrateGUI = new RegistrateGUI(se);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Đợt đăng ký học phần đã kết thúc",
                                "failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        yourRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationResultGUI registrationResultGUI = new RegistrationResultGUI();
            }
        });
    }
}
