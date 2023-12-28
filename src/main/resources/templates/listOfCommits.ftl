<#-- @ftlvariable name="commitsList" type="kotlin.collections.List<String>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list commitsList?reverse as commit>
		<div>
			<p>
                ${commit}
			</p>
		</div>
    </#list>
	<hr>
</@layout.header>