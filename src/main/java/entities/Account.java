package entities;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private long id;
	private Client client;
	private double balance;
	private List<Operation> operations ;
	public Account(long id, Client client, double balance, List<Operation> operations) {
		super();
		this.id = id;
		this.client = client;
		this.balance = balance;
		this.operations = operations;
	}
	
	public Account(long id, Client client, double balance) {
		super();
		this.id = id;
		this.client = client;
		this.balance = balance;
		this.operations = new ArrayList<>();
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	

}
