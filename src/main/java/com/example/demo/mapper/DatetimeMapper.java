package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Datetime;

@Mapper
public interface DatetimeMapper {
	@Select("select * from datetime")
	List<Datetime> findAll();

	@Select("select * from datetime where id = #{id}")
	Datetime findOne(Long id);

	@Insert("insert into datetime (dateName, dateStandart, calulationYear, calulationMonth, calulationDay, resultDate) values (#{dateName}, #{dateStandart}, #{calulationYear}, #{calulationMonth}, #{calulationDay}, #{resultDate})")
	@Options(useGeneratedKeys = true)
	void save(Datetime datetime);

	@Update("update datetime set dateName = #{dateName}, dateStandart = #{dateStandart}, calulationYear = #{calulationYear}, calulationMonth = #{calulationMonth}, calulationDay = #{calulationDay}, resultDate = #{resultDate} where id = #{id}")
	void update(Datetime datetime);

	@Delete("delete from datetime where id = #{id}")
	void delete(Long id);
}
