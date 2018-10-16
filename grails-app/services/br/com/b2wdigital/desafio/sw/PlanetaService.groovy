package br.com.b2wdigital.desafio.sw

import com.google.gson.JsonObject
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.transaction.Transactional
import groovy.json.JsonBuilder
import org.grails.datastore.gorm.finders.MethodExpression
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus

import java.lang.reflect.Array

@Transactional
class PlanetaService {


    @Value('${starwars.api.uri.search}')
    String SW_API
    def rest

    def PlanetaService(){

        rest = new RestBuilder(connectTimeout:2000, readTimeout:5000)
    }


    def getPlanetDetailSW( String planetName ) {

        def relatedFilms = getPlanetInfoSWAPI( planetName )
        return getRelatedMoviesByPlanet( relatedFilms )

    }


    def getPlanetInfoSWAPI(String name){

        try{
            String query = (SW_API + name)

            def planetsData = rest.get(query){
                headers.'User-Agent'= 'Mozilla/5.0'
                accept "application/json"
                contentType "application/json"
            }

            if (planetsData.status.toInteger() == HttpStatus.OK.value()) {
                return planetsData.json.results.films[0]


            }else{
                log.info("Falha ao obter informacoes do planeta: ${planetsData.error.toString()}")
            }
        }catch (Exception e){
            log.info("Falha ao obter informacoes do planeta: ${e.getMessage()}")
        }

    }

    def getRelatedMoviesByPlanet( def moviesUris ) {


            def moviesTitles = []
            moviesUris.each { movieURI ->
            try {

                def movieData = rest.get(movieURI) {
                    headers.'User-Agent' = 'Mozilla/5.0'
                    accept "application/json"
                    contentType "application/json"
                }
                print movieData
                if (movieData.status.toInteger() == HttpStatus.OK.value()) {
                    moviesTitles << movieData.json.title
                } else {
                    log.info("Falha ao obter informacoes do filme: ${movieData.error.toString()}")
                }
            } catch (Exception er ) {
                log.info("Falha ao obter informacoes do filme: ${er.getMessage()}")
            }

                }

        return moviesTitles
    }

}


