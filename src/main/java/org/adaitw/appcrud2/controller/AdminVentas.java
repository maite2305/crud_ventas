package org.adaitw.appcrud2.controller;




import org.adaitw.appcrud2.dao.VentasDAO;
import org.adaitw.appcrud2.model.Ventas;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/adminVentas")
public class AdminVentas extends HttpServlet {
    private static final long serialVersionUID = 1L;
    VentasDAO ventasDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {

            ventasDAO = new VentasDAO(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "nuevo":
                    nuevo(request, response);
                    break;
                case "register":
                    System.out.println("entro");
                    registrar(request, response);
                    break;
                case "mostrar":
                    mostrar(request, response);
                    break;
                case "showedit":
                    showEditar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet..");
        doGet(request, response);
    }

    private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        //mostrar(request, response);
        RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Ventas ventas = new Ventas(0, request.getParameter("nombre_articulo"), Double.parseDouble(request.getParameter("cantidad")), Double.parseDouble(request.getParameter("valor_unitario")),Double.parseDouble(request.getParameter("precio_total")));
        ventasDAO.insertar(ventas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/vista-ventas/register.jsp");
        dispatcher.forward(request, response);
    }


    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/vista-ventas/mostrar.jsp");
        List<Ventas> listaVentas= ventasDAO.listarVentas();
        request.setAttribute("lista", listaVentas);
        dispatcher.forward(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Ventas ventas = ventasDAO.obtenerPorId_venta(Integer.parseInt(request.getParameter("id_venta")));
        request.setAttribute("ventas", ventas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/vista-ventas/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Ventas ventas = new Ventas(Integer.parseInt(request.getParameter("id_venta")), request.getParameter("nombre_articulo"), Double.parseDouble(request.getParameter("cantidad")),
                Double.parseDouble(request.getParameter("valor_unitario")),Double.parseDouble(request.getParameter("precio_total")));
        ventasDAO.actualizar(ventas);
        index(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Ventas ventas = ventasDAO.obtenerPorId_venta(Integer.parseInt(request.getParameter("id_venta")));
        ventasDAO.eliminar(ventas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}
