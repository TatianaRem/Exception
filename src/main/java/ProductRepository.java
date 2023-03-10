import ru.netology.mainclasses.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void saveProducts(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i ++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void deleteById(int deleteId) {
        Product deleteProduct = findById(deleteId);
        if (deleteProduct == null) {
            throw new NotFoundException(deleteId);
        }
        
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != deleteId) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {

        return products;
    }

}