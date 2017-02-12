package com.pavansrivatsav.dao;

import com.pavansrivatsav.exception.PersistenceException;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.UserDetail;

public class TestUserDetailDAO {

	public static void main(String[] args) throws ValidationException, ServiceException, PersistenceException {

		UserDetail userDetail = new UserDetail();
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		LoginDAO login=new LoginDAO();

		/* insert */
//
//		userDetail.setName("test");
//		userDetail.setEmailId("tesstt@gmail.com");
//		userDetail.setPassword("testPassword");
//
//		System.out.println("Inserted : " + userDetailDAO.insert(userDetail));

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
		// *Select one*/
		// UserDetail userlist = userDetailDAO.findOne(1);
		// System.out.println(userlist);

		/* User service validation */

		// UserDetailService uds = new UserDetailService();
		// uds.insert(userDetail);

		
//		System.out.println(userDetailDAO.getPassword("charith93@gmail.com"));
		System.out.println(login.userLogIn("charith93@gmail.com", "dsfdsdsfdsfssdfdfsf"));
	}

}
