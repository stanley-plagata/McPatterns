/**
 * @author Stanley Plagata
 */
public class MasterCC extends CreditCard {
	public MasterCC(String CCNumber) {
		super(CCNumber);
		this.setCardType("Master");
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isMaster(CreditCard card) {
		return card.getCCNumber().substring(0, 1).equals("5")
				&& (card.getCCNumber().substring(1, 2).equals("1")
				|| card.getCCNumber().substring(1, 2).equals("2")
				|| card.getCCNumber().substring(1, 2).equals("3")
				|| card.getCCNumber().substring(1, 2).equals("4")
				|| card.getCCNumber().substring(1, 2).equals("5"))
				&& card.getCCLength() == 16;
	}
}