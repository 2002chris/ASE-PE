package de.dhbw.ase.domain.Tag;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor
public class Tag {
    @Id
    private String name;

    public Tag(String name) {
        this.name = name.toLowerCase();
    }

}
