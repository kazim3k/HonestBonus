package com.github.GroupProject.service.Impl;

import com.github.GroupProject.dto.EBPDto;
import com.github.GroupProject.entities.EBP;
import com.github.GroupProject.repository.BonusRepository;
import com.github.GroupProject.repository.ClientRepository;
import com.github.GroupProject.repository.EBPRepository;
import com.github.GroupProject.repository.EmployeeRepository;
import com.github.GroupProject.service.EBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EBPServiceImpl implements EBPService {

    private EBPRepository ebpRepository;
    private BonusRepository bonusRepository;
    private EmployeeRepository employeeRepository;
    private ClientRepository clientRepository;

    @Autowired
    public EBPServiceImpl(EBPRepository ebpRepository, BonusRepository bonusRepository, EmployeeRepository employeeRepository, ClientRepository clientRepository) {
        this.ebpRepository = ebpRepository;
        this.bonusRepository = bonusRepository;
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(String bonusUuid, String employeeUuid, String clientUuid) {
        EBP ebp = new EBP();
        ebp.setBonus(bonusRepository.findOneByUuid(bonusUuid));
        ebp.setEmployee(employeeRepository.findOneByUuid(employeeUuid));
        ebp.setClient(clientRepository.findOneByUuid(clientUuid));
        ebpRepository.save(ebp);
    }

    @Override
    public Set<EBPDto> findAll() {
        return ebpRepository.findAllBy().stream()
                .map(EBPDto::new)
                .collect(Collectors.toSet());
    }
}
