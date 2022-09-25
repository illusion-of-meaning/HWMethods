import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        // task 1
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите год:");
        Integer enterYear = Integer.valueOf(reader.readLine());
        if (isLeapYear(enterYear)) {
            System.out.println(enterYear + " - високосный год");
        } else {
            System.out.println(enterYear + " - не високосный год");
        }

        // task 2
        System.out.println("Введите тип ОС: 0 — iOS или 1 — Android:");
        Integer clientOS = Integer.valueOf(reader.readLine());
        System.out.println("Введите год выпуска устройства:");
        Integer yearOfRelease = Integer.valueOf(reader.readLine());
        System.out.println(clientOsType(clientOS, yearOfRelease));

        // task 3
        System.out.println("Введите расстояние до адреса доставки:");
        Integer distance = Integer.valueOf(reader.readLine());
        System.out.println("Потребуется дней: " + deliveryTime(distance));
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYearFlag = false;
        if(year % 4 == 0 && year % 100 != 0) {
            isLeapYearFlag = true;
        } else if (year % 100 == 0 && year % 400 == 0) {
            isLeapYearFlag = true;
        }
        return isLeapYearFlag;
    }

    private static String clientOsType(int clientOS, int clientDeviceYear) {
        String result = "";
        int currentYear = LocalDate.now().getYear();
        switch (clientOS) {
            case 0:
                if(clientDeviceYear < currentYear) {
                    result = "Установите облегчённую версию приложения для iOS по ссылке";
                } else {
                    result = "Установите версию приложения для iOS по ссылке";
                }
                break;
            case 1:
                if(clientDeviceYear < currentYear) {
                    result = "Установите облегчённую версию приложения для Android по ссылке";
                } else {
                    result = "Установите версию приложения для Android по ссылке";
                }
                break;
            default:
                result = "Вы используете неизвестное устройство...";
        }
        return result;
    }

    private static int deliveryTime(int deliveryDistance) {
        int result = 0;
        if (deliveryDistance < 20) {
            result = 1;
        } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            result = 2;
        } else if (deliveryDistance >= 60 && deliveryDistance < 100) {
            result = 3;
        }
        return result;
    }
}