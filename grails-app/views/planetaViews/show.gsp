
<%@ page import="br.com.b2wdigital.desafio.sw.Planeta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planeta.label', default: 'Planeta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-planeta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" controller="planetaViews" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" controller="planetaViews" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-planeta" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list planeta">
			
				<g:if test="${planetaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="planeta.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${planetaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planetaInstance?.clima}">
				<li class="fieldcontain">
					<span id="clima-label" class="property-label"><g:message code="planeta.clima.label" default="Clima" /></span>
					
						<span class="property-value" aria-labelledby="clima-label"><g:fieldValue bean="${planetaInstance}" field="clima"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planetaInstance?.terreno}">
				<li class="fieldcontain">
					<span id="terreno-label" class="property-label"><g:message code="planeta.terreno.label" default="Terreno" /></span>
					
						<span class="property-value" aria-labelledby="terreno-label"><g:fieldValue bean="${planetaInstance}" field="terreno"/></span>
					
				</li>
				</g:if>


                <li class="fieldcontain">
                    <span id="terreno-label" class="property-label"><g:message code="planeta.filmesRelacionados.label" default="Filmes" /></span>

                    <g:each in="${planetaInstance.filmesRelacionados}" var="filme">
                        <span class="property-value" aria-labelledby="terreno-label">${filme}</span>
                    </g:each>
                </li>

			</ol>
			<g:form url="[resource:planetaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" controller="planetaViews" action="edit" resource="${planetaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit  class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message',controllerName:'planetaViews', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
