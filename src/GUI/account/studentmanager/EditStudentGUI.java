package GUI.account.studentmanager;

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
import java.util.Date;
import java.util.List;

public class EditStudentGUI extends JFrame {
    private class EditStudentPane extends JPanel{
        private JTextField studentNameTxF;
        private JComboBox genderCb;
        private DatePicker birthdayDp;
        private JComboBox classCb;
        private JTextField emailTxF;
        private JTextField phoneNumberTxF;
        private JButton submitBtn;
        EditStudentPane(Student student){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            studentNameTxF = new JTextField(student.getFullName(), 30);
            String[] gender = {"nam", "nữ"};
            genderCb = new JComboBox(gender);
            birthdayDp = new DatePicker();
            List<Clazz> clazzList = ClazzDAO.getAllClazzes();
            List<String> clazzNameList = new ArrayList<String>();
            for(Clazz i : clazzList)
                clazzNameList.add(i.getClassId());
            classCb = new JComboBox(clazzNameList.toArray());
            emailTxF = new JTextField(student.getEmail(), 30);
            phoneNumberTxF = new JTextField(student.getPhoneNumber(), 30);
            add(new JLabel("Tên sinh viên:"));
            add(studentNameTxF, gbc);
            add(new JLabel("Giới tính:"));
            add(genderCb, gbc);
            add(new JLabel("Ngày sinh:"));
            add(birthdayDp, gbc);
            add(new JLabel("Lớp:"));
            add(classCb, gbc);
            add(new JLabel("E-mail:"));
            add(emailTxF, gbc);
            add(new JLabel("Phone number:"));
            add(phoneNumberTxF, gbc);
            submitBtn = new JButton("Submit");
            add(submitBtn, gbc);

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    student.setFullName(studentNameTxF.getText());
                    student.setGender(genderCb.getItemAt(genderCb.getSelectedIndex()).toString() == "nam"? 1: 0);
                    student.setBirthday(java.sql.Date.valueOf(birthdayDp.getDate()));
                    student.setClazz(clazzList.get(classCb.getSelectedIndex()));
                    student.setEmail(emailTxF.getText());
                    student.setPhoneNumber(phoneNumberTxF.getText());

                    if(StudentDAO.updateStudent(student)){
                        JOptionPane.showMessageDialog(null, "Successfully edit.");
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Cannot edit",
                                "Edit failed",
                                JOptionPane.WARNING_MESSAGE);
                }
            });


        }
    }
    public EditStudentGUI(Student st) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Edit Student");
                setSize(500, 200);
                add(new EditStudentPane(st));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
