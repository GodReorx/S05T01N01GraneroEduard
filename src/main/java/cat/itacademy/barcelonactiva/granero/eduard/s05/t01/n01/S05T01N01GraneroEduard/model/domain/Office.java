package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain;

public class Office {
    protected Integer pk_OfficeID;
    protected String nameOffice;
    protected String countryOffice;

    public Office(Integer pk_OfficeID, String nameOffice, String countryOffice) {
        this.pk_OfficeID = pk_OfficeID;
        this.nameOffice = nameOffice;
        this.countryOffice = countryOffice;
    }
}
