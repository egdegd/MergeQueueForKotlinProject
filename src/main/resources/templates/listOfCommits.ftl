<#-- @ftlvariable name="commitsList" type="kotlin.collections.List<kotlin.Triple<String, com.example.GitUser, String>>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list commitsList as commit>
		<div>
			<p style="color: #d35e06;">
				commit ${commit.third}
			</p>
			<p>
				Author: ${commit.second.name} ${commit.second.email}
			</p>
			<p>
				Date: ${commit.second.date}
			</p>
			<p>
				${commit.first}
			</p>
		</div>
		<hr>
    </#list>
	<hr>
</@layout.header>