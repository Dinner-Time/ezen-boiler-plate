package com.ezen.boilerplate.mes.stdrMng.commonCode.service;

import java.util.List;
import java.util.Optional;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.CodeGroup;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.compositeKey.DetailCodeId;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.CodeGroupRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.DetailCodeRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository.MasterCodeRepository;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.request.SaveCodeDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonCodeRequest {

    private final CodeGroupRepository codeCategoryRepository;
    private final MasterCodeRepository masterCodeRepository;
    private final DetailCodeRepository detailCodeRepository;

    public String saveCategory(SaveCodeDTO dto) {
        CodeGroup category = CodeGroup.builder() //
                .codeId(dto.getCodeId()) //
                .codeNm(dto.getCodeNm()) //
                .codeDesc(dto.getCodeDesc()) //
                .isEnabled(dto.getIsEnabled()) //
                .build();
        codeCategoryRepository.save(category);

        return category.getCodeId();
    }

    /**
     * 
     */
    public String saveMaster(SaveCodeDTO dto) {
        Optional<CodeGroup> category = codeCategoryRepository.findById(dto.getParentCode());

        if (!category.isPresent()) {
            return null;
        }

        MasterCode masterCode = MasterCode.builder() //
                .codeId(dto.getCodeId()) //
                .codeNm(dto.getCodeNm()) //
                .codeDesc(dto.getCodeDesc()) //
                .codeGroup(category.get()) //
                .isEnabled(dto.getIsEnabled()) //
                .build();
        masterCodeRepository.save(masterCode);

        return masterCode.getCodeId();
    }

    /**
     * 
     */
    public String saveDetail(List<SaveCodeDTO> dtoList) {

        for (SaveCodeDTO dto : dtoList) {
            System.out.println(dto.getParentCode());
            Optional<MasterCode> masterCode = masterCodeRepository.findById(dto.getParentCode());

            if (!masterCode.isPresent()) {
                return null;
            }

            DetailCode detailCode = DetailCode.builder() //
                    .id(new DetailCodeId(dto.getCodeId(), dto.getParentCode())) //
                    .codeNm(dto.getCodeNm()) //
                    .codeDesc(dto.getCodeDesc()) //
                    .masterCode(masterCode.get()) //
                    .isEnabled(dto.getIsEnabled()) //
                    .build();
            detailCodeRepository.save(detailCode);
        }

        return "success";
    }
}
