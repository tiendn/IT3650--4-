package samsung.java.week2.bank;

import java.util.Date;

/** Information about saving account
 * Include 5 attributes : <u> accountID</u> , <u> accountName</u> , <u> Assets </u>, <u> dateGive </u> , <u> iRate </u>
 * @author monkey
 * 
 * 
 */
public class SavingAccount {
	private String accountID;
	private String accountName;
	private Double Assets;
	private Date dateGive;
	private Double iRate; // Interest rate
	/** Constructor initiate new account with full of information
	 * 
	 * @param id : Set Account id
	 * @param name : Set Account name
	 * @param assets : Set assets
	 * @param date : Set date given
	 * @param rate :Set rate
	 */
	public SavingAccount(String id, String name,double assets,Date date,Double rate){
		id.trim();
		name.trim();
		if ( !id.equals("") && !name.equals("")){
			setAccountID(id);
			setAccountName(name);
			setAssets(assets);
			setDateGive(date);
			setIRate(rate);
		}
		else System.out.println(" This account cannot create. ");
	}
	/** Constructor init new account with id and name
	 * 
	 * @param id : Set Account id
	 * @param name : Set Account name
	 */
	public SavingAccount(String id, String name){
		id.trim();
		name.trim();
		if ( !id.equals("") && !name.equals("")){
			setAccountID(id);
			setAccountName(name);
			setAssets(null);
			setDateGive(null);
			setIRate(null);
		}
		else System.out.println(" This account cannot create. ");
	}
	// *********************** Get,Set method. ******************************
	public Date getDateGive() {
		return dateGive;
	}
	public void setDateGive(Date dateGive) {
		this.dateGive = dateGive;
	}
	public Double getIRate() {
		return iRate;
	}
	public void setIRate(Double iRate) {
		this.iRate = iRate;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getAssets() {
		return Assets;
	}
	public void setAssets(Double assets) {
		Assets = assets;
	}
	// ********************** End Get,Set Method ****************************** 
	/** Calculate number of days from day given.
	 * 
	 */
	public long getDays(){
		Date date = new Date();		
		return (date.getTime()-this.getDateGive().getTime())/(3600*24*1000);
	}
	/** Money a way from a total
 	 * 
	 * @return  Full of money
	 */
	public double getTotalAssets() {
		return getBalance()+getAssets();
	}
	/** Get Balance
	 * 
	 * @return  balance of this saving account
	 */
	public double getBalance(){
		return getAssets()*getIRate()*getDays()/100;
	}
	/** Withdraw all balance 
	 *  <p> DateGiven = Now </p>
	 */
	public void withdrawInterest(){
		System.out.println(" Your money withdrew: " + getBalance());
		setDateGive(new Date());
	}
	/** Withdraw partially, all balance and some part of assets
	 * <p> DateGiven = Now </p>
	 * @param money : this argument mean how much money user want to withdraw from root account (assets)
	 */
	public void withdrawPartially(double money){
		if ( money <= 0 || money > getAssets())
			System.out.println(" This number is valid");
		else {
			System.out.println(" Partially withdrew = " + (getBalance()+money));
			setAssets(getAssets()-money);
			setDateGive(new Date());
		}
	}
	/**
	 *  Withdraw totally , all money in this account.
	 *  <p> DateGiven = Now </p>
	 */
	public void withdrawTotally(){
		System.out.println(" Totally withdrew = " + getTotalAssets());
		setAssets(0.0);
		setDateGive(new Date());
	}
	/**Give money in bank <br>
	 * Show all balance <br>
	 * DateGiven = Now <br>
	 * @param money : how much money that user give money to the bank
	 */
	public void Deposit(double money){
		System.out.println(" Your balance : " + getBalance());
		if (money <= 0)
			System.out.println(" This number is valid. ");
		else {
			setAssets(getTotalAssets()+money);
			setDateGive(new Date());
		}
	}
	
}
