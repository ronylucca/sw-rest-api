
<%@ page import="br.com.b2wdigital.desafio.sw.Planeta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planeta.label', default: 'Planeta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-planeta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" controller="planetaViews" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-planeta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'planeta.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="clima" title="${message(code: 'planeta.clima.label', default: 'Clima')}" />
					
						<g:sortableColumn property="terreno" title="${message(code: 'planeta.terreno.label', default: 'Terreno')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${planetaInstanceList}" status="i" var="planetaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="planetaViews" action="show" id="${planetaInstance.id}">${fieldValue(bean: planetaInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: planetaInstance, field: "clima")}</td>
					
						<td>${fieldValue(bean: planetaInstance, field: "terreno")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${planetaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
