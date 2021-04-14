package Service;

import Model.Cart;
import Model.Customer;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static String SELECT_PRODUCT_BY_ID = "SELECT * FROM vw_productDetail WHERE productId=?";
    private static String INSERT_INTO_CART = "INSERT INTO cart(productId, quantity, account) values(?,?,?) ";
    private static String GET_PRODUCT_LIST_CART = "SELECT * FROM vw_cartDetail WHERE account=?";
    static List<Product> listProduct = new ArrayList<>();
    Connection connection = DataBaseConnection.databaseConnection();

    public List<Product> getListProductCart(Integer id) {
        boolean isExist = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("typeName");
                String color = resultSet.getString("color");
                Integer memory = resultSet.getInt("memory");
                String price = resultSet.getString("price");
                for (Product product : listProduct) {
                    if (product.getName().equals(name) && product.getColor().equals(color) && memory.equals(product.getMemory())) {
                        isExist = false;
                        product.setQuantity(product.getQuantity() + 1);
                        long newPrice = Long.parseLong(product.getPrice()) + Long.parseLong(price);
                        String str = "";
                        product.setPrice(str + newPrice);
                    }
                }
                if (isExist) {
                    Product product = new Product(id, name, color, memory, 1, price);
                    listProduct.add(product);
                    addCartInDataBase(product, "thanh");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProduct;
    }

    public static List<Product> getListProduct() {
        return listProduct;
    }

    public void addCartInDataBase(Product product, String account) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CART);
        preparedStatement.setInt(1, product.getProductId());
        preparedStatement.setInt(2, product.getQuantity());
        preparedStatement.setString(3, account);
        preparedStatement.executeUpdate();

    }

    public void getCartInDataBase(String account) throws SQLException {
        Cart cart = new Cart();
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST_CART);
        preparedStatement.setString(1, account);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("productId");
            String name = resultSet.getString("typename");
            String color = resultSet.getString("color");
            int memory = resultSet.getInt("memory");
            String price = resultSet.getString("price");
            Product product = new Product(id, name, color, memory, 1, price);
            productList.add(product);
        }
        cart.setListProductInCart(productList);
        cart.setAccount(account);
    }
}
