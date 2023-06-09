package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sander Hintsov
 */
@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;
    private String password;

    private String city;
    private String address;

    private String logoType;

    //
    private int roleId;

    @OneToOne(cascade = CascadeType.MERGE)
    private Author author;
    private boolean isActive;

}