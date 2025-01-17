import Model.*;

import java.util.*;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initialiseGame(){
        players = new LinkedList<>();
        PieceX pieceX = new PieceX();
        Player player1 = new Player("Player1",pieceX);

        PieceO pieceO = new PieceO();
        Player player2 = new Player("Player2",pieceO);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while (noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();

            List<Pair<Integer,Integer>> freespaces = gameBoard.getFreeCells();
            if (freespaces.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println("Player:"+ playerTurn.getName()+"Enter row, column:");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn,playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position choosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                return playerTurn.getName();
            }
        }

        return "tie";
    }


    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}

