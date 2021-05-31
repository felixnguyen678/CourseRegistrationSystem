package GUI.account.clazzmanager;

import DAO.ClazzDAO;
import POJO.Clazz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClazzManagerGUI extends JFrame {

    public class ClazzManagerPane extends  JPanel{
        private JButton refreshButton;
        private JTextField searchBox;
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
            add(new JLabel("              Search class by class-id:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clazz cl = ClazzDAO.getClazzById(searchBox.getText());
                    if(cl != null){
                        SearchClazzGUI searchClazzGUI = new SearchClazzGUI(cl);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "We don't have any class-id like this",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);


            DefaultTableModel accountModel = new DefaultTableModel();
            JTable accountTable = new JTable(accountModel);
            accountTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            accountModel.addColumn("class-id:");
            accountModel.addColumn("class name");

            clazzes = ClazzDAO.getAllClazzes();
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
            addButton = new JButton("Add new class");
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
