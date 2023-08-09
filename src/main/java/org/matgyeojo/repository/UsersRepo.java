package org.matgyeojo.repository;

import java.util.List;
import java.util.Optional;

import org.matgyeojo.dto.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<Users, String> {

	boolean existsByUserId(String userId);

	// 유저 성별 나이 주소 필터링
	public List<Users> findByUserSexAndUserAgeGreaterThanEqualAndUserAddressContaining(String userSex, int userAge,
			String userAddress);

	//모든 유저 가져오기
	@Query(value = "select user_id from users order by user_update_time desc limit 20", nativeQuery = true)
	public List<String> findUserAll();
	
	Optional<Users> findById(String userId);

}
