package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class OfficeDTO {
    private Integer pk_OfficeID;
    @NotEmpty(message = "The name cannot be empty")
    private String nameOffice;
    @NotEmpty(message = "The country cannot be empty")
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

    public static String checkCountryUE(String countryOffice) {
        for (CountryEU country : CountryEU.values()) {
            if (countryOffice.equalsIgnoreCase(country.name())) {
                return "EU";
            }
        }
        return "NOT_EU";
    }
}
