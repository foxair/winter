<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

<#include "/java_imports.include">

import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseEntityDao<${className},${table.idColumn.javaType}> implements ${className}Dao{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "${basepackage}.model.${className}";
	}
	
	public void saveOrUpdate(${className} ${classNameLower}) {
		if(${classNameLower}.get${table.idColumn.columnName}() == null) 
			save(${classNameLower});
		else 
			update(${classNameLower});
	}
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
		return (${className})getSqlSessionTemplate().selectOne(getMybatisMapperNamesapce()+".getBy${column.columnName}",${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public int deleteBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}){
		return getSqlSessionTemplate().delete(getMybatisMapperNamesapce()+".deleteBy${column.columnName}",${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
}
