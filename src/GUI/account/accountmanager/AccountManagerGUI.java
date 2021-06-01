package GUI.account.accountmanager;

import DAO.AccountDAO;
import POJO.Account;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountManagerGUI extends JFrame {

    private class AccountManagerPane extends  JPanel{
        private JButton refreshButton;
        private JTextField searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Account> accounts;
        AccountManagerPane(){
            setTitle("Accounts");
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
                    AccountManagerGUI newaccmnGUI = new AccountManagerGUI();
                }
            });
            add(new JLabel("              Tìm tài khoản giáo vụ bằng username:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Search");
            //listerner
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Account acc = AccountDAO.getAccountByUsername(searchBox.getText());
                    if(acc != null){
                        AccountSearchGUI AccountSearchGUI = new AccountSearchGUI(acc);
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Username không tồn tại",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });

            add(searchButton,gbc);


            Object [] columnNames = new Object[]{ "Id", "Quantity" };


            DefaultTableModel accountModel = new DefaultTableModel();
            JTable accountTable = new JTable(accountModel);
            accountTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            accountModel.addColumn("username");
            accountModel.addColumn("Tên tài khoản");
            accountModel.addColumn("e-mail");
            accountModel.addColumn("Số điện thoại");

            accounts = AccountDAO.getAllAccounts();
            if(accounts != null){
                for(Account i: accounts){
                    accountModel.addRow(new Object[]{
                            i.getUsername(),
                            i.getAccountName(),
                            i.getEmail(),
                            i.getPhoneNumber()
                    });

                }
            }
            JScrollPane scrollPane = new JScrollPane(accountTable);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            add(scrollPane, gbc);
            addButton = new JButton("Thêm tài khoản giáo vụ");
            add(addButton, gbc);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddAccountGUI addAccountGUI = new AddAccountGUI();
                }
            });
        }
    }
    public AccountManagerGUI(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Account Manager");
                setSize(600, 500);
                add(new AccountManagerPane());
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }
}
