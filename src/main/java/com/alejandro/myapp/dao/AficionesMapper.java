package com.alejandro.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.alejandro.myapp.entity.Aficiones;


public interface AficionesMapper {
	
	@Select("select * from aficiones")
	List<Aficiones> getAll();
	
	@Select("select * from aficiones where id = #{id}")
	Aficiones getAficion(int id);
	
	@Select("select * from aficiones where nombre = #{nombre}")
	Aficiones getAficionString(String nombre);

    @Insert("insert into aficiones(nombre) values(#{nombre})")
    @SelectKey( statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    void insert(Aficiones aficiones);

}
