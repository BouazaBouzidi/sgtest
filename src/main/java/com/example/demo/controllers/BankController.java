package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Account;
import entities.Client;
import entities.Operation;
import entities.OperationType;
import views.OperationView;

@CrossOrigin(origins = "*")
@RestController("/")
public class BankController {

	private List<Account> accounts;

	{
		accounts = new ArrayList<>();

		Client c1 = new Client(1, "BOUZIDI Bouaza");
		Client c2 = new Client(2, "HAJARI Youssef");
		
		Account a1 = new Account(1, c1, 0);
		Account a2 = new Account(2, c2, 10000.0);

		accounts.add(a1);
		accounts.add(a2);

	}

	@PostMapping("deposit")
	public Account deposit(@RequestBody OperationView operationView)
			throws Exception {

		Account account = getAccount(operationView.getAccountId());
		Operation operation = buildOperation(operationView.getAccountId(), operationView.getAmount(), OperationType.DEPOSIT);
		operation.setAccount(account);
		operation.applyOperation();

		return account;

	}

	@PostMapping("withdraw")
	public Account withdraw(@RequestBody OperationView operationView)
			throws Exception {

		Account account = getAccount(operationView.getAccountId());
		Operation operation = buildOperation(operationView.getAccountId(), operationView.getAmount(), OperationType.WITHDRAW);
		operation.setAccount(account);
		operation.applyOperation();

		return account;

	}

	@GetMapping("history/{accountId}")
	public List<Operation> getOperations(@PathVariable("accountId") long accountId) throws Exception {
		Account account = getAccount(accountId);
		return account.getOperations();
	}

	private Operation buildOperation(long accountId, double amount, OperationType operationType) throws Exception {
		if (amount <= 0)
			throw new Exception("amount must be positive");
		Operation operation = new Operation();
		operation.setOperationType(operationType);
		operation.setAmount(amount);
		return operation;
	}
	
	private Account getAccount(long accountId) throws Exception {
		Account account = null;
		try {
			account = accounts.stream().filter(a -> a.getId() == accountId).collect(Collectors.toList()).get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("account with id = " + accountId + " not found");
		}
		return account;
	}

}
