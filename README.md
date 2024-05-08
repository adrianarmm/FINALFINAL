# CASO FINAL DE LOS FINALES
# ADRIANA REYES MORERA

## EJERCICIO 1
***1) En relación al estado de un objeto, para preservar el principio de encapsulación:***

b) Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos
de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al
estado de los objetos mediante los métodos que le hayamos permitido utilizar.

***2) Los métodos de una clase no pueden devolver objetos:***

b) Falso

***3) ¿Cuál de las siguientes características de la programación orientada a objetos está
relacionada con la reutilización de código?***
b) Herencia

***4) El tiempo de acceso a un dato en una lista de tipo LinkedList es en el mejor de los casos de:***
a) O(n)

***5) Un algoritmo de ordenación que implemente el método de inserción se basa en la idea de ir
seleccionando el número correspondiente en la lista desordenada que se va a insertar en la
posición última de la lista ordenada:***

b) Falso

## EJERCICIO 2
**PARTE 1**
a) La primera opción tiene una complejidad computacional de O(n), donde n es el tamaño del conjunto de datos de entrada. En este caso, n = 64 KB. Sin embargo, la complejidad espacial es S(1), lo que significa que solo requiere una cantidad constante de memoria. Esta opción se puede implementar en el entorno de memoria restringido, pero su complejidad temporal no es ideal para entradas grandes.

b) La segunda opción tiene una complejidad computacional de O(1), lo que significa que tiene un tiempo de ejecución constante, independientemente del tamaño de la entrada. Sin embargo, la complejidad espacial es S(N^2), lo que significa que requiere una cantidad considerable de memoria, proporcional al cuadrado del tamaño de la entrada. En este caso, requeriría S(64KB^2) = S(4GB), lo que está muy por encima de la memoria disponible de 4 KB. Esta opción no es adecuada para el entorno de memoria restringido.

c) La tercera opción tiene una complejidad computacional de O(log2(n)), que es más eficiente que la primera opción para entradas grandes. Su complejidad espacial es S(O(log2(n))), que también es más eficiente en memoria que la primera opción, ya que solo requiere una cantidad logarítmica de memoria relacionada con el tamaño de la entrada. En este caso, requeriría S(O(log2(64KB))) = S(O(17)) = unos pocos bytes, lo que está bien dentro de la memoria disponible de 4 KB.

**PARTE 2**
Una tabla hash y un árbol son estructuras de datos diferentes que se utilizan para almacenar y organizar información. Una tabla hash utiliza una función de hash para mapear claves a índices específicos en una tabla, lo que permite un acceso rápido a los elementos en tiempo constante. Por otro lado, un árbol es una estructura jerárquica en la que cada nodo tiene un valor y cero o más nodos hijos. Los árboles se utilizan a menudo para mantener relaciones jerárquicas entre elementos y para realizar búsquedas, inserciones y eliminaciones en tiempo logarítmico.

La elección entre una tabla hash y un árbol depende del problema que se esté resolviendo y de las operaciones que se vayan a realizar con más frecuencia. Si se van a realizar operaciones de búsqueda, inserción y eliminación con mucha frecuencia, una tabla hash es una buena opción debido a su tiempo de acceso constante. Sin embargo, si se necesita mantener una relación jerárquica entre los elementos o se van a realizar operaciones de rango, un árbol es una mejor opción.

En cuanto a las operaciones posibles, una tabla hash soporta la inserción, búsqueda y eliminación en tiempo constante, mientras que un árbol soporta las mismas operaciones en tiempo logarítmico. Además, los árboles permiten operaciones adicionales como búsquedas de rango y búsquedas de elementos cercanos, mientras que las tablas hash no.

En resumen, tanto las tablas hash como los árboles son estructuras de datos útiles, pero se utilizan en diferentes situaciones y para diferentes propósitos. La elección entre ellas depende del problema que se esté resolviendo y de las operaciones que se vayan a realizar con más frecuencia.

**PARTE 3**
