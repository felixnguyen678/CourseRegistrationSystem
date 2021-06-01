package GUI.account.subjectmanager;

import DAO.SubjectDAO;
import POJO.Subject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SubjectManagerGUI extends JFrame {

    private class SubjectManagerPane extends  JPanel{
        private JButton refreshButton;
        private JComboBox searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Subject> subjects;
        SubjectManagerPane(){
            setTitle("Subjects");
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
                    SubjectManagerGUI newsjmnGUI = new SubjectManagerGUI();
                }
            });
            add(new JLabel("              Tìm kiếm môn học bằng mã môn học:"));



            subjects = SubjectDAO.getAllSubjects();
            List<String> strings = new ArrayList<String>();
            for( Subject item: subjects){
                strings.add(item.getSubjectId());
            }
            searchBox = new JComboBox(strings.toArray());
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Subject sj = SubjectDAO.getSubjectById(searchBox.getItemAt(searchBox.getSelectedIndex()).toString());
                    if(sj != null){
                        SearchSubjectGUI searchSubjectGUI = new SearchSubjectGUI(sj);
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


            DefaultTableModel accountModel = new DefaultTableModel();
            JTable accountTable = new JTable(accountModel);
            accountTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            accountModel.addColumn("Mã môn học");
            accountModel.addColumn("Tên môn học");
            accountModel.addColumn("Số tín chỉ");

            if(subjects != null){
                for(Subject i: subjects){
                    accountModel.addRow(new Object[]{
                            i.getSubjectId(),
                            i.getSubjectName(),
                            i.getNumberOfCredit()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(accountTable);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm môn học");
            add(addButton, gbc);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddSubjectGUI addSubjectGUI = new AddSubjectGUI();
                }
            });
        }
    }
    public SubjectManagerGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(600, 500);
                add(new SubjectManagerPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
