package com.agasa.xd_f371_v0_0_1.service;

import com.agasa.xd_f371_v0_0_1.dto.ImportDto;

import java.util.List;

public interface ImportService {
    List<ImportDto> getAll();
    ImportDto create(ImportDto importDto);
    ImportDto update(ImportDto importDto);
    boolean delete_f(String so);
}
