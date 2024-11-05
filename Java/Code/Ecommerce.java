import java.util.*;
import java.sql.*;
import java.util.concurrent.*;
class database{
    private static final String url="jdbc:mysql://localhost:3306/ecommerce";
    private static final String user="root";
    private static final String password="root";
    public static Connection createConnection(){
        Connection connection=null;
        try{
            connection= DriverManager.getConnection(url,user,password);
            return connection;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
class Product{
    private int id,stock;
    private Double price;
    private String name;
    public Product(int id, int stock, Double price, String name) {
        this.id = id;
        this.stock=stock;
        this.price=price;
        this.name=name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void changeStock(int quantity){
        this.stock-=quantity;
    }
}
class productCache {
    static HashMap<Integer,Product>cache=new HashMap<>();
    public static Product getProduct(int id){
        return cache.get(id);
    }
    public static void addProduct(Product product){
        cache.put(product.getId(),product);
    }
    public static boolean containsItem(int id){
        return cache.containsKey(id);
    }
}
class Ecommerce{
    public Product getProductById(int id){
        if(productCache.containsItem(id)){
            return productCache.getProduct(id);
        }
        try{
            Connection connection=database.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = new Product(resultSet.getInt("id"),resultSet.getInt("stock"),resultSet.getDouble("price"),resultSet.getString("name"));
            productCache.addProduct(product);
            return product;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void placeOrder(int id, int quantity){
        Product product = getProductById(id);
         if(product.getStock()<quantity){
            System.out.println("insufficient stock");
        }
        product.changeStock(quantity);
        try{
            Connection connection = database.createConnection();
            PreparedStatement updateStock = connection.prepareStatement("UPDATE products SET stock = stock - ? WHERE id = ?");
            PreparedStatement insertOrder = connection.prepareStatement("INSERT INTO orders (product_id, quantity) VALUES (?, ?)");
            updateStock.setInt(1,quantity);
            updateStock.setInt(2,id);
            updateStock.executeUpdate();
            insertOrder.setInt(1,id);
            insertOrder.setInt(2,quantity);
            insertOrder.executeUpdate();
            System.out.println("order placed successfully for product: "+product.getName());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
class order extends Thread{
    private int id,quantity;
    private Ecommerce commerce;
    public order(int id, int quantity, Ecommerce commerce){
        this.id=id;
        this.quantity=quantity;
        this.commerce=commerce;
    }
    public void run(){
        try{
            commerce.placeOrder(id,quantity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class Ecommerce{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Ecommerce commerce = new Ecommerce();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            Connection connection=database.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("id: "+resultSet.getInt("id")+" name: "+resultSet.getString("name")+" price: "+resultSet.getDouble("price")+" stock: "+resultSet.getInt("stock"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        while (true) {
            System.out.println("Enter Product ID to order (0 to exit): ");
            int id = scan.nextInt();
            if (id == 0) 
                break;
            System.out.println("Enter quantity: ");
            int quantity = scan.nextInt();
            executorService.execute(new order(id, quantity, commerce));
        }
        executorService.shutdown();
        scan.close();
    }
}
