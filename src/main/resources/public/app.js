function cadenaInsertar(){
    
    var cadena = document.getElementById("cadena").value;
    fetch('http://ec2-50-17-76-19.compute-1.amazonaws.com:42000/testInsert?string='+cadena)
}