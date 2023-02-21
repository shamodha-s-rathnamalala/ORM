package lk.ijse.hibernate.embeded;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CustomerName {
    private String fName;
    private String mName;
    private String lName;
}
