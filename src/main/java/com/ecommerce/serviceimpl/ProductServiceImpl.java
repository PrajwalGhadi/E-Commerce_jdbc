package com.ecommerce.serviceimpl;

import java.util.List;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.daoimp.ProductDaoImp;
import com.ecommerce.exceptions.InsufficientStockException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

public class ProductServiceImpl implements ProductService
{
	
	public void test() {
		System.out.println("APPLICATION");
	}

	// Dependency on DAO layer
    private ProductDao productDao = new ProductDaoImp();

    @Override
    public List<Product> viewAvailableProducts() {

        return productDao.viewAvailableProducts();
    }
    
    @Override
    public Product displayProductDetails(long productId) {

        return productDao.displayProductDetails(productId);
    }
    
    @Override
    public int showAvailableStock(long productId) {

        return productDao.showAvailableStock(productId);
    }
    
    
    @Override
    public boolean reduceProductStock(long productId, int quantity)
            throws InsufficientStockException {

        int availableStock = productDao.showAvailableStock(productId);

        if (availableStock == -1) {
            throw new IllegalArgumentException("Product not found.");
        }

        if (quantity > availableStock) {
            throw new InsufficientStockException(
                    "Only " + availableStock + " item(s) available in stock.");
        }

        return productDao.reduceProductStock(productId, quantity);
    }
    

}
