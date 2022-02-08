package com.ezen.boilerplate.common.user.service;

import com.ezen.boilerplate.common.user.domain.User;
import com.ezen.boilerplate.common.user.domain.UserRepository;
import com.ezen.boilerplate.common.user.service.DTO.response.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 사용자 정보 조회 service
 *
 * @author 박태훈
 * @since 2022-01-25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일	    수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-01-25  박태훈      최초 생성
 *  2022-02-08  박태훈      회원가입 DTO 적용
 *
 *
 *      </pre>
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserResponseService implements UserDetailsService {

    /**
     * spring security로 로그인 기능을 위해 UserDetailsService 구현
     */

    // 생성자 의존성 주입(자세한 내용은 MainController 참고)
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId);
        return new LoginDTO(user);
    }
}
