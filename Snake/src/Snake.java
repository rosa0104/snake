import java.awt.Point;
import java.util.Scanner;

public class Snake {
	public static void main( String[] args)
	{
		java.awt.Point playerPosition = new java.awt.Point(10, 9);
		java.awt.Point snakePosition = new java.awt.Point(30, 2);
		java.awt.Point goldPosition = new java.awt.Point(6,6);
		java.awt.Point doorPosition = new java.awt.Point(0,5);
		
		boolean rich = false;
		
		while(true){
				//Raster mit Figuren zeichnen
				
				for (int y = 0; y < 10; y++){
						for (int x = 0; x < 40; x++){
								Point p = new Point (x,y);
								if (playerPosition.equals(p)) {
										System.out.print('&');
								} else if (snakePosition.equals(p)){
										System.out.print('s');
								} else if (goldPosition.equals(p)){
										System.out.print('$');
								} else if (doorPosition.equals(p)){
										System.out.print('#');
								} else {
										System.out.print('.');
								}
						}
					System.out.println();
		
				}
						
				//Status festlegen
						
				if (rich && playerPosition.equals(doorPosition)){
						System.out.println("Gewonnen!");
						break;
				}
		
				if (playerPosition.equals(snakePosition)){
						System.out.println("Die Schlange hat dich!");
						break;
				}
		
				if (playerPosition.equals(goldPosition)){
						rich = true;
						goldPosition.setLocation(-1,-1);
				}
		
				//Konsoleneingabe und Spielerposition verändern
		
				switch (new Scanner(System.in).next().charAt(0)){
						case 'h': playerPosition.y = Math.max(0,  playerPosition.y -1); break;
						case 't': playerPosition.y = Math.min(9,  playerPosition.y +1); break;
						case 'l': playerPosition.x = Math.max(0,  playerPosition.x -1); break;
						case 'r': playerPosition.y = Math.min(39,  playerPosition.x +1); break;
				}
					
				//Schlange bewegt sich in Richtung Spieler
		
				if (playerPosition.x < snakePosition.x){
						snakePosition.x--;
				} else if (playerPosition.x > snakePosition.x) {
						snakePosition.x++;
				}
		
				if (playerPosition.y < snakePosition.y){
						snakePosition.y--;
				} else if (playerPosition.y > snakePosition.y) {
						snakePosition.y++;
				}
		
		}

	}

}
