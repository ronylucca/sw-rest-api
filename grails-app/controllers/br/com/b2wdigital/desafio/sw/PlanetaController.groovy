package br.com.b2wdigital.desafio.sw

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlanetaController {
    def planetaService

    static responseFormats = ['json']
    static allowedMethods = [show:"GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Planeta.list(params), [status: OK]
    }

    @Transactional
    def show(Long id) {
        Planeta planeta = Planeta.findById(id)
        if (planeta != null){
            def filmesRelacionados = planetaService.getPlanetDetailSW( planeta.nome )
            if (filmesRelacionados) {
                planeta.getFilmesRelacionados().addAll(filmesRelacionados)
            }
            respond planeta.properties, [status: OK]
        }else{
            render status: NO_CONTENT
        }
    }

    private getIncludeFields() {
        Planeta.getDeclaredFields()
    }


    @Transactional
    def save(Planeta planetaInstance) {
        if (planetaInstance == null) {
            render status: NOT_FOUND
            return
        }

        planetaInstance.validate()
        if (planetaInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        planetaInstance.save flush: true
        respond planetaInstance, [status: CREATED]
    }

    @Transactional
    def update(Planeta planetaInstance) {
        if (planetaInstance == null) {
            render status: NOT_FOUND
            return
        }

        planetaInstance.validate()
        if (planetaInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        planetaInstance.save flush: true
        respond planetaInstance, [status: OK]
    }

    @Transactional
    def delete(Planeta planetaInstance) {

        if (planetaInstance == null) {
            render status: NOT_FOUND
            return
        }

        planetaInstance.delete flush: true
        render status: NO_CONTENT
    }
}
