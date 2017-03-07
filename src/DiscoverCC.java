/**
 * @author Stanley Plagata
 */
public class DiscoverCC extends CreditCard{
	public DiscoverCC(String CCNumber) {
		super(CCNumber);
		this.setCardType("Discover");
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isDiscover(CreditCard card) {
		return card.getCCNumber().substring(0, 4).equals("6011")
				&& card.getCCLength() == 16;
	}
}