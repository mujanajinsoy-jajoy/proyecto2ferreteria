import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FerrecorApp extends JFrame implements AncestorListener, ActionListener {
    private java.awt.Container contenedor;
    private JTextField campoNombre, campoDescribcion, campoPrecio, campoCantidad;
    private JButton botonAgregar,botonEliminar,botonActualizar, botonEstadistica;
    private JList<String> listaDeProductos;
    private DefaultListModel<String> modeloLista;
    private JComboBox<String> comboHerramientas;
    private JLabel etiquetacantidad, etiquetaPrecio, etiquetaDescripcion, etiquetaNombre,etiqutaMterial, etiqutaEjemplos, etiquetaHerramientas;
    private JTextField campoMaterial, campoEjemplo, campoHerramienta;
    private List<producto>productos;

    public FerrecorApp(){
        setTitle("Ferrecor");
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());
        etiquetaNombre =new JLabel("nombre: ");
        campoNombre = new JTextField(20);
        panelSuperior.add(etiquetaNombre);
        panelSuperior.add(campoNombre);
        etiquetaDescripcion =new JLabel("Descripcion: ");
        campoDescribcion =new JTextField(20);
        panelSuperior.add(etiquetaDescripcion);
        panelSuperior.add(campoDescribcion);
        etiquetaPrecio = new JLabel("Precio: ");
        campoPrecio = new JTextField(10);
        panelSuperior.add(etiquetaPrecio);
        panelSuperior.add(campoPrecio);
        etiquetacantidad =new JLabel("Cantidad:");
        campoCantidad =new JTextField(10);
        panelSuperior.add(etiquetacantidad);
        panelSuperior.add(campoCantidad);

        botonAgregar = new JButton("Agregar");
        panelSuperior.add(botonAgregar);
        contenedor.add(panelSuperior, BorderLayout.NORTH);


        JPanel panelCentral =new JPanel();
        panelCentral.setLayout(new BorderLayout());
        modeloLista = new DefaultListModel<>();
        listaDeProductos = new JList<>(modeloLista);
        listaDeProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDeProductos.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = listaDeProductos.getSelectedIndex();
                if(indice !=-1){
                    producto producto = productos.get(indice);
                    campoMaterial.setText(producto.getMaterialElaboracion());
                    campoEjemplo.setText(producto.getEjemploUso());
                    campoHerramienta.setText(producto.getHerramientaNecesaria());

                }
            }
            
        });

        panelCentral.add(new JScrollPane(listaDeProductos), BorderLayout.CENTER);
        contenedor.add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferiro = new JPanel();
        panelInferiro.setLayout(new FlowLayout());
        botonEliminar =new JButton("Eliminar");
        botonEliminar.addActionListener(this);
        panelInferiro.add(botonEliminar);

        botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(this);
        panelInferiro.add(botonActualizar);

        botonEstadistica = new JButton("estadistica");
        botonActualizar.addActionListener(this);
        panelInferiro.add(botonEstadistica);

        contenedor.add(panelInferiro, BorderLayout.SOUTH);

        JDialog VentanEemergente= new JDialog(this, "detalles del producto");
        VentanEemergente.setLayout(new FlowLayout());
        etiqutaMterial = new JLabel("Material:");
        campoMaterial =new JTextField(20);
        VentanEemergente.add(etiqutaMterial);
        VentanEemergente.add(campoMaterial);
        etiqutaEjemplos =new JLabel("Ejemplo de uso: ");
        campoEjemplo =new JTextField(10);
        VentanEemergente.add(etiqutaEjemplos);
        etiquetaHerramientas =new JLabel("herramienta necesaria: ");
        campoHerramienta =new JTextField(20);
        VentanEemergente.add(etiquetaHerramientas);
        VentanEemergente.add(campoHerramienta);
        VentanEemergente.pack();
        VentanEemergente.setVisible(false);

        productos =new ArrayList<>();

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        FerrecorApp ferrecorApp= new FerrecorApp();
        System.out.println("Hello, World!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== botonAgregar){
            String nombre = campoNombre.getText();
            String descripcion = campoDescribcion.getText();
            double precio =Double.parseDouble(campoPrecio.getText());
            int cantidad = Integer.parseInt(campoCantidad.getText());

            producto producto = new producto(nombre, descripcion, precio, cantidad);
            productos.add(producto);
            modeloLista.addElement(producto.getNombre());
        }
    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ancestorAdded'");
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ancestorRemoved'");
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ancestorMoved'");
    }
    
}