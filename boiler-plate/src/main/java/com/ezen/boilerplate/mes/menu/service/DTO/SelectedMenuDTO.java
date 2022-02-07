package com.ezen.boilerplate.mes.menu.service.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SelectedMenuDTO {

    private String parentMenu;
    private String childMenu;
}
