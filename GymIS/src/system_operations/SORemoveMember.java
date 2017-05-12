package system_operations;

import java.sql.SQLException;

import model.Model;

public class SORemoveMember {

	public static boolean execute(Model model, int id) {
		try {
			return model.removeMember(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
