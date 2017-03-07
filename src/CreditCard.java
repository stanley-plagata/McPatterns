/**
 * @author Stanley Plagata
 */
public class CreditCard {
	private String CCNumber;
	private int CCLength;
	private String cardType;
	private static final int MIN_LENGTH = 12;
	private static final int MAX_LENGTH = 19;
	
	public CreditCard(String CCNumber) {
		this.CCNumber = CCNumber;
		CCLength = CCNumber.length();
		cardType = null;
	}
	
	public static boolean isCC(String s) {
    	try {
			float f = Float.parseFloat(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return s.length() >= MIN_LENGTH && s.length() <= MAX_LENGTH;
	}
	
	public String getCCNumber() { return CCNumber; }
	public int getCCLength() { return CCLength; }
	public String getCardType() { return cardType; }
	protected void setCardType(String cardType) { this.cardType = cardType; } 
}