package com.example.cloud.service;

import com.example.cloud.dto.TransportDto;
import com.example.cloud.dto.TransportResult;
import com.example.cloud.models.Transport;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface TransportService {
    List<TransportDto> getTransports();
    TransportResult getTransports(Integer page);

    TransportDto getConcreteTransport(Long transportId);

    List<TransportDto> search(String name);
    List<Transport> searchTrans(String name);



}
