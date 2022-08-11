import java.util.Scanner;

public class Main {
    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while(true) {
            System.out.println("Выберите операцию и введите ее номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String costsStr = scanner.nextLine();
                    int costs = Integer.parseInt(costsStr);
                    spendings += costs;
                    break;
                case 3:
                    int tax6 = taxEarnings(earnings);
                    int tax15 = taxEarningsMinusSpendings(earnings,spendings);
                    if (tax6 < tax15) {
                        System.out.println("Советуем УСН доходы." );
                        System.out.println("Налог составит: " +  tax6 + "рублей" );
                        System.out.println("Налог на другой системе составит: " + tax15 + "рублей" );
                        System.out.println("Экономия: " + (tax15 - tax6) + "рублей" );
                        System.out.println("_________________");
                    } else if (tax6 > tax15) {
                        System.out.println("Советуем УСН доходы минус расходы.");
                        System.out.println("Налог составит: " + tax15 + "рублей");
                        System.out.println("Налог на другой системе составит: " + tax6 + "рублей");
                        System.out.println("Экономия: " + (tax6 - tax15) + "рублей");
                        System.out.println("_________________");
                    } else {
                        System.out.println("Налог одинаковый и составляет: " + tax6 + "рублей");
                        System.out.println("_________________");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}
