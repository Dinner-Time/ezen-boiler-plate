package com.ezen.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * spring boot application
 * 
 * @author 박태훈
 * @since 2022.01.25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022.01.25	박태훈	    최초생성
 *  2022.02.08  박태훈      BaseTimeEntity를 사용하기 위한 @EnableJpaAuditing 추가
 *
 *      </pre>
 */
@SpringBootApplication
@EnableJpaAuditing
public class BoilerPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoilerPlateApplication.class, args);
	}

}
