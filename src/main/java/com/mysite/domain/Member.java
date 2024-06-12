package com.mysite.domain;

import lombok.Data;

@Data
public class Member {
	private int num;
	private String name;
	private String addr;
	
}

// 이클립스에서 생성자, getter, setter 을 만들지 않기 위해 롬복을 설치한것 ! 
// @Getter, @Setter, @RequiredArgsConstructor 을 한번에 만드는 어노테이션 --> @Data