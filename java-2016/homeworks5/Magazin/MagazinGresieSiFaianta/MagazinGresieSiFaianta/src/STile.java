/**
 * 
 * 
 * 
 * @author Gaby
 *
 */
public class STile extends AbstractTile {

		public STile(double priceForSTile) {
				super(priceForSTile);
		}
		
		@Override
		public double calculatePrice(double surfaceToCover) {
			return surfaceToCover * price;
		}	
		
		@Override
		public double calculateArea(){
			return length * width;
		}
}

