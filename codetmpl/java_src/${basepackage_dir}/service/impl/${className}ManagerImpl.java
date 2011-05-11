<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Manager;

<#include "/java_imports.include">

@Service("${classNameLower}Manager")
@Transactional
public class ${className}ManagerImpl extends BaseManager<${className},${table.idColumn.javaType}> implements ${className}Manager{

	private ${className}Dao ${classNameLower}Dao;
	
	@Resource
	public void set${className}Dao(${className}Dao dao) {
		this.${classNameLower}Dao = dao;
	}
	
	public ${className}Dao getEntityDao() {
		return this.${classNameLower}Dao;
	}
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public int deleteBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}){
		return ${classNameLower}Dao.deleteBy${column.columnName}(${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
		return ${classNameLower}Dao.getBy${column.columnName}(${column.columnNameFirstLower});
	}
	
	</#if>
	</#list>
}
