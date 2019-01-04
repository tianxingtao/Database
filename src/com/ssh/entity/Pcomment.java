package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pcomment")
public class Pcomment {
	
	private int pcoid;
	
	private int pid;

	private String uid;
	
	private String pcomment;
	
	private String pspeaker;
	

	@Id
	@Column(name="pcoid")
	public int getPcoid() {
		return pcoid;
	}

	public void setPcoid(int pcoid) {
		this.pcoid = pcoid;
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

	@Column(name="pcomment")
	public String getPcomment() {
		return pcomment;
	}

	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
	
	@Column(name="pspeaker")
	public String getPspeaker() {
		return pspeaker;
	}

	public void setPspeaker(String pspeaker) {
		this.pspeaker = pspeaker;
	}

	public Pcomment(int pcoid, int pid, String uid, String pcomment,String pspeaker) {
		super();
		this.pcoid = pcoid;
		this.pid = pid;
		this.uid = uid;
		this.pcomment = pcomment;
		this.pspeaker=pspeaker;
	}

	public Pcomment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
