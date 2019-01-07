package controller.message;

public class ResponseMsg {
	
	private String result;
	private String msg;
	
	private Object data;
	
	public ResponseMsg(String res, String msg) {
		// TODO Auto-generated constructor stub
		this.result = res;
		this.msg = msg;
	}
	
	public ResponseMsg sendResponse() {
		return this;
	}

	public String getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
