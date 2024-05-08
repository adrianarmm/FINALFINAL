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

Una pila y una cola son tipos abstractos de datos que almacenan colecciones de elementos, pero difieren en la forma en que se agregan y eliminan elementos.

Una pila sigue el principio Last-In-First-Out (LIFO), lo que significa que el último elemento agregado a la pila es el primero en eliminarse. Una pila tiene dos operaciones principales: empujar y sacar. La operación empujar agrega un elemento a la parte superior de la pila, y la operación sacar elimina el elemento superior de la pila. La complejidad temporal de las operaciones empujar y sacar en una pila es O(1), lo que significa que toman tiempo constante para ejecutarse.

Por otro lado, una cola sigue el principio First-In-First-Out (FIFO), lo que significa que el primer elemento agregado a la cola es el primero en eliminarse. Una cola tiene dos operaciones principales: encolar y desencolar. La operación encolar agrega un elemento a la parte posterior de la cola, y la operación desencolar elimina el elemento frontal de la cola. La complejidad temporal de las operaciones encolar y desencolar en una cola también es O(1), lo que significa que toman tiempo constante para ejecutarse.

La elección entre el uso de una pila o una cola depende del problema específico que debe resolverse. Por ejemplo, una pila es útil para tareas que involucran deshacer operaciones, como en un editor de texto, donde el usuario puede deshacer su última acción mediante la eliminación del último elemento de la pila. Una cola es útil para tareas que involucran procesar elementos en el orden en que fueron recibidos, como en una cola de impresión, donde los trabajos se imprimen en el orden en que se enviaron.

En términos de complejidad espacial, una pila y una cola requieren ambas O(n) espacio para almacenar n elementos. Sin embargo, una pila suele usar menos memoria que una cola porque solo necesita realizar un seguimiento del elemento superior, mientras que una cola necesita realizar un seguimiento tanto del elemento frontal como del elemento posterior.

En resumen, una pila y una cola son ambas estructuras de datos útiles, pero difieren en la forma en que se agregan y eliminan elementos. Una pila sigue el principio LIFO y es útil para tareas que involucran deshacer operaciones, mientras que una cola sigue el principio FIFO y es útil para tareas que involucran procesar elementos en el orden en que fueron recibidos. Tanto una pila como una cola tienen una complejidad temporal de O(1) para sus operaciones principales y una complejidad espacial de O(n). La elección entre usar una pila o una cola depende del problema específico que debe resolverse.

**PARTE 4**
EL CODIGO ESTA EN LA CARPETA, EL ARCHIVO SE LLAMA InsertionSort.
En cada iteración, el algoritmo selecciona un elemento de la lista desordenada y lo compara con los elementos anteriores en la lista ordenada. Si el elemento seleccionado es menor que el elemento anterior en la lista ordenada, se mueven los elementos anteriores a la derecha para hacer espacio para el elemento seleccionado. El proceso continúa hasta que el elemento seleccionado esté en su lugar correcto en la lista ordenada.

La complejidad temporal del algoritmo de ordenación por inserción es O(n^2), donde n es el número de elementos en la lista. La complejidad espacial es O(1), ya que solo se requiere una cantidad fija de espacio adicional para realizar el algoritmo.

A continuación, se muestran las iteraciones sobre el conjunto de datos proporcionado:

Después de la primera iteración, el array es [20, 50, 13, 22, 16, 89, 85, 84].
Después de la segunda iteración, el array es [13, 20, 50, 22, 16, 89, 85, 84].
Después de la tercera iteración, el array es [13, 20, 16, 22, 50, 89, 85, 84].
Después de la cuarta iteración, el array es [13, 16, 20, 22, 50, 89, 85, 84].
Después de la quinta iteración, el array es [13, 16, 20, 22, 50, 85, 89, 84].
Después de la sexta iteración, el array es [13, 16, 20, 22, 50, 84, 85, 89].
Después de la séptima iteración, el array es [13, 16, 20, 22, 50, 84, 85, 89].
Por lo tanto, el array ordenado es [13, 16, 20, 22, 50, 84, 85, 89].

**PARTE 5**
EL CODIGO ESTA EN LA CARPETA, EL ARCHIVO SE LLAMA EfficiencyComparison.
Para determinar a partir de qué tamaño de entrada n la función A es más eficiente que la función B, podemos igualar las dos funciones y resolver para n.

La función A tiene una complejidad temporal de O(n) y un número de operaciones de 1024n, mientras que la función B tiene una complejidad temporal de O(n^3) y un número de operaciones de 16n^3.

Si igualamos ambas funciones y despejamos n, tenemos:

1024n = 16n^3

Podemos dividir ambos lados de la ecuación por n para simplificar:

1024 = 16n^2

A continuación, podemos dividir ambos lados de la ecuación por 16:

64 = n^2

Para obtener el valor de n, podemos calcular la raíz cuadrada de ambos lados de la ecuación:

n = √64 = 8

Por lo tanto, a partir de un tamaño de entrada n de 8, la función A es más eficiente que la función B en términos de número de operaciones.

## EJERCICIO 3
a) El código imprime el resultado de la multiplicación de a por sí mismo b veces, utilizando recursividad. Si b es igual a 0, el resultado es 1. Si a es igual a 0, el resultado es 0. Si b es negativo, el programa no compilará porque la llamada recursiva recursive(a, b-1) no tiene sentido para valores negativos de b. Para arreglar el programa, se puede agregar una condición para manejar el caso en que b es negativo, por ejemplo, devolviendo 0 o lanzando una excepción.

b) El cálculo que está haciendo el algoritmo es una multiplicación de a por sí mismo b veces, utilizando recursividad. La recursividad se emplea en la llamada a la función recursive(a, b-1), que se repite hasta que b sea igual a 0. El tipo de recursividad que se está empleando es la recursividad de cola, ya que la llamada recursiva es la última instrucción en la función.

## EJERCICIO 4
EL CODIGO ESTA EN LA CARPETA, EL ARCHIVO SE LLAMA SUMADIGITOS.
b) El tipo de recursividad que se está empleando es la recursividad directa, ya que la llamada recursiva se realiza al mismo método con un argumento diferente.

La complejidad computacional del algoritmo es O(log n), ya que en cada iteración se divide el número entre 10, lo que significa que el número de iteraciones es proporcional al logaritmo en base 10 del número de dígitos del número de entrada. En cada iteración, se realiza una operación de módulo y una operación de suma, lo que significa que la complejidad temporal es O(log n). La complejidad espacial es O(log n), ya que se necesita espacio adicional en la pila de llamadas para cada llamada recursiva.








