/*К калькулятору из предыдущего дз добавить логирование.
 */
//Реализовать простой калькулятор

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class HW_2_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double firstNum = sc.nextDouble();

        System.out.print("Введите знак \"+\", \"-\", \"*\" или \"/\": ");
        char sym = sc.next().charAt(0);

        System.out.print("Введите второе число: ");
        double secondNum = sc.nextDouble();

        if (sym == '+'){
            System.out.printf("%.1f + %.1f = %s\n", firstNum, secondNum, firstNum + secondNum);
        } else if (sym == '-'){
            System.out.printf("%.1f - %.1f = %s\n", firstNum, secondNum, firstNum - secondNum);
        }else if (sym == '*'){
            System.out.printf("%.1f * %.1f = %s\n", firstNum, secondNum, firstNum * secondNum);
        }else if (sym == '/'){
            if (secondNum != 0) {
                double d = firstNum / secondNum;
                System.out.printf("%.1f : %.1f = %.1f\n", firstNum, secondNum, d);
            } else {
                System.out.println("На \"0\" делить нельзя!");
            }
        }
        logger();
    }
    private static void logger() throws IOException {
        Logger log =Logger.getLogger(HW_2_2.class.getName());
        FileHandler fh = new FileHandler("log.xml", true);
        log.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        log.info("Все супер!");
    }
}
