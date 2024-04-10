package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto;

import java.util.Arrays;

public class OfficeDTO {
    private Integer pk_OfficeID;
    private String nameOffice;
    private String countryOffice;
    private String typeOffice;

    public OfficeDTO(Integer pk_OfficeID, String nameOffice, String countryOffice) {
        this.pk_OfficeID = pk_OfficeID;
        this.nameOffice = nameOffice;
        this.countryOffice = countryOffice;
        this.typeOffice = checkCountryUE(countryOffice);
    }

    public Integer getPk_OfficeID() {
        return pk_OfficeID;
    }

    public String getNameOffice() {
        return nameOffice;
    }

    public String getCountryOffice() {
        return countryOffice;
    }

    public String getTypeOffice() {
        return typeOffice;
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

    public void setTypeOffice(String typeOffice) {
        this.typeOffice = typeOffice;
    }

    public String checkCountryUE(String countryOffice) {
        if (Arrays.asList(CountryEU.values()).contains(CountryEU.valueOf(countryOffice))) {
            return "EU";
        } else {
            return "NOT_EU";
        }
    }
}
