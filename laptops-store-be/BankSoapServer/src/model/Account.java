package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Account database table.
 * 
 */
@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private int idAccount;

	private float amount;

	@Enumerated(EnumType.STRING)
	private Brand brand;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "CVC2")
	private String cvc2;

	@Column(name = "expiration_date")
	private String expirationDate;

	@Column(name = "amount_limit")
	private float amountLimit;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "valid_from")
	private Date validFrom;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "valid_to")
	private Date validTo;

	// bi-directional many-to-one association to Customer
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "fk_customer")
	private Customer customer;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private List<Transaction> transactions;

	public Account() {
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvc2() {
		return this.cvc2;
	}

	public void setCvc2(String cvc2) {
		this.cvc2 = cvc2;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public float getAmountLimit() {
		return this.amountLimit;
	}

	public void setAmountLimit(float amountLimit) {
		this.amountLimit = amountLimit;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setAccount(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAccount(null);

		return transaction;
	}

}