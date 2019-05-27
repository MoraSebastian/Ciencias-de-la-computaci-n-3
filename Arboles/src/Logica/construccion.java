/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import javax.swing.JPanel;

/**
 *
 * @author NATA
 */
public class construccion {
    
    Nodo cab;
    
    /*Ingresa un solo valor a el arbol que se tiene, si es el primer valor que 
    se ingresa, se pone en la cabeza-raiz; si el valor ya existe no lo pone y si
    ya existe un arbol evalua si es mayor o menor y se manda a izquierda o 
    derecha respectivamente*/
    public void insertar(String val){
        int valor = Integer.parseInt(val);
        Nodo p = cab;
        Nodo q = null;
        if(p==null){
            cab = new Nodo(valor);
            return;
        }
        int seguimiento=0;
        while(p!=null){
            if(p.info==valor){
                p=null;
                seguimiento=0;
            }else{
                if(p.info>valor){
                    q=p;
                    p=p.izq;
                    seguimiento=1;
                }else{
                    q=p;
                    p=p.der;
                    seguimiento=2;
                }
            }
        }
        if(seguimiento==0){
            return;
        }
        if(seguimiento==1){
            q.izq = new Nodo(valor);
            return;
        }
        if(seguimiento==2){
            q.der = new Nodo(valor);
            return;
        }
    }
    
    /*resive una lista cualquiera, hace el primer valor como la raiz y desde alli
    genera el arbol con los demas*/
    public String construccionCero(String valores){
        if(valores.length()==0){
            return "Debe ingresar valores";
        }
        String[] valoresArr = valores.split(",");
        for(int i=0; i<valoresArr.length; i++){
            insertar(valoresArr[i]);
        }
        return null;
    }
    
    //función para construir el árbol con los datos en Inorden y Preorden
    public Nodo construyeInPre(String[] inorden, String[] preorden, Nodo cen) {

        //verifica si hay que crear un nuevo nodo o no
        if (inorden.length == 0 || preorden.length == 0) {
            return null;
        }
        String[] izquierdaInorden = new String[0], derechaInorden = new String[0], izquierdaPreorden = new String[0], derechaPreorden = new String[0];
        int raiz = Integer.parseInt(preorden[0]);
        if (cab == null) {
            cab = new Nodo(raiz);
            cen = cab;
        } else {
            cen = new Nodo(raiz);
        }

        //busca la raiz en la lista inorden para dividir la lista en mayores y menores
        for (int i = 0; i < inorden.length; i++) {

            if (raiz == Integer.parseInt(inorden[i])) {
                //parte el vector a la mitad
                izquierdaInorden = new String[i];
                izquierdaPreorden = new String[i];
                derechaInorden = new String[preorden.length - 1 - i];
                derechaPreorden = new String[preorden.length - 1 - i];
                //llena el vector
                for (int j = 0; j < izquierdaInorden.length; j++) {
                    izquierdaInorden[j] = inorden[j];

                }
                int l = 0;
                //compara los valores de la izquierda ordenada en la lista preordenada para no cambiar la secuencia
                for (int j = 0; j < preorden.length; j++) {
                    for (int k = 0; k < izquierdaInorden.length; k++) {
                        if (Integer.parseInt(preorden[j]) == Integer.parseInt(izquierdaInorden[k])) {
                            izquierdaPreorden[l] = preorden[j];

                            l++;
                            //para acabar el for cuando ya se encontraron todos los números
                            if (l == izquierdaInorden.length) {
                                break;
                            }

                        }

                    }
                }
                for (int j = 0; j < derechaInorden.length; j++) {
                    derechaInorden[j] = inorden[j + i + 1];

                }
                //compara los valores de la derecha ordenada en la lista preordenada para no cambiar la secuencia
                l = 0;
                for (int j = 0; j < preorden.length; j++) {
                    for (int k = 0; k < derechaInorden.length; k++) {
                        if (Integer.parseInt(preorden[j]) == Integer.parseInt(derechaInorden[k])) {
                            derechaPreorden[l] = preorden[j];

                            l++;
                            //para acabar el for cuando ya se encontraron todos los números
                            if (l == derechaInorden.length) {
                                break;
                            }

                        }

                    }
                }
                break;
            }
        }

        cen.izq = construyeInPre(izquierdaInorden, izquierdaPreorden, cen.izq);

        cen.der = construyeInPre(derechaInorden, derechaPreorden, cen.der);
        return cen;

    }
    
