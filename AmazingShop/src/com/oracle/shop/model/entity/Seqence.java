package com.oracle.shop.model.entity;

public class Seqence {
	private int currSeq;
	private int nextSeq;
	public int getCurrSeq() {
		return currSeq;
	}
	public void setCurrSeq(int currSeq) {
		this.currSeq = currSeq;
	}
	public int getNextSeq() {
		return nextSeq;
	}
	public void setNextSeq(int nextSeq) {
		this.nextSeq = nextSeq;
	}
	public Seqence(){}
	public Seqence(int currSeq, int nextSeq) {
		super();
		this.currSeq = currSeq;
		this.nextSeq = nextSeq;
	}
	@Override
	public String toString() {
		return "Seqence [currSeq=" + currSeq + ", nextSeq=" + nextSeq + "]";
	}
	
}
