package com.example.teamB.domain.member.service.command;
import com.example.teamB.domain.member.entity.Member;
import jakarta.mail.MessagingException;

import com.example.teamB.domain.member.dto.MemberRequestDTO;
import com.example.teamB.domain.member.dto.MemberResponseDTO;

public interface MemberCommandService {
    void signupRequestAndVerifyEmail(MemberRequestDTO.SignupRequestAndVerifyEmailDTO dto) throws MessagingException; // 회원가입 요청 및 인증메일 전송
    void verifyCode(String email, String verificationCode); // 인증 코드 검증
    MemberResponseDTO.MemberTokenDTO signup(MemberRequestDTO.SignupDTO dto); // 회원가입 완료
    MemberResponseDTO.MemberTokenDTO login(MemberRequestDTO.MemberLoginDTO dto); // 로그인
    MemberResponseDTO.MemberTokenDTO refreshToken(String refreshToken); // 토큰 재발급
    void withdraw(Member member); // 탈퇴
    void requestPasswordChange(Member member) throws MessagingException; // 비밀번호 변경 요청
    void verifyPasswordChangeCode(Member member, String verificationCode); // 비밀번호 변경 인증 코드 검증
    void completePasswordChange(Member member, String newPassword); // 비밀번호 변경 완료
    void changeNickname(Member member, String newNickname); // 닉네임 변경
    void changeAlarmSettings(Member member, Boolean alarmStatus, String alarmTime); // 알람 설정 변경

}
