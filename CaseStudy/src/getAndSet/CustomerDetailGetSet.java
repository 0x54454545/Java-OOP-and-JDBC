package getAndSet;

public class CustomerDetailGetSet {
	protected String firstName, middleName, lastName, aptNo, streetName, cCity, cState, cZip, cEmail, cCountry, cardNo, transType, transactionDate;
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	protected int cPhone, month, year, day;
	protected double transValue, transSum;
	
	public double getTransSum() {
		return transSum;
	}
	public void setTransSum(double transSum) {
		this.transSum = transSum;
	}
	public double getTransValue() {
		return transValue;
	}
	public void setTransValue(double transValue) {
		this.transValue = transValue;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getcCity() {
		return cCity;
	}
	public void setcCity(String cCity) {
		this.cCity = cCity;
	}
	public String getcState() {
		return cState;
	}
	public void setcState(String cState) {
		this.cState = cState;
	}
	public String getcZip() {
		return cZip;
	}
	public void setcZip(String cZip) {
		this.cZip = cZip;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcCountry() {
		return cCountry;
	}
	public void setcCountry(String cCountry) {
		this.cCountry = cCountry;
	}
	public int getcPhone() {
		return cPhone;
	}
	public void setcPhone(int cPhone) {
		this.cPhone = cPhone;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
