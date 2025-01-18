import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player(1, 0);
        Player player2 = new Player(2, 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){
        while(winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.ID + " current position is: " + playerTurn.currentPosition);

            int diceNumbers = dice.rollDice();
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("player turn is:" + playerTurn.ID + " new Position is: " + playerNewPosition);
            //check for winning condition
            if(playerNewPosition >= board.cells.length * board.cells.length-1){
                winner = playerTurn;
            }

        }
        System.out.println("WINNER IS:" + winner.ID);
    }

    private int jumpCheck (int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }


    private Player findPlayerTurn(){
        Player playerTurns = playersList.removeFirst();
        playersList.addLast(playerTurns);
        return playerTurns;
    }

}
