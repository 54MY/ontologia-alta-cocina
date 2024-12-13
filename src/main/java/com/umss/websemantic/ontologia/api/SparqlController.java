package com.umss.websemantic.ontologia.api;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/sparql")
public class SparqlController {

    private static final Logger logger = Logger.getLogger(SparqlController.class.getName());
    private Model model;

    public SparqlController() {
        // Cargar la ontología desde un archivo OWL o RDF
        model = ModelFactory.createDefaultModel();
        try {
            model.read(new File("src/main/resources/practica.rdf").getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar la ontología: " + e.getMessage());
        }
    }

    // Mapeo de términos en lenguaje natural a conceptos en la ontología
    private final Map<String, String> termMappings = new HashMap<>();

    {
        termMappings.put("carne", "<http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Carne>");
        termMappings.put("vegetariano", "<http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Vegetariano>");
        termMappings.put("platillos", "<http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Platillo>");
        termMappings.put("reservas", "<http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Reserva>");
        termMappings.put("cocineros", "<http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Cocinero>");
        termMappings.put("primer procedimiento", "");
        termMappings.put("platillo tres", "");
    }

    @PostMapping("/natural-query")
    public String executeNaturalLanguageQuery(@RequestBody String naturalQuery) {
        logger.info("Consulta SPARQL generada: " + naturalQuery);
        String sparqlQuery = convertNaturalToSparql(naturalQuery);

        if (sparqlQuery == null) {
            return "Consulta no reconocida. Intenta con términos como 'dame el platillo tres', 'primero procedimiento de coccion', o 'platillos'.";
        }

        // Registro de la consulta para depuración
        logger.info("Consulta SPARQL generada: " + sparqlQuery);

        // Ejecutar la consulta generada
        return executeQuery(sparqlQuery);
    }

    private String convertNaturalToSparql(String naturalQuery) {
        // Normalizar entrada: convertir a minúsculas y eliminar espacios extra
        naturalQuery = naturalQuery.trim().toLowerCase();
    
        logger.info("convertNaturalToSparql: " + naturalQuery);
    
        // Consultas específicas basadas en términos y mapa
        if (naturalQuery.contains("platillos que tienen carne")) {
            return "SELECT ?platillo WHERE { ?platillo <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/ingrediente> " + termMappings.get("carne") + " . }";
        }
        if (naturalQuery.contains("platillos vegetarianos")) {
            return "SELECT ?platillo WHERE { ?platillo <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/ingrediente> " + termMappings.get("vegetariano") + " . }";
        }
        if (naturalQuery.contains("platillos")) {
            return "SELECT ?platillo WHERE { ?platillo a " + termMappings.get("platillos") + " . }";
        }
        if (naturalQuery.contains("reservas")) {
            return "SELECT ?reserva WHERE { ?reserva a " + termMappings.get("reservas") + " . }";
        }
        if (naturalQuery.contains("cocineros")) {
            return "SELECT ?cocinero WHERE { ?cocinero a " + termMappings.get("cocineros") + " . }";
        }
        if (naturalQuery.contains("primer procedimiento")) {
            return "PREFIX ex: <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11#> SELECT ?property ?value WHERE { ex:Procedimiento2 ?property ?value . }";
        }
        if (naturalQuery.contains("platillo tres")) {
            return "PREFIX ex: <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11#> SELECT ?property ?value WHERE { ex:Platillo3 ?property ?value }";
        }
    
        // Si no se encuentra mapeo, devolver mensaje de error
        return null;
    }

    @PostMapping("/query")
    public String executeQuery(@RequestBody String sparqlQuery) {
        logger.info("Ejecutando consulta SPARQL: " + sparqlQuery);
        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecution qe = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qe.execSelect();
            return ResultSetFormatter.asText(results);
        } catch (Exception e) {
            logger.severe("Error al ejecutar la consulta SPARQL: " + e.getMessage());
            return "Error al ejecutar la consulta: " + e.getMessage();
        }
    }
}
