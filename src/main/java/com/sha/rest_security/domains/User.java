package com.sha.rest_security.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
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

	@Column(name="modified_ts")
	private Timestamp modifiedTs;

	@Column(nullable=false, length=100)
	private String password;

	@Column(name="password_encrypted", nullable=false)
	private byte passwordEncrypted;

	@Column(nullable=false, length=256)
	private String username;

	//bi-directional many-to-one association to PersistentLogin
	@OneToMany(mappedBy="user")
	private List<PersistentLogin> persistentLogins;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to ClientInfo
	@OneToMany(mappedBy="user")
	private List<ClientInfo> clientInfos;

	public User() {
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getPasswordEncrypted() {
		return this.passwordEncrypted;
	}

	public void setPasswordEncrypted(byte passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<PersistentLogin> getPersistentLogins() {
		return this.persistentLogins;
	}

	public void setPersistentLogins(List<PersistentLogin> persistentLogins) {
		this.persistentLogins = persistentLogins;
	}

	public PersistentLogin addPersistentLogin(PersistentLogin persistentLogin) {
		getPersistentLogins().add(persistentLogin);
		persistentLogin.setUser(this);

		return persistentLogin;
	}

	public PersistentLogin removePersistentLogin(PersistentLogin persistentLogin) {
		getPersistentLogins().remove(persistentLogin);
		persistentLogin.setUser(null);

		return persistentLogin;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<ClientInfo> getClientInfos() {
		return this.clientInfos;
	}

	public void setClientInfos(List<ClientInfo> clientInfos) {
		this.clientInfos = clientInfos;
	}

	public ClientInfo addClientInfo(ClientInfo clientInfo) {
		getClientInfos().add(clientInfo);
		clientInfo.setUser(this);

		return clientInfo;
	}

	public ClientInfo removeClientInfo(ClientInfo clientInfo) {
		getClientInfos().remove(clientInfo);
		clientInfo.setUser(null);

		return clientInfo;
	}

}