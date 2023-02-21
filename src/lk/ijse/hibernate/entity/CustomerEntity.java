package lk.ijse.hibernate.entity;

import lk.ijse.hibernate.embeded.CustomerMobiles;
import lk.ijse.hibernate.embeded.CustomerName;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private CustomerName name;
    @Column(name = "age",columnDefinition = "SMALLINT")
    private int age;

    @ElementCollection
    @CollectionTable(
            name = "cusTelNum",
            joinColumns = @JoinColumn(name = "cusId")
    )
    private List<CustomerMobiles> telNums;

    @CreationTimestamp
    private Date createDate;

    @Transient
    private String cordNo;
}
