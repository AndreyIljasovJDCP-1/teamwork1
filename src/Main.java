import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {

        String[] products = {"Молоко", "Гречка", "Пшеница", "Масло"};
        int[] price = {50, 68, 45, 120};
        int[] basket = new int[products.length];

        int sumProducts = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Список возможных товаров для покупки:");

            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ": " + products[i] + " " + price[i] + " руб/шт.");
            }

            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Программа завершена!");
                break;
            }

            String[] stringsInput = input.split(" ");
            if (stringsInput.length != 2) {
                continue;
            }


            String strIndexProduct = String.valueOf(stringsInput[0]);
            String strCountProduct = String.valueOf(stringsInput[1]);
            int indexProduct;
            int countProduct;

            try {


                indexProduct = Integer.parseInt(strIndexProduct) - 1;
                if ((indexProduct < 0) || (indexProduct + 1 > products.length)) {
                    System.out.println("Некорректное значение выбранного продукта");
                    continue;
                }
                countProduct = Integer.parseInt(strCountProduct);
                if (countProduct <= 0) {
                    System.out.println("Некорректное количество");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные");
                continue;
            }

            sumProducts += price[indexProduct] * countProduct;
            basket[indexProduct] += countProduct;


        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != 0) {
                System.out.println(products[i] + " " + basket[i] + " шт " + price[i] + " руб/шт " + (basket[i] * price[i]) + " рублей в сумме");
            }

        }
        System.out.println("Итого: " + sumProducts);


    }


}







