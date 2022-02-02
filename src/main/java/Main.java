import DAO.ClientDAO;
import DAO.GoodsDAO;
import DAO.OrderDAO;
import Models.Adress;
import Models.Client;
import Models.Goods;
import Models.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        GoodsDAO goodsDAO = new GoodsDAO();
        OrderDAO orderDAO = new OrderDAO();


        Scanner sc = new Scanner(System.in);


        Goods goods1 = new Goods("Apple", "apples", 10);
        goodsDAO.add(goods1);

        Client client1 = new Client("Vasia", 11111);
        clientDAO.add(client1);

        Order order1 = new Order(client1);
        order1.addGoods(goods1);
        orderDAO.add(order1);

        while (true) {

            System.out.println("1: add client");
            System.out.println("2: add order");
            System.out.println("3: view orders by phone number");
            System.out.println("4: view orders my date");
            System.out.println("5: add goods");

            String choice = sc.next();
            switch (choice) {
                case "1":
                    createNewClient();
                    break;
                case "2":
                    System.out.println("1: Chose exist client");
                    System.out.println("2: Add client");
                    String s = sc.next();
                    Client client;
                    switch (s) {
                        case "1":
                            List<Client> clientsList = clientDAO.getAll();
                            for (Client c :
                                    clientsList) {
                                System.out.println(c);
                            }
                            System.out.println("Chose client by id");
                            client = clientDAO.getObjectById(sc.nextLong());
                            System.out.println("You chosed");
                            System.out.println(client);
                            break;
                        case "2":
                            client = createNewClient();
                            break;
                        default:
                            return;
                    }
                    List<Goods> goodsList = goodsDAO.getAll();
                    for (Goods g :
                            goodsList) {
                        System.out.println(g);
                    }
                    Order order = new Order(client);
                    while (true) {
                        System.out.println("Print id of Goods or 0 for finish");
                        int id = sc.nextInt();
                        if (id != 0) {
                            Goods goods = goodsDAO.getObjectById((long) id);
                            order.addGoods(goods);
                        } else {
                            break;
                        }
                    }
                    System.out.println("Order");
                    System.out.println(order);
                    System.out.println("To save press 1 or any key to discard");
                    if (sc.next().equals("1")) {
                        orderDAO.add(order);
                    }
                    break;
                case "3":
                    System.out.println("Enter phone number");
                    int phone = sc.nextInt();
                    List<Order> orderList = orderDAO.findByPhone(phone);
                    for (Order o :
                            orderList) {
                        System.out.println(o);
                    }
                    break;
                case "4":
                    System.out.println("Orders by date range");
                    System.out.println("Enter the first date dd.MM.yyyy ");
                    String first = sc.next();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    System.out.println("Enter the second date dd.MM.yyyy ");
                    String second = sc.next();
                    Date f = null;
                    Date se = null;
                    try {
                        f = simpleDateFormat.parse(first);
                        se = simpleDateFormat.parse(second);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (f != null && se != null) {
                        List<Order> orderList1 = orderDAO.findByDateRange(f, se);
                        for (Order o :
                                orderList1) {
                            System.out.println(o);
                        }
                    } else {
                        System.out.println("Typed wrong date");
                    }
                    break;
                case "5":
                    Goods goods = new Goods();
                    System.out.println("Enter name of Goods: ");
                    goods.setName(sc.next());
                    System.out.println("Enter description of Goods: ");
                    goods.setDesc(sc.next());
                    System.out.println("Enter count of Goods: ");
                    goods.setCount(sc.nextInt());
                    goodsDAO.add(goods);
                    System.out.println("Successful added");
                    break;
                default:
                    return;
            }
        }
    }

    public static Client createNewClient() {
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        Adress adress = new Adress();
        System.out.println("Enter client name: ");
        client.setName(sc.next());
        System.out.println("Enter client phone: ");
        client.setPhone(sc.nextInt());
        System.out.println("Enter client country: ");
        adress.setCountry(sc.next());
        System.out.println("Enter client city: ");
        adress.setCity(sc.next());
        System.out.println("Enter cleint street: ");
        adress.setStreet(sc.next());

        client.setAdress(adress);

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.add(client);

        return client;

    }

}
