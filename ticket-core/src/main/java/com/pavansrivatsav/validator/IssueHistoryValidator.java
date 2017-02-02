package com.pavansrivatsav.validator;

import com.pavansrivatsav.exception.ValidationException;
import com.pavansrivatsav.modal.IssueHistory;
import com.pavansrivatsav.util.ValidationUtil;

public class IssueHistoryValidator {

	public void issueValidation(IssueHistory issue) throws ValidationException {

		ValidationUtil.isInvalidObject(issue, "Invalid Operation");
	}

	public void idvalidation(Integer id) throws ValidationException {

		ValidationUtil.isInvalidNumber(id, "Invalid id");
	}

	public void solutionValidation(String name) throws ValidationException {

		ValidationUtil.isInvalidString(name, "Invalid solution");
	}

	public void insertValidation(IssueHistory issue) throws ValidationException {
		issueValidation(issue);
		idvalidation(issue.getId());
		solutionValidation(issue.getSolution());
	}

	public void updateValidation(IssueHistory issue) throws ValidationException {
		issueValidation(issue);
		idvalidation(issue.getId());
		solutionValidation(issue.getSolution());
	}

	public void deleteValidation(IssueHistory issue) throws ValidationException {
		issueValidation(issue);
		idvalidation(issue.getId());
	}
}
