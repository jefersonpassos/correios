<header>
	<div class="container">
			<h1 class="logo"><a href="${pageContext.request.contextPath}/home.jsp">Astec</a></h1>
			<nav>
				<ul>
					<li><i class="fas fa-user-circle"></i>
                                        ${sessionScope.usuario.getNome()}</li>
					<li><i class="fas fa-bars"></i></li>
				</ul>
			</nav>
	</div>
</header>