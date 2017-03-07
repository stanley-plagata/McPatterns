/**
 * @author Stanley Plagata
 */
public class AmExCC extends CreditCard {
	public AmExCC(String CCNumber) {
		super(CCNumber);
		this.setCardType("AmEx");
	}
	
	public static boolean isAmEx(CreditCard card) {
		return card.getCCNumber().substring(0, 1).equals("3")
				&& (card.getCCNumber().substring(1, 2).equals("4")
				|| card.getCCNumber().substring(1, 2).equals("7"))
				&& card.getCCLength() == 15;
	}
}
