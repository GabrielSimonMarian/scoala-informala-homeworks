/** 
  * @author Gaby
 */
public abstract class AbstractTile implements Tile {
	
	protected double length;	
	protected double width;
	protected double price;
		
	public AbstractTile(double pTileWidth, double price, double pTileLength){
		this.price = price;
		width = pTileWidth;
		length = pTileLength;
	}

	public AbstractTile(double price) {
		this.price = price;
	}
}