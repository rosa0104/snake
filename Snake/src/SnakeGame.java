import java.awt.Point;
import java.util.Scanner;

public class SnakeGame {
	
	//Konstanten delarieren
	private static final char MOVE_RIGHT_KEY = 'r';

	private static final char MOVE_LEFT_KEY = 'l';

	private static final char MOVE_DOWN_KEY = 't';


	private static final char MOVE_UP_KEY = 'h';
	
	//Felder deklarieren		
	private Point playerPosition;
	private Point snakePosition;
	private Point goldPosition;
	private Point gold2Position;
	private Point doorPosition;
	private boolean goldGefunden;
	private boolean zweitesGoldGefunden;
	private boolean spielLaeuft;
	
	private Scanner scan;
	

	//Konstruktor
	public SnakeGame(){
		//Felder intitialisieren (Anfangswerte zuweisen)
			playerPosition = new Point(10, 9);
			snakePosition = new Point(30, 2);
			goldPosition = new Point(6,6);
			gold2Position = new Point(7,7);
			doorPosition = new Point(0,5);
		
			goldGefunden = false;
			zweitesGoldGefunden = false;
			spielLaeuft = false;
			
			scan = new Scanner(System.in);
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
		
		scan.close();
	}

	private void statusBestimmen() {
		if (goldGefunden && zweitesGoldGefunden && playerPosition.equals(doorPosition)){
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
		if (playerPosition.equals(gold2Position)){
			zweitesGoldGefunden = true;
			gold2Position.setLocation(-1, -1);
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
		switch (scan.next().charAt(0)){
				case MOVE_UP_KEY: playerPosition.y = Math.max(0,  playerPosition.y -1); break;
				case MOVE_DOWN_KEY: playerPosition.y = Math.min(9,  playerPosition.y +1); break;
				case MOVE_LEFT_KEY: playerPosition.x = Math.max(0,  playerPosition.x -1); break;
				case MOVE_RIGHT_KEY: playerPosition.x = Math.min(39,  playerPosition.x +1); break;
		}
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
						} else if (gold2Position.equals(p)){
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
