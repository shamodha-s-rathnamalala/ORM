package lk.ijse.hibernate.reppsitory;

import lk.ijse.hibernate.entity.CustomerEntity;

public interface CustomerRepository {
    Integer saveCustomer(CustomerEntity customerEntity);

    boolean updateCustomer(CustomerEntity customerEntity);

    boolean deleteCustomerById(int id);

    CustomerEntity findCustomerById(int id);
}
