package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.services;


import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain.Office;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto.OfficeDTO;

import java.util.List;

public interface OfficeService {

    OfficeDTO addOffice(Office office);

    OfficeDTO updateOffice(Office office);

    boolean deleteOffice(Integer id);

    OfficeDTO getOneOfficeDTO(Integer id);

    Office getOneOffice(Integer id);

    List<OfficeDTO> getAllOffice();
}
