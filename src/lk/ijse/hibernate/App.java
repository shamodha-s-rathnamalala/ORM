package lk.ijse.hibernate;

import lk.ijse.hibernate.embeded.CustomerMobiles;
import lk.ijse.hibernate.embeded.CustomerName;
import lk.ijse.hibernate.entity.CustomerEntity;
import lk.ijse.hibernate.reppsitory.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    public static void main(String[] args) {
        CustomerEntity customer = new CustomerEntity();

        List<CustomerMobiles>telNums=new ArrayList<>();
        telNums.add(new CustomerMobiles("078787857","work"));
        telNums.add(new CustomerMobiles("076456456","home"));
        telNums.add(new CustomerMobiles("074657676","lear"));


        //save
        customer.setName(new CustomerName("shamodha","sahan","rathnamalala"));
        customer.setTelNums(telNums);
        customer.setAge(22);
        customer.setCordNo("4574654564");
        System.out.println(customerRepository.saveCustomer(customer));

        //update
        customer.setName(new CustomerName("shamodha","shamodha","shamodha"));
        customer.setId(1);
        customer.setTelNums(telNums);
        customer.setAge(22);
        customer.setCordNo("4574654564");
        System.out.println(customerRepository.updateCustomer(customer));

        //delete
        try {
            System.out.println(customerRepository.deleteCustomerById(1));
        }catch (Exception e){
            System.out.println("Not fount Customer id !");
        }

        //find
        CustomerEntity customerEntity = customerRepository.findCustomerById(1);
        if (customerEntity != null) {
            System.out.println(customerEntity.toString());
        }

    }
}
