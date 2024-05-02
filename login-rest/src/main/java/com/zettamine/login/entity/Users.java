package com.zettamine.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(unique = true)
	private String email;
	private String firstName;
	private String password;
	private String tempPwd;

	private String lastName;
	private Integer roleId;
	private Integer loginStatus;
	private Boolean accountLock;
	private Integer attempts;
}
