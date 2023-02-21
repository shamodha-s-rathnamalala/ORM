package lk.ijse.hibernate.reppsitory;

import lk.ijse.hibernate.entity.CustomerEntity;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepositoryImpl implements CustomerRepository{
    Session session = FactoryConfiguration.getInstance().getSession();

    @Override
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

    @Override
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

    @Override
    public boolean deleteCustomerById(int id){
        Transaction transaction = session.beginTransaction();
        try {
            CustomerEntity customerEntity = findCustomerById(id);
            if (customerEntity != null){
                session.delete(customerEntity);
                transaction.commit();
                return true;
            }
            throw new Exception("Not found customer !");
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public CustomerEntity findCustomerById(int id){
        return session.get(CustomerEntity.class,id);
    }
}
