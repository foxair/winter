<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import ${import_common}.orm.mybatis.EntityDao;
import ${basepackage}.model.${className};

public interface ${className}Dao extends EntityDao<${className},${table.idColumn.javaType}>{

	public void saveOrUpdate(${className} ${classNameLower});
	
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
