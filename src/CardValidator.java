/**
 * @author Stanley Plagata
 */
public class CardValidator {
	private static String cardType = null;
	private static CreditCard card;
	
	public static boolean validate(String cardNumber) {
		if (!CreditCard.isCC(cardNumber)) {
			return false;
		}
		
		if (AmExCC.isAmEx(new CreditCard(cardNumber))) {
			card = new AmExCC(cardNumber);
			cardType = "AmEx";
			return true;
		} else if (DiscoverCC.isDiscover(new CreditCard(cardNumber))) {
			card = new DiscoverCC(cardNumber);
			cardType = "Discover";
			return true;
		} else if (MasterCC.isMaster(new CreditCard(cardNumber))) {
			card = new MasterCC(cardNumber);
			cardType = "Master";
			return true;
		} else if (VisaCC.isVisa(new CreditCard(cardNumber))) {
			card = new VisaCC(cardNumber);
			cardType = "Visa";
			return true;
		} else {
			return false;
		}
	}
	
	public static CreditCard getCard() { return card; }
}