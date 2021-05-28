package GUI;

import DAO.AccountDAO;
import POJO.Account;
import utils.RunTimeUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordGUI extends JFrame{
    private JPanel panel;
    private JButton submitButton;
    private JPasswordField currentPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmedPasswordField;

    public ChangePasswordGUI() {
        add(panel);
        setSize(400, 200);
        setTitle("Change password");
        setLocationRelativeTo(null);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentPassword = String.valueOf(currentPasswordField.getPassword());
                String newPassword = String.valueOf(newPasswordField.getPassword());
                String confirmedPassword = String.valueOf(confirmedPasswordField.getPassword());
                if(newPassword.compareTo(currentPassword) == 0 ){
                    JOptionPane.showMessageDialog(null, "New password much be different from current password.","Change password warning", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(confirmedPassword.compareTo(newPassword) != 0){
                        JOptionPane.showMessageDialog(null, "Not same, please re-enter confirmed password","Change password warning", JOptionPane.WARNING_MESSAGE);

                    }else
                    {
                        if(RunTimeUtil.getTypeOfUser().compareTo("account") == 0){
                            Account currentAccount = AccountDAO.getAccountByUsername(RunTimeUtil.getUserId());
                            if(currentAccount.getPassword().compareTo(currentPassword) != 0){
                                JOptionPane.showMessageDialog(null, "Current password is not right.","Change password warning", JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                                Account newAccount = new Account(currentAccount);
                                newAccount.setPassword(newPassword);
                                if(AccountDAO.updateAccount(newAccount)){
                                    JOptionPane.showMessageDialog(null, "Successfully Updated.");
                                }
                                else
                                    JOptionPane.showMessageDialog(null, "Something wrong, please try again.","Change password warning", JOptionPane.WARNING_MESSAGE);

                            }
                        }
                        if(RunTimeUtil.getTypeOfUser().compareTo("student") == 0){
                            /*

                            student

                             */
                        }
                    }
                }
            }
        });
    }
}
