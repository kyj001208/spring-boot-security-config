package com.green.nowon.security;

import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.green.nowon.domain.entity.MemberEntity;

import lombok.Getter;

@Getter //principal 객체에서 확인 가능 
public class CustomUserDetails extends User{

	private static final long serialVersionUID = 1L;
	
	//principal 에서 확인하기 위해 추가로 등록 가능(선택 사항)
	private String email; //username과 동일 
	private String name;
	

	public CustomUserDetails(MemberEntity entity){
		super(entity.getEmail(),entity.getPass(),
				entity.getRoles().stream()
				.map(role->new SimpleGrantedAuthority("ROLE_"+role))
				.collect(Collectors.toSet()));
		
		
		email=entity.getEmail();
		name=entity.getName();
	
	}
	
}