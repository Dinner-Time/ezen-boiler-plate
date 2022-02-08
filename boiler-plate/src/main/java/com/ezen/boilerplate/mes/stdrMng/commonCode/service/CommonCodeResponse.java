package com.ezen.boilerplate.mes.stdrMng.commonCode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.CodeGroup;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.CodeGroupRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.DetailCodeRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.MasterCodeRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.CodeGroupListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.DetailCodeListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.MasterCodeListDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommonCodeResponse {

    private final CodeGroupRepository codeGroupRepository;
    private final MasterCodeRepository masterCodeRepository;
    private final DetailCodeRepository detailCodeRepository;

    public List<CodeGroupListDTO> codeGroupList() {

        List<CodeGroupListDTO> result = new ArrayList<CodeGroupListDTO>();

        List<CodeGroup> entities = codeGroupRepository.findByIsEnabledOrderByCreatedTime(1);

        if (entities.size() == 0) {
            return result;
        }

        for (CodeGroup entity : entities) {
            result.add(new CodeGroupListDTO(entity));
        }

        return result;
    }

    public List<MasterCodeListDTO> masterCodeListByGroup(String group) {
        List<MasterCodeListDTO> result = new ArrayList<MasterCodeListDTO>();

        Optional<CodeGroup> codeGroup = codeGroupRepository.findById(group);

        if (!codeGroup.isPresent()) {
            return result;
        }

        List<MasterCode> entities = masterCodeRepository.findByCodeGroup(codeGroup.get());

        if (entities.size() == 0) {
            return result;
        }

        for (MasterCode entity : entities) {
            result.add(new MasterCodeListDTO(entity));
        }

        return result;
    }

    public List<DetailCodeListDTO> detailCodeListByMasterCode(String masterCodeId) {
        List<DetailCodeListDTO> result = new ArrayList<DetailCodeListDTO>();

        Optional<MasterCode> masterCode = masterCodeRepository.findById(masterCodeId);

        if (!masterCode.isPresent()) {
            return result;
        }

        List<DetailCode> entities = detailCodeRepository.findByMasterCode(masterCode.get());

        if (entities.size() == 0) {
            return result;
        }

        for (DetailCode entity : entities) {
            result.add(new DetailCodeListDTO(entity));
        }

        return result;
    }
}