    //función para construir el árbol con los datos en Inorden y Posorden
    public Nodo construyeInPos(String[] inorden, String[] posorden, Nodo cen) {
        //verifica si hay que crear un nuevo nodo o no
        if (inorden.length == 0 || posorden.length == 0) {

            return null;
        }
        String[] izquierdaInorden = new String[0], derechaInorden = new String[0], izquierdaPosorden = new String[0], derechaPosorden = new String[0];
        int raiz = Integer.parseInt(posorden[posorden.length - 1]);
        if (cab == null) {
            cab = new Nodo(raiz);
            cen = cab;
        } else {
            cen = new Nodo(raiz);
        }

        //busca la raiz en la lista inorden para dividir la lista en mayores y menores
        for (int i = 0; i < inorden.length; i++) {

            if (raiz == Integer.parseInt(inorden[i])) {
                //parte el vector a la mitad
                izquierdaInorden = new String[i];
                izquierdaPosorden = new String[i];
                derechaInorden = new String[posorden.length - 1 - i];
                derechaPosorden = new String[posorden.length - 1 - i];
                //llena el vector
                for (int j = 0; j < izquierdaInorden.length; j++) {
                    izquierdaInorden[j] = inorden[j];

                }
                int l = 0;
                //compara los valores de la izquierda ordenada en la lista preordenada para no cambiar la secuencia
                for (int j = 0; j < posorden.length; j++) {
                    for (int k = 0; k < izquierdaInorden.length; k++) {
                        if (Integer.parseInt(posorden[j]) == Integer.parseInt(izquierdaInorden[k])) {
                            izquierdaPosorden[l] = posorden[j];

                            l++;
                            //para acabar el for cuando ya se encontraron todos los números
                            if (l == izquierdaInorden.length) {
                                break;
                            }

                        }

                    }
                }
                for (int j = 0; j < derechaInorden.length; j++) {
                    derechaInorden[j] = inorden[j + i + 1];

                }
                //compara los valores de la derecha ordenada en la lista preordenada para no cambiar la secuencia
                l = 0;
                for (int j = 0; j < posorden.length; j++) {
                    for (int k = 0; k < derechaInorden.length; k++) {
                        if (Integer.parseInt(posorden[j]) == Integer.parseInt(derechaInorden[k])) {
                            derechaPosorden[l] = posorden[j];

                            l++;
                            //para acabar el for cuando ya se encontraron todos los números
                            if (l == derechaInorden.length) {
                                break;
                            }

                        }

                    }
                }
                break;
            }
        }

        cen.izq = construyeInPos(izquierdaInorden, izquierdaPosorden, cen.izq);

        cen.der = construyeInPos(derechaInorden, derechaPosorden, cen.der);
        return cen;

    }
    
    /*reconstruye el arbol, con los recorridos de inorden y posorden que se 
    dan... debe mandar a graficar despues*/
    public String recInPos(String inor, String posor) {
        String[] inArray = inor.split(",");                                     //arreglo del recorrido inorden
        String[] poArray = posor.split(",");                                    //arreglo del recorrido posorden
        if (inArray.length == poArray.length) {                                     //tamaño igual
            boolean validacion = true;
            for (int i = 0; i < inArray.length; i++) {                                //valores de lista 1 en la lista 2
                validacion = buscarDato(inArray[i], poArray);
                if (validacion == false) {
                    return "no fueron bien ingresados los valores";
                }
            }
            for (int i = 0; i < poArray.length; i++) {                                //valores de la lista 2 en la lista 1
                validacion = buscarDato(poArray[i], inArray);
                if (validacion == false) {
                    return "no fueron bien ingresados los valores";
                }
            }
            if (validacion == true) {
                construyeInPos(inArray, poArray, null);
            }
            //continuar

        } else {
            return "las listas no coinciden";
        }
        return null;
    }

