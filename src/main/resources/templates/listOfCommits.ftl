<#-- @ftlvariable name="commitsList" type="kotlin.collections.List<kotlin.Pair<String, com.example.GitUser>>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list commitsList as commit>
		<div>
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
    </#list>
	<hr>
</@layout.header>