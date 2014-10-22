/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuelalinux;
/*Proyecto de control escolar
 *
 *Autor:
 *              Kevin Esteban Garibo Bracamontes
 *              Martin Alejandro  Aguilar Lemus
 **/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EscuelaLinux extends JFrame implements ActionListener
{
	Scanner entrada= new Scanner(System.in);	
	
/*Aqui declaramos las variables preincipales de registro*/
static int contador=0;
static int room=25;	
static String	nombre[]=new String[room];
static String   matricula[]= new String [room];
static int control[]= new int[room];
static int Calculo[] =new int[room];
static int Programacion[]= new int [room];
static int BaseDatos[] = new int [room];
static int Ingles[]=new int[room];
/*Aqui terminamos de declarar las variables principales de registro*/
int posicion=0;
Boolean great2=false;

JLabel FondoMenu = new JLabel( new ImageIcon( "Soul/sunday.png" ) );	
JLabel FondoAltas = new JLabel( new ImageIcon( "Soul/Altas.png" ) );
JLabel FondoBajas = new JLabel( new ImageIcon( "Soul/Bajas.png" ) );
JLabel FondoCalificaciones = new JLabel( new ImageIcon( "Soul/Calificaciones.png" ) );
	
JDialog ventanaAltas,ventanaBajas,ventanaCalificaciones;
JDialog ventanaImprimir;

JButton  altas,bajas,calificaciones,botonImprimir,cambios,salir;
JButton guardarAltas,eliminarAlumno;
JButton buscaControl,guardarCalificaciones,plural;


JTextField nombreAlumno,numeroControl,nombreGrupo;
JTextField controlBajas,boxIngles,boxBaseDatos;

JTextField boxControl,boxProgramacion,boxCalculo;
String PruebaNumeroControl="";
int PruebaNumeroControl2=0;

Boolean evaluarControl=false;
Boolean great=false;
Boolean evaluarEXprogramacion=false;
Boolean evaluarEXingles=false;
Boolean evaluarEXcalculo=false;
Boolean evaluarEXbasedatos=false;

public static void main (String[] args)throws IOException
{
new EscuelaLinux(); 
	fichero();		
}
	
	
    EscuelaLinux()
   {

setLayout(null);	
   
/* Aqui se declaran los Botones de la bentana principal*/
    altas = new JButton("Altas");
	altas.reshape(20,40,200,30);
	altas.addActionListener(this);
	add(altas);	
		
	bajas = new JButton("Bajas");
	bajas.reshape(20,105,200,30);
	bajas.addActionListener(this);
	add(bajas);
	
	
	calificaciones = new JButton("Calififcaciones");
	calificaciones.reshape(20,170,200,30);
	calificaciones.addActionListener(this);
	add(calificaciones);
	
	
	botonImprimir = new JButton("Imprimir");
	botonImprimir.reshape(20,235,200,30);
	botonImprimir.addActionListener(this);
	add(botonImprimir);
	
	cambios = new JButton("Cambios");
	cambios.reshape(20,300,200,30);
	cambios.addActionListener(this);
	add(cambios);
		
	salir = new JButton("Salir");
	salir.reshape(20,365,200,30);
	salir.addActionListener(this);
	add(salir);
	

/*Aqui se terminan de declarar los botones de la ventana principal*/	

/*Aqui se declaran los botones de la ventana de registros*/
	ventanaAltas = new JDialog( this, "Altas  -  Registrar alumnos" );
	ventanaAltas.setModal(true);
	ventanaAltas.setSize( 400, 450);
	ventanaAltas.setLocation(350,270);
	ventanaAltas.setLayout( null );
	ventanaAltas.setVisible(false);	
	
	guardarAltas = new JButton("Guardar Registro");
	guardarAltas.reshape(65,340,200,30);
	guardarAltas.addActionListener(this);
	guardarAltas.setVisible(true);
	ventanaAltas.add(guardarAltas);	
	
	
	nombreAlumno = new JTextField();
	nombreAlumno.reshape(170,100,200,20);
	ventanaAltas.add(nombreAlumno);	
			
	numeroControl = new JTextField();
	numeroControl.reshape(170,165,200,20);
	ventanaAltas.add(numeroControl);
	
	nombreGrupo = new JTextField();
	nombreGrupo.reshape(170,230,200,20);
	ventanaAltas.add(nombreGrupo);
	/*Aqui terminamos con la ventana de registro (Texbox, botones y label)*/
	
	/*Aqui declaramos los botones  y texbox de la ventana de bajas*/
	
	ventanaBajas = new JDialog( this, "Bajas  -  Eliminar  alumnos" );
	ventanaBajas.setModal(true);
	ventanaBajas.setSize( 400, 260);
	ventanaBajas.setLocation(350,270);
	ventanaBajas.setLayout( null );
	ventanaBajas.setVisible(false);	
	
	eliminarAlumno= new JButton("Eliminar alumnos");
	eliminarAlumno.reshape(70,155,200,30);
	eliminarAlumno.addActionListener(this);
	eliminarAlumno.setVisible(true);
	ventanaBajas.add(eliminarAlumno);	
	
    controlBajas = new JTextField();
	controlBajas.reshape(170,90,200,20);
	ventanaBajas.add(controlBajas);
	
	/*Aqui terminamos de  declarar la ventana de bajas (Texbox, label, bonon*/
	
	/*Aqui empezamos a declarar la ventana de calificaciones*/
	ventanaCalificaciones = new JDialog( this, "Calificaciones  -  Ingresar Calificaciones" );
	ventanaCalificaciones.setModal(true);
	ventanaCalificaciones.setSize( 400, 530);
	ventanaCalificaciones.setLocation(320,270);
	ventanaCalificaciones.setLayout( null );
	ventanaCalificaciones.setVisible(false);
	
	buscaControl= new JButton("Buscar numero");
	buscaControl.reshape(220,80,140,30);
	buscaControl.addActionListener(this);
	buscaControl.setVisible(true);
	ventanaCalificaciones.add(buscaControl);
	
	boxControl = new JTextField();
	boxControl.reshape(15,80,200,20);
	ventanaCalificaciones.add(boxControl);
		
	
        boxProgramacion = new JTextField();
	boxProgramacion.reshape(200,145,130,20);
	boxProgramacion.setVisible(false);
	ventanaCalificaciones.add(boxProgramacion);
	
	boxIngles = new JTextField();
	boxIngles.reshape(200,210,130,20);
	boxIngles.setVisible(false);
	ventanaCalificaciones.add(boxIngles);
	
	boxBaseDatos= new JTextField();
	boxBaseDatos.reshape(200,275,130,20);
	boxBaseDatos.setVisible(false);
	ventanaCalificaciones.add(boxBaseDatos);
	
	boxCalculo= new JTextField();
	boxCalculo.reshape(200,340,130,20);
	boxCalculo.setVisible(false);
	ventanaCalificaciones.add(boxCalculo);
	
	guardarCalificaciones= new JButton("Guardar");
	guardarCalificaciones.reshape(110,405,140,30);
	guardarCalificaciones.addActionListener(this);
	guardarCalificaciones.setVisible(false);
	ventanaCalificaciones.add(guardarCalificaciones);
	
		
	
	/*Aqui terminamos de declarar la ventana de calificaciones*/
	
	/*Aqui empezamos a declarar la ventana para imprimir las calificaciones*/
	
	ventanaImprimir = new JDialog( this, "Bajas  -  Eliminar  alumnos" );
	ventanaImprimir.setModal(true);
	ventanaImprimir.setSize( 400, 260);
	ventanaImprimir.setLocation(350,270);
	ventanaImprimir.setLayout( null );
	ventanaImprimir.setVisible(false);	
	
	
	plural= new JButton("Buscar numero");
	plural.reshape(220,80,140,30);
	plural.addActionListener(this);
	plural.setVisible(true);
	ventanaImprimir.add(plural);
	/*Aqui terminamos de declarar la ventana de calificaciones*/
	
    FondoMenu.reshape( 0, 0, 900, 900 );
    add( FondoMenu );	


    FondoAltas.reshape( 0, 0,1760 , 1000 );
    ventanaAltas.add( FondoAltas );
	
    FondoBajas.reshape( 0, 0,1760 , 1000 );
    ventanaBajas.add( FondoBajas );

    FondoCalificaciones.reshape( 0, 0,1760 , 1000 );
    ventanaCalificaciones.add( FondoCalificaciones );	
	
	 
setSize(  650, 480);
setVisible( true );
setLocationRelativeTo( null );
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
}
	private static void fichero()throws IOException
	{
		
File directorio = new File("Lanix");
directorio.mkdir(); 	

		
	
File contadorTXT = new File("Lanix/contador.txt");
File nombreTXT = new File("Lanix/nombre.txt");
File controlTXT = new File("Lanix/control.txt");
File matriculaTXT = new File("Lanix/matricula.txt");
File programacionTXT = new File("Lanix/programacion.txt");
File calculoTXT = new File("Lanix/calculo.txt");
File inglesTXT = new File("Lanix/ingles.txt");
File basedatosTXT = new File("Lanix/basedatos.txt");

if(contadorTXT.exists())
{
		Scanner leer_contador=new Scanner(contadorTXT);
		Scanner leer_nombre=new Scanner(nombreTXT);
		Scanner leer_control=new Scanner(controlTXT);
		Scanner leer_matricula=new Scanner(matriculaTXT);
		Scanner leer_programacion=new Scanner(programacionTXT);
		Scanner leer_calculo=new Scanner(calculoTXT);
		Scanner leer_ingles=new Scanner(inglesTXT);
		Scanner leer_basedatos=new Scanner(basedatosTXT);
	
		
      	 contador=leer_contador.nextInt();
      
      	
    	for(int w=0;w<contador;w++)
      	{
      		
      		nombre[w]=leer_nombre.nextLine();
      		control[w]=leer_control.nextInt();
      		matricula[w]=leer_matricula.nextLine();
      		
      		Programacion[w]=leer_programacion.nextInt();
      		Calculo[w]=leer_calculo.nextInt();
      		Ingles[w]=leer_ingles.nextInt();
      		BaseDatos[w]=leer_basedatos.nextInt();
      		
      	}
      	

	}

	
	}	
	

/*Aqui esta la parte de acciones en caso de presionar un boton*/
public void actionPerformed(ActionEvent e)
	{
        if(e.getSource() == altas)
		{
		ventanaAltas.setVisible(true);	
		}	
	    if(e.getSource()==guardarAltas)
	    {
	   	ExtraerDatos();
	    }
	    if(e.getSource() == bajas)
		{
		if(contador>0)
    	{
    	
		ventanaBajas.setVisible(true);
		}
    	else
    	{
    	JOptionPane.showMessageDialog(null,"NO HAY REGISTROS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}		
		}	
		if(e.getSource() == calificaciones)
		{
		if(contador>0)
		{
			
		ventanaCalificaciones.setVisible(true);	
		}
    	else
    	{
    	JOptionPane.showMessageDialog(null,"NO HAY REGISTROS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}
		}
		if(e.getSource() == buscaControl)
		{
        BuscaControlCalificaciones();
        
		}
		if(e.getSource() == guardarCalificaciones)
		{
		GuardarCalificacionesExtraidas();
		}	
		if(e.getSource() == botonImprimir)
		{
		MetodoImprimir();		
		}
		if(e.getSource() == eliminarAlumno)
		{
	
		MetodoBajas();	
		
		}
		if(e.getSource() == cambios)
		{
	
	    MetodoCambios();	
		
		}
		if(e.getSource() == salir)
		{
		semiGuardar();
		System.exit(0);
		   
	
		
		}
		
	
	}
/*Aqui termina la parte de accion en caso de presionar un boton*/

/*Aqui empieza el metodo para extraer datos y guardarlos*/
	public void ExtraerDatos()
	{
		if(contador<room)
		{
PruebaNumeroControl=numeroControl.getText();	


evaluarControl=isNumeric(PruebaNumeroControl);
if(evaluarControl==false)
{
	great=false;
	JOptionPane.showMessageDialog(null,"VERIFIQUE SUS DATOS","Inane error", JOptionPane.ERROR_MESSAGE);
	JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);
 }
 else
 {
 	PruebaNumeroControl2=Integer.parseInt(PruebaNumeroControl);
 	great=true;
 	
 	if(PruebaNumeroControl2<0)
 	{
 		great= false;
 	JOptionPane.showMessageDialog(null,"VERIFIQUE SUS DATOS","Inane error", JOptionPane.ERROR_MESSAGE);
	JOptionPane.showMessageDialog(null,"SOLO NUMEROS DE CONTROL POSITIVOS","Inane warning",JOptionPane.WARNING_MESSAGE);
 		
 	}
 	for(int i=0;i<contador;i++)
 	{
 		if(PruebaNumeroControl2==control[i])
 		{
 		great=false;
        JOptionPane.showMessageDialog(null,"VERIFIQUE SUS DATOS","Inane error", JOptionPane.ERROR_MESSAGE);
    	JOptionPane.showMessageDialog(null,"ESE NUMERO DE CONTROL YA SE ENCUENTRA REGISTRADO","Inane warning",JOptionPane.WARNING_MESSAGE);
    	JOptionPane.showMessageDialog(null,"INTENTE CON OTRO NUMERO DE CONTROL");
 		}
 		
 	} 	
 	if(great==true)
 	{
 	     control[contador]=PruebaNumeroControl2;
 		nombre[contador]=nombreAlumno.getText();
 		matricula[contador]=nombreGrupo.getText();

 		JOptionPane.showMessageDialog(null,"\n==Alumno=="+
                                    "\n\nN. Control: "+control[contador]+
                                    "\nNombre: "+nombre[contador]+
                                    "\nMatricula de grupo: "+matricula[contador]+
                                    "\nCarrera: Ing. Sistemas Computacionales: ");
                                    
                                    nombreAlumno.setText("");                  
                                    nombreGrupo.setText("");
                                    numeroControl.setText("");      
                                    contador++;
 	}
 }	
}
else
{
JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
JOptionPane.showMessageDialog(null,"NO HAY ESPACIO DISPONIBLE","Inane warning",JOptionPane.WARNING_MESSAGE);
}
	}	
	/*Aqui termina el metodo para extraer y guardar datos*/		
		
	public void BuscaControlCalificaciones()
	{
	
	great2=false;
	int extraerControl3=0;	
	String extraerControl2;	

	extraerControl2=boxControl.getText();	
	extraerControl3=Integer.parseInt(extraerControl2);
	
	for(int i=0;i<contador;i++)
	{
		
		if(extraerControl3==control[i])
		{
		boxProgramacion.setVisible(true);
		boxIngles.setVisible(true);
		boxBaseDatos.setVisible(true);
		boxCalculo.setVisible(true);
		guardarCalificaciones.setVisible(true);		
		posicion=i;
		great2=true;
		
		}
	}
	
   if(great2==false)
   {
   JOptionPane.showMessageDialog(null,"NUMERO DE CONTROL NO ENCONTRADO","Inane warning",JOptionPane.WARNING_MESSAGE);
   }
		
		
		
	}
	public void GuardarCalificacionesExtraidas()
	{

	String extraerProgramacion,extraerCalculo;
	String extraerBaseDatos,extraerIngles;
	
	int extraerProgramacion2=0;
	int extraerCalculo2=0;
	int extraerIngles2=0;
	int extraerBaseDatos2=0;
	
	
	extraerProgramacion=boxProgramacion.getText();
	extraerCalculo=boxCalculo.getText();
	extraerIngles=boxIngles.getText();
	extraerBaseDatos=boxBaseDatos.getText();
	
	evaluarEXprogramacion=isNumeric(extraerProgramacion);
	evaluarEXbasedatos=isNumeric(extraerBaseDatos);
	evaluarEXcalculo=isNumeric(extraerCalculo);
	evaluarEXingles=isNumeric(extraerIngles);
	
	
	if((evaluarEXprogramacion==true)&&(evaluarEXbasedatos==true)&&(evaluarEXcalculo==true)&&(evaluarEXingles==true))
	{
    great2=true;
	extraerProgramacion2=Integer.parseInt(extraerProgramacion);
	extraerIngles2=Integer.parseInt(extraerIngles);
	extraerBaseDatos2=Integer.parseInt(extraerBaseDatos);
	extraerCalculo2=Integer.parseInt(extraerCalculo);
	
	if((extraerProgramacion2>100)||(extraerIngles2>100)||(extraerBaseDatos2>100)||(extraerCalculo2>100))
	{great2=false;
	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null,"SOLO CALIFICACIONES MENORES A 100","Inane warning",JOptionPane.WARNING_MESSAGE);	
	}
	if((extraerProgramacion2<0)||(extraerIngles2<0)||(extraerBaseDatos2<0)||(extraerCalculo2<0))
	{great2=false;
	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null,"SOLO CANTIDADES POSITIVAS","Inane warning",JOptionPane.WARNING_MESSAGE);
		
	}
				if(great2==true)
	{
		
			
	
	
	Programacion[posicion]=extraerProgramacion2;
	BaseDatos[posicion]=extraerBaseDatos2;
	Calculo[posicion]=extraerCalculo2;
	Ingles[posicion]=extraerIngles2;
	
	 		JOptionPane.showMessageDialog(null,"\n==Alumno=="+
                                    "\n\nN. Control: "+control[posicion]+
                                    "\nNombre: "+nombre[posicion]+
                                    "\nMatricula de grupo: "+matricula[posicion]+
                                    "\nCarrera: Ing. Sistemas Computacionales: "+
                                    "\n\n"+
                                    "Programacion: "+Programacion[posicion]+
                                    "\nIngles: "+Ingles[posicion]+
                                    "\nBases de datos: "+BaseDatos[posicion]+
                                    "\nCalculo: "+Calculo[posicion]); 
     boxProgramacion.setText("");                  
     boxCalculo.setText("");
     boxBaseDatos.setText("");    
     boxIngles.setText("");
     boxControl.setText("");
                                    
     boxProgramacion.setVisible(false);
	 boxIngles.setVisible(false);
	 boxBaseDatos.setVisible(false);
	 boxCalculo.setVisible(false);
	 guardarCalificaciones.setVisible(false);                            
                                    
		
	}
	}
	else
	{
		
	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null,"VERIFIQUE SUS DATOS","Inane warning",JOptionPane.WARNING_MESSAGE);
	}
		
	}
		
		

	
	public void MetodoImprimir()
	{
	Boolean great5=false,evaluarImprimir=false;
	String intentarImprimir;			
    int opcion=0,Ncontrol=0;
    Boolean evaluarIndividual=false;
    String intentarIndividual;
    if(contador>0)
    {
    
    
		do{
		
	    do{
	    evaluarImprimir=false;
	    /*Evaluando la parte de las opciones*/	
		intentarImprimir=JOptionPane.showInputDialog("1).- Imprimir Individual\n2).- Imprimir genreal\n3).- Salir");
		evaluarImprimir=isNumeric(intentarImprimir);
		if(evaluarImprimir==true)
		{
		opcion=Integer.parseInt(intentarImprimir);	
		if((opcion<0)||(opcion>3))
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evaluarImprimir==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while((opcion<0)||(opcion>3)||(evaluarImprimir==false));
		/*Evaluando la parte de las opciones*/	
			if(opcion==1)
		{great5=false;
			
			/*Aqui evaluamos el numero de control */
			do{		
			evaluarIndividual=false;
			intentarIndividual=JOptionPane.showInputDialog("Ingrese su numero de control: ");
		    evaluarIndividual=isNumeric(intentarIndividual);
		    if(evaluarIndividual==true)
		    {Ncontrol=Integer.parseInt(intentarIndividual);
		    if(Ncontrol<0)
		    {
		   	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"SOLO NUMEROS DE CONTROL POSITIVOS","Inane warning",JOptionPane.WARNING_MESSAGE);		
		    }
		    }
		    if(evaluarIndividual==false)
		    {
		    JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);
		    }
		    }while((Ncontrol<0)||(evaluarIndividual==false));	
		    /*Aqui terminamos de evaluar el numero de control*/
		
		
		
			String encabezado,elementos="";
	        JTextArea areaSalida= new JTextArea();
		    encabezado="Nombre\tNum. Control\tMatricula\tProgramacion\tCalculo\tBases de datos\t Ingles\n";		
			areaSalida.setText(encabezado);
			
			for(int x=0;x<contador;x++)
			{
			if(control[x]==Ncontrol)
			{
			great5=true;
			elementos+=nombre[x]+"\t"+control[x]+"\t"+matricula[x]+"\t"+Programacion[x]+"\t"+Calculo[x]+"\t"+BaseDatos[x]+"\t       "+Ingles[x]+"\n";
			}
			}
			
			if(great5==true)
			{
			areaSalida.append(elementos);
			JOptionPane.showMessageDialog(null,areaSalida);
			}
			else
			{
			 JOptionPane.showMessageDialog(null,"NUMERO DE CONTROL NO ENCONTRADO","Inane warning",JOptionPane.WARNING_MESSAGE);	
			}	
				
		}
		
		if(opcion==2)
		{
		great5=false;
	String encabezado,elementos="";
	JTextArea areaSalida= new JTextArea();
		encabezado="Nombre\tNum. Control\tMatricula\tProgramacion\tCalculo\tBases de datos\t Ingles\n";
		
		
		
			areaSalida.setText(encabezado);
			for(int x=0;x<contador;x++)
			{
			
			elementos+=nombre[x]+"\t"+control[x]+"\t"+matricula[x]+"\t"+Programacion[x]+"\t"+Calculo[x]+"\t"+BaseDatos[x]+"\t       "+Ingles[x]+"\n";
			}	
			areaSalida.append(elementos);
			JOptionPane.showMessageDialog(null,areaSalida);	
		
			}
			
		
		
		}while(opcion!=3);
		
			}
    	else
    	{
    	JOptionPane.showMessageDialog(null,"NO HAY REGISTROS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}	
				
	}	


    
    public void semiGuardar()
    {    	
    try{
    guardarYcerrar(contador,nombre,control,matricula,Programacion,Calculo,Ingles,BaseDatos);
} catch (IOException ex) {}
    	
    }
    
    private void guardarYcerrar(int contador,String [] nombre, int [] control, String [] matricula, int [] Programacion, int [] Calculo, int [] Ingles, int[] BaseDatos) throws IOException
    {
    	
    FileWriter contadorTXT2 = new FileWriter("Lanix/contador.txt");            
    FileWriter nombreTXT2 = new FileWriter("Lanix/nombre.txt");     
    FileWriter controlTXT2 = new FileWriter("Lanix/control.txt");      
    FileWriter matriculaTXT2 = new FileWriter("Lanix/matricula.txt");    
    FileWriter programacionTXT2 = new FileWriter("Lanix/programacion.txt");   
    FileWriter calculoTXT2 = new FileWriter("Lanix/calculo.txt");    
    FileWriter basedatosTXT2 = new FileWriter("Lanix/basedatos.txt");       
    FileWriter inglesTXT2 = new FileWriter("Lanix/ingles.txt");
    
    
        for(int i=0;i<contador;i++)
    {
    	
    nombreTXT2.write(nombre[i] + "\r\n");
    controlTXT2.write(control[i]+ "\r\n");
    matriculaTXT2.write(matricula[i]+ "\r\n");        
    programacionTXT2.write(Programacion[i]+ "\r\n");
    calculoTXT2.write(Calculo[i]+ "\r\n");
    basedatosTXT2.write(BaseDatos[i]+ "\r\n");
    inglesTXT2.write(Ingles[i]+ "\r\n");
    
    			
    	
    }
    
     contadorTXT2.write((contador) + "\r\n");
     
     contadorTXT2.close();
     nombreTXT2.close();
     controlTXT2.close();
     matriculaTXT2.close();     
     programacionTXT2.close();
     inglesTXT2.close();
     calculoTXT2.close();
     basedatosTXT2.close();
        	
    }
    
    
    
    
    
    public void MetodoBajas()
    {   Boolean greatLinux=false,encontrado=false;
    	String intentarBajas;
    	Boolean evaluarBajas=false;
    	int numeroBajas=0;
    	int posicion=0;
    	
    	
    	intentarBajas=controlBajas.getText();
    	evaluarBajas=isNumeric(intentarBajas);
    	if(evaluarBajas==true)
    	{
    	greatLinux=true;
    	numeroBajas=Integer.parseInt(intentarBajas);
    	if(numeroBajas<0)
    	{
    	greatLinux=false;
    	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES POSITIVAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}
    	    	
    	
    		
    	}
    	if(evaluarBajas=false)
    	{greatLinux=false;
    	JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}
    	
    	if(greatLinux==true)
    	{
    		
    	for(int i=0;i<contador;i++)
    	{
    	if(numeroBajas==control[i])
    	{
    	
    	nombre[i]="";
    	control[i]=0;
    	matricula[i]="";
    	Programacion[i]=0;
    	Calculo[i]=0;
    	BaseDatos[i]=0;
    	Ingles[i]=0;  
    	posicion=i;  				
    	encontrado=true;			
    	}
    	   	if((nombre[i].equals(""))&&(control[i]==0)&&(matricula[i].equals(""))&&(Programacion[i]==0)&&(Calculo[i]==0)&&(Ingles[i]==0)&&(BaseDatos[i]==0)&&(encontrado==true))
    	{
    			
    	nombre[i]=nombre[i+1];
    	control[i]=control[i+1];
    	matricula[i]=matricula[i+1];
    	Programacion[i]=Programacion[i+1];
    	Calculo[i]=Calculo[i+1];
    	Ingles[i]=Ingles[i+1];
    	BaseDatos[i]=BaseDatos[i+1];	
    			
    			
    	}
    			
    	}
   	
    	
    	if(encontrado==true)
    	{
    	contador--;	    		
       	JOptionPane.showMessageDialog(null,"REGISTRO ELIMINADO ");                                    
        controlBajas.setText(""); 	
    
                     
                               
                                  
    	}
    	}
    	else
    	{
    	JOptionPane.showMessageDialog(null,"NO HAY REGISTROS ESXISTENTES","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}
    	
    }
    
    
    public void MetodoCambios()
    {
    	
    	
    String intentarNumeroCambios;	
    int Findnumber=0;
    Boolean existeCambio=false,evaluarNumeroCambios=false;
    int posicionCambio=0;
    Boolean cambioBueno=false;
    
    /*Aqui empezamos a declarar las variables de nuestro metodo*/
    String cambioProgramacion,cambioIngles,cambioBaseDatos,cambioCalculo;
    Boolean evalProgramacion=false,evalIngles=false,evalBaseDatos=false,evalCalculo=false;
    
    
    /*Aqui terminamos de  declarar las variables de nuestro metodo*/
    
    /*Evaluamos el numero de control q se ba a ingresar*/
    
    if(contador>0)
    {
    
    
	    do{
	    evaluarNumeroCambios=false;
	    /*Evaluando la parte de las opciones*/	
		intentarNumeroCambios=JOptionPane.showInputDialog("Ingrese su numero de control: ");
		evaluarNumeroCambios=isNumeric(intentarNumeroCambios);
		if(evaluarNumeroCambios==true)
		{
		Findnumber=Integer.parseInt(intentarNumeroCambios);	
		if(Findnumber<0)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evaluarNumeroCambios==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while((Findnumber<0)||(evaluarNumeroCambios==false));
    
    
    	
    for(int i=0;i<contador;i++)
    {
    	if(Findnumber==control[i])
    	{
    		
    		existeCambio=true;
    		posicionCambio=i;
    		
    	}
    	
    }
    if(existeCambio==true)
    {
    
    /**Aqui evaluamos cuando ingresamos la calificacion de Programacion*/	
    	do{
	    evalProgramacion=false;
	   
		cambioProgramacion=JOptionPane.showInputDialog("Ingrese su nueva calificacion en programacion");
		evalProgramacion=isNumeric(cambioProgramacion);
		if(evalProgramacion==true)
		{
		 Programacion[posicionCambio]=Integer.parseInt(cambioProgramacion);	
		if( Programacion[posicionCambio]<0)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evalProgramacion==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while(( Programacion[posicionCambio]<0)||(evalProgramacion==false));
		
       /*Aqui terminamos de evaluar la calificacion de programacion*/
       
       
       /*Aqui empezamos a evaluar la calificaion de Base de datos*/     

       	do{
	    evalBaseDatos=false;
	   
		cambioBaseDatos=JOptionPane.showInputDialog("Ingrese su nueva calificacion en base de datos");
		evalBaseDatos=isNumeric(cambioBaseDatos);
		if(evalBaseDatos==true)
		{
		 BaseDatos[posicionCambio]=Integer.parseInt(cambioBaseDatos);	
		if( BaseDatos[posicionCambio]<0)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evalBaseDatos==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while(( BaseDatos[posicionCambio]<0)||(evalBaseDatos==false));
		
		/*Aqui terminamos de evaluar la calificacion de base de datos*/
       		
 
    
    /*Aqui evaluamos la calificacion de ingles*/
        do{
    	    evalIngles=false;
	   
		cambioIngles=JOptionPane.showInputDialog("Ingrese su nueva calificacion en base de datos");
		evalIngles=isNumeric(cambioIngles);
		if(evalIngles==true)
		{
		Ingles[posicionCambio]=Integer.parseInt(cambioIngles);	
		if(Ingles[posicionCambio]<0)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evalIngles==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while(( Ingles[posicionCambio]<0)||(evalIngles==false));
		
	/*Aqui terminamos de vealuar la calificacion de ingles*/	
	
	
	
	/*Aqui evaluamos la calificacion de calculo*/
	
	       	do{
	    evalCalculo=false;
	   
		cambioCalculo=JOptionPane.showInputDialog("Ingrese su nueva calificacion en base de datos");
		evalCalculo=isNumeric(cambioCalculo);
		if(evalCalculo==true)
		{
		 Calculo[posicionCambio]=Integer.parseInt(cambioCalculo);	
		if( Calculo[posicionCambio]<0)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"VERIFIQUE LAS OPCIONES","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}
		if(evalCalculo==false)
		{
		JOptionPane.showMessageDialog(null,"ERROR","Inane error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"SOLO CANTIDADES NUMERICAS","Inane warning",JOptionPane.WARNING_MESSAGE);	
		}
		}while(( Calculo[posicionCambio]<0)||(evalCalculo==false));
		
		
		
	/*Aqi terminamos de evaluar la calificacion de calculo*/

		
   
	
    	
    	
    }
    else
    {
    JOptionPane.showMessageDialog(null,"REGISTRO NO ENCONTRADO","Inane warning",JOptionPane.WARNING_MESSAGE);		
    }	
    	
    		}
    	else
    	{
    	JOptionPane.showMessageDialog(null,"NO HAY REGISTROS","Inane warning",JOptionPane.WARNING_MESSAGE);	
    	}	
    	
    	
    	
    }
    
    
    
    
    
   	/*Metodo isNumeric para evaluar si las cantidades son numericas*/
	public static boolean isNumeric(String a)
 	{
    try
    {
    Integer.parseInt(a);
    return true;
    }
    catch (NumberFormatException nfe)
    {
    return false;
    }
    }	
    /*Aqui termina el metodo isNumeric donde evaluamos cantidades numericas*/
		
	}
