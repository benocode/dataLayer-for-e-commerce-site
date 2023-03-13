package com.benocode.datalayer.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "commentaire")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentaire_id")
	private int commentId;
	
	@Column(name = "contenu")
	private String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produit_id")
	private Product product;
	
//	public int getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(int commentId) {
//		this.commentId = commentId;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//	
//	@Override
//	public String toString() {
//		return "commentaire_id[" + this.commentId + "], contenu[" + this.content + "]";
//	}
}
