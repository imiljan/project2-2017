package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import domen.Member;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class EditMemberGUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8476735821788172201L;
	
	private JPanel contentPane;
	private JLabel labelIcon;
	private JLabel labelId;
	private JTextField textFieldId;
	private JButton btnPronadji;
	private JLabel lblNePostojiTakav;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblPol;
	private JLabel lblUplacena;
	private JLabel lblClanarina;
	private JLabel lblDo;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldPol;
	private JTextField textFieldClanarina;
	private JLabel lblTelefon;
	private JLabel lblDatumRodjenja;
	private JLabel lblVisina;
	private JLabel lblTezina;
	private JTextField textFieldTelefon;
	private JTextField textFieldDatumRodj;
	private JTextField textFieldVisina;
	private JTextField textFieldTezina;
	private JLabel lblYyyyMmDd;
	private JLabel label;
	private JLabel lblObaveznaPoljaNisu;
	private JButton btnIzmeni;
	private JButton btnOdustani;
	private JLabel lblobaveznaPolja;

	/**
	 * Create the frame.
	 */
	public EditMemberGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditMemberGUI.class.getResource("/resources/1493411578_app_type_gym_512px_GREY.png")));
		setTitle("Izmeni clana");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabelIcon());
		contentPane.add(getLabelId());
		contentPane.add(getTextFieldId());
		contentPane.add(getBtnPronadji());
		contentPane.add(getLabel_1());
		contentPane.add(getLabel_2());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_4());
		contentPane.add(getLabel_5());
		contentPane.add(getLabel_6());
		contentPane.add(getLabel_7());
		contentPane.add(getTextFieldIme());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getTextFieldPol());
		contentPane.add(getTextFieldClanarina());
		contentPane.add(getLblTelefon());
		contentPane.add(getLblDatumRodjenja());
		contentPane.add(getLblVisina());
		contentPane.add(getLblTezina());
		contentPane.add(getTextFieldTelefon());
		contentPane.add(getTextFieldDatumRodj());
		contentPane.add(getTextFieldVisina());
		contentPane.add(getTextFieldTezina());
		contentPane.add(getLblYyyyMmDd());
		contentPane.add(getLabel());
		contentPane.add(getLabel_1_1());
		contentPane.add(getBtnIzmeni());
		contentPane.add(getBtnOdustani());
		contentPane.add(getLabel_1_2());
		lblObaveznaPoljaNisu.setVisible(false);
		lblNePostojiTakav.setVisible(false);
		label.setVisible(false);
		this.getRootPane().setDefaultButton(btnPronadji);
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}
	private JLabel getLabelIcon() {
		if (labelIcon == null) {
			labelIcon = new JLabel(new ImageIcon(SigningFormGUI.class.getResource("/resources/1493411578_app_type_gym_512px_GREY.png")));
			labelIcon.setBounds(10, 11, 111, 90);
		}
		return labelIcon;
	}
	private JLabel getLabelId() {
		if (labelId == null) {
			labelId = new JLabel("ID:");
			labelId.setBounds(10, 112, 46, 14);
		}
		return labelId;
	}
	private JTextField getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextField();
			textFieldId.setBounds(10, 137, 86, 20);
			textFieldId.setColumns(10);
		}
		return textFieldId;
	}
	private JButton getBtnPronadji() {
		if (btnPronadji == null) {
			btnPronadji = new JButton("Pronadji");
			btnPronadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int id;
					try {
						id = Integer.parseInt(textFieldId.getText());
					} catch (NumberFormatException e) {
						lblNePostojiTakav.setVisible(true);
						return;
					}
					Member tempMember = GUIController.findMemberId(id);
					if (tempMember == null) {
						lblNePostojiTakav.setVisible(true);
						return;
					}
					lblNePostojiTakav.setVisible(false);
					textFieldId.setEnabled(false);
					btnPronadji.setEnabled(false);
					btnIzmeni.setEnabled(true);
					
					textFieldIme.setText(tempMember.getFirstName());
					textFieldPrezime.setText(tempMember.getLastName());
					textFieldPol.setText(tempMember.getGender() + "");
					textFieldClanarina.setText(tempMember.getEndDate().toString());
					textFieldTelefon.setText((tempMember.getPhoneNumber() != null) ? tempMember.getPhoneNumber() : "");
					textFieldDatumRodj.setText((tempMember.getBirthdate() != null) ? tempMember.getBirthdate().toString() : "");
					textFieldVisina.setText(tempMember.getHeight() + "");
					textFieldTezina.setText(tempMember.getWeight() + "");
					
					textFieldIme.setEnabled(true);
					textFieldPrezime.setEnabled(true);
					textFieldPol.setEnabled(true);
					textFieldClanarina.setEnabled(true);
					textFieldTelefon.setEnabled(true);
					textFieldDatumRodj.setEnabled(true);
					textFieldVisina.setEnabled(true);
					textFieldTezina.setEnabled(true);
				}
			});
			btnPronadji.setBounds(10, 183, 89, 23);
		}
		return btnPronadji;
	}
	private JLabel getLabel_1() {
		if (lblNePostojiTakav == null) {
			lblNePostojiTakav = new JLabel("Ne postoji takav clan!");
			lblNePostojiTakav.setForeground(Color.RED);
			lblNePostojiTakav.setBounds(10, 168, 127, 14);
		}
		return lblNePostojiTakav;
	}
	private JLabel getLabel_2() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:*");
			lblIme.setBounds(131, 24, 72, 14);
		}
		return lblIme;
	}
	private JLabel getLabel_3() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:*");
			lblPrezime.setBounds(131, 46, 72, 14);
		}
		return lblPrezime;
	}
	private JLabel getLabel_4() {
		if (lblPol == null) {
			lblPol = new JLabel("Pol:*");
			lblPol.setBounds(131, 71, 72, 14);
		}
		return lblPol;
	}
	private JLabel getLabel_5() {
		if (lblUplacena == null) {
			lblUplacena = new JLabel("Uplacena*");
			lblUplacena.setBounds(131, 96, 72, 14);
		}
		return lblUplacena;
	}
	private JLabel getLabel_6() {
		if (lblClanarina == null) {
			lblClanarina = new JLabel("clanarina:");
			lblClanarina.setBounds(131, 112, 72, 14);
		}
		return lblClanarina;
	}
	private JLabel getLabel_7() {
		if (lblDo == null) {
			lblDo = new JLabel("do");
			lblDo.setBounds(144, 127, 59, 14);
		}
		return lblDo;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setEnabled(false);
			textFieldIme.setBounds(213, 21, 112, 20);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setEnabled(false);
			textFieldPrezime.setBounds(213, 43, 112, 20);
			textFieldPrezime.setColumns(10);
		}
		return textFieldPrezime;
	}
	private JTextField getTextFieldPol() {
		if (textFieldPol == null) {
			textFieldPol = new JTextField();
			textFieldPol.setEnabled(false);
			textFieldPol.setBounds(213, 68, 112, 20);
			textFieldPol.setColumns(10);
		}
		return textFieldPol;
	}
	private JTextField getTextFieldClanarina() {
		if (textFieldClanarina == null) {
			try {
				MaskFormatter formatter = new MaskFormatter("####-##-##");
				textFieldClanarina = new JFormattedTextField(formatter);
				textFieldClanarina.setEnabled(false);
			} catch (ParseException e) {
				textFieldClanarina = new JFormattedTextField();
			}
			//textFieldClanarina = new JTextField();
			textFieldClanarina.setBounds(213, 109, 112, 20);
			textFieldClanarina.setColumns(10);
		}
		return textFieldClanarina;
	}
	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon:");
			lblTelefon.setBounds(335, 24, 97, 14);
		}
		return lblTelefon;
	}
	private JLabel getLblDatumRodjenja() {
		if (lblDatumRodjenja == null) {
			lblDatumRodjenja = new JLabel("Datum rodjenja:");
			lblDatumRodjenja.setBounds(335, 46, 97, 14);
		}
		return lblDatumRodjenja;
	}
	private JLabel getLblVisina() {
		if (lblVisina == null) {
			lblVisina = new JLabel("Visina:");
			lblVisina.setBounds(335, 71, 97, 14);
		}
		return lblVisina;
	}
	private JLabel getLblTezina() {
		if (lblTezina == null) {
			lblTezina = new JLabel("Tezina:");
			lblTezina.setBounds(335, 112, 97, 14);
		}
		return lblTezina;
	}
	private JTextField getTextFieldTelefon() {
		if (textFieldTelefon == null) {
			textFieldTelefon = new JTextField();
			textFieldTelefon.setEnabled(false);
			textFieldTelefon.setBounds(442, 21, 112, 20);
			textFieldTelefon.setColumns(10);
		}
		return textFieldTelefon;
	}
	private JTextField getTextFieldDatumRodj() {
		if (textFieldDatumRodj == null) {
			try {
				MaskFormatter formatter = new MaskFormatter("####-##-##");
				textFieldDatumRodj = new JFormattedTextField(formatter);
				textFieldDatumRodj.setEnabled(false);
			} catch (ParseException e) {
				textFieldDatumRodj = new JFormattedTextField();
			}
			//textFieldDatumRodj = new JTextField();
			textFieldDatumRodj.setBounds(442, 43, 112, 20);
			textFieldDatumRodj.setColumns(10);
		}
		return textFieldDatumRodj;
	}
	private JTextField getTextFieldVisina() {
		if (textFieldVisina == null) {
			textFieldVisina = new JTextField();
			textFieldVisina.setEnabled(false);
			textFieldVisina.setBounds(442, 68, 112, 20);
			textFieldVisina.setColumns(10);
		}
		return textFieldVisina;
	}
	private JTextField getTextFieldTezina() {
		if (textFieldTezina == null) {
			textFieldTezina = new JTextField();
			textFieldTezina.setEnabled(false);
			textFieldTezina.setBounds(442, 109, 112, 20);
			textFieldTezina.setColumns(10);
		}
		return textFieldTezina;
	}
	private JLabel getLblYyyyMmDd() {
		if (lblYyyyMmDd == null) {
			lblYyyyMmDd = new JLabel("*yyyy-mm-dd");
			lblYyyyMmDd.setBounds(213, 130, 86, 14);
		}
		return lblYyyyMmDd;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("!");
			label.setFont(new Font("Tahoma", Font.BOLD, 11));
			label.setForeground(Color.RED);
			label.setBounds(564, 46, 15, 14);
		}
		return label;
	}
	private JLabel getLabel_1_1() {
		if (lblObaveznaPoljaNisu == null) {
			lblObaveznaPoljaNisu = new JLabel("Obavezna polja nisu popunjena ili je unos nepravilan!");
			lblObaveznaPoljaNisu.setForeground(Color.RED);
			lblObaveznaPoljaNisu.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblObaveznaPoljaNisu.setBounds(172, 168, 397, 14);
		}
		return lblObaveznaPoljaNisu;
	}
	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni");
			btnIzmeni.setEnabled(false);
			btnIzmeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int id = Integer.parseInt(textFieldId.getText());
					String firstName = textFieldIme.getText();
					String lastName = textFieldPrezime.getText();
					String gender = textFieldPol.getText();
					String endDate = textFieldClanarina.getText();
					String phoneNumber = textFieldTelefon.getText();
					String birthdate = textFieldDatumRodj.getText();
					String height = textFieldVisina.getText();
					String weight = textFieldTezina.getText();
					
					if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() ||
							endDate == null || endDate.isEmpty() || gender == null || gender.isEmpty() || gender.length() > 1) {
						lblObaveznaPoljaNisu.setVisible(true);
						return;
					}
					
					Date birth, end;
					double h = 0, w = 0;
					
					try {
						h = Double.parseDouble(height);
						w = Double.parseDouble(weight);
					} catch (NumberFormatException e) {
						
					}
					
					try {
						end = Date.valueOf(endDate);
					} catch (Exception e) {
						lblObaveznaPoljaNisu.setVisible(true);
						return;
					}
					
					try {
						birth = Date.valueOf(birthdate);
					} catch (Exception e2) {
						birth = null;
					}
					
					boolean updated = GUIController.updateMember(id, firstName, lastName, gender.charAt(0), birth,
							phoneNumber, end, h, w);
							
					if (updated) {
						JOptionPane.showMessageDialog(null, "Clan uspesno izmenjen!");
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Clan nije izmenjen!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnIzmeni.setBounds(196, 206, 89, 23);
		}
		return btnIzmeni;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(327, 206, 89, 23);
		}
		return btnOdustani;
	}
	private JLabel getLabel_1_2() {
		if (lblobaveznaPolja == null) {
			lblobaveznaPolja = new JLabel("*Obavezna polja");
			lblobaveznaPolja.setBounds(442, 210, 112, 14);
		}
		return lblobaveznaPolja;
	}
}
