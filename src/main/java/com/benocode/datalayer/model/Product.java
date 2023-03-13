package com.benocode.datalayer.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "produit")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private int productId;
	
	@Column(name = "nom")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cout")
	private int cost;
	
	@OneToMany(
			mappedBy = "product",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany(
			mappedBy = "products",
			cascade = CascadeType.ALL
			)
	private List<Category> categories = new ArrayList<>();
	
	/* Helpers methods */
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}

//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public int getCost() {
//		return cost;
//	}
//
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//	
//	@Override
//	public String toString() {
//		return "produit_id[" + this.productId + "], nom[" + this.name + "], description[" + this.description + "], coût[" + this.cost + "]";
//	}
}
