	package gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Controller;
import domen.Member;
import domen.Timestamp;

public class GUIController {
	private static MainWindowGUI mainWindowGUI;
	private static AddNewMemberGUI addNewMemberGUI;
	private static EditMemberGUI editMemberGUI;
	private static FindMemberGUI findMemberGUI;
	private static PayMembershipGUI payMembershipGUI;
	private static RecordGUI recordGUI;
	private static RemoveMemberGUI removeMemberGUI;
	private static ShowEvidenceGUI showEvidenceGUI;
	private static EvidenceGUI evidenceGUI;
	private static SigningFormGUI signingFormGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signingFormGUI = new SigningFormGUI();
					signingFormGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void exitApplication() {
		int option = JOptionPane.showConfirmDialog(mainWindowGUI, "Da li zelite da zatvorite aplikaciju?", "Zatvaranje",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	// Showing windows
	// ==================================
	public static void showMainWindow() {
		mainWindowGUI = new MainWindowGUI();
		mainWindowGUI.setVisible(true);
		mainWindowGUI.setLocationRelativeTo(null);
		mainWindowGUI.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitApplication();
			}
		});
	}

	public static void showWindowAddNewMember() {
		addNewMemberGUI = new AddNewMemberGUI();
		addNewMemberGUI.setVisible(true);
	}

	public static void showWindowEditMember() {
		editMemberGUI = new EditMemberGUI();
		editMemberGUI.setVisible(true);
	}

	public static void showWindowRemoveMember() {
		removeMemberGUI = new RemoveMemberGUI();
		removeMemberGUI.setVisible(true);
	}

	public static void showWindowFindMember() {
		findMemberGUI = new FindMemberGUI();
		findMemberGUI.setVisible(true);
	}

	public static void showWindowPayMembership() {
		payMembershipGUI = new PayMembershipGUI();
		payMembershipGUI.setVisible(true);

	}

	public static void showWindowShowEvidence() {
		showEvidenceGUI = new ShowEvidenceGUI();
		showEvidenceGUI.setVisible(true);
	}
	
	public static void showWindowEvidence() {
		evidenceGUI = new EvidenceGUI();
		evidenceGUI.setVisible(true);
	}

	public static void showWindowRecord() {
		recordGUI = new RecordGUI();
		recordGUI.setVisible(true);
	}

	//===============================================
	
	public static boolean logIn(String username, String pass) {
		return Controller.logIn(username, pass);
	}

	public static LinkedList<Member> getAllMembers() {
		return Controller.getAllMembers();
	}


	public static boolean addNewMember(String firstName, String lastName, char gender, Date birth, String phone, Date end,
			double h, double w) {
		return Controller.addNewMember(firstName, lastName, gender, birth, phone, end, h, w);
	}

	public static boolean removeMember(int id) {
		return Controller.removeMember(id);
	}

	public static Member findMemberId(int id) {
		return Controller.findMemberId(id);
	}

	public static boolean updateMember(int id, String firstName, String lastName, char gender, Date birth,
			String phoneNumber, Date end, double h, double w) {
		return Controller.updateMember(id, firstName, lastName, gender, birth, phoneNumber, end, h, w);
	}

	public static LinkedList<Member> findMembersName(String name) {
		return Controller.findMembersName(name);
	}

	public static void showMembersInTable(LinkedList<Member> members) {
		mainWindowGUI.showMembersInTable(members);
	}

	public static LinkedList<Member> findMembersLastName(String lastName) {
		return Controller.findMembersLastName(lastName);
	}

	public static boolean enterRecord(int id) {
		return Controller.enterRecord(id);
	}
	
	public static boolean payMembership(int id, String endDate) {
		return Controller.payMembership(id, endDate);
	}

	public static boolean showEvidenceForId(int id) {
		evidenceGUI = new EvidenceGUI();
		
		
		LinkedList<Timestamp> records = Controller.getAllRecords(id);
		String text = "";
		if(records == null || records.size() == 0) {
			showEvidenceGUI.setErrorLabelVisible(true);
//			evidenceGUI = null;
			return false;
		}
		Member member = Controller.findMemberId(id);
		if (member == null) {
			showEvidenceGUI.setErrorLabelVisible(true);
			return false;
		}
		
		for (Timestamp timestamp : records) {
			text = text + timestamp.getDate().toString() + " " + timestamp.getTime().toString() + "\n\n";
		}
		
		evidenceGUI.setTextInTextArea(text);
		evidenceGUI.setAttributes(id, member.getFirstName(), member.getLastName(), member.getEndDate().toString());
		evidenceGUI.setVisible(true);
		return true;
	}

	public static void disposeEvidence() {
		if(evidenceGUI != null)
			evidenceGUI.dispose();
		evidenceGUI = null;
	}

	public static void showInfoAboutAuthors() {
		JOptionPane.showMessageDialog(mainWindowGUI, "Autori: Miljan Ignjatovic\n              Filip Egeric\nFON, Beograd 2017", "O autorima", JOptionPane.INFORMATION_MESSAGE);
	}

	

}
