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

    public class AccountManagerPane extends  JPanel{
        private JButton refreshButton;
        private JTextField searchBox;
        private JButton searchButton;
        private JButton addButton;
        private List<Account> accounts;
        AccountManagerPane(){
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
            add(new JLabel("              Search account by username:"));
            searchBox = new JTextField("", 25);
            add(searchBox);
            searchButton = new JButton("Search");
            add(searchButton,gbc);
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
                                "We don't have any username like this",
                                "Search failed",
                                JOptionPane.WARNING_MESSAGE);

                }
            });


            Object [] columnNames = new Object[]{ "Id", "Quantity" };


            DefaultTableModel accountModel = new DefaultTableModel();
            JTable accountTable = new JTable(accountModel);
            accountTable.setPreferredScrollableViewportSize(new Dimension(500,80));

            accountModel.addColumn("username");
            accountModel.addColumn("account name");
            accountModel.addColumn("e-mail");
            accountModel.addColumn("phone number");

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
            addButton = new JButton("Add new account");
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
