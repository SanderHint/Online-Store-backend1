package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Category model
 *
 * @author Sander Hintsov
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Category extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //

}