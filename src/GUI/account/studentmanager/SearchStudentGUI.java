package GUI.account.studentmanager;

import DAO.StudentDAO;
import POJO.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudentGUI extends JFrame {
    private class SearchStudentPane extends JPanel{

        SearchStudentPane(Student student){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JLabel("Mã sinh viên:"));
            add(new JLabel(student.getStudentId()), gbc);
            add(new JLabel("Họ tên:"));
            add(new JLabel(student.getFullName()), gbc);
            add(new JLabel("Giới tính:"));
            add(new JLabel(student.getGender() == 1 ? "nam" : "nữ"), gbc);
            add(new JLabel("Ngày sinh:"));
            add(new JLabel(student.getBirthday().toString()), gbc);
            add(new JLabel("Lớp:"));
            add(new JLabel(student.getClazz().getClassId()), gbc);
            add(new JLabel("Email:"));
            add(new JLabel(student.getEmail()), gbc);
            add(new JLabel("SDT:"));
            add(new JLabel(student.getPhoneNumber()), gbc);
            JButton editButon = new JButton("Edit");
            JButton resetPassword = new JButton("Refesh Password");
            add(editButon);
            add(resetPassword, gbc);

            editButon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    EditStudentGUI editStudentGUI = new EditStudentGUI(student);
                }
            });
            resetPassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    student.setPassword(student.getStudentId());
                    if(StudentDAO.updateStudent(student))
                        JOptionPane.showMessageDialog(null, "Successfully reset pasword.");

                }
            });
        }
    }
    public SearchStudentGUI(Student student) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Student");
                setSize(500, 300);
                add(new SearchStudentPane(student));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
