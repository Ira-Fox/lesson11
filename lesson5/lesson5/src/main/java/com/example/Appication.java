package com.example;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.example.domain.Bucket;
import com.example.domain.Product;
import com.example.domain.User;
import com.example.service.BucketService;
import com.example.service.ProductService;
import com.example.service.UserService;
import com.example.service.impl.BucketServiceImpl;
import com.example.service.impl.ProductServiceImpl;
import com.example.service.impl.UserServiceImpl;

public class Appication {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        menu();
        UserService userService = new UserServiceImpl();
        ProductService productService = new ProductServiceImpl();
        BucketService bucketService = new BucketServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            int answer = scanner.nextInt();
            scanner.nextLine();

            switch (answer) {
                case 1:
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();

                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();

                    System.out.println("Enter role:");
                    String role = scanner.nextLine();

                    userService.create(new User(email, firstName, lastName, role));
                    System.out.println("-----------------------------------------------");
                    break;
                case 2:
                    System.out.println("Enter user ID to read:");
                    int read = scanner.nextInt();
                    scanner.nextLine();
                    userService.read(read);
                    System.out.println("-----------------------------------------------");
                    break;
                case 3:
                    System.out.println("Enter user ID to update:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    User user = userService.read(id);

                    System.out.println(
                            "What do you want to change?\n1 -> email\n2 -> first name\n3 -> last name\n4 -> role");
                    int update = scanner.nextInt();
                    scanner.nextLine();

                    switch (update) {
                        case 1:
                            System.out.println("Enter new email:");
                            String updateEmail = scanner.nextLine();
                            user.setEmail(updateEmail);
                            break;
                        case 2:
                            System.out.println("Enter new first name:");
                            String updateFirstName = scanner.nextLine();
                            user.setFirstName(updateFirstName);
                            break;
                        case 3:
                            System.out.println("Enter new last name:");
                            String updateLastName = scanner.nextLine();
                            user.setLastName(updateLastName);
                            break;
                        case 4:
                            System.out.println("Enter new role:");
                            String updateRole = scanner.nextLine();
                            user.setRole(updateRole);
                            break;
                    }
                    userService.update(user);
                    System.out.println("-----------------------------------------------");
                    break;
                case 4:
                    System.out.println("Enter user ID to delete:");
                    int delete = scanner.nextInt();
                    scanner.nextLine();
                    userService.delete(delete);
                    System.out.println("-----------------------------------------------");
                    break;
                case 5:
                    userService.readAll();
                    System.out.println("-----------------------------------------------");
                    break;
                case 6:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter description:");
                    String description = scanner.nextLine();

                    System.out.println("Enter price:");
                    float price = scanner.nextFloat();
                    scanner.nextLine();

                    productService.create(new Product(name, description, price));
                    System.out.println("-----------------------------------------------");
                    break;
                case 7:
                    System.out.println("Enter product ID to read:");
                    int read1 = scanner.nextInt();
                    scanner.nextLine();
                    productService.read(read1);
                    System.out.println("-----------------------------------------------");
                    break;
                case 8:
                    System.out.println("Enter product ID to update:");
                    int id1 = scanner.nextInt();
                    scanner.nextLine();

                    Product product = productService.read(id1);

                    System.out.println("What do you want to change?\n1 -> name\n2 -> description\n3 -> price");
                    int update1 = scanner.nextInt();
                    scanner.nextLine();

                    switch (update1) {
                        case 1:
                            System.out.println("Enter new name:");
                            String updateName = scanner.nextLine();
                            product.setName(updateName);
                            break;
                        case 2:
                            System.out.println("Enter new description:");
                            String updateDescription = scanner.nextLine();
                            product.setDescription(updateDescription);
                            break;
                        case 3:
                            System.out.println("Enter new price:");
                            float updatePrice = scanner.nextFloat();
                            product.setPrice(updatePrice);
                            break;
                    }
                    productService.update(product);
                    System.out.println("-----------------------------------------------");
                    break;

                case 9:
                    System.out.println("Enter product ID to delete:");
                    int delete1 = scanner.nextInt();
                    scanner.nextLine();
                    productService.delete(delete1);
                    System.out.println("-----------------------------------------------");
                    break;
                case 10:
                    productService.readAll();
                    System.out.println("-----------------------------------------------");
                    break;
                case 11:
                    System.out.println("Enter user id:");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter product id:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter purchase date:");
                    String purchaseDateStr = scanner.nextLine();
                    LocalDate purchaseDate = LocalDate.parse(purchaseDateStr,
                            DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    java.util.Date date = Date.from(purchaseDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                    bucketService.create(new Bucket(userId, productId, date));
                    System.out.println("-----------------------------------------------");
                    break;
                case 12:
                    System.out.println("Enter bucket ID to read:");
                    int read2 = scanner.nextInt();
                    scanner.nextLine();
                    bucketService.read(read2);
                    System.out.println("-----------------------------------------------");
                    break;
                case 13:
                    System.out.println("Enter bucket ID to delete:");
                    int delete2 = scanner.nextInt();
                    scanner.nextLine();
                    bucketService.delete(delete2);
                    System.out.println("-----------------------------------------------");
                    break;
                case 14:
                    bucketService.readAll();
                    System.out.println("-----------------------------------------------");
                    break;
                case 15:
                    System.exit(0);
                    System.out.println("-----------------------------------------------");
                    break;
            }
        }

    }

    public static void menu() {
        System.out.println("---------------- User ------------------");
        System.out.println("1. Create user\n2. Read user\n3. Update user\n4. Delete user\n5. Read all users");
        System.out.println("---------------- Product ------------------");
        System.out.println(
                "6. Create product\n7. Read product\n8. Update product\n9. Delete product\n10. Read all products");
        System.out.println("---------------- Bucket ------------------");
        System.out.println("11. Create bucket\n12. Read bucket\n13. Delete bucket\n14. Read all buckets");
        System.out.println("--- Exit the program -------------> 15");
    }
}
