package cn.com.infosec.mypages.entity;

import java.math.BigInteger;

public class UserEntity {

	private BigInteger uuid;
	private String username;
	private String password;

	public UserEntity() {
		super();
	}

	public UserEntity(BigInteger uuid, String username, String password) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.password = password;
	}

	public BigInteger getUuid() {
		return uuid;
	}

	public void setUuid(BigInteger uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [uuid=" + uuid + ", username=" + username + ", password=" + password + "]";
	}

}
