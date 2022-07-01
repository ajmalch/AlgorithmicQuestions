package com.example;

public class TicTacWin {

    public static void main(String[] args) {

        Piece[][] board = {{Piece.EMPTY, Piece.RED, Piece.BLUE},{Piece.BLUE, Piece.RED, Piece.BLUE}, {Piece.BLUE, Piece.RED, Piece.EMPTY}};

        System.out.println(hasWon(board, 1, 1));
        System.out.println(hasWon(board, 0, 0));


    }

    public static Piece hasWon(Piece[][] board, int row, int column){

        if(board.length != board[0].length)
            return Piece.EMPTY;

        if(board[row][column] == Piece.EMPTY)
                return Piece.EMPTY;

        if(hasWonRow(board, row) || hasWonColumn(board, column))
            return board[row][column];

        if(row==column && hasWonDiagonal(board, Diagonal.LEFT))
            return board[row][column];
        if((row == board.length-1-column) &&hasWonDiagonal(board, Diagonal.RIGHT))
            return board[row][column];
        return Piece.EMPTY ;
    }

    private static boolean hasWonColumn(Piece[][] board, int column) {

        Piece piece = board[0][column];

        for(int i=1 ; i< board.length ;i++){

            if(board[i][column] != piece)
                return false;

        }

        return true;

    }

    private static boolean hasWonRow(Piece[][] board, int row) {

        Piece piece = board[row][0];

        for(int i=1 ; i< board[0].length ;i++){

            if(board[row][i] != piece)
                return false;

        }

        return true;
    }

    private static boolean hasWonDiagonal(Piece[][] board, Diagonal diagonal) {

        Piece piece;
        if(diagonal == Diagonal.LEFT){

           piece = board[0][0];
           for (int i=1 ; i<board.length ; i++)
               if (board[i][i] != piece)
                   return false;
       }else {

           piece = board[0][board.length-1];
           for (int i = 1 ; i< board.length; i++){
               if(board[i][board.length-1-i] != piece)
                   return false;
           }

       }

       return  true;

    }

}

enum Piece{

    EMPTY, RED, BLUE;

}

enum Diagonal{
    LEFT, RIGHT;
}