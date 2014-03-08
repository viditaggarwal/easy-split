package edu.usc.easysplit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class SplitUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> partOf = new ArrayList<Integer>();
	
	private String name;
	
	private int balance;

	public List<Integer> getPartOf() {
		return partOf;
	}

	public void setPartOf(List<Integer> partOf) {
		this.partOf = partOf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}