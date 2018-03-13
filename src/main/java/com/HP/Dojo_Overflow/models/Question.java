package com.HP.Dojo_Overflow.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String question;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> Answer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "questions_tags", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Qtags> qtags;

    public Question() {

        this.createdAt = new Date();
        this.updatedAt = new Date();
	}
	
	public Question(String question, List<Qtags> qtags) {
		this.qtags = qtags;
		this.question = question;
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
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

	/**
	 * @return the answer
	 */
	public List<Answer> getAnswer() {
		return Answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(List<Answer> answer) {
		this.Answer = answer;
	}

	/**
	 * @return the categories
	 */
	public List<Qtags> getQtags() {
		return qtags;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setQtags(List<Qtags> qtags) {
		this.qtags = qtags;
	}
}