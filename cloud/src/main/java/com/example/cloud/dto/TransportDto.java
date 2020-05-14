package com.example.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.cloud.models.Transport;
import com.example.cloud.models.Type;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransportDto {
    private Long id;
    private String name;
    private String city;
    private String info;
    private Integer year;
    private Type type;
    private String filePath;

    public static TransportDto from(Transport transport) {
        return TransportDto.builder()
                .id(transport.getId())
                .name(transport.getName())
                .info(transport.getInfo())
                .year(transport.getYear())
                .type(transport.getType())
                .city(transport.getCity())
                .filePath(transport.getFilePath())
                .build();
    }

    public static List<TransportDto> from(List<Transport> transports) {
        return transports.stream()
                .map(TransportDto::from)
                .collect(Collectors.toList());
    }


}
