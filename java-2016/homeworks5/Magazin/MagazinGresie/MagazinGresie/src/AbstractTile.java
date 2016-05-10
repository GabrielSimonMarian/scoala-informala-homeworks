/** 
  * @author Gaby
 */
public abstract class AbstractTile implements Tile {
	
	protected double length;	
	protected double width;
	protected double price;

	
	public AbstractTile(double price) {
		this.price = price;
	}
	
	public AbstractTile(double pTileWidth, double priceForPTile, double pTileLength){
		price = priceForPTile;
		width = pTileWidth;
		length = pTileLength;
	}
	
	public AbstractTile(double PTTileSideLength, double priceForPTTile){
		price = priceForPTTile;
		width = PTTileSideLength;
	}
}