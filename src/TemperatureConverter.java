import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Конвертер температур ===");

        while (true) {
            System.out.println("\nВыберите исходную шкалу: (1) Цельсий (2) Фаренгейт (3) Кельвин");
            int fromScale = scanner.nextInt();

            System.out.println("Выберите шкалу назначения: (1) Цельсий (2) Фаренгейт (3) Кельвин");
            int toScale = scanner.nextInt();

            if (fromScale < 1 || fromScale > 3 || toScale < 1 || toScale > 3) {
                System.out.println("Ошибка: неверный выбор шкалы.");
                continue;
            }

            System.out.print("Введите значение температуры: ");
            double value = scanner.nextDouble();

            double convertedValue = convertTemperature(fromScale, toScale, value);

            System.out.printf("Результат: %.2f\n", convertedValue);

            System.out.print("Хотите продолжить? (y/n): ");
            char cont = scanner.next().charAt(0);
            if (cont != 'y' && cont != 'Y') {
                System.out.println("Выход из программы.");
                break;
            }
        }

        scanner.close();
    }

    private static double convertTemperature(int fromScale, int toScale, double value) {
        // Сначала переводим ВСЁ в Цельсий
        double celsius;
        switch (fromScale) {
            case 1: // Цельсий
                celsius = value;
                break;
            case 2: // Фаренгейт
                celsius = (value - 32) * 5 / 9;
                break;
            case 3: // Кельвин
                celsius = value - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Неверная шкала.");
        }

        // Теперь из Цельсия в нужную шкалу
        switch (toScale) {
            case 1: // Цельсий
                return celsius;
            case 2: // Фаренгейт
                return (celsius * 9 / 5) + 32;
            case 3: // Кельвин
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Неверная шкала.");
        }
    }
}
