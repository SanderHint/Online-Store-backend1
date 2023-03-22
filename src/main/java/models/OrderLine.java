package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Sander Hintsov
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderLine extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Product> products;

    private float qtyOfProducts;

    private float productPrice;

}