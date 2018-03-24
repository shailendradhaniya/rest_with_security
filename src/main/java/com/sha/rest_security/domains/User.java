package com.sha.rest_security.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(unique=true, nullable=false, length=36)
	private String id;

	@Column(nullable=false)
	private boolean enabled;

	@Column(nullable=false, length=100)
	private String password;

	@Column(name="password_encrypted", nullable=false)
	private boolean passwordEncrypted;

	@Column(nullable=false, length=256)
	private String username;

	//bi-directional many-to-one association to PersistentLogin
	@OneToMany(mappedBy="user")
	private List<PersistentLogin> persistentLogins=new ArrayList<>();

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles=new ArrayList<>();

	//bi-directional many-to-one association to ClientInfo
	@OneToMany(mappedBy="user")
	private List<ClientInfo> clientInfos=new ArrayList<>();

	public User() {
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getPasswordEncrypted() {
		return this.passwordEncrypted;
	}

	public void setPasswordEncrypted(boolean passwordEncrypted) {
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