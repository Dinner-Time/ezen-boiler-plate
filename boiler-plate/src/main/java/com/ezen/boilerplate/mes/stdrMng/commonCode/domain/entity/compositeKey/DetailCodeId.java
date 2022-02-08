package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DetailCodeId implements Serializable {
    @Column(name = "CODE_ID", length = 6)
    private String codeId;

    private String masterCodeId;
}
