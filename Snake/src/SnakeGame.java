import java.awt.Point;
import java.util.Scanner;

public class SnakeGame {
	
	private static final char MOVE_RIGHT_KEY = 'r';

	private static final char MOVE_LEFT_KEY = 'l';

	private static final char MOVE_DOWN_KEY = 't';

	//Konstanten delarieren
	private static final char MOVE_UP_KEY = 'h';
	
	//Felder deklarieren		
	private Point playerPosition;
	private Point snakePosition;
	private Point goldPosition;
	private Point doorPosition;
	private boolean goldGefunden;
	private boolean spielLaeuft;

	//Konstruktor
	public SnakeGame(){
		//Felder intitialisieren (Anfangswerte zuweisen)
			playerPosition = new java.awt.Point(10, 9);
			snakePosition = new java.awt.Point(30, 2);
			goldPosition = new java.awt.Point(6,6);
			doorPosition = new java.awt.Point(0,5);
		
			goldGefunden = false;
			spielLaeuft = false;
	}
	
	public static void main( String[] args)	{
		//Deklariere Variable namens myGame vom Typ SnakeGame (Jede Variable hat einen Typ, das ist entweder ein primitiver Typ wie int oder eine Klasse
		SnakeGame myGame;
		
		//Erzeuge neues Objekt der Klasse SnakeGame und weise es myGame zu
		myGame = new SnakeGame();
		
		//rufe play()-Methode des neuen Objekts auf
		myGame.play();
	}

	private void play() {
		spielLaeuft = true;
		
		while(spielLaeuft){
				rasterMitFigurenZeichnen();
				spielerBewegen();		
				schlangeBewegen();		
				statusBestimmen();
		}
	}

	private void statusBestimmen() {
		if (goldGefunden && playerPosition.equals(doorPosition)){
			System.out.println("Gewonnen!");
			spielLaeuft = false;
		}

		if (playerPosition.equals(snakePosition)){
			System.out.println("Die Schlange hat dich!");
			spielLaeuft = false;
		}

		if (playerPosition.equals(goldPosition)){
			goldGefunden = true;
			goldPosition.setLocation(-1,-1);
		}
	}

	private void schlangeBewegen() {
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


	private void spielerBewegen() {
		//Konsoleneingabe und Spielerposition verändern
		Scanner scan = new Scanner(System.in);
		
		switch (scan.next().charAt(0)){
				case MOVE_UP_KEY: playerPosition.y = Math.max(0,  playerPosition.y -1); break;
				case MOVE_DOWN_KEY: playerPosition.y = Math.min(9,  playerPosition.y +1); break;
				case MOVE_LEFT_KEY: playerPosition.x = Math.max(0,  playerPosition.x -1); break;
				case MOVE_RIGHT_KEY: playerPosition.x = Math.min(39,  playerPosition.x +1); break;
		}
		scan.close();
	}

	private void rasterMitFigurenZeichnen() {
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
