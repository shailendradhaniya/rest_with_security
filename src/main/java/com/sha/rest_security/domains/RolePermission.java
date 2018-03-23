package com.sha.rest_security.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the role_permissions database table.
 * 
 */
@Entity
@Table(name="role_permissions")
@NamedQuery(name="RolePermission.findAll", query="SELECT r FROM RolePermission r")
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="created_by", length=36)
	private String createdBy;

	@Column(name="created_ts", nullable=false)
	private Timestamp createdTs;

	@Column(name="modified_by", length=36)
	private String modifiedBy;

	@Column(name="modified_ts", nullable=false)
	private Timestamp modifiedTs;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	@JoinColumn(name="permission_id", nullable=false)
	private Permission permission;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private Role role;

	public RolePermission() {
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

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}