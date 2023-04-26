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
public class DataLayerApplication implements CommandLineRunner {

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

//		System.out.println("***************** Produit avec ses commentaires (relation bidirectionnelle : relation un à plusieurs) *****************");
//		Optional<Product> optProduct4 = productService.getProductById(id);
//		if (optProduct4.isPresent()) {
//			Product product4 = optProduct4.get();
//			System.out.println(product4.getName() + " a les commentaires suivants :");
//			product4.getComments().forEach(comment -> System.out.println(comment.getContent()));		
//		} else {
//			System.out.println("Pas de produit à cet Id");			
//		}		
//		System.out.println();
//		
//		System.out.println("***************** Commentaire avec son produit (relation bidirectionnelle : relation plusieurs à un) *****************");
//		Optional<Comment> optComment2 = commentService.getCommentById(id);
//		if (optComment2.isPresent()) {
//			Comment comment = optComment2.get();
//			System.out.println("Commentaire n°" + id + " : " + comment.getContent());
//			System.out.println("Produit associé au commentaire : " + comment.getProduct().getName());
//		} else {
//			System.out.println("Commentaire n°" + id + " n'existe pas en base");			
//		}
//		System.out.println();

//		System.out.println("***************** Persistance d'une nouvelle catégorie *****************");
//
//		// Affichage des catégories avant l'ajout
//		categoryService.getCategories().forEach(category -> System.out.println(category.getName()));
//		
//		// Ajout de la nouvelle catégorie
//		Category newCategory = new Category();
//		newCategory.setName("Promotion");
//		newCategory = categoryService.addCategory(newCategory);
//		
//		// Affichage des catégories après l'ajout
//		categoryService.getCategories().forEach(category -> System.out.println(category.getName()));
//		System.out.println();

//		System.out.println("***************** Persistance d'un nouveau produit associé à la nouvelle catégorie *****************");
//		// Récupération de la catégorie promotion
//		Optional<Category> optCategory3 = categoryService.getCategoryById(5);
//		Category categoryPromotion = optCategory3.get();
//		System.out.println("Catégorie : " + categoryPromotion.getName());
//		
//		// Affichage des produits avant l'ajout
//		productService.getProducts().forEach(product -> System.out.println(product.getName()));
//		
//		// Caractéristique du nouveau produit
//		Product newProduct = new Product();
//		newProduct.setName("AssuranceAuTiersFidelite");
//		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
//		newProduct.setCost(1100);
//		
//		// Création du lien entre la nouvelle catégorie et le nouveau produit
//		categoryPromotion.addProduct(newProduct);
//		
//		
//		// Ajout du nouveau produit en base de données : le lien avec la catégorie étant créé, la table de jointure sera également complétée
//		newProduct = productService.addProduct(newProduct);
//		
//		// Affichage des produits après l'ajout
//		productService.getProducts().forEach(product -> System.out.println(product.getName()));
//		System.out.println();
//		
//		System.out.println("***************** Affichage des produits associés à la catégorie Promotion *****************");
//		categoryPromotion.getProducts().forEach(product -> System.out.println(product.getName()));
//		System.out.println();
//		
//		System.out.println("***************** Association d'un nouveau commentaire sur le produit AssuranceAuTiersFidelite *****************");
//		Product productAssuranceAuTiersFidelite = productService.getProductById(5).get();
//		System.out.println(productAssuranceAuTiersFidelite.toString());
//
//		Comment newComment = new Comment();
//		newComment.setContent("Assurance extraordinaire!");
//		System.out.println(newComment.toString());
//
//		productAssuranceAuTiersFidelite.addComment(newComment);
//
//		newComment = commentService.addComment(newComment);
//
//		productAssuranceAuTiersFidelite.getComments().forEach(comment -> System.out.println("Commentaire ajouté : " + comment.getContent()));
//		System.out.println();
		
//		System.out.println("***************** Méthode pour rechercher des produits par nom (Derived query ou JPQL query) *****************");
//		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
//		searchResults.forEach(product -> System.out.println(product.getProductId()));
		
//		System.out.println("***************** Méthode pour rechercher des produits par le nom d'une catégorie *****************");
//		searchResults = productService.getProductsByCategoryName("Standard");
//		searchResults.forEach(product -> System.out.println(product.getName()));
		
//		System.out.println("***************** Méthode pour rechercher des produits par son coût (Native query) *****************");
//		searchResults = productService.getProductsByCost(800);
//		searchResults.forEach(product -> System.out.println(product.getProductId()));

		System.out.println("***************** Méthode pour rechercher des produits pour un coût inférieur à 1000 *****************");
		Iterable<Product> searchResults = productService.getProductsWhereCostLessThan(1000);
		searchResults.forEach(product -> System.out.println(product.getName()));
		
		System.out.println("***************** Méthode pour rechercher des catégories par nom *****************");
		Iterable<Category> searchCategories = categoryService.getCategoriesByName("Special");
		searchCategories.forEach(category -> System.out.println(category.getCategoryId()));
		
		System.out.println("***************** Méthode pour rechercher des catégories par le nom d'un produit *****************");
		searchCategories = categoryService.getCategoriesByProductName("AssuranceTousRisquesJeunes");
		searchCategories.forEach(category -> System.out.println(category.getCategoryId()));
		
		System.out.println("***************** Méthode pour rechercher des commentaires dont le contenu contient un mot spécifique *****************");
		Iterable<Comment> searchComments = commentService.getCommentWhereContentContaining("deçu");
		searchComments.forEach(comment -> System.out.println(comment.getContent()));
	}
}
