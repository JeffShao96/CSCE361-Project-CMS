package me.lancer.cms.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import me.lancer.cms.model.Employee;
import me.lancer.cms.service.EmployeeSrv;

public class SettingUI extends JPanel {

	private static final long serialVersionUID = 1L;
	int empId;
	Employee emp;

	public SettingUI(int empId) {
		this.empId = empId;
		this.emp = new EmployeeSrv().Fetch("emp_id=" + empId).get(0);
		this.setLayout(new GridBagLayout());
		initContent();
	}

	protected void initContent() {
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		JButton btnUser = new JButton("View Personal Profile");
		btnUser.setFont(new Font("Times New Romen", Font.PLAIN, 16));
		btnUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsrDialog usrDialog = new UsrDialog(1);
				usrDialog.toFront();
				usrDialog.setModal(true);
				usrDialog.setVisible(true);
			}

		});
		this.add(btnUser);

		JButton btnEdit = new JButton("Edit Personal Profile");
		btnEdit.setFont(new Font("Times New Romen", Font.PLAIN, 16));
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsrDialog usrDialog = new UsrDialog(2);
				usrDialog.toFront();
				usrDialog.setModal(true);
				usrDialog.setVisible(true);
			}

		});
		this.add(btnEdit);

		JButton btnHelp = new JButton("About/Help");
		btnHelp.setFont(new Font("Times New Romen", Font.PLAIN, 16));
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UsrDialog usrDialog = new UsrDialog(3);
				usrDialog.toFront();
				usrDialog.setModal(true);
				usrDialog.setVisible(true);
			}

		});
		this.add(btnHelp);

		JButton btnSwitch = new JButton("Change Account");
		btnSwitch.setFont(new Font("Times New Romen", Font.PLAIN, 16));
		btnSwitch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Unexpected Change!","Message",JOptionPane.ERROR_MESSAGE);
			}

		});
		this.add(btnSwitch);

		JButton btnExit = new JButton("Quit");
		btnExit.setFont(new Font("Times New Romen", Font.PLAIN, 16));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		this.add(btnExit);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(100, 200, 25, 200);
		gbl.setConstraints(btnUser, gbc);
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 200, 25, 200);
		gbl.setConstraints(btnEdit, gbc);
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 200, 25, 200);
		gbl.setConstraints(btnHelp, gbc);
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 200, 25, 200);
		gbl.setConstraints(btnSwitch, gbc);
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 200, 100, 200);
		gbl.setConstraints(btnExit, gbc);
	}

	public static void showPanel() {
		JFrame frame = new JFrame("Setting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SettingUI(1));
		frame.pack();
		frame.setVisible(true);
	}

	class UsrDialog extends JDialog {

		private static final long serialVersionUID = 1L;
		int flag;
		private int width = 400;
		private int height = 400;
		private JPanel pan = new JPanel();
		private JLabel lblAccess1, lblName1, lblNo1, lblAddr1, lblTel1, lblEmail1;
		private JLabel lblAccess2, lblName2, lblNo2, lblAddr2, lblTel2, lblEmail2;
		private JComboBox<String> cbxAccess;
		private JLabel lblName, lblNo, lblPassWord, lblAddr, lblTel, lblEmail;
		private JTextField txtName, txtNo, txtAddr, txtTel, txtEmail;
		private JPasswordField txtPassWord;
		private JButton btnYes, btnNot;
		String accessList[] = { "Employee", "Manager", "Administrator" };

		UsrDialog(int flag) {
			this.flag = flag;
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setLayout(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});

			if (flag == 1) {
				this.setTitle("View Personal Profile");

				lblAccess1 = new JLabel("Authority: ");
				lblAccess1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAccess1.setBounds(80, 30, 120, 30);
				pan.add(lblAccess1);
				lblAccess2 = new JLabel("");
				lblAccess2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAccess2.setBounds(200, 30, 240, 30);
				pan.add(lblAccess2);

				lblNo1 = new JLabel("Workers Number: ");
				lblNo1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblNo1.setBounds(80, 65, 150, 30);
				pan.add(lblNo1);
				lblNo2 = new JLabel("");
				lblNo2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblNo2.setBounds(200, 65, 240, 30);
				pan.add(lblNo2);

				lblName1 = new JLabel("Name: ");
				lblName1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblName1.setBounds(80, 100, 60, 30);
				pan.add(lblName1);
				lblName2 = new JLabel("");
				lblName2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblName2.setBounds(200, 100, 240, 30);
				pan.add(lblName2);

				lblAddr1 = new JLabel("Address: ");
				lblAddr1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAddr1.setBounds(80, 135, 120, 30);
				pan.add(lblAddr1);
				lblAddr2 = new JLabel("");
				lblAddr2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAddr2.setBounds(200, 135, 240, 30);
				pan.add(lblAddr2);

				lblTel1 = new JLabel("Phone Number: ");
				lblTel1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblTel1.setBounds(80, 170, 150, 30);
				pan.add(lblTel1);
				lblTel2 = new JLabel();
				lblTel2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblTel2.setBounds(200, 170, 240, 30);
				pan.add(lblTel2);

				lblEmail1 = new JLabel("E-mail: ");
				lblEmail1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblEmail1.setBounds(80, 205, 120, 30);
				pan.add(lblEmail1);
				lblEmail2 = new JLabel();
				lblEmail2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblEmail2.setBounds(200, 205, 240, 30);
				pan.add(lblEmail2);

				lblAccess2.setText(accessList[emp.getAccess() - 1]);
				lblName2.setText(emp.getName());
				lblNo2.setText(Integer.toString(emp.getNo()));
				lblAddr2.setText(emp.getAddr());
				lblTel2.setText(emp.getTel());
				lblEmail2.setText(emp.getEmail());

				btnNot = new JButton("Yes");
				btnNot.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				btnNot.setBounds(width - 106, height - 80, 66, 30);
				btnNot.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}

				});
				pan.add(btnNot);

				pan.setBounds(0, 0, width, this.height);
				pan.setLayout(null);
				this.add(pan);
			} else if (flag == 2) {
				this.setTitle("Edit Personal Profile");

				lblNo = new JLabel("Workers Number : ");
				lblNo.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblNo.setBounds(80, 30, 120, 30);
				pan.add(lblNo);
				txtNo = new JTextField();
				txtNo.setBounds(200, 30, 120, 30);
				pan.add(txtNo);

				lblName = new JLabel("Name: ");
				lblName.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblName.setBounds(80, 65, 60, 30);
				pan.add(lblName);
				txtName = new JTextField();
				txtName.setBounds(200, 65, 120, 30);
				pan.add(txtName);

				lblPassWord = new JLabel("Password: ");
				lblPassWord.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblPassWord.setBounds(80, 100, 120, 30);
				pan.add(lblPassWord);
				txtPassWord = new JPasswordField();
				txtPassWord.setBounds(200, 100, 120, 30);
				pan.add(txtPassWord);

				lblAddr = new JLabel("Address: ");
				lblAddr.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAddr.setBounds(80, 135, 80, 30);
				pan.add(lblAddr);
				txtAddr = new JTextField();
				txtAddr.setBounds(200, 135, 120, 30);
				pan.add(txtAddr);

				lblTel = new JLabel("Phone Number: ");
				lblTel.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblTel.setBounds(80, 170, 120, 30);
				pan.add(lblTel);
				txtTel = new JTextField();
				txtTel.setBounds(200, 170, 120, 30);
				pan.add(txtTel);

				lblEmail = new JLabel("E-mail: ");
				lblEmail.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblEmail.setBounds(80, 205, 80, 30);
				pan.add(lblEmail);
				txtEmail = new JTextField();
				txtEmail.setBounds(200, 205, 120, 30);
				pan.add(txtEmail);

				txtName.setText(emp.getName());
				txtNo.setText(Integer.toString(emp.getNo()));
				txtPassWord.setText(emp.getPassword());
				txtAddr.setText(emp.getAddr());
				txtTel.setText(emp.getTel());
				txtEmail.setText(emp.getEmail());

				btnYes = new JButton("Yes");
				btnYes.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				btnYes.setBounds(40, height - 80, 66, 30);
				btnYes.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						emp.setAccess(cbxAccess.getSelectedIndex() + 1);
						emp.setName(txtName.getText());
						emp.setNo(Integer.parseInt(txtNo.getText()));
						emp.setPassword(txtPassWord.getText());
						emp.setAddr(txtAddr.getText());
						emp.setTel(txtTel.getText());
						emp.setEmail(txtEmail.getText());
						new EmployeeSrv().modify(emp);
						dispose();
					}

				});
				pan.add(btnYes);

				btnNot = new JButton("Cancel");
				btnNot.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				btnNot.setBounds(width - 106, height - 80, 90, 30);
				btnNot.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}

				});
				pan.add(btnNot);

				pan.setBounds(0, 0, width, this.height);
				pan.setLayout(null);
				this.add(pan);
			} else if (flag == 3) {
				this.setTitle("About authors");

				lblAccess1 = new JLabel("Author : ");
				lblAccess1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAccess1.setBounds(80, 30, 80, 30);
				pan.add(lblAccess1);
				lblAccess2 = new JLabel("Group 10");
				lblAccess2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAccess2.setBounds(140, 30, 240, 30);
				pan.add(lblAccess2);

				lblNo1 = new JLabel("Phone : ");
				lblNo1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblNo1.setBounds(80, 65, 80, 30);
				pan.add(lblNo1);
				lblNo2 = new JLabel("");
				lblNo2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblNo2.setBounds(140, 65, 240, 30);
				pan.add(lblNo2);

				lblName1 = new JLabel("E-mail : ");
				lblName1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblName1.setBounds(80, 100, 80, 30);
				pan.add(lblName1);
				lblName2 = new JLabel("");
				lblName2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblName2.setBounds(140, 100, 240, 30);
				pan.add(lblName2);

				lblAddr1 = new JLabel("Blog : ");
				lblAddr1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAddr1.setBounds(80, 135, 80, 30);
				pan.add(lblAddr1);
				lblAddr2 = new JLabel("");
				lblAddr2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblAddr2.setBounds(140, 135, 240, 30);
				pan.add(lblAddr2);

				lblTel1 = new JLabel("Github : ");
				lblTel1.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblTel1.setBounds(80, 170, 80, 30);
				pan.add(lblTel1);
				lblTel2 = new JLabel("");
				lblTel2.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				lblTel2.setBounds(140, 170, 240, 30);
				pan.add(lblTel2);

				btnNot = new JButton("Yes");
				btnNot.setFont(new Font("Times New Romen", Font.PLAIN, 16));
				btnNot.setBounds(width - 106, height - 80, 66, 30);
				btnNot.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}

				});
				pan.add(btnNot);

				pan.setBounds(0, 0, width, this.height);
				pan.setLayout(null);
				this.add(pan);
			}
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				showPanel();
			}
		});
	}
}