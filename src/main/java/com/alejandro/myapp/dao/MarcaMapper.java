package com.alejandro.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.entity.Persona;

public interface MarcaMapper {
	
	@Select("select * from marca")
	List<Marca> getAll();
	
	@Select("select * from marca where id = #{id}")
	Marca getMarca(int id);
	
	@Select("select * from marca where nombre = #{nombre}")
	Marca getMarcaString(String nombre);

    @Insert("insert into marca(nombre) values(#{nombre})")
    @SelectKey( statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    void insert(Marca marca);
    

}
