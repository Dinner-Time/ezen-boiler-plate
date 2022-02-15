package com.ezen.boilerplate.mes.standard.commonCode.service;

import java.util.List;

import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.CodeGroup;
import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.MasterCode;
import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.compositeKey.DetailCodeId;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.CodeGroupRepository;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.DetailCodeRepository;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.MasterCodeRepository;
import com.ezen.boilerplate.mes.standard.commonCode.service.DTO.request.SaveCodeDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Code 저장, 수정, 삭제 service
 * 
 * @author 박태훈
 * @since 2022-02-08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-08  박태훈      최초 생성
 *
 *      </pre>
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CommonCodeRequest {

    private final CodeGroupRepository codeCategoryRepository;
    private final MasterCodeRepository masterCodeRepository;
    private final DetailCodeRepository detailCodeRepository;

    private final int SUCCESS = 1;
    private final int FAIL = 0;

    /**
     * CodeGroup 저장
     */
    public int saveCodeGroup(SaveCodeDTO dto) {

        CodeGroup category = CodeGroup.builder() //
                .codeId(dto.getCodeId()) //
                .codeNm(dto.getCodeNm()) //
                .codeDesc(dto.getCodeDesc()) //
                .useYn(dto.getIsEnabled()) //
                .build();
        codeCategoryRepository.save(category);

        return SUCCESS;
    }

    /**
     * 
     */
    public int saveMaster(SaveCodeDTO dto) {

        MasterCode masterCode = MasterCode.builder() //
                .codeId(dto.getCodeId()) //
                .codeNm(dto.getCodeNm()) //
                .codeDesc(dto.getCodeDesc()) //
                .codeGroup(dto.getParentCode()) //
                .isEnabled(dto.getIsEnabled()) //
                .build();
        masterCodeRepository.save(masterCode);

        return SUCCESS;
    }

    /**
     * 
     */
    public int saveDetail(List<SaveCodeDTO> dtoList) {

        for (SaveCodeDTO dto : dtoList) {

            DetailCode detailCode = DetailCode.builder() //
                    .id(new DetailCodeId(dto.getCodeId(), dto.getParentCode())) //
                    .codeNm(dto.getCodeNm()) //
                    .codeDesc(dto.getCodeDesc()) //
                    .isEnabled(dto.getIsEnabled()) //
                    .build();
            detailCodeRepository.save(detailCode);
        }

        return SUCCESS;
    }
}
