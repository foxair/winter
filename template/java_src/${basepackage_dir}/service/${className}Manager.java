<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;

<#include "/java_imports.include">

public interface ${className}Manager extends Manager<${className},${table.idColumn.javaType}> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void set${className}Dao(${className}Dao dao);

	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower});
	
	</#if>
	</#list>	
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public int deleteBy${column.columnName}(${column.javaType} ${column.columnNameFirstLower});
	
	</#if>
	</#list>
}
