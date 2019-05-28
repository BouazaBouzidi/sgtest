package entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Operation {
	private long id;
	
	private static long idCounter= 0 ;
	
	private LocalDateTime operationDateTime;
	@JsonIgnore
	private Account account;
	private double amount;
	private OperationType operationType;

	public long getId() {
		return id;
	}

	public LocalDateTime getOperationDateTime() {
		return operationDateTime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		account.getOperations().add(this);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Operation(Account account, double amount,
			OperationType operationType) {
		this();
		this.account = account;
		this.amount = amount;
		this.operationType = operationType;
	}

	public Operation() {
		super();
		this.id = idCounter++;
		this.operationDateTime = LocalDateTime.now();
	}

	public void applyOperation() {
		if (operationType == OperationType.DEPOSIT)
			account.setBalance(account.getBalance() + this.amount);
		else
			account.setBalance(account.getBalance() - this.amount);
	}

}
