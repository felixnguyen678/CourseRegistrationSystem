package GUI.account.semestermanager;

import DAO.SemesterDAO;
import POJO.Semester;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SemesterManagerGUI extends JFrame {

    private class SemesterManagerPane extends  JPanel{
        private JButton refreshButton;
        private JComboBox searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Semester> semesters;
        SemesterManagerPane(){
            setTitle("Semesters");
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
                    SemesterManagerGUI newsjmnGUI = new SemesterManagerGUI();
                }
            });
            add(new JLabel("              Tìm kiếm học kỳ:"));



            semesters = SemesterDAO.getAllSemesters();
            List<String> strings = new ArrayList<String>();
            for( Semester item: semesters){
                strings.add(item.getSemesterId());
            }
            searchBox = new JComboBox(strings.toArray());
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Semester sm = SemesterDAO.getSemesterById(searchBox.getItemAt(searchBox.getSelectedIndex()).toString());
                    if(sm != null){
                        SearchSemesterGUI searchSemesterGUI = new SearchSemesterGUI(sm);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã môn học không tồn tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);


            DefaultTableModel semesterModel = new DefaultTableModel();
            JTable semesterTable = new JTable(semesterModel);
            semesterTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            semesterModel.addColumn("Mã học kỳ");
            semesterModel.addColumn("Tên học kỳ");
            semesterModel.addColumn("Năm học");
            semesterModel.addColumn("Ngày bắt đầu");
            semesterModel.addColumn("Ngày kết thúc");
            semesterModel.addColumn("Là học kỳ hiện tại");
            if(semesters != null){
                for(Semester i: semesters){
                    Integer year = i.getYear();
                    Integer yearpl = year +1;
                    semesterModel.addRow(new Object[]{
                            i.getSemesterId(),
                            i.getSemesterName(),
                            year + "-" + yearpl,
                            i.getFirstDay(),
                            i.getLastDay(),
                            i.getIsCurrent() == 1 ? "yes" : ""
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(semesterTable);
            scrollPane.setPreferredSize(new Dimension(600, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm học kỳ");
            add(addButton, gbc);


            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddSemesterGUI addSemesterGUI = new AddSemesterGUI();
                }
            });
        }
    }
    public SemesterManagerGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(650, 500);
                add(new SemesterManagerPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
