package com.testing.cdw;

public class Queries {
	//Transaction Queries
	public final static String getTransactionOrderByDay ="SELECT * FROM cdw_sapp_creditcard cc join cdw_sapp_customer c on c.ssn = cc.CUST_SSN where CUST_ZIP = ? and month = ? and year = ? group by day desc";
	
	public final static String getTotalValuesAndNumber = "SELECT TRANSACTION_TYPE, COUNT(TRANSACTION_ID), SUM(TRANSACTION_VALUE) FROM cdw_sapp_creditcard cc join cdw_sapp_customer c on c.ssn = cc.CUST_SSN where TRANSACTION_TYPE = ? Group by TRANSACTION_TYPE";
	
	public final static String getTransactionFromBranch = "SELECT BRANCH_STATE, TRANSACTION_TYPE, COUNT(TRANSACTION_ID), SUM(TRANSACTION_VALUE) FROM cdw_sapp_creditcard cc join cdw_sapp_branch b on cc.branch_code = b.branch_code where branch_state  = ? Group by branch_state";
	
	//Customer Queries
	public final static String getCustomerDetails="select * from cdw_sapp_customer where ssn = ?";
	
	public final static String modifyCustomerDetails="update cdw_sapp_customer set first_name = ?, middle_name = ?, last_name = ?, apt_no = ?, street_name = ?, cust_city = ?, cust_state = ?, cust_country = ?, cust_zip = ?, cust_phone = ?, cust_email = ? where ssn = ?";
	
	public final static String checkCreditCardNo="select c.CREDIT_CARD_NO from cdw_sapp_customer c join cdw_sapp_creditcard cc on c.CREDIT_CARD_NO=cc.CREDIT_CARD_NO";
	public final static String getBill = "select c.CREDIT_CARD_NO,sum(transaction_value) from cdw_sapp_customer c join cdw_sapp_creditcard cc on c.CREDIT_CARD_NO=cc.CREDIT_CARD_NO where month = ? and year = ? and c.CREDIT_CARD_NO= ?";
	public final static String getBill2 = "select FIRST_NAME, LAST_NAME, TRANSACTION_TYPE, sum(transaction_value) from cdw_sapp_customer c join cdw_sapp_creditcard cc on c.CREDIT_CARD_NO=cc.CREDIT_CARD_NO where month = ? and year = ? and c.CREDIT_CARD_NO = ? group by transaction_type;";
	
	public final static String getTransactionFromTwoDates = "SELECT * from "+
			 "(SELECT TRANSACTION_ID, TRANSACTION_VALUE, concat(YEAR, \"-\", LPAD(MONTH,2,'0'), \"-\", LPAD(DAY,2,'0')) as TRANSACTION_DATE,"+
			 		" FIRST_NAME, LAST_NAME, SSN"+
					" from cdw_sapp_creditcard cc join cdw_sapp_customer cust on cust.SSN = cc.CUST_SSN) as customer_transactions"+
					" where (TRANSACTION_DATE BETWEEN ? AND ?) AND SSN = ?"+
					" ORDER BY TRANSACTION_DATE DESC";
}
