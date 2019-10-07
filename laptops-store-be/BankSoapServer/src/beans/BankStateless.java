package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Account;
import model.Store;
import model.Transaction;

/**
 * Session Bean implementation class BankStateless
 */
@Stateless
public class BankStateless {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public BankStateless() {
		// TODO Auto-generated constructor stub
	}

	public boolean payment(service.PaymentType payment) {
		Query q = em.createQuery("SELECT a FROM Account a WHERE a.cardNumber LIKE :cardNumber");
		q.setParameter("cardNumber", payment.getCardNumber());
		Transaction transaction = new Transaction();
		Query query = em.createQuery("SELECT s FROM Store s WHERE s.cid LIKE :cid");
		query.setParameter("cid", payment.getCid());
		Store store = (Store) query.getResultList().get(0);
		transaction.setStore(store);
		transaction.setAmount(payment.getAmount());

		if (q.getResultList().isEmpty()) {
			System.out.println("Incorrect card number");
			transaction.setAccount(null);
			transaction.setStatus((byte) 0);

			em.persist(transaction);

			return false;
		}
		Account account = (Account) q.getResultList().get(0);
		if (account.getCardNumber().equals(payment.getCardNumber())
				&& account.getExpirationDate().equals(payment.getExpirationDate())
				&& account.getCvc2().equals(payment.getCvc2())) {
			if (account.getAmount() < payment.getAmount()) {
				System.out.println("Amount is greater then on account");
				transaction.setAccount(account);
				transaction.setStatus((byte) 0);

				em.persist(transaction);

				return false;
			}

			account.setAmount(account.getAmount() - payment.getAmount());
			transaction.setAccount(account);
			transaction.setStatus((byte) 1);

			em.persist(transaction);

			return true;
		} else {
			System.out.println("Incorrect data from card...");

			transaction.setAccount(null);
			transaction.setStatus((byte) 0);

			em.persist(transaction);

			return false;
		}
	}

}
