package com.ezen.boilerplate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class IcubeTest {

    @Autowired
    EntityManager em;

    @Test
    public void test() {

        String selectQuery = """
                    select
                        matrCd = title,
                        itemNm = test
                    from
                        DZICUBE.dbo.A_test
                    where
                        title = '%s'
                """;

        JpaResultMapper jpaResultMapper = new JpaResultMapper();
        Query query = em.createNativeQuery(String.format(selectQuery, "test"));

        MatrDTO result = jpaResultMapper.uniqueResult(query, MatrDTO.class);
        System.out.println(result.toString());
    }
}
