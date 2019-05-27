/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author NATA
 */
public class Grafico extends JPanel {
    
    construccion arbol;
    HashMap posicionNodo = null;
    HashMap TSArbol = null;
    boolean dirty = true;
    Dimension vacio = new Dimension(0,0);
    FontMetrics fm = null;
    int padreAhijo = 20;
    int hijoAhijo = 30;
    
    public Grafico(construccion arbol){
        this.arbol = arbol;
        this.setBackground(Color.WHITE);
        posicionNodo = new HashMap();
        TSArbol = new HashMap();
        dirty = true;
        repaint();
    }
    
    public Dimension tamSubArbol(Nodo nodo){
        if(nodo==null){
            return new Dimension(0,0);
        }
        Dimension id = tamSubArbol(nodo.izq);
        Dimension dd = tamSubArbol(nodo.der);
        int height = fm.getHeight()+padreAhijo+Math.max(id.height, dd.height);
        int width = id.width+hijoAhijo+dd.width;
        Dimension d = new Dimension(width,height);
        TSArbol.put(nodo, d);
        return d;
    }
    
    public void calcPosiciones(Nodo nodo, int izquierda, int derecha, int superior){
        if(nodo!=null){
            Dimension id = (Dimension) TSArbol.get(nodo.izq);
            if(id==null){
                id = vacio;
            }
            Dimension dd = (Dimension) TSArbol.get(nodo.der);
            if(dd==null){
                dd = vacio;
            }
            int centro = 0;
            if(derecha!=Integer.MAX_VALUE){
                centro = derecha-dd.width-hijoAhijo/2;
            }else if(izquierda!=Integer.MAX_VALUE){
                centro = izquierda+id.width+hijoAhijo/2;
            }
            int ancho = fm.stringWidth(Integer.toString(nodo.info));
            posicionNodo.put(nodo, new Rectangle(centro-ancho/2-3,superior,ancho+6,fm.getHeight()));
            calcPosiciones(nodo.izq,Integer.MAX_VALUE,centro-hijoAhijo/2,superior+fm.getHeight()+padreAhijo);
            calcPosiciones(nodo.der,centro-hijoAhijo/2,Integer.MAX_VALUE,superior+fm.getHeight()+padreAhijo);
        }
    }
    
    public void posiciones(){
        posicionNodo.clear();
        TSArbol.clear();
        Nodo referencia = this.arbol.getCab();
        if (referencia!=null){
            tamSubArbol(referencia);
            calcPosiciones(referencia, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
    }
    
    public void dibujar(Graphics2D g, Nodo nodo, int x, int y, int yoffs){
        if(nodo!=null){
            Rectangle rectangulo = (Rectangle) posicionNodo.get(nodo);
            g.draw(rectangulo);
            g.drawString(Integer.toString(nodo.info),rectangulo.x+3,rectangulo.y+yoffs);
            if(x!=Integer.MAX_VALUE){
                g.drawLine(x,y,rectangulo.x+rectangulo.width/2,rectangulo.y);
            }
            dibujar(g,nodo.izq,rectangulo.x+rectangulo.width/2,rectangulo.y+rectangulo.height,yoffs);
            dibujar(g,nodo.der,rectangulo.x+rectangulo.width/2,rectangulo.y+rectangulo.height,yoffs);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();
        if(dirty){
            posiciones();
            dirty = false;
        }
        Graphics2D graf = (Graphics2D) g;
        graf.translate(getWidth()/2, padreAhijo);
        dibujar(graf,this.arbol.getCab(),Integer.MAX_VALUE,Integer.MAX_VALUE,fm.getLeading()+fm.getAscent());
        fm = null;
    }
    
    
    
}
