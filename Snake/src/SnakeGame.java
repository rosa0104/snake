import java.awt.Point;
import java.util.Scanner;

public class SnakeGame {
	
	//Felder		
	private Point playerPosition;
	private Point snakePosition;
	private Point goldPosition;
	private Point doorPosition;
	private boolean goldGefunden;

	//Konstruktor
	public SnakeGame(){
			playerPosition = new java.awt.Point(10, 9);
			snakePosition = new java.awt.Point(30, 2);
			goldPosition = new java.awt.Point(6,6);
			doorPosition = new java.awt.Point(0,5);
		
			goldGefunden = false;
	}
	
	public static void main( String[] args)	{
		SnakeGame myGame = new SnakeGame();
		myGame.play();
	}

	private void play() {

		while(true){
				rasterMitFigurenZeichnen(playerPosition, snakePosition, goldPosition, doorPosition);
						
				if (goldGefunden && playerPosition.equals(doorPosition)){
					System.out.println("Gewonnen!");
					break;
				}

				if (playerPosition.equals(snakePosition)){
					System.out.println("Die Schlange hat dich!");
					break;
				}

				if (playerPosition.equals(goldPosition)){
					goldGefunden = true;
					goldPosition.setLocation(-1,-1);
				}
			
				//Konsoleneingabe und Spielerposition verändern
		
				switch (new Scanner(System.in).next().charAt(0)){
						case 'h': playerPosition.y = Math.max(0,  playerPosition.y -1); break;
						case 't': playerPosition.y = Math.min(9,  playerPosition.y +1); break;
						case 'l': playerPosition.x = Math.max(0,  playerPosition.x -1); break;
						case 'r': playerPosition.x = Math.min(39,  playerPosition.x +1); break;
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


	private void rasterMitFigurenZeichnen(java.awt.Point playerPosition, java.awt.Point snakePosition,
			java.awt.Point goldPosition, java.awt.Point doorPosition) {
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
	}

}
