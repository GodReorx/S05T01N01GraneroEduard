package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.services;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain.Office;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeServicesImpl implements OfficeService{
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public OfficeDTO addOffice(Office office) {
        return convertToDTO(officeRepository.save(office));
    }

    @Override
    public OfficeDTO updateOffice(Office office) {
        Optional<Office> officeDb = officeRepository.findById(office.getPk_OfficeID());
        if(officeDb.isPresent()){
            Office officeUpdate = officeDb.get();
            officeUpdate.setPk_OfficeID(office.getPk_OfficeID());
            officeUpdate.setNameOffice(office.getNameOffice());
            officeUpdate.setCountryOffice(office.getCountryOffice());
            return convertToDTO(officeRepository.save(officeUpdate));
        } else {
            throw new RuntimeException("Record not found with ID: " + office.getPk_OfficeID());
        }
    }

    @Override
    public boolean deleteOffice(Integer id) {
        Optional<Office> officeDb = officeRepository.findById(id);
        if (officeDb.isPresent()){
            officeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OfficeDTO getOneOffice(Integer id) {
        Optional<Office> officeDb = officeRepository.findById(id);
        if (officeDb.isPresent()){
            return convertToDTO(officeDb.get());
        } else {
            throw new RuntimeException("Record not found with ID: " + id);
        }
    }

    @Override
    public List<OfficeDTO> getAllOffice() {
        List<Office> officeList = officeRepository.findAll();
        List<OfficeDTO> officeDTOList = officeList.stream().map(office -> convertToDTO(office)).collect(Collectors.toList());
        return officeDTOList;
    }

    private OfficeDTO convertToDTO(Office office){
        return new OfficeDTO(office.getPk_OfficeID(), office.getNameOffice(), office.getCountryOffice());
    }
}
