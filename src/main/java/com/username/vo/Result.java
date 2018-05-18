package com.username.vo;

import java.util.TreeSet;

public class Result {
	
	 private boolean processResult;
	    private String message;
	    private TreeSet<String>suggestedUserNames;
	   

	    public boolean isProcessResult() {
			return processResult;
		}

		public void setProcessResult(boolean processResult) {
			this.processResult = processResult;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public TreeSet<String> getSuggestedUserNames() {
			return suggestedUserNames;
		}

		public void setSuggestedUserNames(TreeSet<String> suggestedUserNames) {
			this.suggestedUserNames = suggestedUserNames;
		}

	
}
