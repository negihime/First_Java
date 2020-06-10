package bean;

public class Form_Class {
	private String name;
	private String mail;
	private String Content;
	private String time;
	private String file;

	public Form_Class(String name, String mail, String content, String file,String time) {
		super();
		this.name = name;
		this.mail = mail;
		this.Content = content;
		this.file = file;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file= file;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
