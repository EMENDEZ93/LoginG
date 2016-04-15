package login;

import java.awt.Toolkit;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

public class Login extends Application {
       
    //Label global 
        Label Advertencia = new Label( );     

    //variable de intentos globales
         int IntentosF ;

    
    public static void main( String[] args ) {

    //lanzar la aplicacion     
        Application.launch( args );

    }

    //Sobreescribe metodo
        @Override
        public void start( Stage Stage ) throws Exception {
        
    //creacion del gridpane    
        GridPane Grip = new GridPane( );        
        
    //metodo para guia de celdas en la interfaz         
       Grip.setGridLinesVisible( true );

    //margenes   
        Grip.setPadding( new Insets ( 10 , 10 , 10 , 10 ) );

    //espacio de nodos Vertical
        Grip.setVgap( 10 );
            
    //espacio de nodos Horizontal
        Grip.setHgap( 5 );

        
       
        
//_________________________________________________
    //creacion de un label para user
        Label Lnombre = new Label( " - User Name : " );
        
    //ubicacion en la matriz en la interfaz
        GridPane.setConstraints( Lnombre , 1 , 0 );

    //Creacion de TextField introduccir el nombre
        TextField InputName = new TextField( );
    
    // validar solo letras        
        InputName.setOnKeyTyped( e -> handle2( e ) );        
        
    //Efecto dentro del TextField    
        InputName.setPromptText( "Your Name" );
        
    //posicion en la matriz //en la interfaz          
        GridPane.setConstraints( InputName , 1 , 1 );
        
    //tome dos columnas y dejar cercar los botones con otra margen
        GridPane.setColumnSpan( InputName , 2 );

//_________________________________________________






//_________________________________________________
    //creacion de un label password
        Label Lpasw = new Label( "Password :" );
        
    //ubicacion en la matriz en la interfa
        GridPane.setConstraints( Lpasw , 1 , 2 );

    //Creacion de TextFiel password
        PasswordField Passw = new PasswordField( );
        
    //validar solo numeros        
        Passw.setOnKeyTyped( e -> handle( e ) );
                
    //Efecto dentro del TextField        
        Passw.setPromptText( "Password" );
        
    //ubicacion en la matriz
        GridPane.setConstraints( Passw , 1 , 3 );
        
    //tome dos columnas y dejar cercar los botones con otra margen
        GridPane.setColumnSpan( Passw , 2 );
      
//_________________________________________________

        



//__________________________________________________      
    //ingresar imagen para usuario
        Image image = new Image( getClass( ).getResourceAsStream( "usuario.jpg" ) );
    
    //Mostrar imagen
        ImageView imagev = new ImageView( image );
       
    //Creacion de label
        Label label = new Label( );
       
    //agregando imagen al label   
        label.setGraphic( imagev );
       
    //ubicacion en la interfaz //ubicacion en forma de matriz ( X , Y )
        GridPane.setConstraints( imagev , 0 , 0 );
     
    //toma de filas para que no afecten el espacio de los demas nodos   
        GridPane.setRowSpan( imagev , 6 );
//_________________________________________________
 
       
       
       

//_________________________________________________
    //Creacion de boton para el login    
        Button BLogin = new Button( " - Login - " );
       
    //Efecto de cursor mano para el boton
        BLogin.setCursor( Cursor.HAND );
        
    //Efecto para el boton Sombreado
        BLogin.setEffect( new DropShadow( ) );
        
    //busca la imagen para el boton
        Image IconoCorrect = new Image( getClass( ).getResourceAsStream( "Correct.jpg" ) );

    //codigo para introducirla "imagen al boton"
        BLogin.setGraphic( new ImageView( IconoCorrect ) );
        
    //posicion en la matriz de la interfaz          
        GridPane.setConstraints( BLogin , 1 , 4 );
        
    //accion del boton 
        BLogin.setOnAction(  event  ->  Ingresar( event , Passw , InputName , Stage , Grip ) );
   
//_________________________________________________
        



    
//_________________________________________________
    //CReacion de boton para cancelar   
        Button BCancelar = new Button( "- Cancelar -" );
    
    //Efecto de cursor mano para el boton
        BCancelar.setCursor( Cursor.HAND );
        
    //Efecto para el boton sombreado
        BCancelar.setEffect( new DropShadow( ) );
        
    //busca la imagen para el boton
        Image IconoCancel = new Image( getClass( ).getResourceAsStream( "Cancel.jpg" ) );

    //codigo para introducirla "imagen al boton"
        BCancelar.setGraphic( new ImageView ( IconoCancel ) );
        
    //ubicacion en la matriz
        GridPane.setConstraints( BCancelar , 2 , 4 );
//_________________________________________________





//_________________________________________________
    //Agregar nodos
        Grip.getChildren( ).addAll( imagev , BCancelar , Lnombre , InputName , Lpasw , Passw , BLogin );
             
    //Titulo del escenario //interfaz   
        Stage.setTitle( "- Iniciar Sesion -" );

    //Buscar la imagen para insertar en la barra del interfaz 
        Image IconoInterfaz = new Image( getClass().getResourceAsStream( "Interfaz.jpg" ) );
      
    //codigo para agregarla como icono de barra para la interfaz //a la imagen    
        Stage.getIcons( ).add( IconoInterfaz );

    //creacion de la escena
        Scene scene = new Scene( Grip );
             
    //agregar la escena al escenario
        Stage.setScene( scene );

    //iniciar
        Stage.show( );
//_________________________________________________
      

        }

 
        

//_________________________________________________    
//validacion letras  
    private void handle2( KeyEvent e ) {        
        
        String str = e.getCharacter();
        
        int len = str.length();
        
        for ( int i = 0 ; i < len ; i ++ ) {
            
        Character C = str.charAt(i);
        
        if ( !Character.isLetter(C)) {
            
        e.consume();
        
        //sonido de alerta
        Toolkit.getDefaultToolkit().beep();

        }
        
        }//for
                
        }
//_________________________________________________

    
    
    
//_________________________________________________
    //evento para validar numero en el password
        private void handle( KeyEvent e ) {
        
        String str = e.getCharacter();
        
        int len = str.length();
        
        for ( int i = 0 ; i < len ; i ++ ) {
            
        Character C = str.charAt(i);
        
        if ( !Character.isDigit(C)) {
            
        e.consume();
        
        //sonido de alerta
        Toolkit.getDefaultToolkit().beep();
        
        }
        
        }
        
        }
//_________________________________________________

        
        


//_________________________________________________        
    //evento Boton Login 
        private void Ingresar( ActionEvent event , PasswordField Passw , TextField InputName , Stage Stage , GridPane Grip ) {
    
    //validar si esta correcta e ingresar     
        if (  InputName.getText( ).equalsIgnoreCase( "admin" ) && Passw.getText( ).equalsIgnoreCase( "123" )  ) {
    
    //llamar a la clase        
        Ventana R = new Ventana();         
  
    //metodo de la clase
        R.VentanaC( Stage );
            
        }  
        
    //error login por contraseña o usuario    
        else {

    //utilizar variable Global para validar los ingresos    
        IntentosF += 1 ;
                  
    //validacion para hacer posible el mensaje de intentos           
       if ( IntentosF == 1 ) {

    //sonido de alerta
        Toolkit.getDefaultToolkit().beep();        
           
    //label Global con mensaje para 2 intentos       
        Advertencia.setText( "Esta cuenta no existe. Advertencia Te quedan " + ( 3 - IntentosF ) + " Intentos" );

    //color de el mensaje que contiene el label    
        Advertencia.setTextFill( Color.RED );  
        
    //Tamaño tipo de letra
        Advertencia.setFont( new Font( "Cambria" , 9 ) );
                    
    //ubicacion en la matriz
        GridPane.setConstraints( Advertencia , 1 , 5 );

    //add al grip para poder verlo  
        Grip.getChildren( ).addAll( Advertencia );
           
    //para tomar dos Columnas en una sola selda    
        GridPane.setColumnSpan( Advertencia , 2 );

           
        } else if ( IntentosF == 2 ) {
              
    // Advertencia 1 intento   
        Advertencia.setText( "Esta cuenta no existe. Advertencia Te queda " + ( 3 - IntentosF ) + " Intento" );
    
    //sonido de alerta
        Toolkit.getDefaultToolkit().beep();    
        
    //intentos fallidos //mensaje final close       
        } else if ( IntentosF == 3 ) { 
                 
    //sonido de alerta
        Toolkit.getDefaultToolkit().beep();         
            
    //mensaje para advertir que se va cerrar el programa       
        JOptionPane.showMessageDialog( null , " El Programa se cerrara a causa de Error de Usuario o contraseña " , " - Error al Validar - " , JOptionPane.ERROR_MESSAGE );
        
    //cerrar interfaz    
        Stage.close( );
    
        }
       
        }
//________________________________________________________    
 
}
        
}