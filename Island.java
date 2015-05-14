public class Island {

    static int [][] usedArr; /* Дополнительный увеличенный массив - исключает выход за пределы массива
                              при проверке на наличие острова в соседей ячейке */

    static int [] m = {0,0,-1,1}; // Отклонения по строкам в поисках продолжения острова
    static int [] n = {-1,1,0,0}; // Отклонения по столбцам в поисках продолжения острова
    private int count = 0; // Количество островов

    /* Конструктор, который создает:
        1) увеличенный массив
        2) запускает метод для копирования заданного массива
        3) выводит количество "островов" в консоль, запуская метод для подсчета их количества
    */
    /* Constructor:
        1) Generate large array
        2) Copy the array to the increased array
        3) Write result with numbers of islands to the console
    */

    public Island(int [][] arr){
    usedArr = new int [arr.length + 2][arr.length + 2];
        configArray(arr);
    }

    // Метод для формирования увеличенного массива
    // Method for forming the increased array
    private static void configArray(int [][] arr){
        for (int i = 1; i < usedArr.length-1; i++){
            for (int j = 1; j < usedArr.length-1; j++)
                usedArr[i][j] = arr[i-1][j-1];
        }
    }

    // Рекурсионный метот для обхода ячеек массива (обход графа в глубину)
    // Recurs method passing the cells of array
    public static void FGS(int x,int y){
        usedArr[x][y] = 0;
        for(int k = 0; k < 4; k++){
            if (usedArr[x + m[k]][y + n[k]] == 1) {
                FGS(x + m[k],y + n[k]);
            }
        }
    }

    //Method for calculates numbers of islands
    public int countIslands(){
        for(int i = 1; i < usedArr.length - 1; i++){
            for(int j = 1; j < usedArr.length - 1; j++){
                if (usedArr[i][j] == 1){
                    count += 1;
                    FGS(i, j);
                }
            }
        } return count;
    }
}