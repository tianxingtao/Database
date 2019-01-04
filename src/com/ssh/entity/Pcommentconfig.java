package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcommentconfig")
public class Pcommentconfig {
	
	private int pcfid;
	
	private int pid;
	
	private String uid;

	
	@Id
	@Column(name="pcfid")
	public int getPcfid() {
		return pcfid;
	}

	public void setPcfid(int pcfid) {
		this.pcfid = pcfid;
	}

	@Column(name="pid")
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name="uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
