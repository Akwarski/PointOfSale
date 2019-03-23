import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product [] products = new Product[7];

        //example values
        String [] names = {"cheese", "milk", "yoghurt", "water", "juice", "bread", "egg"};
        double [] prices = {40.99, 2.19, 1.45, 1.97, 4.29, 2.49, 7.29};

        List<String> receipt = new ArrayList<>();
        int items = 0, flag;
        double sum = 0.0;

        String barCode = "";

        for(int i=0; i<products.length; i++){
            products[i] = new Product(names[i], prices[i]);
        }

        while(!barCode.equals("exit")){

            barCode = scanner.nextLine();
            flag = 0;

            if(!barCode.equals("exit")) {
                for (Product product : products) {
                    if (barCode.equals(product.retName())) {
                        receipt.add(barCode + " " + product.retPrice() + " PLN");
                        sum += product.retPrice();
                        System.out.println(receipt.get(items));
                        items++;
                        flag++;
                        break;
                    } else if (barCode.isEmpty()) {
                        System.out.println("Invalid bar-code");
                        flag++;
                        break;
                    }
                }

                if (flag == 0) {
                    System.out.println("Product not found");
                }
            }
        }

        System.out.println("\nYour receipt:");
        for (String item: receipt) {
            System.out.println(item);
        }

        System.out.println("TOTAL SUM = " + sum + " PLN\n");
    }
}