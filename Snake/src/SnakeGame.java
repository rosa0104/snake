import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SnakeGame {
	
	private static final int DELAY = 5;

	//Konstanten delarieren
	private static final char MOVE_RIGHT_KEY = 'd';

	private static final char MOVE_LEFT_KEY = 'a';

	private static final char MOVE_DOWN_KEY = 's';

	private static final char MOVE_UP_KEY = 'w';
	
	//Felder deklarieren		

	private boolean spielLaeuft;
	
	private Scanner scan;

	private GameMap map;

	public static List<Character> moveKeys = Arrays.asList(new Character[] {MOVE_RIGHT_KEY, MOVE_LEFT_KEY, MOVE_DOWN_KEY, MOVE_UP_KEY});

	

	//Konstruktor
	public SnakeGame(){
		//Felder intitialisieren (Anfangswerte zuweisen)
		map = new GameMap(60,20);
		map.setPlayerPosition(5,5);		
		map.setDoorPosition(10,19);		
		Set<Gold> allGolds = initGold();
		map.addGolds(allGolds);
		Set<Snake> allSnakes = initSnake();
		map.addSnakes(allSnakes);
		Set<Wall> allWalls = initWall();
		map.addWalls(allWalls);
		
		spielLaeuft = false;		
		scan = new Scanner(System.in);
	}

	private Set<Wall> initWall() {
		HashSet<Wall> newSet = new HashSet<Wall>();
		Wall wall1 = Wall.create (13,6);
		newSet.add(wall1);
		return newSet;
 	}

	private Set<Snake> initSnake() {
		HashSet<Snake> newSet = new HashSet<Snake>();
		Snake snake1 = new Snake(1,0);
		newSet.add(snake1);
		Snake snake2 = new Snake(30,1);
		newSet.add(snake2);
		Snake snake3 = new Snake(50,19);
		newSet.add(snake3);
		return newSet;
	}

	private HashSet<Gold> initGold() {
		HashSet<Gold> newSet = new HashSet<Gold>();
		Gold gold1 = new Gold(6,6);
		newSet.add(gold1);
		Gold gold2 = new Gold(7,7);
		newSet.add(gold2);
		Gold gold3 = new Gold(9,7);
		newSet.add(gold3);
		return newSet;
	}
	
	public static void main( String[] args) throws IOException	{
		//Deklariere Variable namens myGame vom Typ SnakeGame (Jede Variable hat einen Typ, das ist entweder ein primitiver Typ wie int oder eine Klasse
		SnakeGame myGame;
		
		//Erzeuge neues Objekt der Klasse SnakeGame und weise es myGame zu
		myGame = new SnakeGame();
		
		//rufe play()-Methode des neuen Objekts auf
		myGame.play();
	}

	private void play() throws IOException {
		spielLaeuft = true;
		int rundenCounter = 0;
		
		while(spielLaeuft){
				map.printGameMap(System.out);
				spielerBewegen();		
				schlangenBewegen(rundenCounter);		
				statusBestimmen();
				growAllSnakesIfItsTime(rundenCounter);
				rundenCounter++;
		}
		
		scan.close();
	}

	private void growAllSnakesIfItsTime(int rundenCounter) {
		if (rundenCounter % 10 == 0) {
			for (Snake s: map.getSnakes()) {
				s.grow();
			}
		}
	}

	private void statusBestimmen() {
		checkWinCondition();
		checkLossCondition();
		checkGoldFound();
	}

	private void checkGoldFound() {
		for (GameToken someGold: new HashSet<Gold>(map.getGolds())){
			if (someGold.getPositions().contains(map.getPlayerPosition())){
				map.getGolds().remove(someGold);
				shrinkAllSnakes();
			};
		}
	}

	private void shrinkAllSnakes() {
		for (Snake s: map.getSnakes()){
			s.shrink();
		}
	}

	private void checkLossCondition() {
		if (snakePositions().contains(map.getPlayerPosition())){
			System.out.println("Die Schlange hat dich!");
			spielLaeuft = false;
		}
	}

	private void checkWinCondition() {
		if (alleGoldGefunden() && map.getPlayerPosition().equals(map.getDoorPosition())){
			System.out.println("Gewonnen!");
			spielLaeuft = false;
		}
	}

	private boolean alleGoldGefunden() {
		return map.getGolds().size() == 0;
	}

	private void schlangenBewegen(int rundenCounter) {
		if (rundenCounter >= DELAY){
		
			//Schlangen bewegen sich in Richtung Spieler
			for (Snake snake: map.getSnakes()){		
				snake.moveTowards(map.getPlayerPosition());
			}
		}
	}


	private void spielerBewegen() {
		//Konsoleneingabe und Spielerposition verändern	
		char pressedKey = ' ';
		while (!moveKeys.contains(pressedKey)) {
			pressedKey = scan.next().charAt(0);
		}
		switch (pressedKey){
				case MOVE_UP_KEY: map.getPlayerPosition().y = Math.max(0,  map.getPlayerPosition().y -1); break;
				case MOVE_DOWN_KEY: map.getPlayerPosition().y = Math.min(map.getHeight() -1,  map.getPlayerPosition().y +1); break;
				case MOVE_LEFT_KEY: map.getPlayerPosition().x = Math.max(0,  map.getPlayerPosition().x -1); break;
				case MOVE_RIGHT_KEY: map.getPlayerPosition().x = Math.min(map.getWidth() -1,  map.getPlayerPosition().x +1); break;
		}
	}

	private Set<Point> goldPositions() {
		Set<Point> allPositions = new HashSet<Point>();
		for (GameToken g: map.getGolds()){
			allPositions.addAll(g.getPositions());
		}
		return allPositions;
	}
	
	private Set<Point> snakePositions() {
		Set<Point> allPositions = new HashSet<Point>();
		for (Snake s: map.getSnakes()){
			allPositions.addAll(s.getPositions());
		}
		return allPositions;
	}

}
