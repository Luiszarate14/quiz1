# quiz1

Enunciado
=========

Utilizando el patrón MVC realice una calculadora como se le muestra en la imagen, esta
calculadora solo tendrá operaciones básicas (Suma, Resta, Multiplicación y División) para
números enteros y con decimales.


En esta calculadora el usuario escribirá las operaciones matemáticas que desee en el orden
que considere adecuado, sin ninguna contemplación de los espacios. Para la representación
de millares puede utilizar comas “,” o espacio por ejemplo *10,000* o *5,000,321* que se pueden
combinar con puntos de tal forma que un número válido es *10,592.76*. 

Debe tener cuidado con la posición de la coma, ya que *100,02* no es válido, así como tampoco *10,0000*, ni
tampoco *,302*.


Algunas operaciones que se deben poder llevar acabo en la calculadora son:

    10,592.76 + 780 + 10000 * 200.76
    1/323-765
    1 +

Debe mostrar al usuario un mensaje de error cuando la expresión insertada sea incorrecta.
Debe realizar manejo de excepciones tal como fue visto en clase, escribiendo su propia
excepción.
