package net.webprac1.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private Long answerId;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
	private Question question;

	@Lob
	private String contents;
	
	private LocalDateTime createDate;	

	public Answer() {}
	
	public Answer(User writer, Question question, String contents) {
		this.writer = writer;
		this.question = question;
		this.contents=contents;
		this.createDate=LocalDateTime.now();
	}
	public String getFormattedCreateDate() {
		if(createDate == null) return "";
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}

	
	
	
	
	public Long getAnswerId() {
		return answerId;
	}

	public User getWriter() {
		return writer;
	}

	public Question getQuestion() {
		return question;
	}

	public String getContents() {
		return contents;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	
	
	public void update(String contents2) {
		// TODO Auto-generated method stub
		this.contents=contents2;
		this.createDate=LocalDateTime.now();
	}	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		return true;
	}


	
	
}
