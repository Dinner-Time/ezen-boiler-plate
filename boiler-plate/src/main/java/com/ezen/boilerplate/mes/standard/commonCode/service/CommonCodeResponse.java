package com.ezen.boilerplate.mes.standard.commonCode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.CodeGroup;
import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.MasterCode;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.CodeGroupRepository;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.DetailCodeRepository;
import com.ezen.boilerplate.mes.standard.commonCode.domain.repository.MasterCodeRepository;
import com.ezen.boilerplate.mes.standard.commonCode.service.DTO.response.CodeGroupListDTO;
import com.ezen.boilerplate.mes.standard.commonCode.service.DTO.response.DetailCodeListDTO;
import com.ezen.boilerplate.mes.standard.commonCode.service.DTO.response.MasterCodeListDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Code 조회 service
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
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommonCodeResponse {

    private final CodeGroupRepository codeGroupRepository;
    private final MasterCodeRepository masterCodeRepository;
    private final DetailCodeRepository detailCodeRepository;

    /**
     * 
     * CodeGroup 조회
     */
    public List<CodeGroupListDTO> codeGroupList() {

        List<CodeGroupListDTO> result = new ArrayList<CodeGroupListDTO>();

        // DB에서 CodeGroup 조회
        List<CodeGroup> entities = codeGroupRepository.findByUseYnOrderByCreatedTime(1);

        // 조회 결과가 없을 경우 빈 List return
        if (entities.size() == 0) {
            return result;
        }

        // entity => DTO
        for (CodeGroup entity : entities) {
            result.add(new CodeGroupListDTO(entity));
        }

        return result;
    }

    /**
     * 
     * MasterCode 조회
     */
    public List<MasterCodeListDTO> masterCodeListByGroup(String group) {

        List<MasterCodeListDTO> result = new ArrayList<MasterCodeListDTO>();

        // CodeGroup 조회
        Optional<CodeGroup> codeGroup = codeGroupRepository.findById(group);

        // CodeGroup 조회 결과가 없을 경우 빈 List return
        if (!codeGroup.isPresent()) {
            return result;
        }

        // 조회한 CodeGroup으로 MasterCode조회
        List<MasterCode> entities = masterCodeRepository.findByCodeGroup(codeGroup.get());

        // MasterCode 조회 결과가 없을 경우 빈 List return
        if (entities.size() == 0) {
            return result;
        }

        // entity => DTO
        for (MasterCode entity : entities) {
            result.add(new MasterCodeListDTO(entity));
        }

        return result;
    }

    /**
     * 
     * DetailCode 조회
     */
    public List<DetailCodeListDTO> detailCodeListByMasterCode(String masterCodeId) {

        List<DetailCodeListDTO> result = new ArrayList<DetailCodeListDTO>();

        // MasterCode 조회
        Optional<MasterCode> masterCode = masterCodeRepository.findById(masterCodeId);

        // 조회한 MasterCode가 없을 경우 빈 List return
        if (!masterCode.isPresent()) {
            return result;
        }

        // 조회한 MasterCode로 DetailCode조회
        List<DetailCode> entities = detailCodeRepository.findByIdMasterCode(masterCode.get().getCodeId());

        // DetailCode 조회 결과가 없을 경우 빈 List return
        if (entities.size() == 0) {
            return result;
        }

        // entity => DTO
        for (DetailCode entity : entities) {
            result.add(new DetailCodeListDTO(entity));
        }

        return result;
    }
}
