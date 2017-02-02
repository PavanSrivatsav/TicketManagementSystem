package com.pavansrivatsav.service;

import com.pavansrivatsav.dao.IssueHistoryDAO;
import com.pavansrivatsav.exception.ServiceException;
import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.validator.IssueHistoryValidator;

public class IssueHistoryService {
	private IssueHistoryValidator issueHistoryValidator = new IssueHistoryValidator();
	private IssueHistoryDAO issueHistorydao = new IssueHistoryDAO();

	public void insert(IssueHistory issueHistory) throws ServiceException {

		try {
			issueHistoryValidator.insertValidation(issueHistory);

			issueHistorydao.insert(issueHistory);
		} catch (ValidationException e) {
			throw new ServiceException("Could not insert items", e);
		}

	}

	public void update(IssueHistory issueHistory) throws ServiceException {

		try {
			issueHistoryValidator.updateValidation(issueHistory);

			issueHistorydao.update(issueHistory);
		} catch (ValidationException e) {
			throw new ServiceException("Could not update items", e);
		}

	}

	public void delete(IssueHistory issueHistory) throws ServiceException {

		try {
			issueHistoryValidator.deleteValidation(issueHistory);

			issueHistorydao.delete(issueHistory);
		} catch (ValidationException e) {
			throw new ServiceException("Could not delete items", e);
		}

	}

}
