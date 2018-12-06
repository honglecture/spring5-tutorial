package com.tutorial.web.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MemberRole {

	@EmbeddedId
	private MemberRoleId id;
	/*
	 * private String roleName; private String memberId;
	 */

	private boolean defaultRole;

	public MemberRole() {
	}

	public MemberRole(String roleName, String memberId, boolean defaultRole) {
		this.id = new MemberRoleId(memberId, roleName);
		this.defaultRole = defaultRole;
	}

	public String getMemberId() {
		return id.getMemberId();
	}

	public void setMemberId(String memberId) {
		this.id.setMemberId(memberId);
	}

	public String getRoleName() {
		return id.getRoleName();
	}

	public void setRoleName(String roleName) {
		this.id.setRoleName(roleName);
	}

	public boolean isDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}

}