<#import "_layout.ftl" as layout />
<@layout.header>
	<div>
		<h3>Find a repository</h3>
		<p>
			Invalid name of repository. Make sure that the repository is public.
		</p>
		<form action="/" method="post">
			<p>
				<input type="text" name="reponame">
			</p>
			<p>
				<input type="submit">
			</p>
		</form>
	</div>
</@layout.header>