    /*Reconstruye un arbol, con los recorridos de inorden y preorden que se 
    dan... debe mandarlo a graficar despues*/
    public String recInPre(String inor, String preor) {
        String[] inArray = inor.split(",");                                     //arreglo del recorrido inorden
        String[] preArray = preor.split(",");                                   //arreglo del recorrido preorden
        if (inArray.length == preArray.length) {
            boolean validacion = true;
            for (int i = 0; i < inArray.length; i++) {                                //valores de lista 1 en la lista 2
                validacion = buscarDato(inArray[i], preArray);
                if (validacion == false) {
                    //System.out.println("no fueron bien ingresados los valores");
                    return "no fueron bien ingresados los valores";
                }
            }
            for (int i = 0; i < preArray.length; i++) {                                //valores de la lista 2 en la lista 1
                validacion = buscarDato(preArray[i], inArray);
                if (validacion == false) {
                    //System.out.println("no fueron bien ingresados los valores");
                    return "no fueron bien ingresados los valores";
                }
            }
            //si los datos están correctamente colocados, cree el árbol
            if (validacion == true) {
                construyeInPre(inArray, preArray, null);

            }
            //continuar

        } else {
            //System.out.println("las listas no coinciden");
            return "las listas no coinciden";
        }
        return null;
    }
    
    /*Con el arbol creado, crea un string que es el recorrido en inorden del 
    mismo*/
    public String construirListaInorden(Nodo r){
        if(r==null){
            return "";
        }
        return construirListaInorden(r.izq)+Integer.toString(r.info)+" "+construirListaInorden(r.der);
    }

    /*Con el arbol creado, crea un string que es el recorrido en preorden del 
    mismo*/
    public String construirListaPreorden(Nodo r) {
        if(r==null){
            return "";
        }
        return Integer.toString(r.info)+" "+construirListaPreorden(r.izq)+construirListaPreorden(r.der);
    }

    /*Con el arbol creado, crea un string que es el recorrido en posorden del 
    mismo*/
    public String construirListaPosorden(Nodo r) {
        if(r==null){
            return "";
        }
        return construirListaPosorden(r.izq)+construirListaPosorden(r.der)+" "+Integer.toString(r.info);
    }
    
    /*Evalúa si un dato se encuentra en una lista... para comprobar que las 
    listas sean bien ingresadas*/
    public boolean buscarDato(String dato, String[] arreg){
        boolean resp=false;
        for(int i=0; i<arreg.length; i++){
            if(dato.equals(arreg[i])){
                resp=true;
                break;
            }
        }
        return resp;
    }
    
    public double sumaElementos(String recorrido){
        double resultado = 0;
        String[] valores = recorrido.split(" ");
        for(int i=0; i<valores.length; i++){
            resultado = resultado+Integer.parseInt(valores[i]);
        }
        return resultado;
    }
    
    public double sumaTres(String recorrido){
        double resultado = 0;
        String[] valores = recorrido.split(" ");
        for(int i=0; i<valores.length; i++){
            if(multiplo(Integer.parseInt(valores[i]),3)){
                resultado = resultado+Integer.parseInt(valores[i]);
            }
        }
        return resultado;
    }
    
    public boolean multiplo(int numero, int base){
        if(numero%base==0){
            return true;
        }else{
            return false;
        }
    }
    
    /*Elimina el arbol completo*/
    public void eliminar(){
        cab=null;
    }

    public Nodo getCab() {
        return cab;
    }
    
    public JPanel Pintar(){
        return new Grafico(this);
    }
    
}
