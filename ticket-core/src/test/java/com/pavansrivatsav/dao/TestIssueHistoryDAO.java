package com.pavansrivatsav.dao;

import java.util.List;

import com.pavansrivatsav.modal.Department;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.modal.TicketDetail;

public class TestIssueHistoryDAO {

	public static void main(String args[]) {
		IssueHistory issueHistory = new IssueHistory();
		IssueHistoryDAO issueHistorydao = new IssueHistoryDAO();
		/* insert */
		//
		// issueHistory.setId(1);
		//
		TicketDetail td = new TicketDetail();
		td.setId(1);
		// issueHistory.setTicketId(td);
		//
		// issueHistory.setSolution("hi");
		//
		// System.out.println(issueHistorydao.insert(issueHistory));
		//
		/* update */

		// issueHistory.setSolution("hiee");
		// issueHistory.setTicketId(td);
		// System.out.println(issueHistorydao.update(issueHistory));

		/* Delete */

		issueHistory.setId(1);
		System.out.println(issueHistorydao.delete(issueHistory));

		/* Select */

		List<IssueHistory> issuelist = issueHistorydao.find();
		for (IssueHistory i : issuelist) {

			System.out.println(i);
		}
	}
}
