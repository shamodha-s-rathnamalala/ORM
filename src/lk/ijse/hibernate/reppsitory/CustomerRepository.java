package lk.ijse.hibernate.reppsitory;

import lk.ijse.hibernate.entity.CustomerEntity;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    Session session = FactoryConfiguration.getInstance().getSession();

    public Integer saveCustomer(CustomerEntity customerEntity){
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(customerEntity);
            transaction.commit();
            return id;
        }catch (Exception e){
            transaction.rollback();
            return -1;
        }
    }

    public boolean updateCustomer(CustomerEntity customerEntity){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customerEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    public boolean deleteCustomerById(CustomerEntity customerEntity){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customerEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    public CustomerEntity findCustomerById(Integer id){
        return session.get(CustomerEntity.class,id);
    }
}
