package br.com.b2wdigital.desafio.sw

import groovyx.gpars.dataflow.Dataflow

class Planeta {

    String nome
    String clima
    String terreno
    def filmesRelacionados = new ArrayList<String>()


    static constraints = {
        nome(nullable: false, blank: false, unique: true)

    }

    static mapping = {
        filmesRelacionados lazy:false
        version false
        table 'TB_PLANETA'
        id column: "ID"
        nome column: "NOME"
        clima column: "CLIMA"
        terreno column: "TERRENO"
    }


    @Override
    public String toString() {
        return "Planeta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", clima='" + clima + '\'' +
                ", terreno='" + terreno + '\'' +
                ", filmesRelacionados=" + filmesRelacionados +
                '}';
    }
}
