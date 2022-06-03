package tictactoe.com;

public class Structure {

    public static final int MATRIX_SIZE = 3;
    public static final String playX="X";
    public static final String play0="0";
    public static final String VALID_MOVES = "XO";
    private String matrix[][];
    public Structure(){
        matrix= new String[MATRIX_SIZE][MATRIX_SIZE];
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
    public void printStructure(){
        for (int i=0; i<MATRIX_SIZE;  i++){
            for (int x=0; x<MATRIX_SIZE ; x++){
                System.out.print("\t" + matrix[i][x] + "|\t");
            }
            System.out.print("\n");
        }
    }
    public void parseLine(String line,int row){
        String lineSplitted[] = new String[MATRIX_SIZE];
        for (int i=0;i< MATRIX_SIZE; i++) {
            matrix[row][i]= String.valueOf(line.charAt(i));
        }
    }

    public static void main(String[] args) {
        new Structure().test();
    }

    public void test(){
        Structure structure = new Structure();
        structure.parseLine("00X",0);
        structure.parseLine("XX0",1);
        structure.parseLine("0X0",2);
        structure.printStructure();
        structure.checkMatrix();
    }

    private void checkMatrix(){
        if (checkMatrixHorizontalVerticallyDiagonal(playX)){
            System.out.println("YES");
            return;
        }
        if (checkMatrixHorizontalVerticallyDiagonal(play0)){
            System.out.println("YES");
            return;
        }
        System.out.println("NO BODY WIN");
    }
    private void playerWin(String play){
        System.out.println("Player " + play +  " WIN!");
    }

    private boolean checkMatrixHorizontalVerticallyDiagonal(String play){
        //check Vertically

        for (int i=0; i< MATRIX_SIZE; i++){
            Integer horizontalCheck=0;
            Integer verticalCheck=0;
            Integer diagonalPositiveCheck=0;
            Integer diagonalNegativeCheck=0;


            for (int x=0; x< MATRIX_SIZE; x++){
                if (matrix[i][x].equals(play)){
                    horizontalCheck++;
                }
                if (matrix[x][i].equals(play)){
                    verticalCheck++;
                }
                if (matrix[x][x].equals(play)){
                    diagonalPositiveCheck++;
                }
                if (matrix[MATRIX_SIZE - x - 1 ][x].equals(play)){
                    diagonalNegativeCheck++;
                }
            }
            System.out.println("Line " + i + " Player " + play + " plays H:" + horizontalCheck + "V:" + verticalCheck + "D+:" + diagonalPositiveCheck );

            if (horizontalCheck.equals(MATRIX_SIZE)){
                playerWin("HORIZONTAL " + play);
                return true;
            }
            if (verticalCheck.equals(MATRIX_SIZE)){
                playerWin("VERTICAL " + play);
                return true;
            }
            if (diagonalPositiveCheck.equals(MATRIX_SIZE)){
                playerWin("DIAGONAL POSITIVE " + play);
                return true;
            }
            if (diagonalNegativeCheck.equals(MATRIX_SIZE)){
                playerWin("DIAGONAL NEGATIVE " + play);
                return true;
            }
        }
        return false;
    }
}



