package GUI.account.studentmanager;

import DAO.ClazzDAO;
import POJO.Clazz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClassSearchBoxGUI extends JFrame {
    private class ClassSearchBoxPane extends JPanel{

        ClassSearchBoxPane(){
            setBorder(new EmptyBorder(60, 60, 60 ,60 ));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JLabel("Tim kiem sinh vien thuoc lop:"));
            List<Clazz> clazzList = ClazzDAO.getAllClazzes();
            List<String> clazzIdList = new ArrayList<String>();
            for(Clazz i: clazzList)
                clazzIdList.add(i.getClassId());
            JComboBox searchBox = new JComboBox(clazzIdList.toArray());
            add(searchBox);
            JButton searchButton = new JButton("Search");
            add(searchButton);
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StudentListGUI studentListGUI = new StudentListGUI(
                            ClazzDAO.getClazzById(searchBox.getItemAt(searchBox.getSelectedIndex()).toString()));
                }
            });
        }
    }
    public ClassSearchBoxGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Search in Class");
                setSize(500, 200);
                add(new ClassSearchBoxPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
