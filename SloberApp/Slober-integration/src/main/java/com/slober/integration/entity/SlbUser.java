package com.slober.integration.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the slb_user database table.
 * 
 */
@Entity
@Table(name = "slb_user")
@NamedQuery(name = "SlbUser.findAll", query = "SELECT s FROM SlbUser s")
public class SlbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slb_user_id")
	private long slbUserId;
	@Column
	private String email;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String profileImage;

	public SlbUser() {
	}

	public long getSlbUserId() {
		return this.slbUserId;
	}

	public void setSlbUserId(long slbUserId) {
		this.slbUserId = slbUserId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

}