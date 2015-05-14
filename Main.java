/*
Программа, которая считает количество "островов" в мастрице.
Остров - совокупность рядом стоящих 1-ц в матрице (по горизонтали и вертикали)
 */

public class Main {

    public static void main(String[] args) {

        int [][] areaWithIslands = {
                {1, 0, 0, 1, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1}
        };

        Island island = new Island(areaWithIslands);
        System.out.println("Area with islands: ");
        printAreaWithIslands(areaWithIslands);
        int countIslands = island.countIslands();
        System.out.println("Number of islands = " + countIslands);
    }

    public static void printAreaWithIslands(int [][] areaWithIslands){
        for (int i = 0; i < areaWithIslands.length; i++){
            for(int j = 0; j < areaWithIslands.length; j++){
                System.out.print(areaWithIslands[i][j] + " ");
            }
            System.out.println();
        }
    }

}
