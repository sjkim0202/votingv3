package com.example.votingv3.service;

import com.example.votingv3.dto.LoginRequest;
import com.example.votingv3.dto.LoginResponse;

/**
 * 로그인 처리를 위한 서비스 인터페이스
 */
public interface AuthService {
    LoginResponse login(LoginRequest request);  // 로그인 요청 처리
}
