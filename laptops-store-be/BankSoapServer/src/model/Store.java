package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_store")
	private int idStore;

	@Column(name="CID")
	private String cid;

	private String name;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="store", fetch=FetchType.EAGER)
	private List<Transaction> transactions;

	public Store() {
	}

	public int getIdStore() {
		return this.idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setStore(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setStore(null);

		return transaction;
	}

}