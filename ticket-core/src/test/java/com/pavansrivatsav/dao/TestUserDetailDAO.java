package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.TicketDetail;
import com.pavansrivatsav.modal.UserDetail;
import com.pavansrivatsav.service.UserDetailService;
import com.pavansrivatsav.validator.UserDetailValidator;

public class TestUserDetailDAO {

	public static void main(String[] args) throws ValidationException, ServiceException {

		UserDetail userDetail = new UserDetail();
		UserDetailDAO userDetailDAO = new UserDetailDAO();

		/* insert */
		// userDetail.setId(3);
		// userDetail.setName("test");
		// userDetail.setEmailId("tesstt@gmail.com");
		// userDetail.setPassword("testPassword");
		// userDetail.setStatus(true);
		// System.out.println("Inserted : " + userDetailDAO.insert(userDetail));

		/* update */

		// userDetail.setPassword("test");
		// userDetail.setEmailId("");
		// System.out.println("Updated : " + userDetailDAO.update(userDetail));

		/* Delete */
		// userDetail.setId(3);
		// System.out.println("Deleted : " + userDetailDAO.delete(userDetail));

		/* Select */

		// List<UserDetail> userlist = userDetailDAO.find();
		// for (UserDetail i : userlist) {
		//
		// System.out.println(i);
		// }

		// UserDetail userlist = userDetailDAO.findOne(1);
		// System.out.println(userlist);

		// UserDetailValidator valid = new UserDetailValidator();
		// // valid.emailValidation(userDetail);
		// valid.passwordValidation("pavanss.");

		// UserDetailService uds = new UserDetailService();
		// uds.insert(userDetail);

		// UserModules mod = new UserModules();
		// System.out.println(mod.closeTicket("GOWTHAMGOW@GMAIL.COM",
		// "GOWPASSWORD", 1));
		// //
		// UserDetailDAO dao = new UserDetailDAO();
		// System.out.println(dao.getUserId("GOWTHAMGOW@GMAIL.COM"));
	}

}
