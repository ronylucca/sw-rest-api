<%@ page import="br.com.b2wdigital.desafio.sw.Planeta" %>



<div class="fieldcontain ${hasErrors(bean: planetaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="planeta.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${planetaInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: planetaInstance, field: 'clima', 'error')} required">
	<label for="clima">
		<g:message code="planeta.clima.label" default="Clima" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="clima" required="" value="${planetaInstance?.clima}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: planetaInstance, field: 'terreno', 'error')} required">
	<label for="terreno">
		<g:message code="planeta.terreno.label" default="Terreno" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="terreno" required="" value="${planetaInstance?.terreno}"/>

</div>

