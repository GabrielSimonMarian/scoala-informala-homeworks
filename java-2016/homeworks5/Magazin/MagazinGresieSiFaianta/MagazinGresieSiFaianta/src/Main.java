/** 
 * 
 * @author Gaby
 *
 */
public class Main {

	public static void main(String[] args) {
		
		double surfaceToCover = 10; 	// 10 m^2 de acoperit
		
		double priceForSTile = 50; 		// 50 lei / m^2
		double sTileLength = 0.3; 		// 30 cm = 0.3 m
		double sTileWidth = 0.2; 		// 20 cm = 0.2 m
	
		double pTileLength = 0.3;		// 30 cm = 0.3 m
		double pTileWidth = 0.2;		// 20 cm = 0.2 m
		double priceForPTile = 60;      // 60 lei / bucata dreptunghiulara
		
		double lungimeaCatetei = 0.3;  // 30 cm = 0.3 m 
		double priceForPTTile = 80;	    // 80 lei / bucata triungiulara
		
		double sTileCost = calculatesSTileCost(surfaceToCover, priceForSTile);
		System.out.println("Cost for covering the surface with S-type tiles: " + sTileCost + " lei.");
	
		double pTileCost = calculatesPTileCost(surfaceToCover, priceForPTile, pTileWidth, pTileLength);
		System.out.printf("Cost for covering the surface with P-type tiles: %.2f lei \n" , pTileCost );
		
		double splitCost = calculatesCostWithPTypeTileAndSTypeTile(surfaceToCover, priceForSTile, sTileLength, sTileWidth, pTileWidth, pTileLength, priceForPTile);
		System.out.printf("Cost for covering the surface with splited tiles: %.2f lei \n", splitCost);
	

		double PTTIleCost = calculatePTTileCost(surfaceToCover, priceForPTTile,  lungimeaCatetei );
		System.out.printf("Cost for covering the surface with PT-type tiles: %.2f lei ", PTTIleCost);
	}

		private static double calculatesSTileCost(double surfaceToCover, double priceForSTile) {
			Tile sTypeTile = new STile(priceForSTile);
			return sTypeTile.calculatePrice(surfaceToCover);
		}	
		
		private static double calculatesPTileCost(double surfaceToCover, double priceForPTile, double pTileWidth, double pTileLength) {
			Tile pTypeTile = new PTile(pTileWidth, pTileLength, priceForPTile);
			return pTypeTile.calculatePrice(surfaceToCover);
		}		
		
		private static double calculatesCostWithPTypeTileAndSTypeTile(double surfaceToCover, double priceForSTile, double sTileLength, double sTileWidth, double pTileWidth, double pTileLength, double priceForPTile){
			Tile pTypeTile = new PTile(pTileWidth, priceForPTile, pTileLength);
			Tile sTypeTile = new STile(priceForSTile);	
			return pTypeTile.calculatePrice(surfaceToCover / 2) + sTypeTile.calculatePrice(surfaceToCover / 2);
		}
	
		private static double calculatePTTileCost(double surfaceToCover, double priceForPTTile, double PTTileSideLength ){
		
			Tile pTTTypeTile = new PTriunghiularType (PTTileSideLength, priceForPTTile);
			return pTTTypeTile.calculatePrice(surfaceToCover);
		}
}