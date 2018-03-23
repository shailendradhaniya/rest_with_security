package com.sha.rest_security.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the client_info database table.
 * 
 */
@Entity
@Table(name="client_info")
@NamedQuery(name="ClientInfo.findAll", query="SELECT c FROM ClientInfo c")
public class ClientInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=36)
	private String id;

	@Column(name="created_by", length=36)
	private String createdBy;

	@Column(name="created_ts", nullable=false)
	private Timestamp createdTs;

	@Column(nullable=false)
	private byte enabled;

	@Column(name="modified_by", length=36)
	private String modifiedBy;

	@Column(name="modified_ts", nullable=false)
	private Timestamp modifiedTs;

	@Column(name="secret_key", nullable=false, length=512)
	private String secretKey;

	@Column(name="secret_key_encrypted", nullable=false)
	private byte secretKeyEncrypted;

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

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Timestamp modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public byte getSecretKeyEncrypted() {
		return this.secretKeyEncrypted;
	}

	public void setSecretKeyEncrypted(byte secretKeyEncrypted) {
		this.secretKeyEncrypted = secretKeyEncrypted;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}