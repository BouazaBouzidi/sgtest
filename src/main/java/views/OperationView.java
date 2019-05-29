package views;

public class OperationView {
	private long accountId;
	private double amount;

	public OperationView(long accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}

	public OperationView() {
		super();
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
