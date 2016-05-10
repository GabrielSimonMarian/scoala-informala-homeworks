/**
 * 
 * 
 * 
 * @author Gaby
 *
 */

public class PTile extends AbstractTile {

		public PTile(double pTileWidth, double priceForPTile, double pTileLength) {
				super(priceForPTile, pTileLength, pTileWidth); // aici trebuie sa fie deja caracteristicile cu care vine din clasa parinte, pot fi mai multi parametri decat cei relevanti clasei mele, cei releva
				//vanti clasei se pun in linia de sus. 
		}
		
		@Override
		public double calculatePrice(double surfaceToCover) {
			double neededPieces =  surfaceToCover / calculateArea();
			return neededPieces * price;
		}
		@Override
		public double calculateArea(){
			return length * width;
		}
}