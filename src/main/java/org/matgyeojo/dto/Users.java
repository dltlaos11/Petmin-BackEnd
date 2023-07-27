package org.matgyeojo.dto;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERS")
@Entity

public class Users {
  
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)//auto 인데 테이블별로 따로
	private int userId;//유저아이디
	
	@Column(nullable = false)
	private String userPass; //유저 비밀번호
	@Column(nullable = true)
	private String userName;//유저이름
	@Column(nullable = true)
	private int userAge;//유저나이
	@Column(nullable = true)
	private String userAddress;//유저주소
	@Column(nullable = true)
	private String userSex;//유저성별
	@Column(nullable = true,unique = true)
	private String userCard;//유저카드번호
	@Column(nullable = true)
	private int userCardpass;//유저카드비밀번호
	@Column(nullable = false)
	private String userLicence;
	@UpdateTimestamp
	private Timestamp userUpdateTime;//유저마지막업데이트날짜
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private PetsitterProfile petsitterProfile;
}
