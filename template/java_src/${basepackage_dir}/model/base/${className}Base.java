<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model.base;

import java.util.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Max;

import ${import_project_package}.core.text.DateFormatUtils;

import javax.persistence.*;
import javax.validation.constraints.*;

<#include "/java_imports.include">

public class ${className}Base extends BaseEntity implements java.io.Serializable{
	protected static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	public static final String FORMAT_${column.constantName} = DATE_FORMAT;
	</#if>
	</#list>
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	<#list table.columns as column>
	${column.hibernateValidatorExprssion}
	protected ${column.javaType} ${column.columnNameLower};
	</#list>
	//columns END

<@generatePropertyColumnMapper/>
<@generateColumnConst/>
<@generateJavaColumns/>

<@generateDateFields/>
<@generateDateFieldProperties/>
}

<#macro generatePropertyColumnMapper>
	public static Map<String,String> FIELD_MAP = new HashMap<String, String>();

	static{
	<#list table.columns as column>
		FIELD_MAP.put("${column.columnNameLower}", "${column.sqlName}");
	</#list>
	}
</#macro>

<#macro generateColumnConst>

<#list table.columns as column>
	public static final String ${column.getConstantName()} = "${column.columnNameLower}";
</#list>

</#macro>

<#macro generateDateFields>

<#list table.columns as column>
<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
/** ${column.columnAlias} */
protected ${column.javaType} ${column.columnNameLower}Begin;
protected ${column.javaType} ${column.columnNameLower}End;
</#if>
</#list>

</#macro>

<#macro generateDateFieldProperties>
<#list table.columns as column>
<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
public ${column.javaType} get${column.columnName}Begin() {
	return this.${column.columnNameLower}Begin;
}

public void set${column.columnName}Begin(${column.javaType} value) {
	this.${column.columnNameLower}Begin = value;
}	

public ${column.javaType} get${column.columnName}End() {
	return this.${column.columnNameLower}End;
}

public void set${column.columnName}End(${column.javaType} value) {
	this.${column.columnNameLower}End = value;
}
</#if>	
</#list>
</#macro>


<#macro generateJavaColumns>
	<#list table.columns as column>
		<#if column.isDateTimeColumn>
	public String get${column.columnName}String() {
		return DateFormatUtils.format(get${column.columnName}(), FORMAT_${column.constantName});
	}
	public void set${column.columnName}String(String value) {
		set${column.columnName}(DateFormatUtils.parse(value, FORMAT_${column.constantName},${column.javaType}.class));
	}
	
		</#if>
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	protected Set ${fkPojoClassVar}s = null;
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	protected ${fkPojoClass} ${fkPojoClassVar};
	
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>
