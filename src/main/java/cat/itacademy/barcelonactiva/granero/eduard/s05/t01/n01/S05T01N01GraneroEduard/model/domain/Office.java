package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_OfficeID;
    @Column(name = "name")
    @NotEmpty(message = "The name cannot be empty")
    private String nameOffice;
    @Column(name = "country")
    @NotEmpty(message = "The country cannot be empty")
    private String countryOffice;

    public Office() {}

    public Integer getPk_OfficeID() {
        return pk_OfficeID;
    }

    public String getNameOffice() {
        return nameOffice;
    }

    public String getCountryOffice() {
        return countryOffice;
    }

    public void setPk_OfficeID(Integer pk_OfficeID) {
        this.pk_OfficeID = pk_OfficeID;
    }

    public void setNameOffice(String nameOffice) {
        this.nameOffice = nameOffice;
    }

    public void setCountryOffice(String countryOffice) {
        this.countryOffice = countryOffice;
    }
}
