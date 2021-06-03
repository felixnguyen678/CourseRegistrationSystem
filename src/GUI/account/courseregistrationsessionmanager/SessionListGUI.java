package GUI.account.courseregistrationsessionmanager;

import DAO.CourseRegistrationSessionDAO;
import DAO.SemesterDAO;
import GUI.account.clazzmanager.ClazzManagerGUI;
import POJO.CourseRegistrationSession;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import POJO.CourseRegistrationSession;
import POJO.Semester;

public class SessionListGUI extends  JFrame{
    private class SessionListPane extends JPanel{
        List<CourseRegistrationSession> sessionList;
        JButton addBtn;
        SessionListPane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            sessionList = CourseRegistrationSessionDAO.getAllCourseRegistrationSession();

            DefaultTableModel model = new DefaultTableModel();
            JTable  table = new JTable(model);
            table.setPreferredScrollableViewportSize(new Dimension(500, 80));

            model.addColumn("Mã học kỳ:");
            model.addColumn("Tên học kỳ:");
            model.addColumn("Năm học:");
            model.addColumn("Ngày bắt đầu đăng ký:");
            model.addColumn("Ngày kết thúc đăng ký:");

            for(CourseRegistrationSession i : sessionList){
                model.addRow(new Object[]{
                        i.getSemesterId(),
                        i.getSemester().getSemesterName(),
                        i.getSemester().getYear(),
                        i.getFistDay(),
                        i.getLastDay()
                });
            }
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            JButton refreshBth = new JButton("Refresh");
            refreshBth.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    dispose();
                    SessionListGUI ss = new SessionListGUI();
                }
            });
            add(refreshBth, gbc);
            add(scrollPane, gbc);
            addBtn = new JButton("Thêm đợt đăng ký học phần cho học kỳ hiện tại");
            add(addBtn, gbc);
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Semester> crsm = SemesterDAO.getCurrentSemesters();
                    if(crsm == null || crsm.size() == 0)
                        JOptionPane.showMessageDialog(
                                null,
                                "Khong co hoc ky hien tai",
                                "",
                                JOptionPane.WARNING_MESSAGE);
                    else{
                        if(CourseRegistrationSessionDAO.getCourseRegistrationSessionById(
                                crsm.get(0).getSemesterId()
                        ) != null)
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Đã có đợt đăng ký học phần",
                                    "",
                                    JOptionPane.WARNING_MESSAGE);
                        else{
                            AddSessionGUI addSessionGUI = new AddSessionGUI();
                        }
                    }
                }
            });
        }
    }
    public SessionListGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Các đợt đăng ký học phần");
                setSize(600, 500);
                add(new SessionListPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
