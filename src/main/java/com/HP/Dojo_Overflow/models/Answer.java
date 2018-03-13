package com.HP.Dojo_Overflow.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String answer;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    public Answer() {

        this.createdAt = new Date();
        this.updatedAt = new Date();
	}
	
	public Answer(String answer, Question question) {
		this.answer = answer;
		this.question = question;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}


	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}


	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}


	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
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
}