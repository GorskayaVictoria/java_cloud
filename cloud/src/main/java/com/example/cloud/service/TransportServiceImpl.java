package com.example.cloud.service;

import com.example.cloud.dto.TransportDto;
import com.example.cloud.dto.TransportResult;
import com.example.cloud.models.Transport;
import com.example.cloud.models.Type;
import com.example.cloud.repository.TransportsRepository;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.example.cloud.dto.TransportDto.from;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;



@Service
public class TransportServiceImpl implements TransportService {


    @Autowired
    private TransportsRepository transportsRepository;

    @Override
    public List<TransportDto> getTransports() {
        return from(transportsRepository.findAll());
    }

    @Override
    public TransportResult getTransports(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 3);
        Page<Transport> pageResult = transportsRepository.findAll(pageRequest);
        return TransportResult.builder()
                .transports(from(pageResult.getContent()))
                .count(pageResult.getTotalPages())
                .build();
    }


    @Override
    public TransportDto getConcreteTransport(Long transportId) {
        Transport transport = transportsRepository.getOne(transportId);
        return from(transport);
    }

    @Override
    public List<TransportDto> search(String name) {
        return from(transportsRepository.findAllByNameContainsIgnoreCase(name));
    }

    @Override
    public List<Transport> searchTrans(String name) {
        return transportsRepository.searchTrans(name);
    }



}
