package kadai9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Form_Class;
import dao.Form_Function;


/**
 * Servlet implementation class Form_Goal
 */
@WebServlet("/Form_Goal")
@MultipartConfig(maxFileSize=1048576)  // 最大1M
public class Form_Goal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final File uploadDir = new File("C:\\pleiades\\workspace\\Sample\\WebContent\\upload");  // ファイル保存先
	public void init() throws ServletException {
	    uploadDir.mkdir();
	  }
    public Form_Goal() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date1 = new Date();

		// 表示形式を指定
		SimpleDateFormat sdformat1
		= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = sdformat1.format(date1);

		request.setCharacterEncoding("UTF-8");

		//④受け取ったパラメータの取得
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String Content = request.getParameter("Content");
		Part fPart = request.getPart("file");

		String file = (new StringBuilder()
			      .append("_").append(System.currentTimeMillis())
			      .append("_").append(fPart.getSubmittedFileName()
			    ).toString());
			    save(fPart, new File(uploadDir, file));

		Form_Class form = new Form_Class(name,mail,Content,file,time);


		Form_Function.insert(form);

		String view = "/WEB-INF/view/Kadai9/Form_Top.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	public void save(Part in, File out) throws IOException {
	    BufferedInputStream br = new BufferedInputStream(in.getInputStream());
	    try (BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(out)) ) {
	      int len = 0;
	      byte[] buff = new byte[1024];
	      while ((len = br.read(buff)) != -1) {
	        bw.write(buff, 0, len);
	      }
	    }
	  }

}
