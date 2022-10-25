import java.util.Scanner;

public class DepositCalculation {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
       double payment = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return calculateRound(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return calculateRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculatePredictedSum() {
        int period;
        int action ;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией");
        action = scanner.nextInt();

        double predictedSum = 0;

            if (action == 1) {
                predictedSum = calculateComplexPercent(amount, 0.06, period);
            } else if (action == 2) {
                predictedSum = calculateSimplePercent(amount, 0.06, period);
            }
        System.out.println("Результат вклада: " + amount + " рублей за " + period + " лет"
            + " превратятся в " + predictedSum);
    }

    public static void main(String[] args) {
        new DepositCalculation().calculatePredictedSum();
    }
}
