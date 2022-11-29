/*Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class HW_2_1 {

    public static void main(String[] args) throws IOException {
        printArrayInConsole( sortingArr( getNumArr( lenArray())));
        logger();
    }
    private static void logger() throws IOException {
        Logger log = Logger.getLogger(HW_2_1.class.getName());
        FileHandler fh = new FileHandler("log.xml",true);
        log.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        log.info("Все супер!");

    }
    public static int lenArray(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        return sc.nextInt();
    }
    public static int[] getNumArr(int length){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите число в массив: ");
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int[] sortingArr(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j-1] > array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public static void printArrayInConsole(int[] inputArray) {
        for (int j : inputArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
