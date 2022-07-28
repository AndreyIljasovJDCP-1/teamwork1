import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {

        String[] products = {"Молоко", "Гречка", "Пшеница", "Масло"};
        String[] productsStock = {"Гречка", "Масло"};
        int[] price = {50, 68, 45, 120};
        int[] basket = new int[products.length];

        int sumProducts = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Список возможных товаров для покупки:");

            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ": " + products[i] + " " + price[i] + " руб/шт.");
            }
            System.out.println("В акции 3 по цене 2-х участвуют товары: "+Arrays.toString(productsStock));

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

            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные");
                continue;
            }

            if (countProduct == 0) {

                basket[indexProduct] = 0;

            } else {

                basket[indexProduct] += countProduct;
            }

        }
        System.out.println("Ваша корзина:");

        for (int i = 0; i < basket.length; i++) {

            boolean discount = false;

            if (basket[i] > 0) {

                for (int j = 0; j < productsStock.length; j++) {

                    if (products[i].equals(productsStock[j])) {

                        discount = true;
                        int actionSum = ((basket[i] - basket[i] % 3) * price[i] * 2) / 3 + basket[i] % 3 * price[i];
                        sumProducts += actionSum;
                        System.out.println(products[i] + " " + basket[i] + " шт " + price[i] + " руб/шт " + actionSum + " рублей в сумме");
                        break;
                    }
                }

                if (!discount) {

                    System.out.println(products[i] + " " + basket[i] + " шт " + price[i] + " руб/шт " + (basket[i] * price[i]) + " рублей в сумме");
                    sumProducts += basket[i] * price[i];
                }
            }
        }

        System.out.println("Итого: " + sumProducts);
    }

}







