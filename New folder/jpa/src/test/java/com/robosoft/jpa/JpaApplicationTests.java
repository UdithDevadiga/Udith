package com.robosoft.jpa;

import com.robosoft.jpa.modal.Product;
import com.robosoft.jpa.repository.ProductRepository;
import com.robosoft.jpa.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class JpaApplicationTests {
	@Autowired
	ProductService productService;
	@MockBean
	ProductRepository productRepository;

	@Test
	public void getProductsTest() {
		when(productRepository.findAll()).thenReturn(Stream.of(new Product(1,"Samsung Galaxy S15",2,35000),new Product(2,"Bingo",25,10),new Product(3,"Olive Oil",10,45)).collect(Collectors.toList()));
		assertEquals(3,productService.getProducts().size());
	}

	@Test
	public void addProductTest() {
		Product product = new Product(1,"Lego Batman",12,2900);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProduct(product));
	}

	@Test
	public void addProductsTest() {
		Product product1 = new Product(1,"Lego Batman",12,2900);
		Product product2 = new Product(2,"Lego Batman",12,2900);
		Product product3 = new Product(3,"Lego Batman",12,2900);
		List<Product> products = new LinkedList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		when(productRepository.saveAll(products)).thenReturn(products);
		assertEquals(products,productService.addProducts(products));
	}

	@Test
	public void getProductById() {
		int id = 1;
		Product product = new Product(1,"Lego Batman",12,2900);
		when(productRepository.findById(id)).thenReturn(Optional.of(product));
		assertEquals(product,productService.getProductById(id));
	}

	@Test
	public void deleteByIdTest() {
		Product product = new Product(1,"Lego Batman",12,2900);
		productService.deleteById(product.getId());
		verify(productRepository, times(1)).deleteById(product.getId());
	}

}
