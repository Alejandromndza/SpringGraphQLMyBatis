package com.alejandro.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.alejandro.myapp.entity.Aficiones;
import com.alejandro.myapp.entity.Marca;
import com.alejandro.myapp.entity.Persona;


public interface PersonaMapper {
			
	@Select("select m.id, m.nombre from marca m, usuarios e where e.id =#{id} and m.id = e.idMarca")
	Marca getMarca(int id);
	
	@Select("select * from usuarios")
	List<Persona> getAll();
	
	@Select("select * from aficiones a, aficcionesusuarios u where u.idUsuario = #{id} and u.idAficiones = a.id")
	 List<Aficiones> getAficiones(int id);
	
	@Select("select * from usuarios where id = #{id}")
	Persona getPersona(int id);
	
	@Select("select * from usuarios where nombre = #{nombre}")
	Persona getPersonaString(String nombre);
	
    @Insert("insert into usuarios(nombre,salario,idMarca) values(#{nombre},#{salario}, #{marca.id})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",  before = true, resultType = Integer.class)
    void insert(Persona persona);
    
    @Update("update users set salario=#{salario} where nombre=#{nombre}")
    void updatePersona(Persona persona);

    @Delete("delete from usuarios where id = #{id}")
    void delete(int id);

}
