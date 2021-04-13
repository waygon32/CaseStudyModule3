package Service;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static String SELECT_PRODUCT_BY_ID = "SELECT * FROM vw_productDetail WHERE productId=?";
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
                    listProduct.add(new Product(name, color, memory, 1, price));
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
}
