package com.HP.Dojo_Overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products")
public class Qtags {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String subject;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "quest_id")
    // private Question question;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="questions_tags", joinColumns=@JoinColumn(name="tag_id"), inverseJoinColumns=@JoinColumn(name="question_id"))
    private List<Question> questions;

    public Qtags() {

        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    public Qtags(String subject) {

        this.subject = subject;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// /**
	//  * @return the question
	//  */
	// public Question getQuestion() {
	// 	return question;
	// }

	// /**
	//  * @param question the question to set
	//  */
	// public void setQuestion(Question question) {
	// 	this.question = question;
	// }

	/**
	 * @return the categories
	 */
	public List<Question> getQuestion() {
		return questions;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}
}
