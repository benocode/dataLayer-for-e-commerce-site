package com.benocode.datalayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benocode.datalayer.model.Category;
import com.benocode.datalayer.model.Comment;
import com.benocode.datalayer.model.Product;
import com.benocode.datalayer.service.CategoryService;
import com.benocode.datalayer.service.CommentService;
import com.benocode.datalayer.service.ProductService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		int id = 1;
		
//		System.out.println("***************** Produits *****************");
//		Iterable<Product> products = productService.getProducts();
//		products.forEach(product -> System.out.println(product.getName()));
//		Optional<Product> optProduct = productService.getProductById(id);
//		if (optProduct.isPresent()) {
//			Product product = optProduct.get();
//			System.out.println("Produit n°" + id + " : " + product.toString());			
//		} else {
//			System.out.println("Produit n°" + id + " n'existe pas en base");			
//		}
//		System.out.println();
//		
//		System.out.println("***************** Commentaires *****************");
//		Iterable<Comment> comments = commentService.getComments();
//		comments.forEach(comment -> System.out.println(comment.getContent()));
//		Optional<Comment> optComment = commentService.getCommentById(id);
//		if (optComment.isPresent()) {
//			Comment comment = optComment.get();
//			System.out.println("Commentaire n°" + id + " : " + comment.toString());			
//		} else {
//			System.out.println("Commentaire n°" + id + " n'existe pas en base");			
//		}
//		System.out.println();
//		
//		System.out.println("***************** Catégories *****************");
//		Iterable<Category> categories = categoryService.getCategories();
//		categories.forEach(category -> System.out.println(category.getName()));
//		Optional<Category> optCategory = categoryService.getCategoryById(id);
//		if (optCategory.isPresent()) {
//			Category category = optCategory.get();
//			System.out.println("Catégorie n°" + id + " : " + category.toString());			
//		} else {
//			System.out.println("Catégorie n°" + id + " n'existe pas en base");			
//		}
//		System.out.println();
		
//		System.out.println("***************** Produit avec ses commentaires (relation unidirectionnelle : un à plusieurs) *****************");
//		Optional<Product> optProduct2 = productService.getProductById(id);
//		if (optProduct2.isPresent()) {
//			Product product2 = optProduct2.get();
//			System.out.println("Produit n°" + id + " : " + product2.getName());			
//			product2.getComments().forEach(
//				comment -> System.out.println(comment.getContent()));
//		} else {
//			System.out.println("Produit n°" + id + " n'existe pas en base");			
//		}
//		System.out.println();
		
//		System.out.println("***************** Catégorie avec ses produits (relation unidirectionnelle : relation plusieurs à plusieurs) *****************");
//		Optional<Category> optCategory2 = categoryService.getCategoryById(id);
//		if (optCategory2.isPresent()) {
//			Category category2 = optCategory2.get();
//			System.out.println(category2.getName() + " contient les produits suivants :");
//			category2.getProducts().forEach(product -> System.out.println(product.getName()));			
//		} else {
//			System.out.println("Pas de catégorie à cet Id");
//		}
//		System.out.println();
//		
//		System.out.println("***************** Produit avec ses catégories (relation unidirectionnelle : relation plusieurs à plusieurs) *****************");
//		Optional<Product> optProduct3 = productService.getProductById(id);
//		if (optProduct3.isPresent()) {
//			Product product3 = optProduct3.get();
//			System.out.println(product3.getName() + " contient les catégories suivantes :");
//			product3.getCategories().forEach(categorie -> System.out.println(categorie.getName()));			
//		} else {
//			System.out.println("Pas de produit à cet Id");			
//		}
//		System.out.println();
		
		System.out.println("***************** Produit avec ses commentaires (relation bidirectionnelle : relation un à plusieurs) *****************");
		Optional<Product> optProduct4 = productService.getProductById(id);
		if (optProduct4.isPresent()) {
			Product product4 = optProduct4.get();
			System.out.println(product4.getName() + " a les commentaires suivants :");
			product4.getComments().forEach(comment -> System.out.println(comment.getContent()));		
		} else {
			System.out.println("Pas de produit à cet Id");			
		}		
		System.out.println();
		
		System.out.println("***************** Commentaire avec son produit (relation bidirectionnelle : relation plusieurs à un) *****************");
		Optional<Comment> optComment2 = commentService.getCommentById(id);
		if (optComment2.isPresent()) {
			Comment comment = optComment2.get();
			System.out.println("Commentaire n°" + id + " : " + comment.getContent());
			System.out.println("Produit associé au commentaire : " + comment.getProduct().getName());
		} else {
			System.out.println("Commentaire n°" + id + " n'existe pas en base");			
		}
		System.out.println();
	}
}
