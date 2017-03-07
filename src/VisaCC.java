/**
 * @author Stanley Plagata
 */
public class VisaCC extends CreditCard {
	public VisaCC(String CCNumber) {
		super(CCNumber);
		this.setCardType("Visa");
	}
	
	public static boolean isVisa(CreditCard card) {
		return card.getCCNumber().substring(0, 1).equals("4")
				&& (card.getCCNumber().length() == 13
				|| card.getCCLength() == 16);
	}
}
