#### Superclases

PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

SELECT ?class ?superclass
WHERE {
  ?class rdfs:subClassOf ?superclass .
}

## individuals

PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

SELECT ?individual ?class
WHERE {
  ?individual rdf:type ?class .
}

####

PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

SELECT ?individual ?class
WHERE {
  ?individual rdf:type ?class .
}

####      

SELECT ?platillo WHERE { 
    ?platillo <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/ingrediente> 
    <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Vegetariano> . 
}

####

SELECT ?reserva WHERE { 
    ?reserva a <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Reserva> . 
}

####

SELECT ?platillo WHERE { 
    ?platillo <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/ingrediente>  
    <http://www.semanticweb.org/fernando/ontologies/2024/11/untitled-ontology-11/Platillo>  . 
}