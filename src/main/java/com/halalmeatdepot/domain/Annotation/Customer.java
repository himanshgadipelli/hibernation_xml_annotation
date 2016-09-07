package com.halalmeatdepot.domain.Annotation;

import org.hibernate.annotations.ListIndexBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vashishta on 8/30/16.
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name ="FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private String email;

/* ALL MAPPING: the owner shipping will need to be specified at other side by use mappedBy*/

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerProfile customerProfile;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    @ListIndexBase
    private List<Order> orderList=new ArrayList<>();

    public void addOrder(Order order){
        order.setCustomer(this);
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        customerProfile.setCustomer(this);
        this.customerProfile = customerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
