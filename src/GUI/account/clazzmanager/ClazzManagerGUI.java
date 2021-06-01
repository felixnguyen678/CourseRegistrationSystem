package GUI.account.clazzmanager;

import DAO.ClazzDAO;
import POJO.Clazz;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClazzManagerGUI extends JFrame {

    private class ClazzManagerPane extends  JPanel{
        private JButton refreshButton;
        private JComboBox searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Clazz> clazzes;
        ClazzManagerPane(){
            setTitle("Classes");
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
                    ClazzManagerGUI newclmnGUI = new ClazzManagerGUI();
                }
            });
            add(new JLabel("              Tìm kiếm lớp bằng mã lớp:"));



            clazzes = ClazzDAO.getAllClazzes();
            List<String> strings = new ArrayList<String>();
            for( Clazz item: clazzes){
                strings.add(item.getClassId());
            }
            searchBox = new JComboBox(strings.toArray());
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clazz cl = ClazzDAO.getClazzById(searchBox.getItemAt(searchBox.getSelectedIndex()).toString());
                    if(cl != null){
                        SearchClazzGUI searchClazzGUI = new SearchClazzGUI(cl);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Mã lớp không hợp lệ",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);


            DefaultTableModel accountModel = new DefaultTableModel();
            JTable accountTable = new JTable(accountModel);
            accountTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            accountModel.addColumn("Mã lớp");
            accountModel.addColumn("Tên lớp");


            if(clazzes != null){
                for(Clazz i: clazzes){
                    accountModel.addRow(new Object[]{
                            i.getClassId(),
                            i.getClassName(),
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(accountTable);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm lớp");
            add(addButton, gbc);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddClazzGUI addClazzGUI = new AddClazzGUI();
                }
            });
        }
    }
    public ClazzManagerGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(600, 500);
                add(new ClazzManagerPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
