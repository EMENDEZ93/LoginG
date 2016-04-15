
package login;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Ventana {
 
    //contador para click Izquiero
        int Primary;
    
    //contador para click Centro
        int Center;
    
    //Contador para click Derecho
        int Secondary;
    
    //Creacion del circulo
        Circle Circulo = new Circle( 102 );   

        public void VentanaC( Stage Stage ) {
          
           
        HBox Hb = new HBox();
   
        Hb.setPadding( new Insets( 20 ) ) ;
           
    //color del circulo
        Circulo.setFill( Color.DARKORCHID );
        
    //evento para el circulo 
        Circulo.addEventHandler( MouseEvent.MOUSE_CLICKED , e -> HandlerMouse( e ) );

        Hb.getChildren( ).addAll( Circulo );

        Scene scene = new Scene( Hb , 250 , 250 );

        Stage.setScene( scene );

        Stage.setTitle( "- MouseEvent -" );

        Stage.show( );
    }

//evento para los click       
    private void HandlerMouse( MouseEvent e ) {

    //click izquierdo
        if (  e.getButton( ).equals( MouseButton.PRIMARY ) ) {
         
    //contador click izquierdo
        Primary += 1;

    //volver el contador a cero centro...para que sean click de seguidos y no acumulables     
        Center = 0;   
        
    //volver el contador a cero derecho...para que sean click de seguidos y no acumulables     
        Secondary = 0;
            
        
    //validar a cinco para cambiar de color
        if ( Primary == 5) {
             
    //convertir el circulo azul    
        Circulo.setFill( Color.RED );

    //volver a empezar los click
        Primary = 0;
            
            }
    
        
        
                    
    //click Centro    
        } else if ( e.getButton( ).equals( MouseButton.MIDDLE ) ) {
          
    //contador para click del centro
        Center += 1;
  
    //volver el contador a cero izquierdo...para que sean click de seguidos y no acumulables     
        Primary = 0;   
        
    //volver el contador a cero derecho...para que sean click de seguidos y no acumulables     
        Secondary = 0;    

    //validar a cinco para cambiar de color
        if ( Center == 5) {
             
    //convertir el circulo azul    
        Circulo.setFill( Color.YELLOW );

    //volver a empezar los click
        Center = 0;
            
        }
   
        
        
        
    //click derecho    
        } else if ( e.getButton( ).equals( MouseButton.SECONDARY ) ) {
            
    //contador para los click derecho
        Secondary += 1;
        
      //volver el contador a cero centro...para que sean click de seguidos y no acumulables     
        Center = 0;   
        
    //volver el contador a cero derecho...para que sean click de seguidos y no acumulables     
        Primary = 0;    
        
            
    //validar a cinco para cambiar de color
        if ( Secondary == 5) {
             
    //convertir el circulo azul    
        Circulo.setFill( Color.BLUE );

        Secondary = 0;
            
        }
        
        }
    

    }

    
}
