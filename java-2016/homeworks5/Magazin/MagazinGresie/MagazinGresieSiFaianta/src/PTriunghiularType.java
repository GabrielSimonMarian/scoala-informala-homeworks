/**
 * 
 * 
 * 
 * 
 * @author Gaby
 *
 */
public class PTriunghiularType extends AbstractTile {
	
	
	public PTriunghiularType(double lungimeaCatetei, double priceForPTTile){
		super(lungimeaCatetei, priceForPTTile, lungimeaCatetei);  
		}
	
	@Override
	public double calculatePrice(double surfaceToCover) {
		return (surfaceToCover / calculateArea()) * price;
	}

	@Override
	public double calculateArea() {
		return (length * width) / 2;
	}
}

