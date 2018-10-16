package br.com.b2wdigital.desafio.sw


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlanetaViewsController {

    def planetaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Planeta.list(params), model: [planetaInstanceCount: Planeta.count()]
    }

    def show(Planeta planetaInstance) {
        def filmesRelacionados = planetaService.getPlanetDetailSW( planetaInstance.nome )
        if (filmesRelacionados) {
            filmesRelacionados.each { filme ->
                planetaInstance.filmesRelacionados.add(filme)
            }
        }
        respond planetaInstance
    }

    def create() {
        respond new Planeta(params)
    }

    @Transactional
    def save(Planeta planetaInstance) {
        if (planetaInstance == null) {
            notFound()
            return
        }

        if (planetaInstance.hasErrors()) {
            respond planetaInstance.errors, view: 'create'
            return
        }

        planetaInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'planeta.label', default: 'Planeta'), planetaInstance.id])
                redirect planetaInstance
            }
            '*' { respond planetaInstance, [status: CREATED] }
        }
    }

    def edit(Planeta planetaInstance) {
        respond planetaInstance
    }

    @Transactional
    def update(Planeta planetaInstance) {
        if (planetaInstance == null) {
            notFound()
            return
        }

        if (planetaInstance.hasErrors()) {
            respond planetaInstance.errors, view: 'edit'
            return
        }

        planetaInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Planeta.label', default: 'Planeta'), planetaInstance.id])
                redirect planetaInstance
            }
            '*' { respond planetaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Planeta planetaInstance) {

        if (planetaInstance == null) {
            notFound()
            return
        }

        planetaInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Planeta.label', default: 'Planeta'), planetaInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'planeta.label', default: 'Planeta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
