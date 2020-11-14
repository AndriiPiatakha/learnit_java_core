package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.services;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withoutlist.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}
