package GUI.account.studentmanager;

import DAO.StudentDAO;
import DAO.StudentDAO;

import GUI.account.studentmanager.StudentSearchGUI;
import POJO.Clazz;
import POJO.Student;
import POJO.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentListGUI extends JFrame{

    private class StudentListPane extends JPanel {
        private JButton refreshButton;
        private JTextField searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Student> students;
        StudentListPane(Clazz clazz){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            refreshButton = new JButton("Refresh");
            add(refreshButton);
            refreshButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    StudentListGUI stl = new StudentListGUI(clazz);
                }
            });
            add(new JLabel("              Tìm tài khoản sinh viên bằng mã sinh viên:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Student st = StudentDAO.getStudentById(searchBox.getText());
                    if(st != null){
                        SearchStudentGUI studentSearchGUI = new SearchStudentGUI(st);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã sinh viên không tồn tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);

            DefaultTableModel studentModel = new DefaultTableModel();
            JTable studentTable = new JTable(studentModel);
            studentTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            studentModel.addColumn("Mã sinh viên");
            studentModel.addColumn("Tên sinh viên");
            studentModel.addColumn("Giới tính");
            studentModel.addColumn("Ngày sinh");
            studentModel.addColumn("Lớp");
            studentModel.addColumn("Email");
            studentModel.addColumn("Số điện thoại");

            students = StudentDAO.getAllStudentsByClass(clazz);
            if(students != null){
                for(Student i: students){
                    studentModel.addRow(new Object[]{
                            i.getStudentId(),
                            i.getFullName(),
                            i.getGender() == 1 ? "nam" : "nữ",
                            i.getBirthday(),
                            i.getClazz().getClassId(),
                            i.getEmail(),
                            i.getPhoneNumber()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(studentTable);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm tài khoản sinh vien");
            add(addButton, gbc);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddStudentGUI addStudentGUI = new AddStudentGUI();
                }
            });
        }
    }

    public StudentListGUI(Clazz clazz){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Student list");
                setSize(600, 500);
                add(new StudentListPane(clazz));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
