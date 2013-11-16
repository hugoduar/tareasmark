var tareas_revisar = {
    "lista_tareas":[{
            "titulo":"Tarea 1",
            "descripcion":"Hacer un algoritmo",
            "fecha":"05-09-2013",
            "nombre_alumno":"Fernando",
            "grupo":"5IV7"
    },
{
            "titulo":"Tarea 1",
            "descripcion":"Hacer un algoritmo",
            "fecha":"05-09-2013",
            "nombre_alumno":"Fernando",
            "grupo":"5IV7"
    },
{
            "titulo":"Tarea 1",
            "descripcion":"Hacer un algoritmo",
            "fecha":"05-09-2013",
            "nombre_alumno":"Fernando",
            "grupo":"5IV7"
    }]
};

var lista_tareas_revisar = tareas_revisar.lista_tareas;
var aux = {};
$(document).ready(function(){
    for(var i=0; i<lista_tareas_revisar.length; i++){
        aux = lista_tareas_revisar[i];
        var di = '#tareas_'+(i+1);
        console.log(di);
        $(di).html('<div class="tarea_revisar_titulo"></div>'+
                '<div class="tarea_revisar_nombre">'+aux.nombre_alumno+'</div>'+
                '<div class="tarea_revisar_grupo">'+aux.grupo+'</div>'+
                '<div class="tarea_revisar_desc">'+aux.descripcion+'</div>'+
                '<div class="tarea_revisar_fecha">'+aux.fecha+'</div>');
    }   
});

