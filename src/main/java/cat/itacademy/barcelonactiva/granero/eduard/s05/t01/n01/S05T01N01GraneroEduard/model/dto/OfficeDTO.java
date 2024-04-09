package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain.Office;

public class OfficeDTO extends Office {
    private String typeOffice;

    public OfficeDTO(Integer pk_OfficeID, String nameOffice, String countryOffice, String typeOffice) {
        super(pk_OfficeID, nameOffice, countryOffice);
        this.typeOffice = typeOffice;
    }
}
