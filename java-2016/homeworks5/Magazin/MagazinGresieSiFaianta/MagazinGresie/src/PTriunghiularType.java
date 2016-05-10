/**
 * 
 * 
 * 
 * 
 * @author Gaby
 *
 */
public class PTriunghiularType extends AbstractTile {
	
	public PTriunghiularType(double PTTileSideLength, double priceForPTTile){
		super(PTTileSideLength, priceForPTTile); // +width, + length; 
		}
	
	@Override
	public double calculatePrice(double surfaceToCover) {
		return (surfaceToCover / calculateArea()) * price;
	}

	@Override
	public double calculateArea() {
		return (width * width) / 2;
	}
}

