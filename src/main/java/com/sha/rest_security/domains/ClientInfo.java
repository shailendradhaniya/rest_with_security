package com.sha.rest_security.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the client_info database table.
 * 
 */
@Entity
@Table(name="client_info")
@NamedQuery(name="ClientInfo.findAll", query="SELECT c FROM ClientInfo c")
public class ClientInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(unique=true, nullable=false, length=36)
	private String id;

	@Column(nullable=false)
	private boolean enabled;

	@Column(name="secret_key", nullable=false, length=512)
	private String secretKey;

	@Column(name="secret_key_encrypted", nullable=false)
	private boolean secretKeyEncrypted;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public ClientInfo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public boolean getSecretKeyEncrypted() {
		return this.secretKeyEncrypted;
	}

	public void setSecretKeyEncrypted(boolean secretKeyEncrypted) {
		this.secretKeyEncrypted = secretKeyEncrypted;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}