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
        $(di).html(
                '<div class="tarea_revisar_titulo"><h2>'+aux.titulo+'</h2></div>'+
                '<div class="tarea_revisar_nombre"><h2>'+aux.nombre_alumno+'</h2></div>'+
                '<div class="tarea_revisar_grupo"><h2>'+aux.grupo+'</h2></div>'+
                '<div class="tarea_revisar_desc"><h2>'+aux.descripcion+'</h2></div>'+
                '<div class="tarea_revisar_fecha"><h2>'+aux.fecha+'</h2></div>')
                /*'<td>'+aux.titulo+'</td>'+
                '<td>'+aux.nombre_alumno+'</td>'+
                '<td>'+aux.grupo+'</td>'+
                '<td>'+aux.descripcion+'</td>'+
                '<td>'+aux.fecha+'</td>');*/
    }   
});

