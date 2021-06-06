package GUI.student.profilemanager;

import DAO.StudentDAO;
import GUI.ChangePasswordGUI;
import GUI.account.studentmanager.EditStudentGUI;
import POJO.Student;
import utils.RunTimeUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileGUI extends JFrame {
    private class ProfilePane extends JPanel{

        ProfilePane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            Student student = StudentDAO.getStudentById(RunTimeUtil.getUserId());
            if(student == null) return;

            add(new JLabel("Mã sinh viên:"));
            add(new JLabel(student.getStudentId()), gbc);
            add(new JLabel("Tên sinh viên:"));
            add(new JLabel(student.getFullName()), gbc);
            add(new JLabel("Giới tính:"));
            add(new JLabel(student.getGender() == 1 ?"nam": "nữ"), gbc);
            add(new JLabel("Ngày sinh:"));
            add(new JLabel(student.getBirthday().toString()), gbc);
            add(new JLabel("Email:"));
            add(new JLabel(student.getEmail()), gbc);
            add(new JLabel("SDT:"));
            add(new JLabel(student.getPhoneNumber()), gbc);
            add(new JLabel("Lớp:"));
            add(new JLabel(student.getClazz().getClassId()), gbc);

            JButton editBtn = new JButton("Edit Profile");
            add(editBtn);
            JButton changePassBtn = new JButton("Change Password");
            add(changePassBtn, gbc);
            editBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditProfileGUI editProfileGUI = new EditProfileGUI(student);
                }
            });

            changePassBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ChangePasswordGUI  changePasswordGUI = new ChangePasswordGUI();
                }
            });
        }
    }
    public ProfileGUI(Student st) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Edit Student");
                setSize(500, 200);
                add(new ProfilePane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }

}
