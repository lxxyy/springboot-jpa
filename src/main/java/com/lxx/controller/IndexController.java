package com.lxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxx.entity.UserEntity;
import com.lxx.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class IndexController {

	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/index")
	public String index(Integer id){
		UserEntity userEntity = repository.findOne(id);

		System.out.println("1111");
		System.out.println("222");
		return userEntity.toString();
	}


	@RequestMapping("/findbyName")
	public String findbyName(String name){
//		List<UserEntity> UserEntitys = repository.findByNameLike("%"+name+"%");
		List<UserEntity> UserEntitys = repository.findByNameLike(name);
		UserEntitys.stream().forEach(user->{
			System.out.println("id:"+user.getId()+"  name:"+user.getName()+"  age:"+user.getAge());
		});
		System.out.println(UserEntitys.toString());
		UserEntitys.stream().filter(s->s.getAge()>13).sorted(Comparator.comparing(UserEntity::getAge).reversed()).collect(Collectors.toList());
		IntStream.rangeClosed(1, 90).map(s->s*s).forEach(S-> System.out.println(S+""));
		System.out.println();
		return UserEntitys.toString();
	}
}
