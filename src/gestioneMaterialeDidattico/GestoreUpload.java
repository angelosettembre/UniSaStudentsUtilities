package gestioneMaterialeDidattico;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import storageLayer.DatabaseGM;

/**
 * Servlet implementation class GestoreUpload
 */
@WebServlet("/GestoreUpload")
public class GestoreUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestoreUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Tramite questa servlet � possibile effettuare l'upload
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @author Tropeano Domenico Antonio
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String visualizedPage = null;
		String proprietario = "";
		String path = "";
		if (ServletFileUpload.isMultipartContent(request)) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// Parse the request
			List<FileItem> multiparts = null;
			try {
				multiparts = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (multiparts != null) { // && multiparts.size() > 0
				// iterates over form's fields
				for (FileItem item : multiparts) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String UPLOAD_DIRECTORY = getServletContext().getRealPath(path);
						String name = new File(item.getName()).getName();
						double dimensione = item.getSize() / 1024; // fix it
						Date dataUpload = new java.sql.Date(System.currentTimeMillis());
						int like = 0;
						int dislike = 0;
						Risorsa r = new Risorsa(name, proprietario, dimensione, dataUpload, like, dislike, path);

						int idRisorsa = DatabaseGM.insertRisorsa(r);
						String filePath = UPLOAD_DIRECTORY + File.separator + idRisorsa;
						File storeFile = new File(filePath);

						// saves the file on disk
						try {
							item.write(storeFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						if (item.getFieldName().equals("path")) {
							path = item.getString();
						} else if (item.getFieldName().equals("visualizedPage")) {
							visualizedPage = item.getString();
						} else if (item.getFieldName().equals("user")) {
							proprietario = item.getString();
							System.out.println("questo � il proprietario" + proprietario);
						}
					}
				}
			}
		}
		response.sendRedirect(visualizedPage);
	}

}
