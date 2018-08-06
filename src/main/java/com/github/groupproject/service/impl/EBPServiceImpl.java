package com.github.groupproject.service.impl;

import com.github.groupproject.dto.EBPDto;
import com.github.groupproject.entities.EBP;
import com.github.groupproject.repository.BonusRepository;
import com.github.groupproject.repository.ClientRepository;
import com.github.groupproject.repository.EBPRepository;
import com.github.groupproject.repository.EmployeeRepository;
import com.github.groupproject.service.EBPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EBPServiceImpl implements EBPService {

    Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private EBPRepository ebpRepository;
    private BonusRepository bonusRepository;
    private EmployeeRepository employeeRepository;
    private ClientRepository clientRepository;

    @Autowired
    public EBPServiceImpl(EBPRepository ebpRepository, BonusRepository bonusRepository,
                          EmployeeRepository employeeRepository, ClientRepository clientRepository) {
        this.ebpRepository = ebpRepository;
        this.bonusRepository = bonusRepository;
        this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public String create(String bonusUuid, String employeeUuid, String clientUuid) {
        LOG.info("Created EBP : [employeeUuid]: " + clientUuid + "[bonusUuid]: "
                + bonusUuid + "[clientUuid]: " + clientUuid);
    EBP ebp = new EBP();
        ebp.setBonus(bonusRepository.findOneByUuid(bonusUuid));
        ebp.setEmployee(employeeRepository.findOneByUuid(employeeUuid));
        ebp.setClient(clientRepository.findOneByUuid(clientUuid));
        ebpRepository.save(ebp);
        return ebp.getUuid();
}

    @Override
    public Set<EBPDto> findAll() {
        return ebpRepository.findAllBy().stream()
                .map(EBPDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<EBPDto> findAllByClientUserUuid(String userUuid) {
        return ebpRepository.findAllByClientUserUuid(userUuid).stream()
                .map(EBPDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<EBPDto> findAllByEmployeeUuid(String employeeUuid) {
        return ebpRepository.findAllByEmployeeUuid(employeeUuid).stream()
                .map(EBPDto::new)
                .collect(Collectors.toSet());
    }
}
