package GUI.student.profilemanager;

import DAO.ClazzDAO;
import DAO.StudentDAO;
import POJO.Clazz;
import POJO.Student;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditProfileGUI extends JFrame {
    private class EditProfilePane extends JPanel {
        private JTextField idTf;
        private JTextField nameTf;
        private JComboBox genderCb;
        private DatePicker birthdayDp;
        private JTextField emailTf;
        private JTextField phoneNumberTf;
        private JComboBox classCb;

        EditProfilePane(Student student) {
            setBorder(new EmptyBorder(60, 60, 60, 60));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Mã sinh viên:"));
            idTf = new JTextField(student.getStudentId(), 25);
            add(idTf,gbc);

            add(new JLabel("Tên sinh viên:"));
            nameTf = new JTextField(student.getFullName(), 25);
            add(nameTf, gbc);

            add(new JLabel("Giới tính:"));
            String[] genders = {"nữ", "nam"};
            genderCb = new JComboBox(genders);
            add(genderCb, gbc);

            add(new JLabel("Ngày sinh:"));
            birthdayDp = new DatePicker();
            add(birthdayDp, gbc);

            add(new JLabel("Email"));
            emailTf = new JTextField(student.getEmail(), 25);
            add(emailTf, gbc);

            add(new JLabel("SDT"));
            phoneNumberTf = new JTextField(student.getPhoneNumber(), 25);
            add(phoneNumberTf, gbc);

            add(new JLabel("Lớp:"));
            List<Clazz> clazzes = ClazzDAO.getAllClazzes();
            List<String> clazzStrings = new ArrayList<String>();
            for(Clazz i: clazzes)
                clazzStrings.add(i.getClassId());
            classCb = new JComboBox(clazzStrings.toArray());
            add(classCb, gbc);

            JButton submitBtn = new JButton("Submit");
            add(submitBtn, gbc);

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    student.setStudentId(idTf.getText());
                    student.setFullName(nameTf.getText());
                    student.setGender(genderCb.getSelectedIndex());
                    student.setBirthday(java.sql.Date.valueOf(birthdayDp.getDate()));
                    student.setClazz(clazzes.get(classCb.getSelectedIndex()));
                    student.setEmail(emailTf.getText());
                    student.setPhoneNumber(phoneNumberTf.getText());

                    if(StudentDAO.updateStudent(student))
                        JOptionPane.showMessageDialog(null, "Successfully updated.");
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot insert, please check your student-id",
                                "Edit failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }
    public EditProfileGUI(Student student){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Profile Manager");
                setSize(600, 500);
                add(new EditProfilePane(student));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}

