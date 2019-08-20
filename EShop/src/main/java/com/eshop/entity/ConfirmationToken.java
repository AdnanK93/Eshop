package com.eshop.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conftoken")
@NoArgsConstructor
@Data
public class ConfirmationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private int id;
	@Column(name = "conftoken")
	private String confirmationToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	public ConfirmationToken(User user) {
		this.user = user;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}
}
