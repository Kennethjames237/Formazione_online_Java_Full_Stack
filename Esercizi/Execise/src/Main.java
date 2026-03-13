import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Array libero
        int [] numeri = {10,20,30,40,50};

        //foreach
        for (int n : numeri){
            System.out.println("Valore: " + n);
        }
        System.out.println("--------------------Matrix-------------------------");

        int [] numeri1 = new int[5];
        numeri1[0] = 1;
        numeri1[1] = 4;
        numeri1[2] = 5;
        numeri1[3] = 6;
        numeri1[4] = 7;
        for(int i = 0 ; i < numeri1.length; i++){
            System.out.println("Elemento in posizone: " + i + " è: " + numeri1[i]);
        }
        System.out.println("----------------matric[row][column]---------------------------------");
        int [][] matrice = {
                {1,2,3},
                {5,6,7},
                {9,10,11}
        };

        for(int i = 0 ; i < matrice.length;i++){
            for(int j=0 ; j < matrice[i].length; j++){
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0 ; i < matrice.length;i++){
            for(int j=0 ; j < matrice[i].length; j++) {
                sum += matrice[i][j];
            }
        }
        System.out.println("The sum of all the values are: " + sum);

        System.out.print("la diagonale sono: ");
        for(int i = 0; i < matrice.length; i++){
            System.out.print(matrice[i][i]+ " ");
        }
        System.out.println();
        System.out.println("-------invert matix------------------------");
        int [][] matrix = {
                {1,2,3},
                {4,5,6}
        };
        int row = matrix.length;
        int column = matrix[1].length;
        System.out.println(row + " * "+ column);

        int [][] Transpose = new int [column][row];
        for (int i = 0 ; i < column;i++){
            for(int j = 0; j < row; j++){
                int result = Transpose[i][j] = matrix[j][i];
                System.out.print( result + " ");
            }
            System.out.println();
        }





    }
}